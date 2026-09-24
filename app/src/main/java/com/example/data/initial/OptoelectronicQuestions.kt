package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val optoelectronicQuestions: List<Question> = listOf(
    Question(
        id = "opto-single-001",
        type = QuestionType.SINGLE,
        question = "在可见光光学成像系统中，决定光学镜头收集光线能力与景深的最主要光学参数是：",
        options = listOf(
            QuizOption("A", "相对孔径与光圈数（F数）"),
            QuizOption("B", "机身涂层折射率"),
            QuizOption("C", "遮光罩长度"),
            QuizOption("D", "固定螺栓材质"),
        ),
        answer = listOf("A"),
        explanation = "F数 = 焦距 / 入瞳直径。F数越小，进光量越大，低照度感光能力越强，但景深相对变浅。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-002",
        type = QuestionType.SINGLE,
        question = "长波红外（LWIR）热成像相机通常工作的大气传输窗口波长范围是：",
        options = listOf(
            QuizOption("A", "8 ~ 14 微米（μm）"),
            QuizOption("B", "0.4 ~ 0.7 微米"),
            QuizOption("C", "1.5 ~ 2.0 微米"),
            QuizOption("D", "100 ~ 200 微米"),
        ),
        answer = listOf("A"),
        explanation = "红外波段通常划分为短波红外（1~3μm）、中波红外（3~5μm）和长波红外（8~14μm），8~14μm处于常温常压下的大气低吸收透射窗口。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-003",
        type = QuestionType.SINGLE,
        question = "红外热像仪探测小型无人机依靠的是：",
        options = listOf(
            QuizOption("A", "无人机电机、电调、电池与机体摩擦散发的热辐射与背景温度差异"),
            QuizOption("B", "反射太阳可见白光"),
            QuizOption("C", "吸收空气中的紫外线"),
            QuizOption("D", "无人机机壳上的荧光粉"),
        ),
        answer = listOf("A"),
        explanation = "无人机动力无刷电机在高速运转时电流很大，电调与锂电池发热明显，机身与空气摩擦产生红外温差，热像仪通过测量微小辐射温差成像。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-004",
        type = QuestionType.SINGLE,
        question = "光电转台在反无人机伺服跟踪系统中，用于消除外界风阻扰动和平台颠簸振动的传感器核心组件是：",
        options = listOf(
            QuizOption("A", "光纤陀螺仪或MEMS惯性测量单元（IMU）"),
            QuizOption("B", "气压计"),
            QuizOption("C", "指南针磁力计"),
            QuizOption("D", "水银温度计"),
        ),
        answer = listOf("A"),
        explanation = "高精度两轴四框架光电转台内部配备速率陀螺仪（如光纤陀螺FOG），通过测定空间角速度扰动并施加反向力矩，实现对视轴惯性空间隔离稳瞄。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-005",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点5] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-006",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点6] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-007",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点7] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-008",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点8] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-009",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点9] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-010",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点10] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-011",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点11] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-012",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点12] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-013",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点13] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-014",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点14] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-015",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点15] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-016",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点16] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-017",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点17] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-018",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点18] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-019",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点19] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-020",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点20] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-021",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点21] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-022",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点22] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-023",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点23] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-024",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点24] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-025",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点25] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-026",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点26] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-027",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点27] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-028",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点28] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-029",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点29] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-030",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点30] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-031",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点31] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-032",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点32] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-033",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点33] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-034",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点34] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-035",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点35] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-036",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点36] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-037",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点37] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-038",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点38] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-039",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点39] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-040",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点40] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-041",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点41] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-042",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点42] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-043",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点43] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-044",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点44] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-045",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点45] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-046",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点46] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-047",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点47] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-048",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点48] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-049",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点49] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-050",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点50] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-051",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点51] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-052",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点52] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-053",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点53] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-054",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点54] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-055",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点55] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-056",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点56] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-057",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点57] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-058",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点58] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-059",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点59] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-060",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点60] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-061",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点61] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-062",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点62] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-063",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点63] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-064",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点64] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-065",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点65] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-066",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点66] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-067",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点67] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-068",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点68] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-069",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点69] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-070",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点70] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-071",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点71] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-072",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点72] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-073",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点73] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-074",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点74] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-075",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点75] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-076",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点76] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-077",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点77] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-078",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点78] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-079",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点79] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-080",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点80] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-081",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点81] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-082",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点82] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-083",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点83] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-084",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点84] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-085",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点85] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-086",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点86] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-087",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点87] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-088",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点88] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-089",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点89] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-090",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点90] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-091",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点91] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-092",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点92] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-093",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点93] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-094",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点94] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-095",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点95] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-096",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点96] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-097",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点97] 脉冲激光测距机测量目标距离利用的核心物理常数是：",
        options = listOf(
            QuizOption("A", "真空光速（约 3 × 10⁸ m/s）"),
            QuizOption("B", "普朗克常数"),
            QuizOption("C", "重力加速度"),
            QuizOption("D", "阿伏伽德罗常数"),
        ),
        answer = listOf("A"),
        explanation = "激光飞行时间测距（ToF）公式为 R = (c * t) / 2，通过超精细高频时钟计数器记录发射至接收的光速传播时差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-098",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点98] 在全自动无人机视觉跟瞄算法中，常用于在图像帧间实现目标连续闭环定位的算法是：",
        options = listOf(
            QuizOption("A", "孪生网络目标跟踪（SiamRPN/SiamFC）或核相关滤波（KCF）"),
            QuizOption("B", "冒泡排序"),
            QuizOption("C", "散列哈希映射"),
            QuizOption("D", "Floyd算法"),
        ),
        answer = listOf("A"),
        explanation = "KCF与SiamRPN是光电跟踪领域主流算法，通过对目标模板与搜索区域特征相关性计算，以几十至几百帧每秒输出无人机在画面的像素中心偏差。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-099",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点99] 相比非制冷长波红外热像仪，中波制冷型热成像仪（MWIR）最显著的性能优势是：",
        options = listOf(
            QuizOption("A", "灵敏度极高（NETD通常小于20mK），对微小温差敏感，探测距离远可达数公里以上"),
            QuizOption("B", "零功耗免供电"),
            QuizOption("C", "开机无需降温秒级出图"),
            QuizOption("D", "整机重量小于50克"),
        ),
        answer = listOf("A"),
        explanation = "中波制冷型热像仪采用斯特林制冷机将探测器降温至77K超低温，消除探测器自身热本底噪声，具有极高的热灵敏度与超远识别距离。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-single-100",
        type = QuestionType.SINGLE,
        question = "[光电探测原理专业考点100] 当雾霾严重时，短波红外（SWIR，1.0~1.7μm）相比可见光相机的透雾透尘能力：",
        options = listOf(
            QuizOption("A", "显著增强，因波长更长受微小气溶胶颗粒的瑞利散射影响大幅下降"),
            QuizOption("B", "完全消失"),
            QuizOption("C", "毫无变化"),
            QuizOption("D", "下降十倍"),
        ),
        answer = listOf("A"),
        explanation = "根据散射物理定律，散射强度与波长的四次方成反比。短波红外波长明显大于可见光，能够穿透轻烟、尘雾与水汽薄雾。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-multi-001",
        type = QuestionType.MULTI,
        question = "低空防御一体化光电转台系统通常集成的多光谱与传感器载荷包括：",
        options = listOf(
            QuizOption("A", "长焦连续光学变焦高清可见光相机"),
            QuizOption("B", "中波制冷或长波非制冷高灵敏度红外热像仪"),
            QuizOption("C", "人眼安全半导体脉冲激光测距机（LRF）"),
            QuizOption("D", "高动态多轴精密陀螺稳定伺服转台机构"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "典型反无人机光电系统涵盖可见光识别（白天高清）、红外成像（全天候夜视）、激光测距（提供空间三维坐标）与陀螺增稳伺服平台。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-multi-002",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合2] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-003",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合3] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-004",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合4] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-005",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合5] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-006",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合6] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-007",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合7] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-008",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合8] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-009",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合9] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-010",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合10] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-011",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合11] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-012",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合12] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-013",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合13] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-014",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合14] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-015",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合15] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-016",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合16] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-017",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合17] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-018",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合18] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-019",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合19] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-020",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合20] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-021",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合21] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-022",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合22] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-023",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合23] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-024",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合24] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-025",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合25] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-026",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合26] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-027",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合27] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-028",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合28] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-029",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合29] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-030",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合30] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-031",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合31] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-032",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合32] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-033",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合33] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-034",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合34] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-035",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合35] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-036",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合36] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-037",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合37] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-038",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合38] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-039",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合39] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-multi-040",
        type = QuestionType.MULTI,
        question = "[光电探测原理多维综合40] 光电系统在对低空无人机进行视觉跟踪时，容易发生目标丢失的复杂背景干扰场景包括：",
        options = listOf(
            QuizOption("A", "无人机飞入浓密树丛背后产生视距被遮挡（Occlusion）"),
            QuizOption("B", "无人机由天空背景穿入高反差楼宇、玻璃幕墙复杂地面背景"),
            QuizOption("C", "相机正对太阳发生强光眩目过曝饱和"),
            QuizOption("D", "镜头前飞过一只大鸟产生瞬间遮挡混淆"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "光电跟踪受视距遮挡、强反差地杂波、强光饱和与相似移动物交叠影响显著，需要智能重捕获与多特征自适应更新机制。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-judge-001",
        type = QuestionType.JUDGE,
        question = "可见光相机在夜间无辅助照明（如探照灯）且无月光的开阔自然环境下，依然能清晰识别数公里外飞行的黑色无人机。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。可见光相机依赖反射外界环境光，夜间全黑无光照时必须切换为被动红外热成像仪工作。",
        topic = "光电探测原理",
        difficulty = 1
    ),
    Question(
        id = "opto-judge-002",
        type = QuestionType.JUDGE,
        question = "热成像仪的噪声等效温差（NETD）指标数值越小，代表热成像探测器的温度灵敏度越高、成像越细腻。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。NETD表示探测器恰能分辨的最小温度差，数值越小（如15mK优于40mK），对微弱温差感知能力越强。",
        topic = "光电探测原理",
        difficulty = 1
    ),
    Question(
        id = "opto-judge-003",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析3] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-004",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析4] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-005",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析5] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-006",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析6] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-007",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析7] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-008",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析8] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-009",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析9] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-010",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析10] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-011",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析11] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-012",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析12] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-013",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析13] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-014",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析14] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-015",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析15] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-016",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析16] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-017",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析17] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-018",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析18] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-019",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析19] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-020",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析20] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-021",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析21] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-022",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析22] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-023",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析23] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-024",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析24] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-025",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析25] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-026",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析26] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-027",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析27] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-028",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析28] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-029",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析29] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-judge-030",
        type = QuestionType.JUDGE,
        question = "[光电探测原理正误辨析30] 激光测距机在测量极小反射面积的四旋翼无人机时，激光束发散角越小，目标上落入的光能量密度越高，测距越远越精准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。小发散角激光束准直度高，长距离光斑扩张慢，利于微小无人机反射足够光子至雪崩光电二极管（APD）。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-001",
        type = QuestionType.FILL,
        question = "热成像系统衡量热灵敏度最核心的技术参数是噪声等效温差，其英文缩写为______。",
        options = emptyList(),
        answer = listOf("NETD"),
        explanation = "NETD是Noise Equivalent Temperature Difference的缩写。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-002",
        type = QuestionType.FILL,
        question = "光电转台通过两轴或四轴伺服系统在风阻和抖动下保持镜头瞄准视轴稳定的传感器是______陀螺仪。",
        options = emptyList(),
        answer = listOf("陀螺仪", "光纤陀螺仪", "陀螺"),
        explanation = "速率陀螺仪实时感知转台角位移并闭环反馈补偿伺服电机。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-003",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空3] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-004",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空4] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-005",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空5] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-006",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空6] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-007",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空7] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-008",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空8] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-009",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空9] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-010",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空10] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-011",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空11] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-012",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空12] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-013",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空13] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-014",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空14] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-fill-015",
        type = QuestionType.FILL,
        question = "[光电探测原理核心填空15] 光学镜头的焦距除以有效通光孔径直径所得的比值称为镜头的______数。",
        options = emptyList(),
        answer = listOf("F", "光圈", "相对孔径"),
        explanation = "F数定义为 f / D，衡量镜头通光能力。",
        topic = "光电探测原理",
        difficulty = 2
    ),
    Question(
        id = "opto-short-001",
        type = QuestionType.SHORT,
        question = "简述光电侦搜系统与低空探测雷达在反无人机作战中的协同联动配合流程与互补价值。",
        options = emptyList(),
        answer = listOf("协同流程：1. 雷达在远距离（3~5km）广域快速搜索，发现目标后解算其方位角、俯仰角与距离，将坐标引导数据高速推送给光电；2. 光电转台根据引导坐标迅速调转视轴指向目标空域（Slew-to-Cue）；3. 光电系统使用可见光或红外传感器在狭小视场内快速捕获目标，启动图像闭环跟踪，实施光学放大识别取证并精确测距；4. 为后续电磁软杀伤或激光硬杀伤提供厘米级/毫弧度级火控跟瞄指向。\n互补价值：雷达负责广域粗搜、全天候远距测距测速；光电负责窄视场高精度角分辨、直观外形定性与法律取证，两者结合弥补了雷达缺乏视觉证据与光电搜索视场窄的固有缺陷。"),
        explanation = "考查雷达与光电联动火控链路的工程实践。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-002",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述2] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-003",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述3] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-004",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述4] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-005",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述5] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-006",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述6] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-007",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述7] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-008",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述8] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-009",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述9] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-010",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述10] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-011",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述11] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-012",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述12] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-013",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述13] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-014",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述14] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    ),
    Question(
        id = "opto-short-015",
        type = QuestionType.SHORT,
        question = "[光电探测原理原理与应用论述15] 分析红外热像仪在夏季高温城市环境下探测小型无人机可能遭遇的技术挑战及应对措施。",
        options = emptyList(),
        answer = listOf("挑战：夏季地面水泥建筑物与沥青路面温度高达40~50℃，地表背景红外辐射饱和，无人机电机温差与背景温差对比度大幅降低；空气对流热浪引发光束抖动与图像变形。\n措施：采用中波制冷型高灵敏度探测器；应用宽动态范围数字图像细节增强（DDE）与自适应局部对比度均衡算法；结合可见光与微多普勒雷达数据实现多特征加权关联确认。"),
        explanation = "考查红外成像在极端环境下的信号处理与抗干扰措施。",
        topic = "光电探测原理",
        difficulty = 3
    )
);
