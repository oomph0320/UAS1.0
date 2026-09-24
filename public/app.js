/**
 * 无人机专家 WebApp 全局交互引擎
 * 支持：全真题题库、5大拓展科目、刷题/背题模式、模拟考试计时判卷、错题本、收藏夹、Word(.docx)纯前端解析导入
 */

const STORAGE_KEYS = {
  QUESTIONS: 'uav_expert_questions_v2',
  USER_PROGRESS: 'uav_expert_progress_v2',
  SETTINGS: 'uav_expert_settings_v2'
};

class DroneQuizApp {
  constructor() {
    this.questions = [];
    this.userProgress = {}; // id -> { selected: [], isAnswered: bool, isCorrect: bool, isWrong: bool, isFavorite: bool, note: "" }
    this.settings = {
      mode: 'PRACTICE', // 'PRACTICE' or 'MEMORIZE'
      randomOrder: false
    };

    this.currentView = 'home'; // home, quiz, exam, detail, wrong, favorites, search
    this.quizContext = {
      title: '',
      subtitle: '',
      questions: [],
      currentIndex: 0,
      mode: 'PRACTICE',
      examTimer: null,
      examSecondsLeft: 45 * 60,
      isExamFinished: false
    };

    this.activeSubject = null;

    this.init();
  }

  init() {
    this.loadState();
    this.bindEvents();
    this.render();
  }

  loadState() {
    // 1. 加载题目
    const savedQuestions = localStorage.getItem(STORAGE_KEYS.QUESTIONS);
    if (savedQuestions) {
      try {
        this.questions = JSON.parse(savedQuestions);
      } catch (e) {
        console.error('Failed to parse saved questions, fallback to defaults', e);
        this.questions = [...window.DEFAULT_QUESTIONS];
      }
    } else if (window.DEFAULT_QUESTIONS && window.DEFAULT_QUESTIONS.length > 0) {
      this.questions = [...window.DEFAULT_QUESTIONS];
      this.saveQuestions();
    }

    // 2. 加载用户答题进度
    const savedProgress = localStorage.getItem(STORAGE_KEYS.USER_PROGRESS);
    if (savedProgress) {
      try {
        this.userProgress = JSON.parse(savedProgress);
      } catch (e) {
        this.userProgress = {};
      }
    }

    // 3. 加载设置
    const savedSettings = localStorage.getItem(STORAGE_KEYS.SETTINGS);
    if (savedSettings) {
      try {
        this.settings = Object.assign(this.settings, JSON.parse(savedSettings));
      } catch (e) {}
    }
  }

  saveQuestions() {
    localStorage.setItem(STORAGE_KEYS.QUESTIONS, JSON.stringify(this.questions));
  }

  saveProgress() {
    localStorage.setItem(STORAGE_KEYS.USER_PROGRESS, JSON.stringify(this.userProgress));
  }

  saveSettings() {
    localStorage.setItem(STORAGE_KEYS.SETTINGS, JSON.stringify(this.settings));
  }

  bindEvents() {
    // 监听 Word 上传
    const fileInput = document.getElementById('word-file-input');
    if (fileInput) {
      fileInput.addEventListener('change', (e) => this.handleFileSelect(e));
    }
  }

  getProgress(id) {
    if (!this.userProgress[id]) {
      this.userProgress[id] = {
        selected: [],
        textResponse: '',
        isAnswered: false,
        isCorrect: null,
        isWrong: false,
        isFavorite: false,
        note: ''
      };
    }
    return this.userProgress[id];
  }

  /* ------------------- 页面路由与渲染 ------------------- */

