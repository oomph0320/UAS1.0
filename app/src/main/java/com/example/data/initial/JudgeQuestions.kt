package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val judgeQuestions: List<Question> = listOf(
    // ========== 2025年新版UOM无人机考试 判断题 (1-10) ==========
    Question(
        id = "uom-judge-01",
        type = QuestionType.JUDGE,
        question = "UOM无人机可以在任何恶劣天气条件下飞行。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。无人机飞行受气象条件严格制约，雷暴、大风、大雾、雨雪及极端高低温严禁飞行。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-02",
        type = QuestionType.JUDGE,
        question = "操作UOM无人机不需要任何专业培训与安全规则学习。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。无人机操作涉及航空安全与公共人身安全，操作人员必须接受理论规则学习与实操安全培训。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-03",
        type = QuestionType.JUDGE,
        question = "电池电量极低时，UOM无人机也能正常安全执行远距离作业飞行。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。电量过低极易触发低电量强制迫降，甚至在空中因瞬间大电流拉垮电压导致断电坠毁。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-04",
        type = QuestionType.JUDGE,
        question = "UOM无人机飞行过程中可以随意侵入未经报备批准的管制航线改变航向。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。飞行活动必须在批准的空域与高度范围内实施，严禁擅自偏离规划航路侵入空中管制通道。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-05",
        type = QuestionType.JUDGE,
        question = "只要螺旋桨桨叶外观看起来完好，起飞前就不需要再检查其安装到位与卡扣锁紧情况。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。起飞前必须机械用手轻拔确认螺旋桨已旋转自锁或螺丝拧紧到位，防止空中射桨脱落。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-06",
        type = QuestionType.JUDGE,
        question = "遇到紧急飞行险情时，飞手应立即慌乱关闭无人机遥控器电源。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。关闭遥控器将彻底失去人工干预避险可能；应保持遥控器开启，观察姿态并根据情况切手动或点一键返航/迫降。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-07",
        type = QuestionType.JUDGE,
        question = "UOM无人机在密闭室内也能很好地利用GPS卫星进行高精度卫星定位。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。室内钢筋混凝土与屋顶会完全遮挡吸收GNSS微波信号，室内无GPS，通常依赖光流视觉或进入纯姿态模式。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-08",
        type = QuestionType.JUDGE,
        question = "不同型号、不同工作电压与容量的UOM无人机动力电池可以任意混合插接使用。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。不同规格电芯内阻与放电曲线差异巨大，混用会导致严重偏流过热、电池起火或动力骤降。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-09",
        type = QuestionType.JUDGE,
        question = "飞行过程中听到电机或螺旋桨传来剧烈异常刺耳异响，应无需理会继续观察盲目飞完航线。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。异常震动与异响预示电机扫膛、轴承损坏或桨叶即将疲劳断裂，必须立即安全悬停降落检查。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "uom-judge-10",
        type = QuestionType.JUDGE,
        question = "操作人员可以在适量饮酒后操控无人机进行起降飞行。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。民航法律法规严禁饮酒或服用受管制药物后操控无人机飞行，酒精会麻痹神经延误应急反应。",
        topic = "法规与空域规则",
        difficulty = 1
    ),

    // ========== CAAC无人机理论考试 判断题 (1-10) ==========
    Question(
        id = "caac-judge-01",
        type = QuestionType.JUDGE,
        question = "所有无人机在每次起飞前都必须无条件强制进行指南针（磁罗盘）校准。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。部分现代无人机具备磁场自动标定抗扰算法；且在钢筋混凝土地面或磁异常区域盲目重复校准反而会导致校准错误引起刷锅，仅在异地转场或提示磁干扰时在开阔草地校准。",
        topic = "飞行操作与维护",
        difficulty = 2
    ),
    Question(
        id = "caac-judge-02",
        type = QuestionType.JUDGE,
        question = "微型无人机（空机重量≤4千克）在非管制适飞空域飞行时，完全不需要考虑任何飞行高度限制。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。在非管制适飞空域内，国家规定微型机与轻型机依然受真高120米（微型机限高50米）的通用空域高度限制。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-03",
        type = QuestionType.JUDGE,
        question = "无人机飞行中，若GPS信号意外丢失，姿态模式（无GPS）下仍能依靠飞控实现自动抗风定点纹丝不动的悬停。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。姿态模式下无外部位置参考点，只能保持机身水平姿态，一旦有外界横风，无人机会顺风自然漂移，必须飞手手动推杆修正位置。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "caac-judge-04",
        type = QuestionType.JUDGE,
        question = "标注具备防水等级的工业级无人机在雨天飞行时，可以完全忽略降水与雷电对传感器和电机的任何负面影响。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。雨天伴随低能见度，雨滴覆盖云台镜头与避障雷达会引发误报，剧烈雨幕还会增大桨叶阻力，严防强对流与雷电袭击。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-05",
        type = QuestionType.JUDGE,
        question = "民用无人机作业飞行日志只需记录起飞和降落的具体时间即可。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。飞行日志应完整详实记录机长、执照编号、起降时间、飞行高度、空域作业范围、电池循环及任何异常机务维护记录。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-06",
        type = QuestionType.JUDGE,
        question = "视距内（VLOS）操作飞行时，操作员必须始终保持肉眼（或借助视力矫正眼镜）能直接目视观察到飞行器全貌。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("A"),
        explanation = "正确。视距内飞行的法定核心准则是肉眼直视维持情境感知，不得脱离目视仅依靠图传盲飞。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-07",
        type = QuestionType.JUDGE,
        question = "无人机机载重心（CG）前后严重偏移，不会对飞行姿态能耗和电池续航时间产生任何负面影响。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。重心偏移会导致部分电机必须以极高转速运转抗衡力矩，整体动力效率大跌，电机发热加剧，续航大幅缩减。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-08",
        type = QuestionType.JUDGE,
        question = "在机场周边区域飞行时，只要避开跑道中心线即可，无需理会滑行道、净空区与航线侧向走廊。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。机场净空保护区覆盖以跑道为轴线两侧各10公里、两端外各20公里的广大三维几何空间，严禁任何违规黑飞。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-09",
        type = QuestionType.JUDGE,
        question = "无人机动力电池剩余电量降至20%以下时，飞手应立即执行安全返航操作。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("A"),
        explanation = "正确。预留至少20%安全冗余电量是应对逆风减速、航路避障及突发对空让行降落的黄金保底法则。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "caac-judge-10",
        type = QuestionType.JUDGE,
        question = "在超视距（BVLOS）长距离作业飞行中，图传画面瞬间雪花中断故障对飞行安全没有任何实质影响。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误")
        ),
        answer = listOf("B"),
        explanation = "错误。超视距无法肉眼目视，图传中断将导致操作员瞬间丧失外部视觉态势感知，必须高度警惕并触发保护返航程序。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    )
)
