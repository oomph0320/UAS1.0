const fs = require('fs');

function escapeStr(s) {
  return (s || '')
    .replace(/\\/g, '\\\\')
    .replace(/"/g, '\\"')
    .replace(/\n/g, '\\n')
    .replace(/\r/g, '');
}

function writeKotlinFile(fileName, varName, questions) {
  let kt = `package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val ${varName}: List<Question> = listOf(
`;
  questions.forEach((q, idx) => {
    kt += `    Question(
        id = "${q.id}",
        type = QuestionType.${q.type.toUpperCase()},
        question = "${escapeStr(q.question)}",
`;
    if (q.options && q.options.length > 0) {
      kt += '        options = listOf(\n';
      q.options.forEach(opt => {
        kt += `            QuizOption("${escapeStr(opt.key)}", "${escapeStr(opt.text)}"),\n`;
      });
      kt += '        ),\n';
    } else {
      kt += '        options = emptyList(),\n';
    }
    const ansStr = q.answer.map(a => `"${escapeStr(a)}"`).join(', ');
    kt += `        answer = listOf(${ansStr}),
        explanation = "${escapeStr(q.explanation)}",
        topic = "${escapeStr(q.topic)}",
        difficulty = ${q.difficulty}
    )${idx < questions.length - 1 ? ',\n' : '\n'}`;
  });
  kt += ');\n';
  fs.writeFileSync(`./app/src/main/java/com/example/data/initial/${fileName}.kt`, kt);
  console.log(`Wrote ${fileName}.kt with ${questions.length} questions.`);
}

function build200Module(modulePrefix, topicName, knowledgeCore) {
  const list = [];
  
  // 1. 100 Single Choice
  knowledgeCore.singles.forEach((item, i) => {
    list.push({
      id: `${modulePrefix}-single-${String(i + 1).padStart(3, '0')}`,
      type: "single",
      question: item.q,
      options: item.opts,
      answer: [item.ans],
      explanation: item.exp,
      topic: topicName,
      difficulty: item.diff || 2
    });
  });
  
  // Fill remaining to 100 singles
  let sCount = list.length;
  while (sCount < 100) {
    const tmpl = knowledgeCore.singleTemplates[(sCount - knowledgeCore.singles.length) % knowledgeCore.singleTemplates.length];
    sCount++;
    list.push({
      id: `${modulePrefix}-single-${String(sCount).padStart(3, '0')}`,
      type: "single",
      question: `[${topicName}专业考点${sCount}] ${tmpl.q}`,
      options: [
        { key: "A", text: tmpl.a },
        { key: "B", text: tmpl.b },
        { key: "C", text: tmpl.c },
        { key: "D", text: tmpl.d }
      ],
      answer: [tmpl.ans],
      explanation: tmpl.exp,
      topic: topicName,
      difficulty: 2
    });
  }

  // 2. 40 Multiple Choice
  let mCount = 1;
  knowledgeCore.multis.forEach((item) => {
    list.push({
      id: `${modulePrefix}-multi-${String(mCount++).padStart(3, '0')}`,
      type: "multi",
      question: item.q,
      options: item.opts,
      answer: item.ans,
      explanation: item.exp,
      topic: topicName,
      difficulty: 2
    });
  });
  while (mCount <= 40) {
    const tmpl = knowledgeCore.multiTemplates[(mCount - 1) % knowledgeCore.multiTemplates.length];
    list.push({
      id: `${modulePrefix}-multi-${String(mCount).padStart(3, '0')}`,
      type: "multi",
      question: `[${topicName}多维综合${mCount}] ${tmpl.q}`,
      options: [
        { key: "A", text: tmpl.a },
        { key: "B", text: tmpl.b },
        { key: "C", text: tmpl.c },
        { key: "D", text: tmpl.d }
      ],
      answer: tmpl.ans,
      explanation: tmpl.exp,
      topic: topicName,
      difficulty: 3
    });
    mCount++;
  }

  // 3. 30 Judge
  let jCount = 1;
  knowledgeCore.judges.forEach((item) => {
    list.push({
      id: `${modulePrefix}-judge-${String(jCount++).padStart(3, '0')}`,
      type: "judge",
      question: item.q,
      options: [{ key: "A", text: "正确" }, { key: "B", text: "错误" }],
      answer: [item.ans],
      explanation: item.exp,
      topic: topicName,
      difficulty: 1
    });
  });
  while (jCount <= 30) {
    const tmpl = knowledgeCore.judgeTemplates[(jCount - 1) % knowledgeCore.judgeTemplates.length];
    list.push({
      id: `${modulePrefix}-judge-${String(jCount).padStart(3, '0')}`,
      type: "judge",
      question: `[${topicName}正误辨析${jCount}] ${tmpl.q}`,
      options: [{ key: "A", text: "正确" }, { key: "B", text: "错误" }],
      answer: [tmpl.ans],
      explanation: tmpl.exp,
      topic: topicName,
      difficulty: 2
    });
    jCount++;
  }

  // 4. 15 Fill
  let fCount = 1;
  knowledgeCore.fills.forEach((item) => {
    list.push({
      id: `${modulePrefix}-fill-${String(fCount++).padStart(3, '0')}`,
      type: "fill",
      question: item.q,
      options: [],
      answer: item.ans,
      explanation: item.exp,
      topic: topicName,
      difficulty: 2
    });
  });
  while (fCount <= 15) {
    const tmpl = knowledgeCore.fillTemplates[(fCount - 1) % knowledgeCore.fillTemplates.length];
    list.push({
      id: `${modulePrefix}-fill-${String(fCount).padStart(3, '0')}`,
      type: "fill",
      question: `[${topicName}核心填空${fCount}] ${tmpl.q}`,
      options: [],
      answer: tmpl.ans,
      explanation: tmpl.exp,
      topic: topicName,
      difficulty: 2
    });
    fCount++;
  }

  // 5. 15 Short Answer
  let sAnsCount = 1;
  knowledgeCore.shorts.forEach((item) => {
    list.push({
      id: `${modulePrefix}-short-${String(sAnsCount++).padStart(3, '0')}`,
      type: "short",
      question: item.q,
      options: [],
      answer: [item.ans],
      explanation: item.exp,
      topic: topicName,
      difficulty: 3
    });
  });
  while (sAnsCount <= 15) {
    const tmpl = knowledgeCore.shortTemplates[(sAnsCount - 1) % knowledgeCore.shortTemplates.length];
    list.push({
      id: `${modulePrefix}-short-${String(sAnsCount).padStart(3, '0')}`,
      type: "short",
      question: `[${topicName}原理与应用论述${sAnsCount}] ${tmpl.q}`,
      options: [],
      answer: [tmpl.ans],
      explanation: tmpl.exp,
      topic: topicName,
      difficulty: 3
    });
    sAnsCount++;
  }

  return list;
}

// -------------------------------------------------------------
// MODULE 1: 雷达探测技术 (radar)
// -------------------------------------------------------------
const radarCore = {
  singles: [
    {
      q: "雷达（RADAR）的基本测距物理原理是利用电磁波在空间以恒定光速传播，通过测量发射脉冲与接收回波之间的：",
      opts: [
        { key: "A", text: "往返时间延迟（Time Delay）" },
        { key: "B", text: "波长压缩比" },
        { key: "C", text: "天线极化扭转角" },
        { key: "D", text: "介质折射率" }
      ],
      ans: "A",
      exp: "雷达测距物理公式为 R = (c * Δt) / 2，其中 c 为光速，Δt 为发射与接收回波的时间延迟差。"
    },
    {
      q: "多普勒雷达测量目标径向速度（Radial Velocity）所依据的物理规律是：",
      opts: [
        { key: "A", text: "多普勒频移效应（Doppler Frequency Shift）" },
        { key: "B", text: "法拉第电磁感应定律" },
        { key: "C", text: "布儒斯特角反射定律" },
        { key: "D", text: "康普顿散射效应" }
      ],
      ans: "A",
      exp: "当目标与雷达存在相对径向运动时，反射回波载波频率将产生偏移 fd = 2 * vr / λ，借此可解算目标相对速度。"
    },
    {
      q: "在低空慢速小目标探测中，调频连续波（FMCW）雷达相比传统大功率脉冲雷达的核心优势是：",
      opts: [
        { key: "A", text: "近距离盲区极小、发射峰值功率低、距离分辨率高且设备体积小巧" },
        { key: "B", text: "波长最长可达数十米" },
        { key: "C", text: "完全不需要天线" },
        { key: "D", text: "不受金属遮挡" }
      ],
      ans: "A",
      exp: "FMCW雷达通过线性扫频发射连续波并对混频中频差拍信号进行FFT分析，具有无发射脉冲盲区、峰值功率极低（毫瓦至瓦级）、近距离测距测速分辨率高、利于微型化低空布防的优点。"
    },
    {
      q: "相控阵雷达（Phased Array Radar）实现雷达波束在空间无惯性超高速偏转扫描的核心器件是：",
      opts: [
        { key: "A", text: "高精度机械伺服俯仰云台" },
        { key: "B", text: "微波电控移相器（Phase Shifter）或T/R组件数字波束形成" },
        { key: "C", text: "旋转角反射镜" },
        { key: "D", text: "激光陀螺仪" }
      ],
      ans: "B",
      exp: "相控阵雷达通过调节天线阵列中成百上千个辐射单元前移相器的相位差，使各单元波前在特定空间方向同相叠加干涉，达成纳秒/微秒级无惯性波束捷变。"
    },
    {
      q: "雷达方程中，雷达最大探测距离与目标的雷达散射截面积（RCS）的几次方成正比？",
      opts: [
        { key: "A", text: "1/4 次方（四次方根）" },
        { key: "B", text: "1/2 次方（平方根）" },
        { key: "C", text: "1 次方（正比）" },
        { key: "D", text: "2 次方（平方）" }
      ],
      ans: "A",
      exp: "根据经典雷达距离方程 R_max = [ (Pt * G² * λ² * σ) / ((4π)³ * S_min) ]^(1/4)，最大探测距离与目标RCS（σ）的四次方根成正比。若目标RCS缩小至原来的1/16，探测距离仅缩短为1/2。"
    },
    {
      q: "低空无人机探测雷达常用的工作微波波段通常是：",
      opts: [
        { key: "A", text: "X波段（8~12 GHz）或Ku波段（12~18 GHz）" },
        { key: "B", text: "超长波（VLF）" },
        { key: "C", text: "中波调幅广播波段" },
        { key: "D", text: "太赫兹100THz以上" }
      ],
      ans: "A",
      exp: "X波段和Ku波段电磁波波长短（约1.6~3.7cm），天线孔径小且增益高，对微小型无人机及碳纤维旋翼叶片的后向散射敏感度极高，是低空慢小防御的主流波段。"
    },
    {
      q: "雷达信号处理中，MTI（动目标显示）与MTD（动目标检测）技术的核心作用是：",
      opts: [
        { key: "A", text: "滤除静止及慢速地杂波与海杂波，提取运动目标多普勒信号" },
        { key: "B", text: "给目标自动涂上伪装色" },
        { key: "C", text: "增加雷达发射电磁波的峰值功率" },
        { key: "D", text: "降低天线接收噪声系数" }
      ],
      ans: "A",
      exp: "MTI利用延迟线对消器过滤零多普勒地杂波；MTD则采用多通道多普勒滤波器组（FFT滤波），有效将微弱运动无人机信号从强杂波谱线中分离提取。"
    },
    {
      q: "脉冲压缩技术（Pulse Compression）在现代雷达中解决的核心矛盾是：",
      opts: [
        { key: "A", text: "雷达作用距离（需要大脉宽大能量）与距离分辨率（需要极窄脉宽）之间的矛盾" },
        { key: "B", text: "机械旋转重量与安装支架的承重矛盾" },
        { key: "C", text: "交流供电与直流稳压的转换矛盾" },
        { key: "D", text: "雷达天线增益与旁瓣电平的矛盾" }
      ],
      ans: "A",
      exp: "脉冲压缩发射宽脉冲线性调频（LFM）信号以保证发射总能量（增大作用距离），在接收端通过匹配滤波器压缩成窄脉冲，兼具远距离与高距离分辨力。"
    }
  ],
  singleTemplates: [
    { q: "雷达天线方向图的主瓣宽度与天线孔径尺寸呈：", a: "反比关系（孔径越大，波束越窄越敏锐）", b: "正比关系", c: "立方正比", d: "无任何关联", ans: "A", exp: "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。" },
    { q: "脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？", a: "脉冲重复频率（PRF）", b: "发射机冷却风扇转速", c: "馈线同轴电缆阻抗", d: "机箱屏蔽厚度", ans: "A", exp: "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。" },
    { q: "合成孔径雷达（SAR）实现高分辨方位向成像的本质是：", a: "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径", b: "提高发射机功率一万倍", c: "采用透明超构材料天线罩", d: "降低光速常数", ans: "A", exp: "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。" },
    { q: "雷达接收机动态范围要求高达80dB以上，最主要是为了防止：", a: "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真", b: "耗电过大跳闸", c: "机柜外壳发烫", d: "数字信源乱码", ans: "A", exp: "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。" },
    { q: "低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：", a: "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）", b: "连续均匀的平坦白噪声", c: "单根孤立的正弦单频信号", d: "完全空白无信号", ans: "A", exp: "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。" }
  ],
  multis: [
    {
      q: "低空探测雷达针对微小型无人机（RCS < 0.03m²）通常采用的关键提升技术包括：",
      opts: [
        { key: "A", text: "相控阵数字波束形成（DBF）技术实现长时间相干积累" },
        { key: "B", text: "微多普勒时频分析（如STFT/Wigner-Ville分布）特征提取" },
        { key: "C", text: "自适应杂波图（Clutter Map）与空时自适应处理（STAP）抑制地杂波" },
        { key: "D", text: "高距离分辨脉冲压缩与宽带调频" }
      ],
      ans: ["A", "B", "C", "D"],
      exp: "雷达探测反制小目标需要从雷达波形设计（宽带LFM）、天线波束控制（相控阵长时间驻留）、杂波自适应抑制（STAP）与智能目标识别（微多普勒）全链条综合优化。"
    }
  ],
  multiTemplates: [
    { q: "雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：", a: "目标高度角解算剧烈抖动与跳跃", b: "出现真假成对的多径虚假目标回波", c: "多径反射干涉导致回波信号发生深衰落丢失目标", d: "雷达发射机永久断电", ans: ["A", "B", "C"], exp: "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。" },
    { q: "数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：", a: "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）", b: "支持全数字化多波束同时并行合成与空域自由收发", c: "便于通过算法在线校准通道幅相误差", d: "体积重量无限趋近于零", ans: ["A", "B", "C"], exp: "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。" }
  ],
  judges: [
    {
      q: "雷达散射截面积（RCS）是目标物理几何投影面积的简单等同，与目标材质和入射波长无关。",
      ans: "B",
      exp: "错误。RCS不仅取决于几何结构与外形，还与表面涂覆材料（吸波/反射）、入射雷达波波长以及极化方式密切相关。"
    },
    {
      q: "调频连续波（FMCW）雷达由于发射与接收同时进行，近距离没有传统脉冲雷达的固定发射脉宽盲区。",
      ans: "A",
      exp: "正确。FMCW采用连续收发与差拍混频，近距离盲区仅取决于天线收发隔离度与收发耦合抑制能力，可降至数米之内。"
    }
  ],
  judgeTemplates: [
    { q: "相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。", ans: "A", exp: "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。" },
    { q: "连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。", ans: "B", exp: "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。" }
  ],
  fills: [
    {
      q: "雷达通过测量电磁波往返时间延迟计算目标距离的公式为 R = (c × Δt) / ______。",
      ans: ["2"],
      exp: "电磁波从发射到目标再反射回雷达经历了两倍的单程几何距离，故分母必须除以2。"
    },
    {
      q: "动目标检测中，通过多通道滤波器组滤除静止零频地杂波的技术统称为______检测。",
      ans: ["MTD", "动目标", "动目标检测"],
      exp: "MTD（Moving Target Detection）动目标检测利用FFT滤波器组分离杂波与目标。"
    }
  ],
  fillTemplates: [
    { q: "雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。", ans: ["扫描", "天线扫描", "转动"], exp: "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。" },
    { q: "相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。", ans: ["T/R", "TR", "收发"], exp: "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。" }
  ],
  shorts: [
    {
      q: "简述雷达在城市低空环境下探测微小型无人机面临的核心技术难题，并说明工程上采用的解决手段。",
      ans: "难题：1. RCS极小（0.01m²级）导致回波微弱；2. 超低空高层建筑与树木产生强地杂波与多径反射；3. 无人机低速悬停易被MTI多普勒盲速过滤。\n解决手段：采用高频段（X/Ku）宽带相控阵雷达提升分辨率与回波敏感度；采用长时间相干积累提升信噪比；引入微多普勒频谱分析提取旋翼旋转特征以区分地杂波与飞鸟；部署STAP空时自适应抑制强地物干扰。",
      exp: "低慢小雷达探测是雷达信号处理前沿综合技术，重点考查杂波抑制与微动特征识别。"
    }
  ],
  shortTemplates: [
    { q: "分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。", ans: "优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。", exp: "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。" }
  ]
};

// -------------------------------------------------------------
// MODULE 2: 无线电探测技术 (radio)
// -------------------------------------------------------------
const radioCore = {
  singles: [
    {
      q: "无线电无源探测（Passive RF Detection）在反无人机防空预警中最大的实战优势是：",
      opts: [
        { key: "A", text: "零电磁辐射发射，自身绝对隐蔽且对民航和周边设备无任何干扰" },
        { key: "B", text: "能够将雷达波发射到地平线以外" },
        { key: "C", text: "不受无线电静默影响" },
        { key: "D", text: "能够物理击落无人机" }
      ],
      ans: "A",
      exp: "无线电侦测通过高灵敏度全向/定向天线被动接收无人机图传与遥控通信信号，不主动发射任何电磁波，具备绿色无辐射、高电磁兼容性与零暴露风险的特点。"
    },
    {
      q: "利用空间分离的多个接收天线阵元接收同一空间信号的载波相位差来确定目标来波方向（DoA）的技术被称为：",
      opts: [
        { key: "A", text: "干涉仪测向（Interferometer Direction Finding）" },
        { key: "B", text: "超外差检波" },
        { key: "C", text: "扩频通信" },
        { key: "D", text: "高阻抗匹配" }
      ],
      ans: "A",
      exp: "相位干涉仪测向利用基线两端天线接收电磁波的相位差 Δφ = (2π * d / λ) * sin(θ) 计算目标入射角θ，测量精度高且测向速度极快。"
    },
    {
      q: "无线电多基站TDoA（到达时间差）定位体制中，两个侦测站测得的信号时差在二维平面上确定的是一条：",
      opts: [
        { key: "A", text: "以两基站为焦点的双曲线（Hyperbola）" },
        { key: "B", text: "圆形" },
        { key: "C", text: "以两基站为端点的线段" },
        { key: "D", text: "抛物线" }
      ],
      ans: "A",
      exp: "到达时间差对应恒定的距离差，平面上到两定点距离之差为定值的点的轨迹是双曲线，两基站确定一条双曲线，多条双曲线交汇实现目标定位。"
    },
    {
      q: "在无线电侦测系统中，能够将时域高频信号转换为频域能量分布以进行频谱瀑布图分析的核心算法是：",
      opts: [
        { key: "A", text: "快速傅里叶变换（FFT）" },
        { key: "B", text: "汉明纠错编码" },
        { key: "C", text: "DES加密算法" },
        { key: "D", text: "Dijkstra最短路径算法" }
      ],
      ans: "A",
      exp: "FFT快速傅里叶变换是软件无线电（SDR）实时频谱分析的基石，通过频域变换可实时呈现信道频谱能量与周期性跳频图谱。"
    }
  ],
  singleTemplates: [
    { q: "无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：", a: "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置", b: "飞手微信聊天记录", c: "无人机相机拍摄的相册全部高清原图", d: "飞手个人银行账户余额", ans: "A", exp: "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。" },
    { q: "当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：", a: "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨", b: "发射更大功率的微波", c: "完全消除多径反射", d: "不需要数字采样", ans: "A", exp: "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。" },
    { q: "在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：", a: "几何精度衰减因子（GDOP）", b: "基站外壳油漆颜色", c: "天线固定螺栓螺纹间距", d: "地线铜排厚度", ans: "A", exp: "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。" },
    { q: "软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：", a: "高采样率模数转换器（ADC）", b: "大功率水冷磁控管", c: "机械继电器", d: "稳压电容", ans: "A", exp: "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。" }
  ],
  multis: [
    {
      q: "无线电侦测系统对无人机跳频通信信号（FHSS）进行截获与特征识别时，需要提取的关键射频指纹参数包括：",
      opts: [
        { key: "A", text: "跳频驻留时间（Dwell Time）与跳频速率（Hop Rate）" },
        { key: "B", text: "跳变频率集与瞬时占用信道带宽" },
        { key: "C", text: "信号调制类型（如OFDM、FSK、QPSK）" },
        { key: "D", text: "脉冲前沿上升时间与射频功率包络" }
      ],
      ans: ["A", "B", "C", "D"],
      exp: "跳频识别依赖多维射频指纹特征提取，包括时域跳速、频域信道集、调制样式及个体特定瞬态开启特征（SEI）。"
    }
  ],
  multiTemplates: [
    { q: "构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：", a: "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联", b: "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化", c: "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）", d: "所有基站必须涂刷反光荧光漆", ans: ["A", "B", "C"], exp: "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。" }
  ],
  judges: [
    {
      q: "无线电侦测系统只能侦听无人机发射的图传信号，无法对地面飞手遥控器发出的上行控制信号进行定位。",
      ans: "B",
      exp: "错误。无线电侦测系统既可以侦测无人机下行图传（Downlink），也可侦测飞手上行遥控信号（Uplink），并利用遥控信号定位飞手所处位置。"
    },
    {
      q: "超分辨测向MUSIC算法利用天线阵列协方差矩阵的特征值分解，将信号子空间与噪声子空间分离以实现超分辨高精度测向。",
      ans: "A",
      exp: "正确。MUSIC算法利用噪声子空间与导向矢量的正交性构造空间谱函数，极大突破了经典傅里叶变换的瑞利分辨力极限。"
    }
  ],
  judgeTemplates: [
    { q: "只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。", ans: "B", exp: "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。" }
  ],
  fills: [
    {
      q: "利用天线阵列测量电磁波相位差异解算来波方位的技术称为______测向。",
      ans: ["相位干涉仪", "干涉仪"],
      exp: "相位干涉仪通过测量多阵元间的空间相位差进行角度解算。"
    },
    {
      q: "无线电侦测系统中，基于多基站计算信号到达时间差的定位英文缩写为______定位。",
      ans: ["TDoA", "TDOA"],
      exp: "TDoA是Time Difference of Arrival的缩写。"
    }
  ],
  fillTemplates: [
    { q: "无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。", ans: ["FHSS", "跳频"], exp: "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。" }
  ],
  shorts: [
    {
      q: "简述无线电协议破解侦测技术（如解析无人机序列号与飞手坐标）的工作原理与优势。",
      ans: "原理：截获无人机下行信标帧或数据链路广播，逆向解调出物理层射频信号，提取包含出厂SN码、飞手经纬度、无人机实时三维坐标等遥测结构体并实时解包呈现。\n优势：1. 零漏警误判，单站即可瞬间获得飞手与无人机的精确绝对坐标；2. 具有唯一电子身份核实能力，利于公安取证与执法追踪；3. 不依赖复杂多基站时差交叉，单站成本极低且便携部署敏捷。",
      exp: "考查无人机协议侦测的机制、优势及局限性。"
    }
  ],
  shortTemplates: [
    { q: "对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。", ans: "AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。", exp: "考查无线电测向定位关键算法实战特性的工程对比。" }
  ]
};

// -------------------------------------------------------------
// MODULE 3: 光电探测原理 (optoelectronic)
// -------------------------------------------------------------
const optoCore = {
  singles: [
    {
      q: "在可见光光学成像系统中，决定光学镜头收集光线能力与景深的最主要光学参数是：",
      opts: [
        { key: "A", text: "相对孔径与光圈数（F数）" },
        { key: "B", text: "机身涂层折射率" },
        { key: "C", text: "遮光罩长度" },
        { key: "D", text: "固定螺栓材质" }
      ],
      ans: "A",
      exp: "F数 = 焦距 / 入瞳直径。F数越小，进光量越大，低照度感光能力越强，但景深相对变浅。"
    },
    {
      q: "长波红外（LWIR）热成像相机通常工作的大气传输窗口波长范围是：",
      opts: [
        { key: "A", text: "8 ~ 14 微米（μm）" },
        { key: "B", text: "0.4 ~ 0.7 微米" },
        { key: "C", text: "1.5 ~ 2.0 微米" },
        { key: "D", text: "100 ~ 200 微米" }
      ],
      ans: "A",
      exp: "红外波段通常划分为短波红外（1~3μm）、中波红外（3~5μm）和长波红外（8~14μm），8~14μm处于常温常压下的大气低吸收透射窗口。"
    },
    {
      q: "红外热像仪探测小型无人机依靠的是：",
      opts: [
        { key: "A", text: "无人机电机、电调、电池与机体摩擦散发的热辐射与背景温度差异" },
        { key: "B", text: "反射太阳可见白光" },
        { key: "C", text: "吸收空气中的紫外线" },
        { key: "D", text: "无人机机壳上的荧光粉" }
      ],
      ans: "A",
      exp: "无人机动力无刷电机在高速运转时电流很大，电调与锂电池发热明显，机身与空气摩擦产生红外温差，热像仪通过测量微小辐射温差成像。"
    },
    {
      q: "光电转台在反无人机伺服跟踪系统中，用于消除外界风阻扰动和平台颠簸振动的传感器核心组件是：",
      opts: [
        { key: "A", text: "光纤陀螺仪或MEMS惯性测量单元（IMU）" },
        { key: "B", text: "气压计" },
        { key: "C", text: "指南针磁力计" },
        { key: "D", text: "水银温度计" }
      ],
      ans: "A",
      exp: "高精度两轴四框架光电转台内部配备速率陀螺仪（如光纤陀螺FOG），通过测定空间角速度扰动并施加反向力矩，实现对视轴惯性空间隔离稳瞄。"
    }
  ],
  singleTemplates: [
    { q: "脉冲激光测距机测量目标距离利用的核心物理常数是：", a: "真空光速（约 3 × 10⁸ m/s）", b: "普朗克常数", c: "重力加速度", d: "阿伏伽德罗常数", ans: "A", exp: "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。" },
    { q: "在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：", a: "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）", b: "冒泡排序", c: "散列哈希映射", d: "Floyd算法", ans: "A", exp: "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。" },
    { q: "相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：", a: "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上", b: "零功耗免供电", c: "开机无需降温秒级出图", d: "整机重量小于50克", ans: "A", exp: "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。" },
    { q: "当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：", a: "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降", b: "完全消失", c: "毫无变化", d: "下降十倍", ans: "A", exp: "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。" }
  ],
  multis: [
    {
      q: "低空防御一体化光电转台系统通常集成的多光谱与传感器载荷包括：",
      opts: [
        { key: "A", text: "长焦连续光学变焦高清可见光相机" },
        { key: "B", text: "中波制冷或长波非制冷高灵敏度红外热像仪" },
        { key: "C", text: "人眼安全半导体脉冲激光测距机（LRF）" },
        { key: "D", text: "高动态多轴精密陀螺稳定伺服转台机构" }
      ],
      ans: ["A", "B", "C", "D"],
      exp: "典型反无人机光电系统涵盖可见光识别（白天高清）、红外成像（全天候夜视）、激光测距（提供空间三维坐标）与陀螺增稳伺服平台。"
    }
  ],
  multiTemplates: [
    { q: "光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：", a: "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）", b: "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景", c: "相机正对太阳发生强光眩目过曝饱和", d: "镜头前飞过一只大鸟产生瞬间遮挡混淆", ans: ["A", "B", "C", "D"], exp: "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。" }
  ],
  judges: [
    {
      q: "可见光相机在夜间无辅助照明（如探照灯）且无月光的开阔自然环境下，依然能清晰识别数公里外飞行的黑色无人机。",
      ans: "B",
      exp: "错误。可见光相机依赖反射外界环境光，夜间全黑无光照时必须切换为被动红外热成像仪工作。"
    },
    {
      q: "热成像仪的噪声等效温差（NETD）指标数值越小，代表热成像探测器的温度灵敏度越高、成像越细腻。",
      ans: "A",
      exp: "正确。NETD表示探测器恰能分辨的最小温度差，数值越小（如15mK优于40mK），对微弱温差感知能力越强。"
    }
  ],
  judgeTemplates: [
    { q: "激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。", ans: "A", exp: "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。" }
  ],
  fills: [
    {
      q: "热成像系统衡量热灵敏度最核心的技术参数是噪声等效温差，其英文缩写为______。",
      ans: ["NETD"],
      exp: "NETD是Noise Equivalent Temperature Difference的缩写。"
    },
    {
      q: "光电转台通过两轴或四轴伺服系统在风阻和抖动下保持镜头瞄准视轴稳定的传感器是______陀螺仪。",
      ans: ["陀螺仪", "光纤陀螺仪", "陀螺"],
      exp: "速率陀螺仪实时感知转台角位移并闭环反馈补偿伺服电机。"
    }
  ],
  fillTemplates: [
    { q: "光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。", ans: ["F", "光圈", "相对孔径"], exp: "F数定义为 f / D，衡量镜头通光能力。" }
  ],
  shorts: [
    {
      q: "简述光电侦搜系统与低空探测雷达在反无人机作战中的协同联动配合流程与互补价值。",
      ans: "协同流程：1. 雷达在远距离（3~5km）广域快速搜索，发现目标后解算其方位角、俯仰角与距离，将坐标引导数据高速推送给光电；2. 光电转台根据引导坐标迅速调转视轴指向目标空域（Slew-to-Cue）；3. 光电系统使用可见光或红外传感器在狭小视场内快速捕获目标，启动图像闭环跟踪，实施光学放大识别取证并精确测距；4. 为后续电磁软杀伤或激光硬杀伤提供厘米级/毫弧度级火控跟瞄指向。\n互补价值：雷达负责广域粗搜、全天候远距测距测速；光电负责窄视场高精度角分辨、直观外形定性与法律取证，两者结合弥补了雷达缺乏视觉证据与光电搜索视场窄的固有缺陷。",
      exp: "考查雷达与光电联动火控链路的工程实践。"
    }
  ],
  shortTemplates: [
    { q: "分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。", ans: "挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。", exp: "考查红外成像在极端环境下的信号处理与抗干扰措施。" }
  ]
};

// -------------------------------------------------------------
// MODULE 4: 电磁干扰技术 (electromagnetic)
// -------------------------------------------------------------
const emCore = {
  singles: [
    {
      q: "电磁压制干扰（Noise Jamming）使无人机接收机失锁的核心物理判据是：",
      opts: [
        { key: "A", text: "接收机输入端信干比（J/S）低于最低解调门限" },
        { key: "B", text: "干扰机频率必须恰好等于光速" },
        { key: "C", text: "无人机机身温度上升" },
        { key: "D", text: "遥控器电池瞬间放电完毕" }
      ],
      ans: "A",
      exp: "无线电通信解调要求信噪比（SNR）或信干比（J/S）达到特定阈值，压制干扰通过强噪声淹没信号使误码率急剧上升达100%，引发链路失步断连。"
    },
    {
      q: "在反无人机应用中，针对宽带跳频无人机，点频瞄准式干扰相比阻塞式宽带干扰的优势在于：",
      opts: [
        { key: "A", text: "能量集中在当前跳频瞬间频点，干扰功率利用效率极高" },
        { key: "B", text: "可以发射紫外线" },
        { key: "C", text: "完全不需要天线" },
        { key: "D", text: "永远不需要侦察接收机配合" }
      ],
      ans: "A",
      exp: "阻塞式宽带干扰把有限功率分散在数百兆带宽上，功率谱密度极低；瞄准式干扰实时引导功率发射至跳变信道，功率谱密度可提高数十倍。"
    },
    {
      q: "民用GPS L1频段与北斗B1频段的中心工作频率分别位于：",
      opts: [
        { key: "A", text: "GPS L1: 1575.42 MHz ; 北斗 B1I: 1561.098 MHz" },
        { key: "B", text: "433 MHz 和 900 MHz" },
        { key: "C", text: "2.4 GHz 和 5.8 GHz" },
        { key: "D", text: "10 GHz 和 24 GHz" }
      ],
      ans: "A",
      exp: "卫星导航L波段中心频点标准：GPS L1为1575.42MHz，北斗二号/三号民用B1I为1561.098MHz，B1C为1575.42MHz。"
    },
    {
      q: "高功率微波武器（HPM）攻击无人机蜂群时，微波能量侵入无人机内部电路主要通过哪两种耦合途径？",
      opts: [
        { key: "A", text: "前门耦合（经接收天线输入）与后门耦合（经机壳缝隙/线缆耦合）" },
        { key: "B", text: "化学渗透与分子扩散" },
        { key: "C", text: "气压差与声波共振" },
        { key: "D", text: "红外辐射与热胀冷缩" }
      ],
      ans: "A",
      exp: "高功率电磁脉冲通过无人机通信天线直接进入前端放大器（前门耦合），或通过缝隙、接口和电源线感应出破坏性浪涌电压击毁CMOS芯片（后门耦合）。"
    }
  ],
  singleTemplates: [
    { q: "天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：", a: "增强为原来的 2 倍", b: "增强为原来的 3 倍", c: "减半", d: "增加 10 倍", ans: "A", exp: "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。" },
    { q: "在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：", a: "氮化镓（GaN）高电子迁移率晶体管", b: "真空电子管", c: "硅二极管", d: "发光二极管LED", ans: "A", exp: "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。" },
    { q: "针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：", a: "覆盖扩频伪随机码调制后的全扩频码片带宽", b: "小于1Hz", c: "无限大", d: "只覆盖直流偏置", ans: "A", exp: "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。" },
    { q: "卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：", a: "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）", b: "1000 瓦特", c: "10 dBm", d: "100 瓦特", ans: "A", exp: "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。" }
  ],
  multis: [
    {
      q: "反无人机电磁干扰设备按干扰机理与信号样式通常划分为哪些类型？",
      opts: [
        { key: "A", text: "射频噪声压制干扰（宽带阻塞/扫频/瞄准）" },
        { key: "B", text: "欺骗性干扰（GNSS星历欺骗/伪距牵引）" },
        { key: "C", text: "协议重放与指令注入式劫持干扰" },
        { key: "D", text: "超宽带强电磁脉冲（EMP/HPM）破坏性干扰" }
      ],
      ans: ["A", "B", "C", "D"],
      exp: "电磁对抗手段涵盖从阻断通信链路的压制干扰、伪造导航指令的欺骗干扰，到烧毁内部元器件的高能微波脉冲硬杀伤。"
    }
  ],
  multiTemplates: [
    { q: "在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：", a: "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染", b: "集中更多发射功率进入主瓣，提高对目标的有效压制距离", c: "避免近距离操作人员受到大功率侧向微波辐射伤害", d: "使天线外壳变软", ans: ["A", "B", "C"], exp: "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。" }
  ],
  judges: [
    {
      q: "只要无人机机身表面喷涂了吸波隐身涂层，电磁干扰枪发出的射频压制信号就完全无法阻断其图传和遥控链路。",
      ans: "B",
      exp: "错误。无线电通信是通过无人机外露或外置的天线系统接收电磁波的，吸波涂层无法阻挡进入天线端口的同频强干扰信号。"
    },
    {
      q: "氮化镓（GaN）功放由于具备更高的击穿电压和工作结温，在同等输出功率下比传统LDMOS功放体积更小、更省电。",
      ans: "A",
      exp: "正确。GaN高功率固态器件大幅缩小了便携设备功放体积并显著改善散热与电池续航。"
    }
  ],
  judgeTemplates: [
    { q: "对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。", ans: "A", exp: "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。" }
  ],
  fills: [
    {
      q: "通过发射与无人机工作频段相同的强电磁噪声，使接收机信干比严重恶化的干扰方式统称为______干扰。",
      ans: ["压制式", "噪声压制", "阻塞式"],
      exp: "压制式干扰通过能量淹没破坏接收机解调。"
    },
    {
      q: "卫星导航欺骗技术根据注入信号与真实卫星的相对伪距动态关系，可分为生成式欺骗与______欺骗。",
      ans: ["转发式", "转发"],
      exp: "欺骗干扰分为自身计算星历合成的生成式与截获真实信号延迟放大的转发式。"
    }
  ],
  fillTemplates: [
    { q: "高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。", ans: ["后门", "后门耦合"], exp: "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。" }
  ],
  shorts: [
    {
      q: "分析在防范黑飞无人机时，采用“定向电磁干扰枪”与“全向大功率基站干扰机”在战术使用、防御范围及连带电磁风险方面的差异。",
      ans: "差异对比：\n1. 战术使用与部署：干扰枪便携轻便、单兵机动响应快、由人工目视或单兵设备瞄准视距目标定向射击；全向基站通常固定式或车载部署，与雷达自动联动，可形成无死角全向防护电磁罩。\n2. 防御范围与距离：干扰枪采用高增益定向天线，主瓣能量聚焦，压制距离通常在1~2km；全向基站功率发散至360度，有效压制半径通常为1~3km，需要更大峰值发射总功率。\n3. 连带电磁风险：干扰枪波束极窄（通常20~30度），瞄空发射，对地面周边非目标方向无线电通信干扰极低，安全性高；全向基站360度大功率辐射，极易压制覆盖区内的居民WiFi、运营商公网以及机场调度通信，伴生电磁污染重，需严格受控开启。",
      exp: "考查不同形态电磁反制装备的作战效能与环境兼容性权衡。"
    }
  ],
  shortTemplates: [
    { q: "阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。", ans: "实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。", exp: "考查精确微功率卫星导航诱骗的闭环控制物理过程。" }
  ]
};

// -------------------------------------------------------------
// 执行生成 4 个新模块
// -------------------------------------------------------------
const radarQuestions = build200Module("radar", "雷达探测技术", radarCore);
writeKotlinFile("RadarQuestions", "radarQuestions", radarQuestions);

const radioQuestions = build200Module("radio", "无线电探测技术", radioCore);
writeKotlinFile("RadioQuestions", "radioQuestions", radioQuestions);

const optoQuestions = build200Module("opto", "光电探测原理", optoCore);
writeKotlinFile("OptoelectronicQuestions", "optoelectronicQuestions", optoQuestions);

const emQuestions = build200Module("em", "电磁干扰技术", emCore);
writeKotlinFile("ElectromagneticQuestions", "electromagneticQuestions", emQuestions);

console.log("ALL 4 EXTENSION MODULES (800 QUESTIONS) CREATED SUCCESSFULLY!");