  navigate(view, payload = null) {
    if (this.quizContext.examTimer) {
      clearInterval(this.quizContext.examTimer);
      this.quizContext.examTimer = null;
    }

    this.currentView = view;
    if (view === 'subject_detail' && payload) {
      this.activeSubject = payload;
    }
    this.render();
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  render() {
    const root = document.getElementById('app-root');
    if (!root) return;

    switch (this.currentView) {
      case 'home':
        root.innerHTML = this.renderHomeScreen();
        break;
      case 'subject_detail':
        root.innerHTML = this.renderSubjectDetailScreen();
        break;
      case 'quiz':
        root.innerHTML = this.renderQuizScreen();
        break;
      case 'exam':
        root.innerHTML = this.renderExamScreen();
        break;
      case 'wrong':
        root.innerHTML = this.renderSpecialBookScreen('wrong', '错题巩固本', '集中突破做错的难点与易混淆考点');
        break;
      case 'favorites':
        root.innerHTML = this.renderSpecialBookScreen('favorites', '重点收藏夹', '标记的核心理论与高频考题合集');
        break;
      case 'search':
        root.innerHTML = this.renderSearchScreen();
        break;
      default:
        root.innerHTML = this.renderHomeScreen();
    }

    // 重新初始化 Lucide 图标
    if (window.lucide) {
      window.lucide.createIcons();
    }
  }

  /* ------------------- 1. 软件主页（无人机专家） ------------------- */

  renderHomeScreen() {
    const total = this.questions.length;
    let answered = 0;
    let correct = 0;
    let wrong = 0;
    let fav = 0;

    this.questions.forEach(q => {
      const p = this.userProgress[q.id];
      if (p) {
        if (p.isAnswered) answered++;
        if (p.isCorrect === true) correct++;
        if (p.isWrong) wrong++;
        if (p.isFavorite) fav++;
      }
    });

    const accuracy = answered > 0 ? Math.round((correct / answered) * 100) : 0;
    const primary = window.INITIAL_SUBJECTS.primary;
    const extensions = window.INITIAL_SUBJECTS.extensions;

    // 统计各题型数量
    const typeCount = {
      single: this.questions.filter(q => q.type === 'single').length,
      multi: this.questions.filter(q => q.type === 'multi').length,
      judge: this.questions.filter(q => q.type === 'judge').length,
      fill: this.questions.filter(q => q.type === 'fill').length,
      short: this.questions.filter(q => q.type === 'short').length,
    };

    return `
      <div class="space-y-6">
        <!-- Hero Header -->
        <div class="relative overflow-hidden rounded-2xl bg-gradient-to-br from-slate-900 via-slate-800 to-cyan-950 p-6 border border-cyan-800/40 shadow-xl">
          <div class="absolute -right-8 -top-8 w-44 h-44 bg-cyan-500/10 rounded-full blur-3xl pointer-events-none"></div>
          
          <div class="relative z-10 flex flex-col md:flex-row md:items-center md:justify-between gap-4">
            <div>
              <div class="flex items-center space-x-2 mb-2">
                <span class="px-2.5 py-0.5 rounded-full text-xs font-semibold bg-cyan-500/20 text-cyan-300 border border-cyan-500/30">
                  专业学科体系已就绪
                </span>
                <span class="text-xs text-slate-400">1+5 矩阵架构</span>
              </div>
              <h1 class="text-2xl md:text-3xl font-black text-white tracking-tight">无人机专家 · 综合考评看板</h1>
              <p class="text-sm text-slate-300 mt-1 max-w-xl">
                覆盖无人机执照考试全真题库，贯通低空小型飞行器探测反制、相控阵雷达、无线电测向、光电追踪及电磁干扰五大拓展学科。
              </p>
            </div>

            <!-- Stats Badge Group -->
            <div class="grid grid-cols-3 gap-3 bg-slate-900/80 p-3 rounded-xl border border-slate-700/60 backdrop-blur-sm">
              <div class="text-center px-2">
                <div class="text-xs text-slate-400 font-medium">总收录真题</div>
                <div class="text-xl font-extrabold text-cyan-400 mt-0.5">${total} <span class="text-[10px] text-slate-400 font-normal">道</span></div>
              </div>
              <div class="text-center px-2 border-x border-slate-800">
                <div class="text-xs text-slate-400 font-medium">综合正确率</div>
                <div class="text-xl font-extrabold ${accuracy >= 80 ? 'text-emerald-400' : 'text-amber-400'} mt-0.5">${accuracy}%</div>
              </div>
              <div class="text-center px-2">
                <div class="text-xs text-slate-400 font-medium">累计已练</div>
                <div class="text-xl font-extrabold text-white mt-0.5">${answered} <span class="text-[10px] text-slate-400 font-normal">道</span></div>
              </div>
            </div>
          </div>

          <!-- Quick Navigation Bar inside Hero -->
          <div class="mt-6 pt-4 border-t border-slate-800/80 flex flex-wrap items-center justify-between gap-3 text-sm">
            <div class="flex items-center space-x-4">
              <button onclick="app.navigate('wrong')" class="flex items-center space-x-1.5 text-rose-400 hover:text-rose-300 font-medium">
                <i data-lucide="alert-circle" class="w-4 h-4"></i>
                <span>错题巩固 (${wrong})</span>
              </button>
              <button onclick="app.navigate('favorites')" class="flex items-center space-x-1.5 text-amber-400 hover:text-amber-300 font-medium">
                <i data-lucide="bookmark" class="w-4 h-4"></i>
                <span>重点收藏 (${fav})</span>
              </button>
            </div>
            
            <div class="flex items-center space-x-2">
              <span class="text-xs text-slate-400">答题模式：</span>
              <button onclick="app.toggleQuizMode()" class="px-2.5 py-1 rounded-md text-xs font-semibold ${this.settings.mode === 'PRACTICE' ? 'bg-cyan-600 text-white' : 'bg-slate-800 text-slate-400 hover:text-white'} transition">
                ${this.settings.mode === 'PRACTICE' ? '刷题判题' : '背题速记'}
              </button>
            </div>
          </div>
        </div>

        <!-- 核心科目区：无人机技术基础 -->
        <div>
          <div class="flex items-center justify-between mb-3">
            <div class="flex items-center space-x-2">
              <h2 class="text-lg font-bold text-white flex items-center gap-1.5">
                <i data-lucide="award" class="w-5 h-5 text-cyan-400"></i>
                核心理论科目
              </h2>
              <span class="text-xs text-slate-400">（全量真题收录）</span>
            </div>
            <button onclick="app.startExam()" class="text-xs font-semibold px-3 py-1.5 rounded-lg bg-emerald-600/90 hover:bg-emerald-500 text-white flex items-center space-x-1 shadow transition">
              <i data-lucide="play" class="w-3.5 h-3.5"></i>
              <span>全真模拟考 (100分)</span>
            </button>
          </div>

          <div class="rounded-2xl bg-gradient-to-r from-slate-900 to-slate-800 border-2 border-cyan-500/40 p-6 shadow-xl relative group hover:border-cyan-400 transition">
            <div class="flex flex-col md:flex-row md:items-center justify-between gap-4">
              <div>
                <div class="flex items-center space-x-2 mb-1.5">
                  <span class="px-2.5 py-0.5 rounded-md text-xs font-bold bg-cyan-500/20 text-cyan-300 border border-cyan-500/40">
                    ${primary.categoryBadge}
                  </span>
                  <span class="text-xs text-slate-400">真题共收录 ${total} 题</span>
                </div>
                <h3 class="text-xl font-bold text-white group-hover:text-cyan-300 transition">${primary.title}</h3>
                <p class="text-sm text-slate-300 mt-1">${primary.subtitle}</p>
                <div class="flex flex-wrap gap-1.5 mt-3">
                  ${primary.tags.map(t => `<span class="text-[11px] px-2 py-0.5 rounded bg-slate-800 text-slate-300 border border-slate-700">${t}</span>`).join('')}
                </div>
              </div>

              <div class="flex flex-col sm:flex-row gap-2.5">
                <button onclick="app.startQuizAll()" class="px-5 py-2.5 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white font-semibold text-sm shadow-lg shadow-cyan-600/30 flex items-center justify-center space-x-2 transition">
                  <i data-lucide="layers" class="w-4 h-4"></i>
                  <span>进入大题库练习</span>
                </button>
                <button onclick="app.navigate('subject_detail', window.INITIAL_SUBJECTS.primary)" class="px-4 py-2.5 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-200 text-sm font-medium border border-slate-700 flex items-center justify-center space-x-1.5 transition">
                  <i data-lucide="book-open" class="w-4 h-4"></i>
                  <span>科目大纲</span>
                </button>
              </div>
            </div>

            <!-- 题型细分快速直达入口 -->
            <div class="mt-6 pt-4 border-t border-slate-800/80 grid grid-cols-2 sm:grid-cols-5 gap-2.5">
              <button onclick="app.startQuizByType('single')" class="p-2.5 rounded-xl bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 text-left transition flex items-center justify-between">
                <div>
                  <div class="text-xs text-slate-400 font-medium">单选题</div>
                  <div class="text-sm font-bold text-sky-400 mt-0.5">${typeCount.single} 道</div>
                </div>
                <i data-lucide="check-circle" class="w-4 h-4 text-sky-400/80"></i>
              </button>

              <button onclick="app.startQuizByType('multi')" class="p-2.5 rounded-xl bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 text-left transition flex items-center justify-between">
                <div>
                  <div class="text-xs text-slate-400 font-medium">多选题</div>
                  <div class="text-sm font-bold text-purple-400 mt-0.5">${typeCount.multi} 道</div>
                </div>
                <i data-lucide="list-checks" class="w-4 h-4 text-purple-400/80"></i>
              </button>

              <button onclick="app.startQuizByType('judge')" class="p-2.5 rounded-xl bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 text-left transition flex items-center justify-between">
                <div>
                  <div class="text-xs text-slate-400 font-medium">判断题</div>
                  <div class="text-sm font-bold text-teal-400 mt-0.5">${typeCount.judge} 道</div>
                </div>
                <i data-lucide="help-circle" class="w-4 h-4 text-teal-400/80"></i>
              </button>

              <button onclick="app.startQuizByType('fill')" class="p-2.5 rounded-xl bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 text-left transition flex items-center justify-between">
                <div>
                  <div class="text-xs text-slate-400 font-medium">填空题</div>
                  <div class="text-sm font-bold text-amber-400 mt-0.5">${typeCount.fill} 道</div>
                </div>
                <i data-lucide="edit-3" class="w-4 h-4 text-amber-400/80"></i>
              </button>

              <button onclick="app.startQuizByType('short')" class="p-2.5 rounded-xl bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 text-left transition flex items-center justify-between col-span-2 sm:col-span-1">
                <div>
                  <div class="text-xs text-slate-400 font-medium">简答分析</div>
                  <div class="text-sm font-bold text-rose-400 mt-0.5">${typeCount.short} 道</div>
                </div>
                <i data-lucide="sparkles" class="w-4 h-4 text-rose-400/80"></i>
              </button>
            </div>
          </div>
        </div>

        <!-- 同级拓展目录矩阵（5大前沿科目） -->
        <div>
          <div class="flex items-center justify-between mb-3">
            <div>
              <h2 class="text-lg font-bold text-white flex items-center gap-1.5">
                <i data-lucide="cpu" class="w-5 h-5 text-indigo-400"></i>
                低空安全与探测反制 · 同级拓展科目矩阵
              </h2>
              <p class="text-xs text-slate-400 mt-0.5">已预置完整专业学科纲要与考点体系，题库拓展接口已开放</p>
            </div>
          </div>

          <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            ${extensions.map(sub => {
              const subQuestions = this.questions.filter(q => q.topic && (q.topic.includes(sub.title) || q.subjectId === sub.id));
              const count = subQuestions.length;
              return `
                <div class="rounded-xl bg-slate-900/90 border border-slate-800 hover:border-cyan-500/50 p-5 shadow-lg flex flex-col justify-between transition hover:-translate-y-0.5">
                  <div>
                    <div class="flex items-center justify-between mb-2">
                      <span class="text-[11px] font-semibold px-2 py-0.5 rounded bg-indigo-500/10 text-indigo-300 border border-indigo-500/20">
                        ${sub.categoryBadge}
                      </span>
                      <span class="text-xs ${count > 0 ? 'text-cyan-400 font-bold' : 'text-slate-500'}">
                        ${count > 0 ? `已录入 ${count} 题` : '当前 0 题 · 拓展口就绪'}
                      </span>
                    </div>

                    <h3 class="text-base font-bold text-white hover:text-cyan-300 cursor-pointer" onclick='app.navigate("subject_detail", ${JSON.stringify(sub)})'>
                      ${sub.title}
                    </h3>
                    <p class="text-xs text-slate-400 mt-1 line-clamp-1">${sub.subtitle}</p>
                    <p class="text-xs text-slate-400 mt-2 line-clamp-2 leading-relaxed">${sub.description}</p>
                  </div>

                  <div class="mt-4 pt-3 border-t border-slate-800/80 flex items-center justify-between">
                    <div class="flex items-center space-x-1">
                      ${sub.tags.slice(0, 3).map(t => `<span class="text-[10px] px-1.5 py-0.5 rounded bg-slate-800 text-slate-400">${t}</span>`).join('')}
                    </div>
                    <div class="flex space-x-2">
                      <button onclick='app.openImportForSubject("${sub.id}")' class="px-2.5 py-1 rounded bg-slate-800 hover:bg-slate-700 text-slate-300 text-xs font-medium transition" title="导入此学科专属题库">
                        导入题目
                      </button>
                      <button onclick='app.navigate("subject_detail", ${JSON.stringify(sub)})' class="px-3 py-1 rounded bg-cyan-600/30 hover:bg-cyan-600 text-cyan-300 hover:text-white text-xs font-medium transition">
                        查看看板
                      </button>
                    </div>
                  </div>
                </div>
              `;
            }).join('')}
          </div>
        </div>
      </div>
    `;
  }

  /* ------------------- 2. 学科拓展详情看板 ------------------- */

  renderSubjectDetailScreen() {
    const sub = this.activeSubject;
    if (!sub) return this.renderHomeScreen();

    const subQuestions = this.questions.filter(q => q.topic && (q.topic.includes(sub.title) || q.subjectId === sub.id));
    const isPrimary = sub.isPrimary === true;

    return `
      <div class="space-y-6">
        <!-- Top Back Bar -->
        <div class="flex items-center justify-between">
          <button onclick="app.navigate('home')" class="flex items-center space-x-1.5 text-sm text-slate-400 hover:text-white transition">
            <i data-lucide="arrow-left" class="w-4 h-4"></i>
            <span>返回「无人机专家」主页</span>
          </button>
          <span class="text-xs px-2.5 py-0.5 rounded bg-slate-800 text-slate-300 border border-slate-700">${sub.categoryBadge}</span>
        </div>

        <!-- Subject Header Banner -->
        <div class="rounded-2xl bg-gradient-to-r from-slate-900 to-slate-800 border border-cyan-800/40 p-6 shadow-xl">
          <h1 class="text-2xl font-black text-white">${sub.title}</h1>
          <p class="text-sm text-cyan-400 mt-1 font-medium">${sub.subtitle}</p>
          <p class="text-sm text-slate-300 mt-3 leading-relaxed">${sub.description}</p>

          <div class="flex flex-wrap gap-2 mt-4">
            ${sub.tags.map(t => `<span class="text-xs px-2.5 py-1 rounded-md bg-slate-800/80 text-slate-200 border border-slate-700">${t}</span>`).join('')}
          </div>

          <div class="mt-6 pt-4 border-t border-slate-800 flex flex-wrap items-center justify-between gap-3">
            <div class="text-sm text-slate-400">
              题库收录情况：<span class="font-bold text-white">${subQuestions.length > 0 ? `${subQuestions.length} 道题目` : '0 道（暂未录入题目）'}</span>
            </div>
            <div class="flex space-x-3">
              <button onclick='app.openImportForSubject("${sub.id}")' class="px-4 py-2 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white text-sm font-semibold shadow transition">
                + 为本科目导入题库 (Word/文本)
              </button>
              ${subQuestions.length > 0 ? `
                <button onclick='app.startQuizWithList("${sub.title} 专项特训", ${JSON.stringify(subQuestions)})' class="px-4 py-2 rounded-xl bg-emerald-600 hover:bg-emerald-500 text-white text-sm font-semibold shadow transition">
                  开始答题
                </button>
              ` : ''}
            </div>
          </div>
        </div>

        <!-- Core Knowledge Syllabus (考点大纲与知识图谱) -->
        <div class="rounded-2xl bg-slate-900/90 border border-slate-800 p-6 shadow-xl">
          <h2 class="text-lg font-bold text-white mb-4 flex items-center space-x-2">
            <i data-lucide="compass" class="w-5 h-5 text-cyan-400"></i>
            <span>学科知识纲要体系与核心考点架构</span>
          </h2>

          <div class="space-y-3">
            ${sub.keyTopics.map((topic, idx) => `
              <div class="p-4 rounded-xl bg-slate-800/50 border border-slate-700/60 flex items-start space-x-3">
                <span class="w-6 h-6 rounded-full bg-cyan-500/20 text-cyan-400 font-bold text-xs flex items-center justify-center shrink-0 mt-0.5">
                  0${idx + 1}
                </span>
                <div class="flex-1">
                  <div class="text-sm font-bold text-white">${topic}</div>
                  <div class="text-xs text-slate-400 mt-1">
                    涵盖理论原理深度解析、典型系统架构指标与实战考评核心考查方向。
                  </div>
                </div>
              </div>
            `).join('')}
          </div>
        </div>
      </div>
    `;
  }

  /* ------------------- 3. 试题答题 / 刷题引擎 (Quiz View) ------------------- */

  startQuizAll() {
    this.startQuizWithList('全部题型 · 综合练习', [...this.questions], '无人机全考点综合测评');
  }

  startQuizByType(type) {
    const list = this.questions.filter(q => q.type === type);
    const typeNames = { single: '单选题', multi: '多选题', judge: '判断题', fill: '填空题', short: '简答题' };
    this.startQuizWithList(typeNames[type] || '题型专练', list, `共 ${list.length} 道针对性专项突破题`);
  }

  startQuizWithList(title, list, subtitle = '') {
    if (!list || list.length === 0) {
      alert('该分类下目前暂无题目，您可以使用顶部的「导入试题」功能添加！');
      return;
    }

    let finalQuestions = [...list];
    if (this.settings.randomOrder) {
      finalQuestions = this.shuffle([...finalQuestions]);
    }

    this.quizContext = {
      title,
      subtitle: subtitle || `共 ${finalQuestions.length} 道练习题`,
      questions: finalQuestions,
      currentIndex: 0,
      mode: this.settings.mode,
      examTimer: null,
      examSecondsLeft: 0,
      isExamFinished: false
    };

    this.navigate('quiz');
  }

  renderQuizScreen() {
    const ctx = this.quizContext;
    if (!ctx.questions || ctx.questions.length === 0) return this.renderHomeScreen();

    const q = ctx.questions[ctx.currentIndex];
    const p = this.getProgress(q.id);
    const total = ctx.questions.length;
    const currentNum = ctx.currentIndex + 1;

    const isPractice = ctx.mode === 'PRACTICE';
    const showExplanation = !isPractice || p.isAnswered;

    return `
      <div class="space-y-4 max-w-3xl mx-auto">
        <!-- Top Control Bar -->
        <div class="flex items-center justify-between bg-slate-900/90 p-4 rounded-xl border border-slate-800">
          <div class="flex items-center space-x-3">
            <button onclick="app.navigate('home')" class="p-1.5 rounded-lg bg-slate-800 text-slate-300 hover:text-white transition">
              <i data-lucide="arrow-left" class="w-5 h-5"></i>
            </button>
            <div>
              <div class="text-sm font-bold text-white">${ctx.title}</div>
              <div class="text-xs text-slate-400">题号：<span class="text-cyan-400 font-bold">${currentNum}</span> / ${total}</div>
            </div>
          </div>

          <div class="flex items-center space-x-2">
            <!-- Favorite button -->
            <button onclick="app.toggleFavorite('${q.id}')" class="p-2 rounded-lg border ${p.isFavorite ? 'bg-amber-500/20 border-amber-500/50 text-amber-400' : 'bg-slate-800 border-slate-700 text-slate-400 hover:text-white'} transition" title="收藏此题">
              <i data-lucide="bookmark" class="w-4 h-4"></i>
            </button>

            <!-- Mode Switch -->
            <button onclick="app.toggleQuizMode()" class="px-2.5 py-1 rounded-md text-xs font-semibold ${isPractice ? 'bg-slate-800 text-slate-300' : 'bg-amber-600/30 text-amber-300 border border-amber-500/40'}">
              ${isPractice ? '刷题模式' : '背题模式'}
            </button>
          </div>
        </div>

        <!-- Progress Bar -->
        <div class="w-full bg-slate-800 h-1.5 rounded-full overflow-hidden">
          <div class="bg-cyan-500 h-full transition-all duration-300" style="width: ${(currentNum / total) * 100}%"></div>
        </div>

        <!-- Question Card -->
        <div class="rounded-2xl bg-slate-900 border border-slate-800 p-6 shadow-xl space-y-6">
          <!-- Question Type and Topic Badge -->
          <div class="flex items-center justify-between">
            <div class="flex items-center space-x-2">
              <span class="px-2.5 py-0.5 rounded text-xs font-bold ${this.getTypeBadgeColor(q.type)}">
                ${this.getTypeName(q.type)}
              </span>
              <span class="text-xs text-slate-400">${q.topic || '综合理论'}</span>
            </div>
            ${p.isAnswered ? `
              <span class="text-xs font-bold ${p.isCorrect ? 'text-emerald-400' : 'text-rose-400'} flex items-center gap-1">
                <i data-lucide="${p.isCorrect ? 'check-circle' : 'x-circle'}" class="w-4 h-4"></i>
                ${p.isCorrect ? '回答正确' : '回答错误'}
              </span>
            ` : ''}
          </div>

          <!-- Question Prompt -->
          <div class="text-lg font-bold text-white leading-relaxed">
            ${currentNum}. ${q.question}
          </div>

          <!-- Options or Input Area -->
          <div class="space-y-3">
            ${this.renderQuestionInteractiveBody(q, p, isPractice)}
          </div>

          <!-- Answer & Explanation Card -->
          ${showExplanation ? `
            <div class="mt-6 p-4 rounded-xl bg-slate-800/80 border border-slate-700/80 space-y-2 animate-fadeIn">
              <div class="flex items-center justify-between text-xs">
                <span class="font-bold text-cyan-400">参考正确答案：<span class="text-white text-sm ml-1 font-mono">${q.answer.join('、')}</span></span>
                ${q.difficulty ? `<span class="text-slate-400">难度：${'★'.repeat(q.difficulty)}</span>` : ''}
              </div>
              <div class="text-xs text-slate-300 leading-relaxed pt-2 border-t border-slate-700/60">
                <span class="font-semibold text-slate-400">【解析】</span>${q.explanation || '暂无详细解析。'}
              </div>
            </div>
          ` : ''}

          <!-- Pagination Bar -->
          <div class="pt-4 border-t border-slate-800 flex items-center justify-between">
            <button onclick="app.prevQuestion()" class="px-4 py-2 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-300 disabled:opacity-40 disabled:hover:bg-slate-800 text-sm font-medium transition flex items-center space-x-1" ${ctx.currentIndex === 0 ? 'disabled' : ''}>
              <i data-lucide="chevron-left" class="w-4 h-4"></i>
              <span>上一题</span>
            </button>

            <span class="text-xs text-slate-500 font-mono">${currentNum} / ${total}</span>

            <button onclick="app.nextQuestion()" class="px-5 py-2 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white disabled:opacity-40 text-sm font-semibold transition flex items-center space-x-1 shadow" ${ctx.currentIndex === total - 1 ? 'disabled' : ''}>
              <span>下一题</span>
              <i data-lucide="chevron-right" class="w-4 h-4"></i>
            </button>
          </div>
        </div>
      </div>
    `;
  }

  renderQuestionInteractiveBody(q, p, isPractice) {
    if (q.type === 'single' || q.type === 'judge') {
      const options = q.options && q.options.length > 0 ? q.options : [
        { key: 'A', text: '正确' },
        { key: 'B', text: '错误' }
      ];

      return options.map(opt => {
        const isSelected = p.selected.includes(opt.key);
        const isRightAnswer = q.answer.includes(opt.key);

        let style = 'bg-slate-800/60 border-slate-700 text-slate-200 hover:border-cyan-500/60 hover:bg-slate-800';
        if (p.isAnswered || !isPractice) {
          if (isRightAnswer) {
            style = 'bg-emerald-950/60 border-emerald-500 text-emerald-200 font-semibold';
          } else if (isSelected && !isRightAnswer) {
            style = 'bg-rose-950/60 border-rose-500 text-rose-200';
          }
        } else if (isSelected) {
          style = 'bg-cyan-950/60 border-cyan-500 text-cyan-200 font-semibold';
        }

        return `
          <button onclick="app.submitOption('${q.id}', '${opt.key}', false)" class="w-full text-left p-3.5 rounded-xl border transition flex items-start space-x-3 ${style}">
            <span class="w-6 h-6 rounded-full border border-current flex items-center justify-center text-xs font-bold shrink-0 mt-0.5">
              ${opt.key}
            </span>
            <span class="text-sm leading-relaxed">${opt.text}</span>
          </button>
        `;
      }).join('');
    }

    if (q.type === 'multi') {
      return `
        <div class="space-y-3">
          ${q.options.map(opt => {
            const isSelected = p.selected.includes(opt.key);
            const isRightAnswer = q.answer.includes(opt.key);

            let style = 'bg-slate-800/60 border-slate-700 text-slate-200 hover:border-cyan-500/60';
            if (p.isAnswered || !isPractice) {
              if (isRightAnswer) {
                style = 'bg-emerald-950/60 border-emerald-500 text-emerald-200 font-semibold';
              } else if (isSelected && !isRightAnswer) {
                style = 'bg-rose-950/60 border-rose-500 text-rose-200';
              }
            } else if (isSelected) {
              style = 'bg-cyan-950/60 border-cyan-500 text-cyan-200 font-semibold';
            }

            return `
              <button onclick="app.toggleMultiOption('${q.id}', '${opt.key}')" class="w-full text-left p-3.5 rounded-xl border transition flex items-start space-x-3 ${style}">
                <span class="w-6 h-6 rounded-md border border-current flex items-center justify-center text-xs font-bold shrink-0 mt-0.5">
                  ${opt.key}
                </span>
                <span class="text-sm leading-relaxed">${opt.text}</span>
              </button>
            `;
          }).join('')}

          ${!p.isAnswered && isPractice ? `
            <div class="pt-2 text-right">
              <button onclick="app.submitMultiAnswer('${q.id}')" class="px-5 py-2 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white font-semibold text-sm shadow transition">
                确认提交本题
              </button>
            </div>
          ` : ''}
        </div>
      `;
    }

    if (q.type === 'fill' || q.type === 'short') {
      return `
        <div class="space-y-3">
          <textarea id="text-input-${q.id}" rows="${q.type === 'short' ? 4 : 2}" placeholder="在此输入您的作答内容进行模拟自评..." class="w-full bg-slate-800 border border-slate-700 rounded-xl p-3 text-sm text-slate-200 focus:outline-none focus:border-cyan-500 resize-none font-sans" ${p.isAnswered ? 'readonly' : ''}>${p.textResponse || ''}</textarea>

          ${!p.isAnswered && isPractice ? `
            <div class="flex items-center justify-between pt-1">
              <span class="text-xs text-slate-500">完成作答后点击查看专家标准要点与自评</span>
              <button onclick="app.submitTextAnswer('${q.id}', '${q.type}')" class="px-5 py-2 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white font-semibold text-sm shadow transition">
                提交并查看答案
              </button>
            </div>
          ` : ''}
        </div>
      `;
    }

    return '';
  }

  submitOption(qid, optKey, isMulti) {
    const p = this.getProgress(qid);
    const q = this.questions.find(x => x.id === qid);
    if (!q) return;

    if (p.isAnswered) return; // 已答不可重复提交

    p.selected = [optKey];
    p.isAnswered = true;
    p.isCorrect = q.answer.length === 1 && q.answer[0] === optKey;
    p.isWrong = !p.isCorrect;

    this.saveProgress();
    this.render();
  }

  toggleMultiOption(qid, optKey) {
    const p = this.getProgress(qid);
    if (p.isAnswered) return;

    if (p.selected.includes(optKey)) {
      p.selected = p.selected.filter(k => k !== optKey);
    } else {
      p.selected.push(optKey);
      p.selected.sort();
    }
    this.render();
  }

  submitMultiAnswer(qid) {
    const p = this.getProgress(qid);
    const q = this.questions.find(x => x.id === qid);
    if (!q) return;

    if (p.selected.length === 0) {
      alert('请先选择至少一个选项！');
      return;
    }

    p.isAnswered = true;
    const sortedAns = [...q.answer].sort();
    const sortedSel = [...p.selected].sort();
    p.isCorrect = sortedAns.join('') === sortedSel.join('');
    p.isWrong = !p.isCorrect;

    this.saveProgress();
    this.render();
  }

  submitTextAnswer(qid, type) {
    const input = document.getElementById(`text-input-${qid}`);
    const text = input ? input.value.trim() : '';

    const p = this.getProgress(qid);
    p.textResponse = text;
    p.isAnswered = true;
    p.isCorrect = true; // 主观题/填空自评模式

    this.saveProgress();
    this.render();
  }

  prevQuestion() {
    if (this.quizContext.currentIndex > 0) {
      this.quizContext.currentIndex--;
      this.render();
      window.scrollTo({ top: 0, behavior: 'smooth' });
    }
  }

  nextQuestion() {
    if (this.quizContext.currentIndex < this.quizContext.questions.length - 1) {
      this.quizContext.currentIndex++;
      this.render();
      window.scrollTo({ top: 0, behavior: 'smooth' });
    }
  }

  toggleFavorite(qid) {
    const p = this.getProgress(qid);
    p.isFavorite = !p.isFavorite;
    this.saveProgress();
    this.render();
  }

  toggleQuizMode() {
    this.settings.mode = this.settings.mode === 'PRACTICE' ? 'MEMORIZE' : 'PRACTICE';
    this.quizContext.mode = this.settings.mode;
    this.saveSettings();
    this.render();
  }

  /* ------------------- 4. 全真模拟考试 (Exam) ------------------- */

  startExam() {
    // 随机抽选 50 道题 (单选30 + 多选10 + 判断10，满分100分)
    const singles = this.shuffle(this.questions.filter(q => q.type === 'single')).slice(0, 30);
    const multis = this.shuffle(this.questions.filter(q => q.type === 'multi')).slice(0, 10);
    const judges = this.shuffle(this.questions.filter(q => q.type === 'judge')).slice(0, 10);

    const examQuestions = [...singles, ...multis, ...judges];
    if (examQuestions.length < 10) {
      alert('题库题目不足，无法生成完整模拟试卷！');
      return;
    }

    if (this.quizContext.examTimer) {
      clearInterval(this.quizContext.examTimer);
    }

    this.quizContext = {
      title: '无人机理论执照全真模拟考试',
      subtitle: '满分 100 分 · 及格 80 分 · 45分钟',
      questions: examQuestions,
      currentIndex: 0,
      mode: 'PRACTICE',
      examSecondsLeft: 45 * 60,
      isExamFinished: false,
      examUserAnswers: {} // qid -> []
    };

    this.quizContext.examTimer = setInterval(() => {
      if (this.quizContext.examSecondsLeft > 0) {
        this.quizContext.examSecondsLeft--;
        this.updateExamTimerDisplay();
      } else {
        this.finishExam(true);
      }
    }, 1000);

    this.navigate('exam');
  }

  updateExamTimerDisplay() {
    const el = document.getElementById('exam-timer-text');
    if (!el) return;
    const m = Math.floor(this.quizContext.examSecondsLeft / 60);
    const s = this.quizContext.examSecondsLeft % 60;
    el.innerText = `${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}`;
  }

  finishExam(isTimeout = false) {
    if (this.quizContext.examTimer) {
      clearInterval(this.quizContext.examTimer);
      this.quizContext.examTimer = null;
    }

    this.quizContext.isExamFinished = true;
    this.render();
  }

  renderExamScreen() {
    const ctx = this.quizContext;
    if (ctx.isExamFinished) {
      return this.renderExamResult();
    }

    const q = ctx.questions[ctx.currentIndex];
    const currentNum = ctx.currentIndex + 1;
    const total = ctx.questions.length;

    const answers = ctx.examUserAnswers || {};
    const selected = answers[q.id] || [];

    const m = Math.floor(ctx.examSecondsLeft / 60);
    const s = ctx.examSecondsLeft % 60;
    const timerStr = `${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}`;

    return `
      <div class="space-y-4 max-w-3xl mx-auto">
        <!-- Exam Header -->
        <div class="flex items-center justify-between bg-slate-900 p-4 rounded-xl border border-slate-800">
          <div>
            <div class="text-base font-bold text-white">${ctx.title}</div>
            <div class="text-xs text-slate-400">题号：<span class="text-cyan-400 font-bold">${currentNum}</span> / ${total}</div>
          </div>

          <div class="flex items-center space-x-4">
            <div class="flex items-center space-x-1.5 px-3 py-1.5 rounded-lg bg-rose-500/10 border border-rose-500/30 text-rose-400 font-mono font-bold text-sm">
              <i data-lucide="timer" class="w-4 h-4"></i>
              <span id="exam-timer-text">${timerStr}</span>
            </div>

            <button onclick="if(confirm('确定提前交卷并计算总成绩？')) app.finishExam();" class="px-4 py-1.5 rounded-lg bg-emerald-600 hover:bg-emerald-500 text-white font-semibold text-xs transition">
              交卷判分
            </button>
          </div>
        </div>

        <!-- Question Body Card -->
        <div class="rounded-2xl bg-slate-900 border border-slate-800 p-6 shadow-xl space-y-6">
          <div class="flex items-center justify-between">
            <span class="px-2.5 py-0.5 rounded text-xs font-bold ${this.getTypeBadgeColor(q.type)}">
              ${this.getTypeName(q.type)} (每题2分)
            </span>
            <span class="text-xs text-slate-400">考试模式 · 实时隐藏答案</span>
          </div>

          <div class="text-lg font-bold text-white leading-relaxed">
            ${currentNum}. ${q.question}
          </div>

          <!-- Options -->
          <div class="space-y-3">
            ${(q.options && q.options.length > 0 ? q.options : [
              { key: 'A', text: '正确' },
              { key: 'B', text: '错误' }
            ]).map(opt => {
              const isChecked = selected.includes(opt.key);
              return `
                <button onclick="app.selectExamAnswer('${q.id}', '${opt.key}', '${q.type}')" class="w-full text-left p-3.5 rounded-xl border transition flex items-start space-x-3 ${isChecked ? 'bg-cyan-950/60 border-cyan-500 text-cyan-200 font-semibold' : 'bg-slate-800/60 border-slate-700 text-slate-200 hover:border-cyan-500/50'}">
                  <span class="w-6 h-6 rounded-full border border-current flex items-center justify-center text-xs font-bold shrink-0 mt-0.5">
                    ${opt.key}
                  </span>
                  <span class="text-sm leading-relaxed">${opt.text}</span>
                </button>
              `;
            }).join('')}
          </div>

          <!-- Pagination -->
          <div class="pt-4 border-t border-slate-800 flex items-center justify-between">
            <button onclick="app.prevQuestion()" class="px-4 py-2 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-300 disabled:opacity-40 text-sm font-medium transition" ${ctx.currentIndex === 0 ? 'disabled' : ''}>
              上一题
            </button>
            <span class="text-xs text-slate-500 font-mono">${currentNum} / ${total}</span>
            <button onclick="app.nextQuestion()" class="px-5 py-2 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white disabled:opacity-40 text-sm font-semibold transition" ${ctx.currentIndex === total - 1 ? 'disabled' : ''}>
              下一题
            </button>
          </div>
        </div>

        <!-- Question Card Grid Jump (答题卡) -->
        <div class="bg-slate-900/80 p-4 rounded-xl border border-slate-800">
          <div class="text-xs text-slate-400 font-medium mb-3">答题卡快速跳转：</div>
          <div class="flex flex-wrap gap-1.5">
            ${ctx.questions.map((item, idx) => {
              const isAnswered = answers[item.id] && answers[item.id].length > 0;
              const isCurrent = idx === ctx.currentIndex;
              let style = isAnswered ? 'bg-cyan-600 text-white' : 'bg-slate-800 text-slate-400';
              if (isCurrent) style += ' ring-2 ring-white';
              return `
                <button onclick="app.jumpToQuestion(${idx})" class="w-8 h-8 rounded text-xs font-mono font-semibold transition ${style}">
                  ${idx + 1}
                </button>
              `;
            }).join('')}
          </div>
        </div>
      </div>
    `;
  }

  selectExamAnswer(qid, key, type) {
    if (!this.quizContext.examUserAnswers) {
      this.quizContext.examUserAnswers = {};
    }
    const current = this.quizContext.examUserAnswers[qid] || [];
    if (type === 'multi') {
      if (current.includes(key)) {
        this.quizContext.examUserAnswers[qid] = current.filter(k => k !== key);
      } else {
        this.quizContext.examUserAnswers[qid] = [...current, key].sort();
      }
    } else {
      this.quizContext.examUserAnswers[qid] = [key];
    }
    this.render();
  }

  jumpToQuestion(index) {
    this.quizContext.currentIndex = index;
    this.render();
  }

  renderExamResult() {
    const ctx = this.quizContext;
    const answers = ctx.examUserAnswers || {};
    let score = 0;
    let rightCount = 0;
    let wrongCount = 0;

    ctx.questions.forEach(q => {
      const userAns = answers[q.id] || [];
      const isRight = [...q.answer].sort().join('') === [...userAns].sort().join('');
      if (isRight) {
        score += 2;
        rightCount++;
      } else {
        wrongCount++;
        // 自动记入错题本
        const p = this.getProgress(q.id);
        p.isWrong = true;
      }
    });
    this.saveProgress();

    const isPassed = score >= 80;

    return `
      <div class="max-w-2xl mx-auto space-y-6">
        <div class="rounded-2xl bg-slate-900 border border-slate-800 p-8 text-center shadow-2xl">
          <div class="w-20 h-20 rounded-full mx-auto flex items-center justify-center text-3xl font-black mb-4 ${isPassed ? 'bg-emerald-500/20 text-emerald-400 border border-emerald-500/40' : 'bg-rose-500/20 text-rose-400 border border-rose-500/40'}">
            ${score}
          </div>

          <h2 class="text-2xl font-black text-white">${isPassed ? '恭喜！顺利通过理论考核' : '考核未通过，仍需强化突破'}</h2>
          <p class="text-sm text-slate-400 mt-2">
            总分 100 分 · 及格线 80 分 · 本次作答共 ${ctx.questions.length} 道
          </p>

          <div class="grid grid-cols-2 gap-4 my-6 p-4 rounded-xl bg-slate-800/60 border border-slate-700/60 max-w-sm mx-auto">
            <div>
              <div class="text-xs text-slate-400">正确题数</div>
              <div class="text-xl font-bold text-emerald-400 mt-1">${rightCount} 道</div>
            </div>
            <div>
              <div class="text-xs text-slate-400">错误题数</div>
              <div class="text-xl font-bold text-rose-400 mt-1">${wrongCount} 道</div>
            </div>
          </div>

          <div class="flex justify-center space-x-3">
            <button onclick="app.navigate('wrong')" class="px-5 py-2.5 rounded-xl bg-slate-800 hover:bg-slate-700 text-slate-200 text-sm font-semibold transition">
              复盘做错的题目
            </button>
            <button onclick="app.navigate('home')" class="px-6 py-2.5 rounded-xl bg-cyan-600 hover:bg-cyan-500 text-white text-sm font-bold shadow-lg shadow-cyan-600/30 transition">
              返回主页
            </button>
          </div>
        </div>
      </div>
    `;
  }

  /* ------------------- 5. 专项突破（错题本 / 收藏夹） ------------------- */

  renderSpecialBookScreen(type, title, subtitle) {
    const list = this.questions.filter(q => {
      const p = this.userProgress[q.id];
      if (!p) return false;
      return type === 'wrong' ? p.isWrong : p.isFavorite;
    });

    return `
      <div class="space-y-6">
        <div class="flex items-center justify-between">
          <button onclick="app.navigate('home')" class="flex items-center space-x-1.5 text-sm text-slate-400 hover:text-white transition">
            <i data-lucide="arrow-left" class="w-4 h-4"></i>
            <span>返回「无人机专家」主页</span>
          </button>
          ${list.length > 0 ? `
            <button onclick='app.startQuizWithList("${title}", ${JSON.stringify(list)})' class="px-4 py-1.5 rounded-lg bg-cyan-600 hover:bg-cyan-500 text-white text-xs font-semibold shadow transition">
              全部开始练习 (${list.length})
            </button>
          ` : ''}
        </div>

        <div>
          <h1 class="text-2xl font-black text-white">${title}</h1>
          <p class="text-sm text-slate-400 mt-1">${subtitle} · 当前共收录 ${list.length} 道</p>
        </div>

        ${list.length === 0 ? `
          <div class="rounded-2xl bg-slate-900 border border-slate-800 p-12 text-center">
            <i data-lucide="${type === 'wrong' ? 'check-circle-2' : 'bookmark'}" class="w-12 h-12 mx-auto text-slate-600 mb-3"></i>
            <div class="text-base font-bold text-slate-400">${type === 'wrong' ? '太棒了，目前没有错题！' : '暂无收藏题目'}</div>
            <p class="text-xs text-slate-500 mt-1">在刷题过程中随时可点击收藏重要考点</p>
          </div>
        ` : `
          <div class="space-y-3">
            ${list.map((q, idx) => `
              <div class="rounded-xl bg-slate-900 border border-slate-800 p-4 hover:border-slate-700 transition">
                <div class="flex items-start justify-between gap-3">
                  <div class="space-y-1">
                    <div class="flex items-center space-x-2">
                      <span class="px-2 py-0.5 rounded text-[10px] font-bold ${this.getTypeBadgeColor(q.type)}">
                        ${this.getTypeName(q.type)}
                      </span>
                      <span class="text-xs text-slate-400">${q.topic || '综合理论'}</span>
                    </div>
                    <div class="text-sm font-bold text-white">${idx + 1}. ${q.question}</div>
                    <div class="text-xs text-slate-400">参考答案：<span class="text-cyan-400 font-bold">${q.answer.join('、')}</span></div>
                  </div>

                  <button onclick='app.startQuizWithList("${title}", [${JSON.stringify(q)}])' class="px-3 py-1.5 rounded-lg bg-slate-800 hover:bg-slate-700 text-cyan-300 text-xs font-medium shrink-0 transition">
                    做这道题
                  </button>
                </div>
              </div>
            `).join('')}
          </div>
        `}
      </div>
    `;
  }

  /* ------------------- 6. 全局搜索 ------------------- */

  openSearch() {
    this.navigate('search');
  }

  renderSearchScreen() {
    return `
      <div class="space-y-6 max-w-3xl mx-auto">
        <div class="flex items-center space-x-3">
          <button onclick="app.navigate('home')" class="p-2 rounded-lg bg-slate-800 text-slate-300 hover:text-white transition">
            <i data-lucide="arrow-left" class="w-5 h-5"></i>
          </button>
          <div class="flex-1 relative">
            <input type="text" id="global-search-input" oninput="app.handleSearch(this.value)" placeholder="搜索考点、法规、题目关键字（如：空域、伯努利、微多普勒）..." class="w-full bg-slate-900 border border-slate-700 rounded-xl px-4 py-3 pl-11 text-sm text-slate-200 focus:outline-none focus:border-cyan-500 shadow-xl font-sans">
            <i data-lucide="search" class="w-5 h-5 absolute left-3.5 top-3.5 text-slate-500"></i>
          </div>
        </div>

        <div id="search-results-container" class="space-y-3">
          <div class="text-center py-12 text-slate-500 text-sm">请输入关键字检索全系统真题</div>
        </div>
      </div>
    `;
  }

  handleSearch(keyword) {
    const container = document.getElementById('search-results-container');
    if (!container) return;

    const term = keyword.trim().toLowerCase();
    if (!term) {
      container.innerHTML = '<div class="text-center py-12 text-slate-500 text-sm">请输入关键字检索全系统真题</div>';
      return;
    }

    const matches = this.questions.filter(q => {
      const inQ = q.question.toLowerCase().includes(term);
      const inExp = (q.explanation || '').toLowerCase().includes(term);
      const inTopic = (q.topic || '').toLowerCase().includes(term);
      return inQ || inExp || inTopic;
    });

    if (matches.length === 0) {
      container.innerHTML = `<div class="text-center py-12 text-slate-500 text-sm">未检索到包含 "${keyword}" 的相关题目</div>`;
      return;
    }

    container.innerHTML = `
      <div class="text-xs text-slate-400 mb-2">检索到 <span class="text-cyan-400 font-bold">${matches.length}</span> 道相关试题：</div>
      <div class="space-y-3">
        ${matches.map((q, idx) => `
          <div class="rounded-xl bg-slate-900 border border-slate-800 p-4 hover:border-cyan-500/40 transition">
            <div class="flex items-start justify-between gap-3">
              <div>
                <div class="flex items-center space-x-2 mb-1">
                  <span class="px-2 py-0.5 rounded text-[10px] font-bold ${this.getTypeBadgeColor(q.type)}">
                    ${this.getTypeName(q.type)}
                  </span>
                  <span class="text-xs text-slate-400">${q.topic || '综合理论'}</span>
                </div>
                <div class="text-sm font-bold text-white">${q.question}</div>
                <div class="text-xs text-slate-400 mt-1">答案：<span class="text-cyan-400 font-bold">${q.answer.join('、')}</span></div>
                ${q.explanation ? `<div class="text-xs text-slate-500 mt-1">${q.explanation}</div>` : ''}
              </div>
              <button onclick='app.startQuizWithList("搜索练习", [${JSON.stringify(q)}])' class="px-3 py-1.5 rounded-lg bg-slate-800 hover:bg-slate-700 text-cyan-300 text-xs font-medium shrink-0 transition">
                练这道题
              </button>
            </div>
          </div>
        `).join('')}
      </div>
    `;
    if (window.lucide) window.lucide.createIcons();
  }

  /* ------------------- 7. 导入 Word (.docx) / 试题文本 ------------------- */

  openImportModal() {
    const modal = document.getElementById('import-modal');
    if (modal) modal.classList.remove('hidden');
    if (window.lucide) window.lucide.createIcons();
  }

  closeImportModal() {
    const modal = document.getElementById('import-modal');
    if (modal) modal.classList.add('hidden');
  }

  openImportForSubject(subjectId) {
    this.openImportModal();
    const select = document.getElementById('import-target-subject');
    if (select) select.value = subjectId;
  }

  handleFileSelect(event) {
    const file = event.target.files[0];
    if (!file) return;

    const status = document.getElementById('import-status-text');
    if (status) status.innerText = `正在读取并解析文件：${file.name}...`;

    if (file.name.endsWith('.docx')) {
      if (typeof window.mammoth !== 'undefined') {
        const reader = new FileReader();
        reader.onload = (loadEvent) => {
          const arrayBuffer = loadEvent.target.result;
          window.mammoth.extractRawText({ arrayBuffer: arrayBuffer })
            .then(result => {
              const text = result.value;
              const textarea = document.getElementById('import-text-input');
              if (textarea) textarea.value = text;
              if (status) status.innerText = `Word 文档提取成功（${text.length} 字符），请确认后点击导入`;
            })
            .catch(err => {
              console.error('Word parsing failed', err);
              if (status) status.innerText = `Word 解析失败，请重试或直接复制文字`;
            });
        };
        reader.readAsArrayBuffer(file);
      } else {
        alert('Mammoth.js 插件尚未加载完毕，请稍候重试');
      }
    } else {
      // 文本文件
      const reader = new FileReader();
      reader.onload = (loadEvent) => {
        const text = loadEvent.target.result;
        const textarea = document.getElementById('import-text-input');
        if (textarea) textarea.value = text;
        if (status) status.innerText = `文件读取成功，请确认后点击导入`;
      };
      reader.readAsText(file);
    }
  }

  executeImport() {
    const textarea = document.getElementById('import-text-input');
    const text = textarea ? textarea.value.trim() : '';
    if (!text) {
      alert('请先上传文件或粘贴题目内容！');
      return;
    }

    const select = document.getElementById('import-target-subject');
    const subjectId = select ? select.value : 'uav_foundation';
    const subjectMap = {
      uav_foundation: '无人机技术基础',
      counter_uas_tech: '低空小型无人飞行器探测反制技术及应用',
      radar_detection: '雷达探测技术',
      radio_detection: '无线电探测技术',
      optoelectronic_detection: '光电探测原理',
      electromagnetic_jamming: '电磁干扰技术'
    };
    const targetTopic = subjectMap[subjectId] || '无人机理论拓展';

    const parsed = this.parseRawQuestionText(text, targetTopic, subjectId);
    if (parsed.length === 0) {
      alert('未能识别出有效试题。请检查题目格式是否包含题号（如 1. 2.）及答案（如“答案：A”）。');
      return;
    }

    // 存入题库
    this.questions = [...this.questions, ...parsed];
    this.saveQuestions();

    alert(`成功识别并导入 ${parsed.length} 道题目到【${targetTopic}】！`);
    this.closeImportModal();
    if (textarea) textarea.value = '';
    this.render();
  }

  parseRawQuestionText(text, topic, subjectId) {
    const lines = text.split(/\r?\n/).map(l => l.trim()).filter(l => l.length > 0);
    const questions = [];

    let currentQ = null;

    for (let i = 0; i < lines.length; i++) {
      const line = lines[i];

      // 匹配题干起始：例如 "1. ", "1、", "(1) "
      const numMatch = line.match(/^(\d{1,4})[\.、\s]+(.*)/);
      if (numMatch) {
        if (currentQ && currentQ.question && currentQ.answer.length > 0) {
          questions.push(currentQ);
        }
        currentQ = {
          id: `custom-${Date.now()}-${Math.random().toString(36).substr(2, 5)}`,
          type: 'single',
          question: numMatch[2],
          options: [],
          answer: [],
          explanation: '',
          topic: topic,
          subjectId: subjectId,
          difficulty: 1
        };
        continue;
      }

      if (!currentQ) continue;

      // 匹配选项：A. B. C. D.
      const optMatch = line.match(/^([A-Z])[\.、\s]+(.*)/);
      if (optMatch) {
        currentQ.options.push({
          key: optMatch[1],
          text: optMatch[2]
        });
        continue;
      }

      // 匹配答案：例如 "答案：A" 或 "答案: ABCD"
      const ansMatch = line.match(/^(?:答案|参考答案|正确答案)[:：\s]+([A-Za-z0-9对错√×]+)/i);
      if (ansMatch) {
        let rawAns = ansMatch[1].trim().toUpperCase();
        if (rawAns === '对' || rawAns === '√' || rawAns === '正确') rawAns = 'A';
        if (rawAns === '错' || rawAns === '×' || rawAns === '错误') rawAns = 'B';

        const ansList = rawAns.split('').filter(c => /[A-Z]/.test(c));
        currentQ.answer = ansList;
        if (ansList.length > 1) {
          currentQ.type = 'multi';
        } else if (currentQ.options.length === 2) {
          currentQ.type = 'judge';
        }
        continue;
      }

      // 匹配解析：例如 "解析：..."
      const expMatch = line.match(/^(?:解析|考点解析)[:：\s]+(.*)/);
      if (expMatch) {
        currentQ.explanation = expMatch[1].trim();
        continue;
      }

      // 无法识别的延续行追加到题干或解析
      if (currentQ.answer.length === 0 && currentQ.options.length === 0) {
        currentQ.question += ' ' + line;
      } else if (currentQ.explanation) {
        currentQ.explanation += ' ' + line;
      }
    }

    if (currentQ && currentQ.question && currentQ.answer.length > 0) {
      questions.push(currentQ);
    }

    return questions;
  }

  resetBank() {
    if (confirm('确定要将题库恢复为初始的 145 道全量真题并保留作答进度吗？')) {
      this.questions = [...window.DEFAULT_QUESTIONS];
      this.saveQuestions();
      this.render();
      alert('已成功重置题库！');
    }
  }

  /* ------------------- 辅助函数 ------------------- */

  getTypeName(type) {
    const map = { single: '单选题', multi: '多选题', judge: '判断题', fill: '填空题', short: '简答题' };
    return map[type] || '试题';
  }

  getTypeBadgeColor(type) {
    const map = {
      single: 'bg-sky-500/20 text-sky-400 border border-sky-500/30',
      multi: 'bg-purple-500/20 text-purple-400 border border-purple-500/30',
      judge: 'bg-teal-500/20 text-teal-400 border border-teal-500/30',
      fill: 'bg-amber-500/20 text-amber-400 border border-amber-500/30',
      short: 'bg-rose-500/20 text-rose-400 border border-rose-500/30'
    };
    return map[type] || 'bg-slate-700 text-slate-300';
  }

  shuffle(array) {
    const arr = [...array];
    for (let i = arr.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [arr[i], arr[j]] = [arr[j], arr[i]];
    }
    return arr;
  }
}

// 挂载全局实例
window.app = new DroneQuizApp();
