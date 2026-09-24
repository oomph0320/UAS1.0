package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val singleChoiceQuestionsPart2: List<Question> = listOf(
    // ========== 2025年新版UOM无人机考试 单选题 (10题) ==========
    Question(
        id = "uom-2025-sc-01",
        type = QuestionType.SINGLE,
        question = "UOM无人机在起飞前，电量显示必须达到（ ）。",
        options = listOf(
            QuizOption("A", "30%"),
            QuizOption("B", "50%"),
            QuizOption("C", "70%"),
            QuizOption("D", "90%")
        ),
        answer = listOf("C"),
        explanation = "为确保起飞后具备充足的动力冗余与应对逆风返航储备，起飞前电池电量通常要求达到70%以上。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-02",
        type = QuestionType.SINGLE,
        question = "当UOM无人机飞行过程中遇到强风，应（ ）。",
        options = listOf(
            QuizOption("A", "加速飞行"),
            QuizOption("B", "原地悬停"),
            QuizOption("C", "尽快降落"),
            QuizOption("D", "升高飞行高度")
        ),
        answer = listOf("C"),
        explanation = "遇到超出抗风能力的强风时，飞机姿态容易失控且电量消耗急剧增加，应逆风压低高度并尽快寻找安全区域降落。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-03",
        type = QuestionType.SINGLE,
        question = "UOM无人机的GPS信号丢失时，会（ ）。",
        options = listOf(
            QuizOption("A", "自动返航"),
            QuizOption("B", "继续按原航线飞行"),
            QuizOption("C", "随机漂移"),
            QuizOption("D", "悬停")
        ),
        answer = listOf("A"),
        explanation = "多数现代作业机型在GPS信号瞬时失效或持续丢失时，飞控安全机制会触发进入保护逻辑（依赖航位推算返航或切换姿态模式后提示返航降落）。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "uom-2025-sc-04",
        type = QuestionType.SINGLE,
        question = "操作UOM无人机时，遥控器信号指示灯闪烁代表（ ）。",
        options = listOf(
            QuizOption("A", "电量低"),
            QuizOption("B", "信号不稳定"),
            QuizOption("C", "正常工作"),
            QuizOption("D", "设备故障")
        ),
        answer = listOf("B"),
        explanation = "遥控器信号灯闪烁通常指示当前控制链路信号衰减或处于不稳定边缘，需注意天线朝向或缩短距离。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-05",
        type = QuestionType.SINGLE,
        question = "UOM无人机的桨叶损坏时，（ ）。",
        options = listOf(
            QuizOption("A", "可以继续飞行"),
            QuizOption("B", "需更换桨叶后再飞行"),
            QuizOption("C", "降低飞行高度继续飞"),
            QuizOption("D", "忽略继续操作")
        ),
        answer = listOf("B"),
        explanation = "桨叶损伤会导致严重动平衡失衡、气动效率骤降并可能在空中解体撕裂，严禁带伤飞行，必须更换新桨。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-06",
        type = QuestionType.SINGLE,
        question = "以下哪种天气不适合UOM无人机飞行（ ）。",
        options = listOf(
            QuizOption("A", "晴天"),
            QuizOption("B", "小雨"),
            QuizOption("C", "大雾"),
            QuizOption("D", "微风")
        ),
        answer = listOf("C"),
        explanation = "大雾不仅严重遮挡目视视距与避障视觉传感器，高湿度冷凝水还会进入电机与电路板引起短路故障。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-07",
        type = QuestionType.SINGLE,
        question = "UOM无人机在飞行中电量突然下降很快，应（ ）。",
        options = listOf(
            QuizOption("A", "增加动力"),
            QuizOption("B", "立即降落"),
            QuizOption("C", "调整飞行姿态"),
            QuizOption("D", "继续观察")
        ),
        answer = listOf("B"),
        explanation = "电量突然跳水通常说明电芯老化出现虚电或存在动力系统短路漏电，必须立即就近迫降以防空中断电坠毁。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-08",
        type = QuestionType.SINGLE,
        question = "启动UOM无人机前，不需要检查的是（ ）。",
        options = listOf(
            QuizOption("A", "桨叶安装"),
            QuizOption("B", "电池电量"),
            QuizOption("C", "遥控器电池"),
            QuizOption("D", "周围人群性别")
        ),
        answer = listOf("D"),
        explanation = "起飞前需确认周围人员撤离至安全距离以外，人员性别与飞行安全毫无关联。",
        topic = "飞行操作与维护",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-09",
        type = QuestionType.SINGLE,
        question = "UOM无人机飞行高度限制一般是（ ）。",
        options = listOf(
            QuizOption("A", "50米"),
            QuizOption("B", "100米"),
            QuizOption("C", "120米"),
            QuizOption("D", "200米")
        ),
        answer = listOf("C"),
        explanation = "我国适飞空域常规飞行真高上限标准为120米（400英尺），超过120米需提前申请空域审批。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "uom-2025-sc-10",
        type = QuestionType.SINGLE,
        question = "当UOM无人机出现失控状态，应（ ）。",
        options = listOf(
            QuizOption("A", "关闭遥控器"),
            QuizOption("B", "等待其自动降落"),
            QuizOption("C", "尝试重新连接遥控器并控制"),
            QuizOption("D", "远离现场")
        ),
        answer = listOf("C"),
        explanation = "飞手应调整遥控器天线方位、靠近障碍物盲区边缘，尝试快速重新取得控制链路以安全接管或触发返航。",
        topic = "应急处置与飞行规范",
        difficulty = 1
    ),

    // ========== CAAC无人机理论考试题库2025年 单选题 (部分精选与全量对应) ==========
    Question(
        id = "caac-2025-sc-01",
        type = QuestionType.SINGLE,
        question = "根据CAAC最新规定，民用无人机实名登记的起始重量为：",
        options = listOf(
            QuizOption("A", "150克"),
            QuizOption("B", "200克"),
            QuizOption("C", "250克"),
            QuizOption("D", "300克")
        ),
        answer = listOf("C"),
        explanation = "民用无人驾驶航空器最大起飞重量超过250克（含250克）的，所有者均必须通过民航实名登记系统完成实名登记。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-sc-02",
        type = QuestionType.SINGLE,
        question = "多旋翼无人机的升力主要来源于：",
        options = listOf(
            QuizOption("A", "机翼与空气的相对运动"),
            QuizOption("B", "螺旋桨旋转产生的拉力"),
            QuizOption("C", "尾翼的平衡作用"),
            QuizOption("D", "电池提供的动力输出")
        ),
        answer = listOf("B"),
        explanation = "多旋翼无人机没有固定机翼，完全依靠电机驱动多组螺旋桨高速旋转产生向下的下洗气流反作用拉力（升力）。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-sc-03",
        type = QuestionType.SINGLE,
        question = "视距内驾驶员执照允许操作无人机的最大视距范围（水平距离）为：",
        options = listOf(
            QuizOption("A", "300米"),
            QuizOption("B", "500米"),
            QuizOption("C", "800米"),
            QuizOption("D", "1000米")
        ),
        answer = listOf("B"),
        explanation = "视距内（VLOS）操作半径通常限制在操作员肉眼可视的500米半径以内，且高度不超过120米。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-sc-04",
        type = QuestionType.SINGLE,
        question = "无人机飞行中，若遇到动力系统失效，优先采取的措施是：",
        options = listOf(
            QuizOption("A", "尝试重启动力"),
            QuizOption("B", "立即切换手动模式"),
            QuizOption("C", "选择开阔场地迫降"),
            QuizOption("D", "加速冲向目标点")
        ),
        answer = listOf("C"),
        explanation = "动力失效不可逆时，最优先准则是避开人群密集区与公路建筑，果断寻找空旷开阔无人区实施应急迫降减损。",
        topic = "应急处置与飞行规范",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-sc-05",
        type = QuestionType.SINGLE,
        question = "真高120米以下的管制空域内，微型无人机（空机重量≤4千克）执行非商业飞行时，是否需要提交飞行计划？",
        options = listOf(
            QuizOption("A", "不需要，自由飞行"),
            QuizOption("B", "需要提前2小时提交"),
            QuizOption("C", "需要提前12小时提交"),
            QuizOption("D", "需要提前72小时提交")
        ),
        answer = listOf("B"),
        explanation = "管制空域内微型机非商业运行若涉及管制区通行，通常需提前2小时报备空管部门确认放行。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-sc-06",
        type = QuestionType.SINGLE,
        question = "无人机失速的根本原因是：",
        options = listOf(
            QuizOption("A", "飞行速度过低"),
            QuizOption("B", "迎角超过临界值"),
            QuizOption("C", "螺旋桨损坏"),
            QuizOption("D", "电池电量不足")
        ),
        answer = listOf("B"),
        explanation = "失速的物理本质是气流迎角超过临界最大升力迎角，导致上表面产生强烈的涡流分离区破坏升力，速度过低也是迎角被迫增大导致的间接因素。",
        topic = "飞行原理与气动力学",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-sc-07",
        type = QuestionType.SINGLE,
        question = "以下哪种气象条件最适合无人机飞行？",
        options = listOf(
            QuizOption("A", "风速5m/s，无降水"),
            QuizOption("B", "风速12m/s，晴"),
            QuizOption("C", "雷暴云覆盖区域"),
            QuizOption("D", "能见度1公里的雾天")
        ),
        answer = listOf("A"),
        explanation = "风速5m/s（3级微风）处于绝大部分无人机最佳控制区间，且无降水利于电路安全与视距保持。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-sc-08",
        type = QuestionType.SINGLE,
        question = "无人机飞行前，飞控系统校准的主要目的是：",
        options = listOf(
            QuizOption("A", "提升图传清晰度"),
            QuizOption("B", "确保传感器数据准确"),
            QuizOption("C", "延长电池续航"),
            QuizOption("D", "增强遥控信号强度")
        ),
        answer = listOf("B"),
        explanation = "校准IMU、指南针和地磁计是为了消除零偏漂移与磁异常，确保飞控解算的俯仰、滚转和航向姿态角真实可信。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "caac-2025-sc-09",
        type = QuestionType.SINGLE,
        question = "根据《无人驾驶航空器飞行管理暂行条例》，在机场净空保护区域内，无人机飞行高度不得超过真高：",
        options = listOf(
            QuizOption("A", "50米"),
            QuizOption("B", "100米"),
            QuizOption("C", "150米"),
            QuizOption("D", "200米")
        ),
        answer = listOf("A"),
        explanation = "机场净空区属高等级严格保护区，非批准情况下微型机即便取得极特殊许可也严格限制在50米真高以下。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2025-sc-10",
        type = QuestionType.SINGLE,
        question = "多旋翼无人机重心偏移过大会导致：",
        options = listOf(
            QuizOption("A", "飞行速度提升"),
            QuizOption("B", "悬停稳定性下降"),
            QuizOption("C", "抗风能力增强"),
            QuizOption("D", "电池消耗减少")
        ),
        answer = listOf("B"),
        explanation = "重心偏移会导致各轴电机动力输出分配严重不均，偏重一侧电机过载发热，飞控PID补偿吃力，悬停易漂移晃动。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),

    // ========== CAAC理论考试题库 (2026修订版扩展) ==========
    Question(
        id = "caac-2026-sc-ex-01",
        type = QuestionType.SINGLE,
        question = "根据CAAC《民用无人机驾驶员管理规定》（2026修订版），微型无人机的最大起飞重量（MTOM）限制为：",
        options = listOf(
            QuizOption("A", "0.25kg"),
            QuizOption("B", "1.5kg"),
            QuizOption("C", "2kg"),
            QuizOption("D", "4kg")
        ),
        answer = listOf("B"),
        explanation = "根据2026最新规定划分，空机重量及最大起飞重量不超过1.5kg（且具有相应安全防护）的划分为微型无人驾驶航空器。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-ex-02",
        type = QuestionType.SINGLE,
        question = "四旋翼无人机的“桨序”（从机头方向顺时针编号）通常为：",
        options = listOf(
            QuizOption("A", "1正桨、2反桨、3正桨、4反桨"),
            QuizOption("B", "1反桨、2正桨、3反桨、4正桨"),
            QuizOption("C", "1正桨、2正桨、3反桨、4反桨"),
            QuizOption("D", "1反桨、2反桨、3正桨、4正桨")
        ),
        answer = listOf("A"),
        explanation = "四旋翼相邻桨旋转方向相反以相互抵消反扭矩，对角线上的电机旋转方向相同。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-ex-03",
        type = QuestionType.SINGLE,
        question = "无人机气压高度表的基准面为：",
        options = listOf(
            QuizOption("A", "平均海平面（QNH）"),
            QuizOption("B", "机场标高（QFE）"),
            QuizOption("C", "起飞点高度（QNE）"),
            QuizOption("D", "任意参考点")
        ),
        answer = listOf("A"),
        explanation = "标准气压高度表常以标准海平面修正海平面气压（QNH）作为基准参考面解算海拔高度。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-ex-04",
        type = QuestionType.SINGLE,
        question = "我国无人机禁飞区不包括以下哪类区域：",
        options = listOf(
            QuizOption("A", "核电站周边5公里"),
            QuizOption("B", "军事管理区"),
            QuizOption("C", "大型体育赛事场馆（非活动期间）"),
            QuizOption("D", "机场跑道中心线两侧10公里")
        ),
        answer = listOf("C"),
        explanation = "大型体育场馆通常在举办重大赛事活动期间划设临时禁飞空域，非活动期间不作为常设禁飞区。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-ex-05",
        type = QuestionType.SINGLE,
        question = "多旋翼无人机悬停时，若出现机头持续向左偏转（逆时针自旋），最可能的故障是：",
        options = listOf(
            QuizOption("A", "1号电机转速过高"),
            QuizOption("B", "2号电机转速过低"),
            QuizOption("C", "3号电机转速过高"),
            QuizOption("D", "4号电机转速过低")
        ),
        answer = listOf("D"),
        explanation = "多旋翼偏航是由正反桨转速差产生的反扭矩失衡控制的，顺时针旋转桨转速不足会导致剩余反扭矩驱使机身向左反向自旋。",
        topic = "飞行原理与飞控",
        difficulty = 3
    ),
    Question(
        id = "caac-2026-sc-ex-06",
        type = QuestionType.SINGLE,
        question = "无人机电池（锂聚合物电池）单节电芯的安全电压工作区间通常是：",
        options = listOf(
            QuizOption("A", "2.75V - 4.2V / 单节"),
            QuizOption("B", "3.0V - 4.0V / 单节"),
            QuizOption("C", "3.5V - 4.5V / 单节"),
            QuizOption("D", "2.5V - 4.5V / 单节")
        ),
        answer = listOf("A"),
        explanation = "常规LiPo锂电池满电截止电压为4.20V，放电极限保护电压为2.75V~3.0V，低于2.75V会产生永久化学损伤。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-ex-07",
        type = QuestionType.SINGLE,
        question = "根据《无人驾驶航空器飞行管理暂行条例》，未实名登记的无人机起飞，可能面临最高罚款：",
        options = listOf(
            QuizOption("A", "200元"),
            QuizOption("B", "1000元"),
            QuizOption("C", "5000元"),
            QuizOption("D", "10000元")
        ),
        answer = listOf("C"),
        explanation = "民用无人机未依法进行实名登记擅自飞行的，公安或民用航空管理机关可处以责令改正并处最高5000元以下罚款。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-ex-08",
        type = QuestionType.SINGLE,
        question = "若无人机电池放电倍率为20C，电池容量为5000mAh，则其最大允许持续放电电流为：",
        options = listOf(
            QuizOption("A", "50A"),
            QuizOption("B", "100A"),
            QuizOption("C", "150A"),
            QuizOption("D", "200A")
        ),
        answer = listOf("B"),
        explanation = "最大放电电流 = 容量(Ah) * C倍率 = 5Ah * 20 = 100A。",
        topic = "动力与电池系统",
        difficulty = 2
    ),
    Question(
        id = "caac-2026-sc-ex-09",
        type = QuestionType.SINGLE,
        question = "多旋翼无人机的“横滚（Roll）”运动由哪两个电机的转速差实现控制：",
        options = listOf(
            QuizOption("A", "前后电机"),
            QuizOption("B", "左右电机"),
            QuizOption("C", "对角电机"),
            QuizOption("D", "所有电机")
        ),
        answer = listOf("B"),
        explanation = "横滚动作（左右倾斜）通过改变左右两侧电机的转速与拉力差异产生横滚力矩实现。",
        topic = "飞行原理与飞控",
        difficulty = 1
    ),
    Question(
        id = "caac-2026-sc-ex-10",
        type = QuestionType.SINGLE,
        question = "无人机飞行高度（真高，Absolute Altitude / AGL）的定义是：",
        options = listOf(
            QuizOption("A", "相对于平均海平面的高度"),
            QuizOption("B", "相对于起飞点或正下方地表的垂直距离"),
            QuizOption("C", "相对于机载GPS天线的虚拟高度"),
            QuizOption("D", "相对于标准气压面的高度")
        ),
        answer = listOf("B"),
        explanation = "真高（AGL）是指航空器至其正下方真实地表或起飞参考基准点的实际垂直空间距离。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    )
)
