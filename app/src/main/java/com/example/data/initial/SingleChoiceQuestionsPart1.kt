package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val singleChoiceQuestionsPart1: List<Question> = listOf(
    // ========== CAAC无人机理论考试 (2026修订版) ==========
    Question(
        id = "caac-2026-sc-01",
        type = QuestionType.SINGLE,
        question = "根据2026修订版《民用无人驾驶航空器运行管理暂行条例》，以下不属于微型无人机定义范畴的是（ ）。",
        options = listOf(
            QuizOption("A", "最大起飞重量0.1kg"),
            QuizOption("B", "全程自主飞行且不与地面站通信"),
            QuizOption("C", "飞行高度限制120米"),
            QuizOption("D", "未安装任何抛投装置")
        ),
        answer = listOf("C"),
        explanation = "微型无人机飞行高度限制为50米，120米为轻型无人机适飞空域上限。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-02",
        type = QuestionType.SINGLE,
        question = "伯努利原理描述的空气动力学现象是（ ）。",
        options = listOf(
            QuizOption("A", "气流速度增加，静压增加"),
            QuizOption("B", "气流速度增加，动压减少"),
            QuizOption("C", "气流速度增加，静压减少"),
            QuizOption("D", "气流速度与压力无关")
        ),
        answer = listOf("C"),
        explanation = "伯努利方程：P + 1/2 ρv² = 常数。流体流速增加时，静压降低，动压增加。",
        topic = "飞行原理与气动力学",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-03",
        type = QuestionType.SINGLE,
        question = "无人机飞行中出现“失速”的直接原因是（ ）。",
        options = listOf(
            QuizOption("A", "飞行速度过高"),
            QuizOption("B", "迎角超过临界值"),
            QuizOption("C", "发动机功率不足"),
            QuizOption("D", "气压高度表故障")
        ),
        answer = listOf("B"),
        explanation = "当迎角超过临界值时，机翼上表面气流发生严重边界层分离，升力骤降、阻力急剧增大，引发失速。",
        topic = "飞行原理与气动力学",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-04",
        type = QuestionType.SINGLE,
        question = "轻型无人机（4kg＜M≤25kg）在管制空域内飞行，需提前（ ）向空中交通管理机构提出飞行计划申请。",
        options = listOf(
            QuizOption("A", "1小时"),
            QuizOption("B", "6小时"),
            QuizOption("C", "12小时"),
            QuizOption("D", "24小时")
        ),
        answer = listOf("D"),
        explanation = "2026修订版规定管制空域内轻型无人机需提前24小时向空中交通管理机构提出飞行计划申请报备。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-05",
        type = QuestionType.SINGLE,
        question = "积雨云（Cb）对无人机飞行的主要危害不包括（ ）。",
        options = listOf(
            QuizOption("A", "强湍流"),
            QuizOption("B", "冰雹"),
            QuizOption("C", "低能见度"),
            QuizOption("D", "稳定上升气流")
        ),
        answer = listOf("D"),
        explanation = "积雨云内存在极强烈的垂直气流（包括剧烈上升气流与极危险的下沉气流/微下冲气流），绝无稳定上升特性。",
        topic = "航空气象与环境",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-06",
        type = QuestionType.SINGLE,
        question = "多旋翼无人机悬停时，若某一电机转速异常降低，最可能出现的现象是（ ）。",
        options = listOf(
            QuizOption("A", "向该电机对角方向漂移"),
            QuizOption("B", "向该电机同侧方向倾斜"),
            QuizOption("C", "原地自旋"),
            QuizOption("D", "垂直下降")
        ),
        answer = listOf("B"),
        explanation = "多旋翼通过对称电机反向旋转平衡扭矩，单电机转速降低会导致对应侧产生的升力不足，引起机身向同侧倾斜。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-07",
        type = QuestionType.SINGLE,
        question = "无人机电池剩余电量为20%时，应执行的操作是（ ）。",
        options = listOf(
            QuizOption("A", "继续完成当前航点"),
            QuizOption("B", "立即返航"),
            QuizOption("C", "降低飞行高度节省电量"),
            QuizOption("D", "切换至手动模式")
        ),
        answer = listOf("B"),
        explanation = "2026版规范要求电池电量低于25%时需触发返航警告，达到20%必须立即执行返航或就近降落，防止动力骤降坠机。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-08",
        type = QuestionType.SINGLE,
        question = "以下气象条件中，符合轻型无人机飞行要求的是（ ）。",
        options = listOf(
            QuizOption("A", "风速8m/s（4级风）"),
            QuizOption("B", "能见度1.5km"),
            QuizOption("C", "云底高度80米"),
            QuizOption("D", "气温-15℃")
        ),
        answer = listOf("A"),
        explanation = "轻型无人机允许风速≤10m/s（8m/s符合要求）；能见度要求≥3km；云底高度要求≥120米；适宜工作气温一般需高于-10℃或做好保温措施。",
        topic = "航空气象与环境",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-09",
        type = QuestionType.SINGLE,
        question = "无人机飞行中，GNSS信号丢失但IMU正常时，飞控系统会进入（ ）模式。",
        options = listOf(
            QuizOption("A", "姿态模式"),
            QuizOption("B", "定点模式"),
            QuizOption("C", "返航模式"),
            QuizOption("D", "失控保护")
        ),
        answer = listOf("A"),
        explanation = "GNSS信号丢失后飞控无法获取绝对地理位置坐标，无法定点悬停，仅依靠IMU维持水平姿态稳定，故自动切入姿态模式（ATTI）。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-10",
        type = QuestionType.SINGLE,
        question = "计算无人机升力时，若翼面积S=0.5m²，空气密度ρ=1.225kg/m³，飞行速度v=20m/s，升力系数C_L=0.8，则升力L为（ ）。",
        options = listOf(
            QuizOption("A", "196N"),
            QuizOption("B", "392N"),
            QuizOption("C", "784N"),
            QuizOption("D", "1568N")
        ),
        answer = listOf("B"),
        explanation = "升力公式 L = 1/2 * ρ * v² * S * C_L = 0.5 * 1.225 * 400 * 0.5 * 0.8 = 392N。",
        topic = "飞行原理与气动力学",
        difficulty = 3
    ),

    // ========== 2025年无人机理论考试 (基础知识/法规/操作/维护/应用) ==========
    Question(
        id = "uav-2025-base-01",
        type = QuestionType.SINGLE,
        question = "以下哪种飞行器不属于无人机范畴？",
        options = listOf(
            QuizOption("A", "固定翼无人机"),
            QuizOption("B", "载人直升机"),
            QuizOption("C", "多旋翼无人机"),
            QuizOption("D", "无人飞艇")
        ),
        answer = listOf("B"),
        explanation = "无人机是无人驾驶飞行器的统称。载人直升机需要飞行员在机上驾驶，不属于无人机范畴。",
        topic = "无人机基础理论",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-base-02",
        type = QuestionType.SINGLE,
        question = "按用途分类，用于农业喷洒农药的无人机属于以下哪一类？",
        options = listOf(
            QuizOption("A", "消费级无人机"),
            QuizOption("B", "工业级无人机"),
            QuizOption("C", "军用无人机"),
            QuizOption("D", "航模无人机")
        ),
        answer = listOf("B"),
        explanation = "工业级无人机主要用于专业作业领域，如农业、测绘、物流、电力巡检等。",
        topic = "无人机基础理论",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-base-03",
        type = QuestionType.SINGLE,
        question = "无人机系统一般不包括以下哪个部分？",
        options = listOf(
            QuizOption("A", "飞行器平台"),
            QuizOption("B", "地面控制站"),
            QuizOption("C", "飞行员座舱"),
            QuizOption("D", "数据链路")
        ),
        answer = listOf("C"),
        explanation = "无人机是无人驾驶的，不需要飞行员座舱。主要由飞行器平台、地面控制站和数据链路系统构成。",
        topic = "无人机基础理论",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-base-04",
        type = QuestionType.SINGLE,
        question = "以下哪个部件不属于无人机飞行控制系统的组成部分？",
        options = listOf(
            QuizOption("A", "陀螺仪"),
            QuizOption("B", "加速度计"),
            QuizOption("C", "发动机"),
            QuizOption("D", "飞行控制器")
        ),
        answer = listOf("C"),
        explanation = "陀螺仪、加速度计、飞行控制器均属于飞控系统。发动机是动力系统的核心，不属于飞控系统本身。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-base-05",
        type = QuestionType.SINGLE,
        question = "无人机飞行时，机翼上表面的气流速度与下表面的气流速度相比：",
        options = listOf(
            QuizOption("A", "上表面气流速度快"),
            QuizOption("B", "下表面气流速度快"),
            QuizOption("C", "上下表面气流速度相同"),
            QuizOption("D", "不确定")
        ),
        answer = listOf("A"),
        explanation = "机翼上表面为凸弯弧度，气流流经路程更长且流速更快，静压变小；下表面流速慢、压强大，形成向上升力。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-base-06",
        type = QuestionType.SINGLE,
        question = "以下哪种因素会影响无人机的升力？",
        options = listOf(
            QuizOption("A", "飞行速度"),
            QuizOption("B", "空气密度"),
            QuizOption("C", "机翼面积"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "根据升力公式 L = 1/2 * ρ * V² * S * CL，空气密度ρ、飞行速度V、机翼面积S及升力系数CL均直接影响升力大小。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-law-01",
        type = QuestionType.SINGLE,
        question = "我国目前管理无人机的主要法规是？",
        options = listOf(
            QuizOption("A", "《中华人民共和国民用航空法》"),
            QuizOption("B", "《无人驾驶航空器飞行管理暂行条例》"),
            QuizOption("C", "《通用航空飞行管制条例》"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "我国无人机运行受《民用航空法》、《无人驾驶航空器飞行管理暂行条例》及《通用航空飞行管制条例》等多部法规协同规范。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-law-02",
        type = QuestionType.SINGLE,
        question = "根据相关法规，民用无人机所有者必须进行：",
        options = listOf(
            QuizOption("A", "实名登记"),
            QuizOption("B", "购买保险"),
            QuizOption("C", "参加培训"),
            QuizOption("D", "以上都不是")
        ),
        answer = listOf("A"),
        explanation = "根据我国法规，民用无人机所有者必须在民用无人驾驶航空器综合管理平台（UOM）完成实名登记，粘贴二维码后方可飞行。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-law-03",
        type = QuestionType.SINGLE,
        question = "以下哪个区域属于无人机禁飞区域？",
        options = listOf(
            QuizOption("A", "机场净空保护区"),
            QuizOption("B", "军事管理区"),
            QuizOption("C", "国家重点机构和敏感区域"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "机场净空区、军事管辖区、党政机关及国家重点敏感目标等均属于法定管制禁飞空域。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-law-04",
        type = QuestionType.SINGLE,
        question = "在城市市区飞行无人机，需要注意以下哪些事项？",
        options = listOf(
            QuizOption("A", "遵守当地的相关规定"),
            QuizOption("B", "避免在人群密集区域飞行"),
            QuizOption("C", "保持与建筑物和障碍物的安全距离"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "在城市区域作业须严格遵守属地管制报备规定，避开人员聚集区，并与建筑保持充足安全距离，防止干扰与碰撞。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-law-05",
        type = QuestionType.SINGLE,
        question = "在我国，操作轻型无人机在管制空域内飞行，需要具备：",
        options = listOf(
            QuizOption("A", "民用无人驾驶航空器操控员执照"),
            QuizOption("B", "不需要任何执照"),
            QuizOption("C", "仅需进行实名登记"),
            QuizOption("D", "以上都不对")
        ),
        answer = listOf("A"),
        explanation = "轻型无人机在管制空域内飞行必须取得民用无人驾驶航空器操控员执照（CAAC），在非管制适飞空域内非商业飞行仅需实名登记。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "uav-2025-law-06",
        type = QuestionType.SINGLE,
        question = "考取民用无人驾驶航空器操控员执照，一般需要经过以下哪些步骤？",
        options = listOf(
            QuizOption("A", "理论学习与考试"),
            QuizOption("B", "实践飞行训练与考核"),
            QuizOption("C", "体检与背景审查"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "考取执照需满足身体健康标准、无不良记录，通过地面理论考试与真机实操/综合问答飞行技能考核。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-op-01",
        type = QuestionType.SINGLE,
        question = "起飞前检查无人机，以下哪项检查内容是不必要的？",
        options = listOf(
            QuizOption("A", "检查电池电量"),
            QuizOption("B", "检查螺旋桨安装是否牢固"),
            QuizOption("C", "检查天气是否适合飞行"),
            QuizOption("D", "检查无人机的颜色")
        ),
        answer = listOf("D"),
        explanation = "电池电量、螺旋桨机械紧固与天气条件直接关乎飞行安全；机身涂装颜色与适航安全性无关。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-op-02",
        type = QuestionType.SINGLE,
        question = "在起飞前，需要对地面控制站进行以下哪些操作？",
        options = listOf(
            QuizOption("A", "开机并检查设备状态"),
            QuizOption("B", "连接无人机与地面控制站"),
            QuizOption("C", "加载飞行任务规划"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "起飞前地面站须完成设备自检、数传链路握手连接、航线与应急安全返航参数加载等全套准备。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-op-03",
        type = QuestionType.SINGLE,
        question = "在无人机飞行过程中，如果遇到强风，应该采取以下哪种措施？",
        options = listOf(
            QuizOption("A", "降低飞行高度"),
            QuizOption("B", "增加飞行速度"),
            QuizOption("C", "保持原飞行状态"),
            QuizOption("D", "立即降落")
        ),
        answer = listOf("A"),
        explanation = "高空由于地面粗糙度影响小风力普遍偏大，降低高度通常能减小风速影响，并能更安全地规划返航降落。",
        topic = "应急处置与飞行规范",
        difficulty = 2
    ),
    Question(
        id = "uav-2025-op-04",
        type = QuestionType.SINGLE,
        question = "在进行无人机转弯操作时，应该：",
        options = listOf(
            QuizOption("A", "缓慢平稳地操作遥控器"),
            QuizOption("B", "快速大幅度地操作遥控器"),
            QuizOption("C", "不操作遥控器，让无人机自动转弯"),
            QuizOption("D", "以上都不对")
        ),
        answer = listOf("A"),
        explanation = "平稳柔和推杆可避免过大角加速度导致姿态失控或桨叶气动剧烈波动，保证航向平稳过渡。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-op-05",
        type = QuestionType.SINGLE,
        question = "无人机降落时，以下哪种做法是正确的？",
        options = listOf(
            QuizOption("A", "提前选择好降落地点"),
            QuizOption("B", "降落过程中保持适当的下降速度"),
            QuizOption("C", "降落时确保无人机处于水平状态"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "降落必须选定无障碍开阔平整场地，匀速下沉，着地前保持姿态平稳水平，防止侧翻打桨。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-op-06",
        type = QuestionType.SINGLE,
        question = "如果无人机在降落过程中出现异常情况（如无法正常降落），应该：",
        options = listOf(
            QuizOption("A", "尝试手动控制降落"),
            QuizOption("B", "寻找安全的迫降地点"),
            QuizOption("C", "向相关部门报告情况"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "降落异常时首选手工接管调整，若无法安全返航则果断寻找安全平坦无人区迫降，事后依规上报记录。",
        topic = "应急处置与飞行规范",
        difficulty = 2
    ),
    Question(
        id = "uav-2025-maint-01",
        type = QuestionType.SINGLE,
        question = "无人机日常维护中，以下哪项是正确的清洁方法？",
        options = listOf(
            QuizOption("A", "使用湿布擦拭机身"),
            QuizOption("B", "使用高压水枪冲洗"),
            QuizOption("C", "使用酒精擦拭电子设备"),
            QuizOption("D", "以上都不对")
        ),
        answer = listOf("A"),
        explanation = "机身外观微湿布擦拭即可；高压水冲洗会渗水烧板，酒精擦拭敏感电子元件或镜头可能损坏涂层或防静电保护层。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-maint-02",
        type = QuestionType.SINGLE,
        question = "定期检查无人机的电池，以下哪项检查内容是错误的？",
        options = listOf(
            QuizOption("A", "检查电池外观是否有破损"),
            QuizOption("B", "检查电池电量是否充足"),
            QuizOption("C", "检查电池的生产日期"),
            QuizOption("D", "检查电池的充电次数")
        ),
        answer = listOf("C"),
        explanation = "判断锂电池健康度的核心是外观有无鼓包漏液、电芯压差、循环寿命次数及容量衰减，生产日期并不能直接代表当前电池真实电气性能状态。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-maint-03",
        type = QuestionType.SINGLE,
        question = "无人机飞行时出现抖动现象，可能的原因是：",
        options = listOf(
            QuizOption("A", "螺旋桨不平衡"),
            QuizOption("B", "飞行控制系统故障"),
            QuizOption("C", "电池电量不足"),
            QuizOption("D", "以上都可能")
        ),
        answer = listOf("D"),
        explanation = "螺旋桨动平衡失衡会导致强烈高频震动；飞控PID震荡或传感器异常会抖动机体；低电降频供电不稳也可能引发机体晃动。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "uav-2025-maint-04",
        type = QuestionType.SINGLE,
        question = "如果无人机无法起飞，首先应该检查：",
        options = listOf(
            QuizOption("A", "电池是否安装正确且电量充足"),
            QuizOption("B", "遥控器是否正常工作并已对频"),
            QuizOption("C", "飞行环境是否处于禁飞区或传感器自检受阻"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "起飞受阻通常为动力电源未接通、链路未连接对频、禁飞区固件锁死或IMU罗盘未就绪等多种原因综合造成。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-maint-05",
        type = QuestionType.SINGLE,
        question = "更换无人机的螺旋桨时，需要注意以下哪些事项？",
        options = listOf(
            QuizOption("A", "选择合适的螺旋桨型号"),
            QuizOption("B", "确保螺旋桨安装方向正确（正反桨对应）"),
            QuizOption("C", "拧紧螺旋桨螺母或确认卡扣锁死"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "桨型尺寸必须与电机推力匹配，正反桨（CW/CCW）方向必须对应安装，紧固件必须锁紧到位以防空中射桨。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-maint-06",
        type = QuestionType.SINGLE,
        question = "对无人机进行部件升级时，以下哪项是错误的做法？",
        options = listOf(
            QuizOption("A", "选择质量可靠的升级部件"),
            QuizOption("B", "自行随意更改无人机的电路系统"),
            QuizOption("C", "按照说明书进行升级操作"),
            QuizOption("D", "升级后进行试飞测试")
        ),
        answer = listOf("B"),
        explanation = "自行随意更改电路极易导致供电线束短路过载、起火甚至空中断电坠机，严禁私自违规改动动力电路。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-app-01",
        type = QuestionType.SINGLE,
        question = "农业无人机在农业生产中的主要作用不包括以下哪项？",
        options = listOf(
            QuizOption("A", "农药喷洒"),
            QuizOption("B", "种子播种"),
            QuizOption("C", "土壤改良"),
            QuizOption("D", "作物生长监测")
        ),
        answer = listOf("C"),
        explanation = "农业植保机可实施农药喷洒、水稻撒肥播种、多光谱作物长势巡查监测；深层土壤物理与化学改良非无人机直接功能。",
        topic = "应用领域与行业实操",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-app-02",
        type = QuestionType.SINGLE,
        question = "农业无人机进行农药喷洒时，需要考虑以下哪些因素？",
        options = listOf(
            QuizOption("A", "农药的类型和浓度"),
            QuizOption("B", "飞行高度和速度"),
            QuizOption("C", "天气条件（如温度、风速）"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "药液配比浓度、飞行离地作业高度、航速及外界风速温湿度均直接决定雾滴漂移沉降效果与药效防治率。",
        topic = "应用领域与行业实操",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-app-03",
        type = QuestionType.SINGLE,
        question = "测绘无人机可以获取以下哪些地理信息？",
        options = listOf(
            QuizOption("A", "地形地貌高程信息（DEM/DOM）"),
            QuizOption("B", "土地利用与植被覆盖情况"),
            QuizOption("C", "建筑物分布与三维实景模型"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "测绘航摄搭载航空相机与激光雷达，能快速生成数字正射影像、数字高程模型及高精度三维城市实景模型。",
        topic = "应用领域与行业实操",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-app-04",
        type = QuestionType.SINGLE,
        question = "使用测绘无人机进行测绘作业时，以下哪项是正确的操作流程？",
        options = listOf(
            QuizOption("A", "规划飞行路线 - 数据采集 - 数据处理 - 成果输出"),
            QuizOption("B", "数据采集 - 规划飞行路线 - 数据处理 - 成果输出"),
            QuizOption("C", "数据处理 - 规划飞行路线 - 数据采集 - 成果输出"),
            QuizOption("D", "以上都不对")
        ),
        answer = listOf("A"),
        explanation = "标准航空测绘工程作业流：前期测区航线航高规划 -> 外业航拍与地面相控点采集 -> 内业像控刺点空三解算与建模 -> 生成测绘图件成果。",
        topic = "应用领域与行业实操",
        difficulty = 2
    ),
    Question(
        id = "uav-2025-app-05",
        type = QuestionType.SINGLE,
        question = "物流无人机在配送过程中面临的主要挑战不包括以下哪项？",
        options = listOf(
            QuizOption("A", "续航能力有限"),
            QuizOption("B", "载重量较小"),
            QuizOption("C", "天气适应性强"),
            QuizOption("D", "法规限制与空域审批")
        ),
        answer = listOf("C"),
        explanation = "“天气适应性强”是理想优势而非挑战。目前物流无人机普遍面临恶劣天气适应能力不足、电池续航及有效商业载重有限的挑战。",
        topic = "应用领域与行业实操",
        difficulty = 1
    ),
    Question(
        id = "uav-2025-app-06",
        type = QuestionType.SINGLE,
        question = "为了提高物流无人机的配送效率，以下哪些措施是可行的？",
        options = listOf(
            QuizOption("A", "优化飞行路线规划与自动避障"),
            QuizOption("B", "提高电池能量密度与快速换电站建设"),
            QuizOption("C", "采用轻量化材料增加有效载重量"),
            QuizOption("D", "以上都是")
        ),
        answer = listOf("D"),
        explanation = "路线算法优化、自动化换电机巢建设以及高强度碳纤维轻量化机身提升载重比，均是提升物流配送周转效率的关键手段。",
        topic = "应用领域与行业实操",
        difficulty = 1
    )
)
