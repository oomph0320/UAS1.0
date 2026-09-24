package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val multiChoiceQuestions: List<Question> = listOf(
    // ========== CAAC无人机理论考试 (2026修订版) 多选题 1-5 ==========
    Question(
        id = "caac-2026-mc-01",
        type = QuestionType.MULTI,
        question = "以下属于无人机飞行前必须检查的项目有（ ）。",
        options = listOf(
            QuizOption("A", "遥控器与飞控的通信链路"),
            QuizOption("B", "电池剩余容量及循环次数"),
            QuizOption("C", "飞行区域的空域限制（如机场净空区）"),
            QuizOption("D", "飞控系统的固件版本及传感器状态")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "2026版《无人机操作规范》明确要求在每次飞行实施前，必须完成通信链路、动力能源、空域合规以及飞控传感器健康状态四项核心前置检查。",
        topic = "飞行操作与维护",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-mc-02",
        type = QuestionType.MULTI,
        question = "无人机在人口密集区飞行时，需遵守的规定包括（ ）。",
        options = listOf(
            QuizOption("A", "飞行高度不超过50米"),
            QuizOption("B", "与人群保持50米以上水平距离"),
            QuizOption("C", "禁止抛投任何物品"),
            QuizOption("D", "需额外申请特殊飞行许可")
        ),
        answer = listOf("B", "C", "D"),
        explanation = "人口密集区飞行高度法定限制通常为不超过30米（非50米）；必须保持水平50米以上防撞距离，严禁高空抛物，且必须报经特别批准。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-mc-03",
        type = QuestionType.MULTI,
        question = "影响无人机续航时间的因素有（ ）。",
        options = listOf(
            QuizOption("A", "电池能量密度"),
            QuizOption("B", "飞行速度"),
            QuizOption("C", "空气湿度"),
            QuizOption("D", "负载重量")
        ),
        answer = listOf("A", "B", "D"),
        explanation = "续航时间直接由电池可用能量、克服重力的载重消耗以及飞行风阻动力工况决定；常规空气湿度对放电与气动升力的直接影响极其有限。",
        topic = "动力与电池系统",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-mc-04",
        type = QuestionType.MULTI,
        question = "以下情况需立即终止飞行的有（ ）。",
        options = listOf(
            QuizOption("A", "遥控器信号强度持续低于-90dBm"),
            QuizOption("B", "飞控提示“指南针校准异常”"),
            QuizOption("C", "无人机出现不可控的横向漂移"),
            QuizOption("D", "地面站显示电池电压骤降")
        ),
        answer = listOf("A", "C", "D"),
        explanation = "信号濒临中断（＜-90dBm）、不可控姿态漂移以及电芯电压骤降随时可能导致空中断电或彻底失控，必须立即终止飞行返航降落。",
        topic = "应急处置与飞行规范",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-mc-05",
        type = QuestionType.MULTI,
        question = "中型无人机（25kg＜M≤150kg）运行需满足（ ）。",
        options = listOf(
            QuizOption("A", "驾驶员持有视距内驾驶员执照"),
            QuizOption("B", "在隔离空域内飞行"),
            QuizOption("C", "安装ADS-B OUT设备"),
            QuizOption("D", "制定地面防撞方案")
        ),
        answer = listOf("B", "C", "D"),
        explanation = "中型无人机动能大、风险高，操控员必须持有超视距（BVLOS）执照（视距内执照仅适用于轻型及以下）；须在隔离空域飞行并加装广播式自动相关监视设备。",
        topic = "法规与空域规则",
        difficulty = 3
    ),

    // ========== UOM无人机考试题库 多选题 ==========
    Question(
        id = "uom-2025-mc-01",
        type = QuestionType.MULTI,
        question = "操作UOM无人机前需要进行的准备工作有（ ）。",
        options = listOf(
            QuizOption("A", "检查飞机外观与结构紧固"),
            QuizOption("B", "校准电子罗盘与IMU传感器"),
            QuizOption("C", "正确安装螺旋桨并锁紧"),
            QuizOption("D", "检查遥控器功能与摇杆回中")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "机身外观、传感器校准、机械桨叶紧固及遥控器摇杆行程校准是缺一不可的航前检查流程。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-02",
        type = QuestionType.MULTI,
        question = "影响UOM无人机飞行安全的因素有（ ）。",
        options = listOf(
            QuizOption("A", "天气状况（风速、雨雾、气温）"),
            QuizOption("B", "强电磁干扰环境（高压铁塔、发射塔）"),
            QuizOption("C", "电池电芯性能与健康度"),
            QuizOption("D", "操作人员技术水平与心理素质")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "飞行安全受气象环境、无线电磁环境、飞行器自身硬件以及飞手操控决断能力四大维度共同影响。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-03",
        type = QuestionType.MULTI,
        question = "UOM无人机飞行过程中可能出现的故障有（ ）。",
        options = listOf(
            QuizOption("A", "电机或电调烧毁停转"),
            QuizOption("B", "飞控传感器死机或逻辑异常"),
            QuizOption("C", "控制信号或图传链路中断"),
            QuizOption("D", "螺旋桨空中破裂损坏")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "动力电机、电调、飞控算法、数传通信和机械构件均存在发生偶发故障的潜在风险，需预设应急预案。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-04",
        type = QuestionType.MULTI,
        question = "以下属于UOM无人机典型行业应用场景的是（ ）。",
        options = listOf(
            QuizOption("A", "影视与地理航拍"),
            QuizOption("B", "农田农业植保喷洒"),
            QuizOption("C", "应急与末端物流配送"),
            QuizOption("D", "高压输电线路电力巡检")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "无人机在航拍摄影、农林植保、物流运输、电网巡检、森林防火等国民经济领域均有深度应用。",
        topic = "应用领域与行业实操",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-05",
        type = QuestionType.MULTI,
        question = "UOM无人机的电池使用注意事项包括（ ）。",
        options = listOf(
            QuizOption("A", "避免电芯过充与过度放电"),
            QuizOption("B", "定期做充放电循环保养"),
            QuizOption("C", "满电状态常年高温长期存放"),
            QuizOption("D", "不同型号、不同容量电池严禁混用")
        ),
        answer = listOf("A", "B", "D"),
        explanation = "满电（4.2V）长期存放会加速锂电池内部产气鼓包与化学衰减，长期存放应保持在3.85V存储电压。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-06",
        type = QuestionType.MULTI,
        question = "操作UOM无人机时，需要注意的合规与安全事项有（ ）。",
        options = listOf(
            QuizOption("A", "遵守空域管制及民用航空法律法规"),
            QuizOption("B", "远离人群密集场所与敏感区域"),
            QuizOption("C", "时刻关注起降场与航路飞行环境"),
            QuizOption("D", "在规定范围内保持视距内飞行")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "合规飞行不仅要遵纪守法，更要时刻警惕对第三者人身财产的安全威胁。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-07",
        type = QuestionType.MULTI,
        question = "当UOM无人机出现异常高频剧烈震动时，可能的原因有（ ）。",
        options = listOf(
            QuizOption("A", "螺旋桨缺损或动平衡严重失衡"),
            QuizOption("B", "电机轴承磨损旷量过大或电机弯曲"),
            QuizOption("C", "机身支臂螺丝松动或机架出现裂纹"),
            QuizOption("D", "飞行速度过快（无机械原因）")
        ),
        answer = listOf("A", "B", "C"),
        explanation = "高频抖动大多由机械旋转件动不平衡、轴承旷动或结构刚性连接松动引起，通常与平飞航速本身无必然关联。",
        topic = "飞行操作与维护",
        difficulty = 2
    ),
    Question(
        id = "uom-2025-mc-08",
        type = QuestionType.MULTI,
        question = "UOM无人机的常见飞行控制模式一般包括（ ）。",
        options = listOf(
            QuizOption("A", "手动/姿态模式（Attitude Mode）"),
            QuizOption("B", "自主航线规划模式（Auto/Waypoint Mode）"),
            QuizOption("C", "智能自动返航模式（RTH Mode）"),
            QuizOption("D", "GPS定位增稳悬停模式（GPS/Position Mode）")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "飞控提供定位悬停、航线自主巡航、自动返航保护及无GPS介入的纯姿态操控等多种模式。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-09",
        type = QuestionType.MULTI,
        question = "为保证UOM无人机长期飞行稳定与机械寿命，需要（ ）。",
        options = listOf(
            QuizOption("A", "定期校准电子罗盘、IMU与云台传感器"),
            QuizOption("B", "保持机身、散热口与电机内部清洁无异物"),
            QuizOption("C", "及时更换有微小磕碰磨损的螺旋桨部件"),
            QuizOption("D", "选择开阔平整、避开强磁干扰的合规起降场地")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "良好的设备维保、传感器定期标定与开阔场地起降是杜绝飞行故障的根本保证。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-mc-10",
        type = QuestionType.MULTI,
        question = "UOM无人机在以下哪些区域飞行会受到严格管制或法定禁飞（ ）。",
        options = listOf(
            QuizOption("A", "民用运输机场净空保护区及跑道延长线"),
            QuizOption("B", "军事管辖区与国防阵地设施周边"),
            QuizOption("C", "国家重点党政机关与要害敏感部门"),
            QuizOption("D", "大型集会与人员高度密集公共场所")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "民用无人机严禁在机场净空区、涉密敏感机构、军事管理区以及未申报的人员密集集会场所上空擅自飞行。",
        topic = "法规与空域规则",
        difficulty = 1
    ),

    // ========== CAAC理论考试题库 多选题 (全量) ==========
    Question(
        id = "caac-2025-mc-01",
        type = QuestionType.MULTI,
        question = "无人机法规中“轻型无人机”的法定定义与属性包含：",
        options = listOf(
            QuizOption("A", "空机重量＞4千克但≤25千克且最大起飞重量≤25千克"),
            QuizOption("B", "最大起飞重量≤4千克"),
            QuizOption("C", "从事商业作业飞行需取得相应操控员执照"),
            QuizOption("D", "无需进行实名登记")
        ),
        answer = listOf("A", "C"),
        explanation = "轻型无人机空机重量＞4kg且最大起飞重量≤25kg，商业飞行必须取得CAAC执照，且必须依法实名登记。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-mc-02",
        type = QuestionType.MULTI,
        question = "气象恶劣条件对无人机安全运行的主要负面危害包括：",
        options = listOf(
            QuizOption("A", "低能见度极大限制目视视距与环境感知"),
            QuizOption("B", "强阵风严重影响姿态稳定并加剧电池消耗"),
            QuizOption("C", "极端低温导致电池可用化学容量锐减及电压跳水"),
            QuizOption("D", "晴朗天气提升太阳能板充电转化效率")
        ),
        answer = listOf("A", "B", "C"),
        explanation = "浓雾视距差、大风消耗功率大、低温放电性能骤减是典型的气象危害，常规作业机不使用太阳能发电。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-03",
        type = QuestionType.MULTI,
        question = "无人机发生空中紧急故障时的应急处置核心原则包括：",
        options = listOf(
            QuizOption("A", "地面人身安全高于一切，优先避免人员伤亡"),
            QuizOption("B", "在确保地面安全前提下尽量保护设备完整"),
            QuizOption("C", "沉着冷静，严格按应急检查单标准动作操作"),
            QuizOption("D", "任何小故障均应立即切断油门任其坠落")
        ),
        answer = listOf("A", "B", "C"),
        explanation = "航空应急黄金法则：生命安全第一、科学处置、保持冷静，切断油门任其乱坠会极大加剧地面砸人风险。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-04",
        type = QuestionType.MULTI,
        question = "进入管制空域实施无人机飞行，提出计划申请通常需报备的材料包括：",
        options = listOf(
            QuizOption("A", "无人机机型、序列号及UOM实名登记信息"),
            QuizOption("B", "明确的飞行计划（起止时间、真高上限、作业空域范围）"),
            QuizOption("C", "操控员合法有效的执照信息"),
            QuizOption("D", "飞行作业任务性质与安全防范方案说明")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "向空管部门申请管制空域航线必须具备合法的飞机资质、人员执照、精确时空航路及应急防撞处置预案。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-mc-05",
        type = QuestionType.MULTI,
        question = "多旋翼无人机飞控基础四通道自由度控制包括：",
        options = listOf(
            QuizOption("A", "油门控制（Throttle，控制垂直升降高度）"),
            QuizOption("B", "俯仰控制（Pitch，控制机体前后倾斜与位移）"),
            QuizOption("C", "横滚控制（Roll，控制机体左右横移）"),
            QuizOption("D", "航向控制（Yaw，控制机头原地旋转自旋）")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "四通道：油门（上升/下降）、俯仰（前进/后退）、横滚（向左/向右倾斜）、航向（左转/右转偏航）。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-06",
        type = QuestionType.MULTI,
        question = "下列哪些区域属于法律明确禁止或严格管制的禁飞区域：",
        options = listOf(
            QuizOption("A", "国家机关办公要害区域及驻军军事管理区"),
            QuizOption("B", "正在举行重大群体性活动的露天现场"),
            QuizOption("C", "核设施、大型水电大坝及易燃易爆危化品库区"),
            QuizOption("D", "远离市区且无管制的开阔平原田野")
        ),
        answer = listOf("A", "B", "C"),
        explanation = "军事要害、国家机关、能源枢纽及人员密集活动区依法属于管制或临时管控禁飞区域。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-07",
        type = QuestionType.MULTI,
        question = "动力锂电池日常储存与使用安全规范包括：",
        options = listOf(
            QuizOption("A", "严禁电芯过充（＞4.25V）或过放（＜2.75V）"),
            QuizOption("B", "长期闲置时保持在50%~60%（约3.85V）存储电压"),
            QuizOption("C", "在烈日暴晒的高温环境中大电流快速充电"),
            QuizOption("D", "定期排查电池外观有无磕碰凹陷、鼓包破皮与漏液")
        ),
        answer = listOf("A", "B", "D"),
        explanation = "高温暴晒下大电流快充极易引发热失控爆炸起火，属于严重违规危险操作。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-08",
        type = QuestionType.MULTI,
        question = "飞手在飞行作业过程中，地面站与遥控器界面上需持续严密监控的核心遥测参数有：",
        options = listOf(
            QuizOption("A", "动力电池剩余电量、单体最低电压及放电电流"),
            QuizOption("B", "飞行绝对真高、相对起飞点高度及水平地速/垂直速度"),
            QuizOption("C", "遥控上行信号与图传下行信号的RSSI强度及丢包率"),
            QuizOption("D", "返航点（Home点）有效性及避障传感器报警状态")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "动力健康、飞行航迹高度、通信质量与空间障碍告警是保障视距与超视距作业安全的核心遥测指标。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-mc-09",
        type = QuestionType.MULTI,
        question = "实施超视距（BVLOS）飞行任务相较于视距内飞行，需额外具备的条件包括：",
        options = listOf(
            QuizOption("A", "操作人员持有民航CAAC超视距操控员执照"),
            QuizOption("B", "具备超视距双向冗余通信链路及遥测地面站"),
            QuizOption("C", "具备实时高清图传感知与可靠的避障防撞系统"),
            QuizOption("D", "无需理会空域审批与隔离要求可自由穿越")
        ),
        answer = listOf("A", "B", "C"),
        explanation = "超视距飞行风险高，必须由持证人员驾驶具备完备通信监控机制的无人机，并严格接受空域管理与审批。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-mc-10",
        type = QuestionType.MULTI,
        question = "无人机飞控系统核心惯性测量单元（IMU）通常集成的元器件包括：",
        options = listOf(
            QuizOption("A", "三轴加速度计（测量三轴线性加速度）"),
            QuizOption("B", "三轴陀螺仪（测量三轴角速度）"),
            QuizOption("C", "磁力计/地磁罗盘（测量地磁航向方位）"),
            QuizOption("D", "高精度数字气压计（测量环境气压解算高度）")
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "现代高集成飞控系统内部普遍整合了加速度计、陀螺仪、地磁计与气压计以实现高可靠性姿态融合滤波算法。",
        topic = "飞行原理与飞控",
        difficulty = 2
    )
)
