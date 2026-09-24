package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val radarQuestions: List<Question> = listOf(
    Question(
        id = "radar-single-001",
        type = QuestionType.SINGLE,
        question = "雷达（RADAR）的基本测距物理原理是利用电磁波在空间以恒定光速传播，通过测量发射脉冲与接收回波之间的：",
        options = listOf(
            QuizOption("A", "往返时间延迟（Time Delay）"),
            QuizOption("B", "波长压缩比"),
            QuizOption("C", "天线极化扭转角"),
            QuizOption("D", "介质折射率"),
        ),
        answer = listOf("A"),
        explanation = "雷达测距物理公式为 R = (c * Δt) / 2，其中 c 为光速，Δt 为发射与接收回波的时间延迟差。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-002",
        type = QuestionType.SINGLE,
        question = "多普勒雷达测量目标径向速度（Radial Velocity）所依据的物理规律是：",
        options = listOf(
            QuizOption("A", "多普勒频移效应（Doppler Frequency Shift）"),
            QuizOption("B", "法拉第电磁感应定律"),
            QuizOption("C", "布儒斯特角反射定律"),
            QuizOption("D", "康普顿散射效应"),
        ),
        answer = listOf("A"),
        explanation = "当目标与雷达存在相对径向运动时，反射回波载波频率将产生偏移 fd = 2 * vr / λ，借此可解算目标相对速度。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-003",
        type = QuestionType.SINGLE,
        question = "在低空慢速小目标探测中，调频连续波（FMCW）雷达相比传统大功率脉冲雷达的核心优势是：",
        options = listOf(
            QuizOption("A", "近距离盲区极小、发射峰值功率低、距离分辨率高且设备体积小巧"),
            QuizOption("B", "波长最长可达数十米"),
            QuizOption("C", "完全不需要天线"),
            QuizOption("D", "不受金属遮挡"),
        ),
        answer = listOf("A"),
        explanation = "FMCW雷达通过线性扫频发射连续波并对混频中频差拍信号进行FFT分析，具有无发射脉冲盲区、峰值功率极低（毫瓦至瓦级）、近距离测距测速分辨率高、利于微型化低空布防的优点。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-004",
        type = QuestionType.SINGLE,
        question = "相控阵雷达（Phased Array Radar）实现雷达波束在空间无惯性超高速偏转扫描的核心器件是：",
        options = listOf(
            QuizOption("A", "高精度机械伺服俯仰云台"),
            QuizOption("B", "微波电控移相器（Phase Shifter）或T/R组件数字波束形成"),
            QuizOption("C", "旋转角反射镜"),
            QuizOption("D", "激光陀螺仪"),
        ),
        answer = listOf("B"),
        explanation = "相控阵雷达通过调节天线阵列中成百上千个辐射单元前移相器的相位差，使各单元波前在特定空间方向同相叠加干涉，达成纳秒/微秒级无惯性波束捷变。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-005",
        type = QuestionType.SINGLE,
        question = "雷达方程中，雷达最大探测距离与目标的雷达散射截面积（RCS）的几次方成正比？",
        options = listOf(
            QuizOption("A", "1/4 次方（四次方根）"),
            QuizOption("B", "1/2 次方（平方根）"),
            QuizOption("C", "1 次方（正比）"),
            QuizOption("D", "2 次方（平方）"),
        ),
        answer = listOf("A"),
        explanation = "根据经典雷达距离方程 R_max = [ (Pt * G² * λ² * σ) / ((4π)³ * S_min) ]^(1/4)，最大探测距离与目标RCS（σ）的四次方根成正比。若目标RCS缩小至原来的1/16，探测距离仅缩短为1/2。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-006",
        type = QuestionType.SINGLE,
        question = "低空无人机探测雷达常用的工作微波波段通常是：",
        options = listOf(
            QuizOption("A", "X波段（8~12 GHz）或Ku波段（12~18 GHz）"),
            QuizOption("B", "超长波（VLF）"),
            QuizOption("C", "中波调幅广播波段"),
            QuizOption("D", "太赫兹100THz以上"),
        ),
        answer = listOf("A"),
        explanation = "X波段和Ku波段电磁波波长短（约1.6~3.7cm），天线孔径小且增益高，对微小型无人机及碳纤维旋翼叶片的后向散射敏感度极高，是低空慢小防御的主流波段。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-007",
        type = QuestionType.SINGLE,
        question = "雷达信号处理中，MTI（动目标显示）与MTD（动目标检测）技术的核心作用是：",
        options = listOf(
            QuizOption("A", "滤除静止及慢速地杂波与海杂波，提取运动目标多普勒信号"),
            QuizOption("B", "给目标自动涂上伪装色"),
            QuizOption("C", "增加雷达发射电磁波的峰值功率"),
            QuizOption("D", "降低天线接收噪声系数"),
        ),
        answer = listOf("A"),
        explanation = "MTI利用延迟线对消器过滤零多普勒地杂波；MTD则采用多通道多普勒滤波器组（FFT滤波），有效将微弱运动无人机信号从强杂波谱线中分离提取。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-008",
        type = QuestionType.SINGLE,
        question = "脉冲压缩技术（Pulse Compression）在现代雷达中解决的核心矛盾是：",
        options = listOf(
            QuizOption("A", "雷达作用距离（需要大脉宽大能量）与距离分辨率（需要极窄脉宽）之间的矛盾"),
            QuizOption("B", "机械旋转重量与安装支架的承重矛盾"),
            QuizOption("C", "交流供电与直流稳压的转换矛盾"),
            QuizOption("D", "雷达天线增益与旁瓣电平的矛盾"),
        ),
        answer = listOf("A"),
        explanation = "脉冲压缩发射宽脉冲线性调频（LFM）信号以保证发射总能量（增大作用距离），在接收端通过匹配滤波器压缩成窄脉冲，兼具远距离与高距离分辨力。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-009",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点9] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-010",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点10] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-011",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点11] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-012",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点12] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-013",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点13] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-014",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点14] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-015",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点15] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-016",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点16] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-017",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点17] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-018",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点18] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-019",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点19] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-020",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点20] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-021",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点21] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-022",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点22] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-023",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点23] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-024",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点24] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-025",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点25] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-026",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点26] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-027",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点27] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-028",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点28] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-029",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点29] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-030",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点30] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-031",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点31] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-032",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点32] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-033",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点33] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-034",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点34] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-035",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点35] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-036",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点36] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-037",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点37] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-038",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点38] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-039",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点39] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-040",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点40] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-041",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点41] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-042",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点42] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-043",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点43] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-044",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点44] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-045",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点45] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-046",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点46] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-047",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点47] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-048",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点48] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-049",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点49] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-050",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点50] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-051",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点51] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-052",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点52] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-053",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点53] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-054",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点54] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-055",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点55] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-056",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点56] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-057",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点57] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-058",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点58] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-059",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点59] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-060",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点60] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-061",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点61] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-062",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点62] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-063",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点63] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-064",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点64] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-065",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点65] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-066",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点66] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-067",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点67] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-068",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点68] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-069",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点69] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-070",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点70] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-071",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点71] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-072",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点72] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-073",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点73] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-074",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点74] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-075",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点75] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-076",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点76] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-077",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点77] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-078",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点78] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-079",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点79] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-080",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点80] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-081",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点81] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-082",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点82] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-083",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点83] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-084",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点84] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-085",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点85] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-086",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点86] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-087",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点87] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-088",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点88] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-089",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点89] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-090",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点90] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-091",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点91] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-092",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点92] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-093",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点93] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-094",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点94] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-095",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点95] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-096",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点96] 合成孔径雷达（SAR）实现高分辨方位向成像的本质是：",
        options = listOf(
            QuizOption("A", "依靠雷达平台运动虚拟构建出一个巨大的等效长天线孔径"),
            QuizOption("B", "提高发射机功率一万倍"),
            QuizOption("C", "采用透明超构材料天线罩"),
            QuizOption("D", "降低光速常数"),
        ),
        answer = listOf("A"),
        explanation = "SAR利用雷达随飞行平台的运动轨迹，通过相干相加多时刻的回波历史，合成为数公里长的人工等效孔径，获得极细的方位角分辨率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-097",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点97] 雷达接收机动态范围要求高达80dB以上，最主要是为了防止：",
        options = listOf(
            QuizOption("A", "近距离超强地杂波反射导致前置低噪放（LNA）饱和阻塞失真"),
            QuizOption("B", "耗电过大跳闸"),
            QuizOption("C", "机柜外壳发烫"),
            QuizOption("D", "数字信源乱码"),
        ),
        answer = listOf("A"),
        explanation = "近距离地面强反射回波与远距离微弱无人机回波强度差可达数十万倍，接收机必须具有大动态范围与STC灵敏度时间控制。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-098",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点98] 低空无人机旋翼叶片在微多普勒频谱上呈现出的典型形态为：",
        options = listOf(
            QuizOption("A", "围绕主体多普勒中心对称分布的闪烁侧带谱线（Blade Flash）"),
            QuizOption("B", "连续均匀的平坦白噪声"),
            QuizOption("C", "单根孤立的正弦单频信号"),
            QuizOption("D", "完全空白无信号"),
        ),
        answer = listOf("A"),
        explanation = "多旋翼叶片高速旋转产生周期性向雷达靠近与远离的极端速度调制，表现为时频图上周期对称的宽带多普勒“叶片闪烁”。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-099",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点99] 雷达天线方向图的主瓣宽度与天线孔径尺寸呈：",
        options = listOf(
            QuizOption("A", "反比关系（孔径越大，波束越窄越敏锐）"),
            QuizOption("B", "正比关系"),
            QuizOption("C", "立方正比"),
            QuizOption("D", "无任何关联"),
        ),
        answer = listOf("A"),
        explanation = "半功率波束宽度 θ ≈ 70° * λ / D，孔径尺寸D越大，天线波束越窄，空间定向精度与增益越高。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-single-100",
        type = QuestionType.SINGLE,
        question = "[雷达探测技术专业考点100] 脉冲多普勒（PD）雷达中的“速度模糊（Blind Speed）”现象主要是由以下哪个参数决定的？",
        options = listOf(
            QuizOption("A", "脉冲重复频率（PRF）"),
            QuizOption("B", "发射机冷却风扇转速"),
            QuizOption("C", "馈线同轴电缆阻抗"),
            QuizOption("D", "机箱屏蔽厚度"),
        ),
        answer = listOf("A"),
        explanation = "盲速与脉冲重复频率PRF及波长成正比（Vb = n * λ * PRF / 2），当多普勒频移等于PRF的整数倍时会产生混叠。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-multi-001",
        type = QuestionType.MULTI,
        question = "低空探测雷达针对微小型无人机（RCS < 0.03m²）通常采用的关键提升技术包括：",
        options = listOf(
            QuizOption("A", "相控阵数字波束形成（DBF）技术实现长时间相干积累"),
            QuizOption("B", "微多普勒时频分析（如STFT/Wigner-Ville分布）特征提取"),
            QuizOption("C", "自适应杂波图（Clutter Map）与空时自适应处理（STAP）抑制地杂波"),
            QuizOption("D", "高距离分辨脉冲压缩与宽带调频"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "雷达探测反制小目标需要从雷达波形设计（宽带LFM）、天线波束控制（相控阵长时间驻留）、杂波自适应抑制（STAP）与智能目标识别（微多普勒）全链条综合优化。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-multi-002",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合2] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-003",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合3] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-004",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合4] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-005",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合5] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-006",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合6] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-007",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合7] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-008",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合8] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-009",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合9] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-010",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合10] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-011",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合11] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-012",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合12] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-013",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合13] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-014",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合14] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-015",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合15] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-016",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合16] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-017",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合17] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-018",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合18] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-019",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合19] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-020",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合20] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-021",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合21] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-022",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合22] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-023",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合23] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-024",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合24] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-025",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合25] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-026",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合26] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-027",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合27] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-028",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合28] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-029",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合29] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-030",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合30] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-031",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合31] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-032",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合32] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-033",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合33] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-034",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合34] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-035",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合35] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-036",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合36] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-037",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合37] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-038",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合38] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-039",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合39] 雷达在复杂多径环境（如城市楼宇或水面低空）探测无人机时，通常会引发的误差与异常包括：",
        options = listOf(
            QuizOption("A", "目标高度角解算剧烈抖动与跳跃"),
            QuizOption("B", "出现真假成对的多径虚假目标回波"),
            QuizOption("C", "多径反射干涉导致回波信号发生深衰落丢失目标"),
            QuizOption("D", "雷达发射机永久断电"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "多径直射波与反射波矢量干涉会造成天线波瓣裂相、信号深度衰落，并在仰角测量中产生严重虚假径迹。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-multi-040",
        type = QuestionType.MULTI,
        question = "[雷达探测技术多维综合40] 数字阵列雷达（DAR）相比传统模拟相控阵雷达的突出技术优势有：",
        options = listOf(
            QuizOption("A", "每个天线阵元或子阵均具备独立的数字收发通道（ADC/DAC）"),
            QuizOption("B", "支持全数字化多波束同时并行合成与空域自由收发"),
            QuizOption("C", "便于通过算法在线校准通道幅相误差"),
            QuizOption("D", "体积重量无限趋近于零"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "数字阵列雷达将数字化推进至每个T/R组件，实现多波束并发、超低副瓣自适应调零与敏捷波形自由度。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-judge-001",
        type = QuestionType.JUDGE,
        question = "雷达散射截面积（RCS）是目标物理几何投影面积的简单等同，与目标材质和入射波长无关。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。RCS不仅取决于几何结构与外形，还与表面涂覆材料（吸波/反射）、入射雷达波波长以及极化方式密切相关。",
        topic = "雷达探测技术",
        difficulty = 1
    ),
    Question(
        id = "radar-judge-002",
        type = QuestionType.JUDGE,
        question = "调频连续波（FMCW）雷达由于发射与接收同时进行，近距离没有传统脉冲雷达的固定发射脉宽盲区。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。FMCW采用连续收发与差拍混频，近距离盲区仅取决于天线收发隔离度与收发耦合抑制能力，可降至数米之内。",
        topic = "雷达探测技术",
        difficulty = 1
    ),
    Question(
        id = "radar-judge-003",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析3] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-004",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析4] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-005",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析5] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-006",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析6] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-007",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析7] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-008",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析8] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-009",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析9] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-010",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析10] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-011",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析11] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-012",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析12] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-013",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析13] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-014",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析14] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-015",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析15] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-016",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析16] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-017",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析17] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-018",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析18] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-019",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析19] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-020",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析20] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-021",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析21] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-022",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析22] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-023",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析23] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-024",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析24] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-025",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析25] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-026",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析26] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-027",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析27] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-028",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析28] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-029",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析29] 相控阵雷达通过数字电控移相实现波束瞬间跳转，极大提高了对多方向多目标的快速交替跟踪能力。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。无惯性波束捷变使相控阵雷达可在毫秒内完成数十个空中目标的多任务交叉跟踪扫描。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-judge-030",
        type = QuestionType.JUDGE,
        question = "[雷达探测技术正误辨析30] 连续波雷达在不进行频率调制的情况下，可以直接测出目标与雷达之间的精确几何距离。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。单频连续波雷达只能通过多普勒测量相对速度，无法直接测量距离，必须通过线性调频（FMCW）或编码调制测距。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-001",
        type = QuestionType.FILL,
        question = "雷达通过测量电磁波往返时间延迟计算目标距离的公式为 R = (c × Δt) / ______。",
        options = emptyList(),
        answer = listOf("2"),
        explanation = "电磁波从发射到目标再反射回雷达经历了两倍的单程几何距离，故分母必须除以2。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-002",
        type = QuestionType.FILL,
        question = "动目标检测中，通过多通道滤波器组滤除静止零频地杂波的技术统称为______检测。",
        options = emptyList(),
        answer = listOf("MTD", "动目标", "动目标检测"),
        explanation = "MTD（Moving Target Detection）动目标检测利用FFT滤波器组分离杂波与目标。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-003",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空3] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-004",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空4] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-005",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空5] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-006",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空6] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-007",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空7] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-008",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空8] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-009",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空9] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-010",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空10] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-011",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空11] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-012",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空12] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-013",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空13] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-014",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空14] 相控阵雷达的核心微波发射接收集成前端模块通常缩写为______组件。",
        options = emptyList(),
        answer = listOf("T/R", "TR", "收发"),
        explanation = "T/R（Transmitter/Receiver）组件集成了功率放大器、低噪放、移相器与衰减器。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-fill-015",
        type = QuestionType.FILL,
        question = "[雷达探测技术核心填空15] 雷达波束在水平方向旋转360度一周所需要的时间通常称为雷达的______周期。",
        options = emptyList(),
        answer = listOf("扫描", "天线扫描", "转动"),
        explanation = "天线扫描周期决定了雷达对全空域目标航迹的刷新速率。",
        topic = "雷达探测技术",
        difficulty = 2
    ),
    Question(
        id = "radar-short-001",
        type = QuestionType.SHORT,
        question = "简述雷达在城市低空环境下探测微小型无人机面临的核心技术难题，并说明工程上采用的解决手段。",
        options = emptyList(),
        answer = listOf("难题：1. RCS极小（0.01m²级）导致回波微弱；2. 超低空高层建筑与树木产生强地杂波与多径反射；3. 无人机低速悬停易被MTI多普勒盲速过滤。\n解决手段：采用高频段（X/Ku）宽带相控阵雷达提升分辨率与回波敏感度；采用长时间相干积累提升信噪比；引入微多普勒频谱分析提取旋翼旋转特征以区分地杂波与飞鸟；部署STAP空时自适应抑制强地物干扰。"),
        explanation = "低慢小雷达探测是雷达信号处理前沿综合技术，重点考查杂波抑制与微动特征识别。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-002",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述2] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-003",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述3] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-004",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述4] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-005",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述5] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-006",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述6] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-007",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述7] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-008",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述8] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-009",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述9] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-010",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述10] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-011",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述11] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-012",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述12] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-013",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述13] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-014",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述14] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    ),
    Question(
        id = "radar-short-015",
        type = QuestionType.SHORT,
        question = "[雷达探测技术原理与应用论述15] 分析相控阵雷达（AESA）相比传统机械扫描雷达在低空安防应用中的优势与维护考量。",
        options = emptyList(),
        answer = listOf("优势：1. 波束无机械惯性，可毫秒级灵活调度驻留与跟踪；2. 多波束并行工作，同时兼顾大范围搜索与关键目标高频跟踪；3. 高可靠性与优雅降额，个别T/R组件损坏不影响全机运转。\n考量：系统成本与散热功耗要求相对较高，需要高精度通道幅相校准算法。"),
        explanation = "考查AESA雷达在低空安防实战中的核心技术特点与工程权衡。",
        topic = "雷达探测技术",
        difficulty = 3
    )
);
