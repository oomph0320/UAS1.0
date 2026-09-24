package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val radioQuestions: List<Question> = listOf(
    Question(
        id = "radio-single-001",
        type = QuestionType.SINGLE,
        question = "无线电无源探测（Passive RF Detection）在反无人机防空预警中最大的实战优势是：",
        options = listOf(
            QuizOption("A", "零电磁辐射发射，自身绝对隐蔽且对民航和周边设备无任何干扰"),
            QuizOption("B", "能够将雷达波发射到地平线以外"),
            QuizOption("C", "不受无线电静默影响"),
            QuizOption("D", "能够物理击落无人机"),
        ),
        answer = listOf("A"),
        explanation = "无线电侦测通过高灵敏度全向/定向天线被动接收无人机图传与遥控通信信号，不主动发射任何电磁波，具备绿色无辐射、高电磁兼容性与零暴露风险的特点。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-002",
        type = QuestionType.SINGLE,
        question = "利用空间分离的多个接收天线阵元接收同一空间信号的载波相位差来确定目标来波方向（DoA）的技术被称为：",
        options = listOf(
            QuizOption("A", "干涉仪测向（Interferometer Direction Finding）"),
            QuizOption("B", "超外差检波"),
            QuizOption("C", "扩频通信"),
            QuizOption("D", "高阻抗匹配"),
        ),
        answer = listOf("A"),
        explanation = "相位干涉仪测向利用基线两端天线接收电磁波的相位差 Δφ = (2π * d / λ) * sin(θ) 计算目标入射角θ，测量精度高且测向速度极快。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-003",
        type = QuestionType.SINGLE,
        question = "无线电多基站TDoA（到达时间差）定位体制中，两个侦测站测得的信号时差在二维平面上确定的是一条：",
        options = listOf(
            QuizOption("A", "以两基站为焦点的双曲线（Hyperbola）"),
            QuizOption("B", "圆形"),
            QuizOption("C", "以两基站为端点的线段"),
            QuizOption("D", "抛物线"),
        ),
        answer = listOf("A"),
        explanation = "到达时间差对应恒定的距离差，平面上到两定点距离之差为定值的点的轨迹是双曲线，两基站确定一条双曲线，多条双曲线交汇实现目标定位。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-004",
        type = QuestionType.SINGLE,
        question = "在无线电侦测系统中，能够将时域高频信号转换为频域能量分布以进行频谱瀑布图分析的核心算法是：",
        options = listOf(
            QuizOption("A", "快速傅里叶变换（FFT）"),
            QuizOption("B", "汉明纠错编码"),
            QuizOption("C", "DES加密算法"),
            QuizOption("D", "Dijkstra最短路径算法"),
        ),
        answer = listOf("A"),
        explanation = "FFT快速傅里叶变换是软件无线电（SDR）实时频谱分析的基石，通过频域变换可实时呈现信道频谱能量与周期性跳频图谱。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-005",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点5] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-006",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点6] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-007",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点7] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-008",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点8] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-009",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点9] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-010",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点10] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-011",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点11] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-012",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点12] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-013",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点13] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-014",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点14] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-015",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点15] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-016",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点16] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-017",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点17] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-018",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点18] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-019",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点19] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-020",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点20] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-021",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点21] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-022",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点22] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-023",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点23] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-024",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点24] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-025",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点25] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-026",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点26] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-027",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点27] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-028",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点28] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-029",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点29] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-030",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点30] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-031",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点31] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-032",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点32] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-033",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点33] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-034",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点34] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-035",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点35] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-036",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点36] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-037",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点37] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-038",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点38] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-039",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点39] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-040",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点40] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-041",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点41] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-042",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点42] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-043",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点43] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-044",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点44] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-045",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点45] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-046",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点46] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-047",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点47] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-048",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点48] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-049",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点49] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-050",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点50] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-051",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点51] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-052",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点52] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-053",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点53] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-054",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点54] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-055",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点55] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-056",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点56] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-057",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点57] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-058",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点58] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-059",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点59] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-060",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点60] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-061",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点61] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-062",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点62] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-063",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点63] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-064",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点64] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-065",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点65] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-066",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点66] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-067",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点67] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-068",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点68] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-069",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点69] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-070",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点70] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-071",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点71] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-072",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点72] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-073",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点73] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-074",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点74] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-075",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点75] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-076",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点76] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-077",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点77] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-078",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点78] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-079",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点79] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-080",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点80] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-081",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点81] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-082",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点82] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-083",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点83] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-084",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点84] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-085",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点85] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-086",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点86] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-087",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点87] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-088",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点88] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-089",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点89] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-090",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点90] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-091",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点91] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-092",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点92] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-093",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点93] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-094",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点94] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-095",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点95] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-096",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点96] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-097",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点97] 无线电协议解析侦测设备能够从大疆OcuSync图传信号中提取的明文广播信息通常包括：",
        options = listOf(
            QuizOption("A", "无人机机身唯一电子序列号（SN码）、无人机实时经纬度与高度、飞手遥控器位置"),
            QuizOption("B", "飞手微信聊天记录"),
            QuizOption("C", "无人机相机拍摄的相册全部高清原图"),
            QuizOption("D", "飞手个人银行账户余额"),
        ),
        answer = listOf("A"),
        explanation = "协议侦测技术利用DroneID广播协议逆向解析，可实时提取无人机出厂SN、经纬度高度、航向速度以及起飞点/飞手遥控器精准位置。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-098",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点98] 当两个无人机遥控器同时同频发射时，超分辨测向算法（如MUSIC算法）相比经典波束形成（Beamforming）的核心突破是：",
        options = listOf(
            QuizOption("A", "突破天线孔径瑞利极限，能够对角度间隔小于半波束宽度的相干多目标实现角分辨"),
            QuizOption("B", "发射更大功率的微波"),
            QuizOption("C", "完全消除多径反射"),
            QuizOption("D", "不需要数字采样"),
        ),
        answer = listOf("A"),
        explanation = "MUSIC（多重信号分类）基于阵列接收协方差矩阵的特征值分解，将信号子空间与噪声子空间正交投影，具有极高的超分辨测向能力。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-099",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点99] 在密集建筑城市中心部署TDoA基站网络时，影响定位精度的最大几何结构指标是：",
        options = listOf(
            QuizOption("A", "几何精度衰减因子（GDOP）"),
            QuizOption("B", "基站外壳油漆颜色"),
            QuizOption("C", "天线固定螺栓螺纹间距"),
            QuizOption("D", "地线铜排厚度"),
        ),
        answer = listOf("A"),
        explanation = "GDOP反映了基站拓扑几何分布对时差测量误差的放大倍数，基站包围被测目标空域时GDOP最优，呈直线排列时GDOP急剧恶化发散。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-single-100",
        type = QuestionType.SINGLE,
        question = "[无线电探测技术专业考点100] 软件无线电（SDR）接收机前端中，负责将模拟射频连续信号转换为离散数字信号的关键器件是：",
        options = listOf(
            QuizOption("A", "高采样率模数转换器（ADC）"),
            QuizOption("B", "大功率水冷磁控管"),
            QuizOption("C", "机械继电器"),
            QuizOption("D", "稳压电容"),
        ),
        answer = listOf("A"),
        explanation = "ADC（Analog-to-Digital Converter）是SDR软件无线电数字化的核心枢纽，采样率和有效位数（ENOB）决定了侦测带宽和动态范围。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-multi-001",
        type = QuestionType.MULTI,
        question = "无线电侦测系统对无人机跳频通信信号（FHSS）进行截获与特征识别时，需要提取的关键射频指纹参数包括：",
        options = listOf(
            QuizOption("A", "跳频驻留时间（Dwell Time）与跳频速率（Hop Rate）"),
            QuizOption("B", "跳变频率集与瞬时占用信道带宽"),
            QuizOption("C", "信号调制类型（如OFDM、FSK、QPSK）"),
            QuizOption("D", "脉冲前沿上升时间与射频功率包络"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "跳频识别依赖多维射频指纹特征提取，包括时域跳速、频域信道集、调制样式及个体特定瞬态开启特征（SEI）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-multi-002",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合2] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-003",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合3] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-004",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合4] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-005",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合5] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-006",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合6] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-007",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合7] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-008",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合8] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-009",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合9] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-010",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合10] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-011",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合11] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-012",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合12] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-013",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合13] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-014",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合14] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-015",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合15] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-016",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合16] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-017",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合17] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-018",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合18] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-019",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合19] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-020",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合20] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-021",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合21] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-022",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合22] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-023",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合23] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-024",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合24] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-025",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合25] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-026",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合26] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-027",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合27] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-028",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合28] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-029",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合29] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-030",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合30] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-031",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合31] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-032",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合32] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-033",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合33] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-034",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合34] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-035",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合35] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-036",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合36] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-037",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合37] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-038",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合38] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-039",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合39] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-multi-040",
        type = QuestionType.MULTI,
        question = "[无线电探测技术多维综合40] 构建高精度TDoA低空无线电侦测网络，工程部署必须满足的关键条件包括：",
        options = listOf(
            QuizOption("A", "各基站配备GPS/北斗纳秒级高精度授时模块或光纤时钟互联"),
            QuizOption("B", "各基站空间分布合理，避免处于一条同轴直线上导致GDOP恶化"),
            QuizOption("C", "站点间具备稳定高带宽数据回传网络（以太网或光纤专网）"),
            QuizOption("D", "所有基站必须涂刷反光荧光漆"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "TDoA定位依赖精密纳秒同步时钟、几何布局分散以保障小GDOP值，以及高速网络回传I/Q数据解算互相关峰。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-judge-001",
        type = QuestionType.JUDGE,
        question = "无线电侦测系统只能侦听无人机发射的图传信号，无法对地面飞手遥控器发出的上行控制信号进行定位。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。无线电侦测系统既可以侦测无人机下行图传（Downlink），也可侦测飞手上行遥控信号（Uplink），并利用遥控信号定位飞手所处位置。",
        topic = "无线电探测技术",
        difficulty = 1
    ),
    Question(
        id = "radio-judge-002",
        type = QuestionType.JUDGE,
        question = "超分辨测向MUSIC算法利用天线阵列协方差矩阵的特征值分解，将信号子空间与噪声子空间分离以实现超分辨高精度测向。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。MUSIC算法利用噪声子空间与导向矢量的正交性构造空间谱函数，极大突破了经典傅里叶变换的瑞利分辨力极限。",
        topic = "无线电探测技术",
        difficulty = 1
    ),
    Question(
        id = "radio-judge-003",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析3] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-004",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析4] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-005",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析5] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-006",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析6] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-007",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析7] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-008",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析8] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-009",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析9] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-010",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析10] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-011",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析11] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-012",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析12] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-013",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析13] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-014",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析14] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-015",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析15] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-016",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析16] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-017",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析17] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-018",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析18] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-019",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析19] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-020",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析20] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-021",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析21] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-022",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析22] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-023",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析23] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-024",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析24] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-025",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析25] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-026",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析26] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-027",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析27] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-028",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析28] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-029",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析29] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-judge-030",
        type = QuestionType.JUDGE,
        question = "[无线电探测技术正误辨析30] 只要无人机在空中开启了无线电图传，即使信号被建筑遮挡产生反射，被动测向系统也绝不会产生任何测向角偏差。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。建筑与地面多径反射会造成波达方向产生非视距（NLOS）伪峰或相位失真，导致测向角偏转误差。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-001",
        type = QuestionType.FILL,
        question = "利用天线阵列测量电磁波相位差异解算来波方位的技术称为______测向。",
        options = emptyList(),
        answer = listOf("相位干涉仪", "干涉仪"),
        explanation = "相位干涉仪通过测量多阵元间的空间相位差进行角度解算。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-002",
        type = QuestionType.FILL,
        question = "无线电侦测系统中，基于多基站计算信号到达时间差的定位英文缩写为______定位。",
        options = emptyList(),
        answer = listOf("TDoA", "TDOA"),
        explanation = "TDoA是Time Difference of Arrival的缩写。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-003",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空3] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-004",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空4] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-005",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空5] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-006",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空6] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-007",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空7] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-008",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空8] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-009",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空9] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-010",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空10] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-011",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空11] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-012",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空12] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-013",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空13] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-014",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空14] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-fill-015",
        type = QuestionType.FILL,
        question = "[无线电探测技术核心填空15] 无人机遥控通信中广泛采用的避开定频干扰的跳变频率扩频技术缩写为______通信。",
        options = emptyList(),
        answer = listOf("FHSS", "跳频"),
        explanation = "FHSS即跳频扩频通信技术（Frequency-Hopping Spread Spectrum）。",
        topic = "无线电探测技术",
        difficulty = 2
    ),
    Question(
        id = "radio-short-001",
        type = QuestionType.SHORT,
        question = "简述无线电协议破解侦测技术（如解析无人机序列号与飞手坐标）的工作原理与优势。",
        options = emptyList(),
        answer = listOf("原理：截获无人机下行信标帧或数据链路广播，逆向解调出物理层射频信号，提取包含出厂SN码、飞手经纬度、无人机实时三维坐标等遥测结构体并实时解包呈现。\n优势：1. 零漏警误判，单站即可瞬间获得飞手与无人机的精确绝对坐标；2. 具有唯一电子身份核实能力，利于公安取证与执法追踪；3. 不依赖复杂多基站时差交叉，单站成本极低且便携部署敏捷。"),
        explanation = "考查无人机协议侦测的机制、优势及局限性。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-002",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述2] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-003",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述3] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-004",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述4] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-005",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述5] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-006",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述6] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-007",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述7] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-008",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述8] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-009",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述9] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-010",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述10] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-011",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述11] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-012",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述12] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-013",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述13] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-014",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述14] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    ),
    Question(
        id = "radio-short-015",
        type = QuestionType.SHORT,
        question = "[无线电探测技术原理与应用论述15] 对比分析无线电到达角测向（AoA）与到达时间差定位（TDoA）在城市复杂电磁环境中的优缺点。",
        options = emptyList(),
        answer = listOf("AoA优点：单站即可给出指向目标的方位线，设备部署简单，不依赖超高精度基站间授时同步；缺点：受城市建筑强多径反射影响大，测向线易弯曲偏转，两站交叉距离远时纵向误差大。\nTDoA优点：定位精度高，多站冗余解算可抑制随机噪声，抗轻微多径能力较好；缺点：依赖至少3~4个基站，需要纳秒级GPS高精度授时同步，依赖高带宽数据通信回传，基站几何布局不佳时易产生奇异解。"),
        explanation = "考查无线电测向定位关键算法实战特性的工程对比。",
        topic = "无线电探测技术",
        difficulty = 3
    )
);
