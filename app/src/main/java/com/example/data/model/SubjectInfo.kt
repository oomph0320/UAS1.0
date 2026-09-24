package com.example.data.model

data class SubjectInfo(
    val id: String,
    val title: String,
    val subtitle: String,
    val isPrimary: Boolean = false,
    val categoryBadge: String,
    val tags: List<String>,
    val description: String,
    val keyTopics: List<String>
)

object SubjectCatalog {
    val PRIMARY_SUBJECT = SubjectInfo(
        id = "uav_foundation",
        title = "无人机技术基础",
        subtitle = "执照考证真题 · 飞行原理 · 规章标准 · 全题型",
        isPrimary = true,
        categoryBadge = "核心题库 · 已收录全量真题",
        tags = listOf("CAAC/UOM真题", "单选/多选/判断", "填空/简答", "模拟考试"),
        description = "收录民航局与无人机理论考试全部真题题库，涵盖单选题、多选题、判断题、填空题与简答分析题，支持背题模式、真机模拟考与错题复盘。",
        keyTopics = listOf(
            "民用无人驾驶航空器运行管理暂行条例与空域划设",
            "空气动力学原理、升力公式与失速机理",
            "多旋翼/固定翼动力电池与电机控制原理",
            "飞行气象评估、积雨云与风切变危害应对",
            "应急处置、IMU姿态模式与三级失控保护逻辑"
        )
    )

    val EXTENSION_SUBJECTS = listOf(
        SubjectInfo(
            id = "counter_uas_tech",
            title = "低空小型无人飞行器探测反制技术及应用",
            subtitle = "低空空防 · 黑飞预警 · 综合反制体系",
            isPrimary = false,
            categoryBadge = "拓展科目 · 题库拓展口已开放",
            tags = listOf("低空防御", "多源融合", "要地防护", "处置预案"),
            description = "聚焦“低慢小”无人机目标的防御预警与综合打击处置体系，覆盖城市低空、重要设施与重大活动的立体防空实战应用。",
            keyTopics = listOf(
                "低慢小无人飞行器目标雷达/无线电/光电融合侦测",
                "无人机威胁等级判定与非授权黑飞取证",
                "定向射频压制与通信链路强行阻断",
                "导航诱骗驱离与网捕/激光硬毁伤处置",
                "低空防御反制系统布设与军地民协同指挥"
            )
        ),
        SubjectInfo(
            id = "radar_detection",
            title = "雷达探测技术",
            subtitle = "微动特征 · 毫米波与相控阵 · 杂波抑制",
            isPrimary = false,
            categoryBadge = "拓展科目 · 题库拓展口已开放",
            tags = listOf("主动探测", "微多普勒", "相控阵雷达", "动目标检测"),
            description = "深入剖析针对微小型无人机超低雷达散射截面积（RCS）的主动探测雷达机制，重点突破微多普勒旋翼特征提取与复杂地面杂波过滤难题。",
            keyTopics = listOf(
                "超低RCS目标雷达回波与探测威力方程",
                "多旋翼叶片高速旋转微多普勒频率特征分析",
                "Ku/X波段有源相控阵(AESA)三维低空空情监视",
                "城市低空强地面杂波过滤与MTI/MTD检测算法",
                "微弱动目标航迹起始与多目标连续稳定跟踪"
            )
        ),
        SubjectInfo(
            id = "radio_detection",
            title = "无线电探测技术",
            subtitle = "频谱侦测 · TDoA/AoA测向 · 协议解析",
            isPrimary = false,
            categoryBadge = "拓展科目 · 题库拓展口已开放",
            tags = listOf("被动侦测", "无线电测向", "指纹识别", "协议解析"),
            description = "基于无人机遥控、图传与数传无线电信号的被动截获、测向定位与协议分析，实现零电磁污染下的超远距离提前预警与飞手精准定位。",
            keyTopics = listOf(
                "无人机全频段射频频谱特征监测与指纹库比对",
                "到达角(AoA)与时差定位(TDoA)高精度测向原理",
                "无人机跳频/扩频图传与遥控信号特征截获",
                "OcuSync/Lightbridge等主流图传协议深度反演",
                "微弱射频信号特征提取与飞手物理经纬度反算"
            )
        ),
        SubjectInfo(
            id = "optoelectronic_detection",
            title = "光电探测原理",
            subtitle = "红外热成像 · 可见光智能跟踪 · 激光测距",
            isPrimary = false,
            categoryBadge = "拓展科目 · 题库拓展口已开放",
            tags = listOf("光学成像", "红外夜视", "AI视觉识别", "光电转台"),
            description = "研究利用中长波红外热成像、高倍连续变焦可见光与高精度激光测距传感器，对低空无人机目标实施昼夜全天候目标确认、连续跟踪与取证记录。",
            keyTopics = listOf(
                "无人机电机、电调与机体摩擦红外热辐射特征",
                "超长焦光学系统设计与大气湍流自适应校正",
                "基于深度学习的无人机目标检测与闭环连续跟踪",
                "复杂背景（云层、鸟类、建筑物）虚警智能剔除",
                "高稳定双轴/四轴光电伺服转台联动引导控制"
            )
        ),
        SubjectInfo(
            id = "electromagnetic_jamming",
            title = "电磁干扰技术",
            subtitle = "压制式干扰 · 定向电子枪 · 卫星导航诱骗",
            isPrimary = false,
            categoryBadge = "拓展科目 · 题库拓展口已开放",
            tags = listOf("电子对抗", "射频压制", "GNSS欺骗", "干扰链路"),
            description = "研讨对无人机通信链路、图传信道及卫星导航授时系统的电磁阻断与信号欺骗技术，涵盖宽带阻塞式干扰、瞄准式干扰及数字导航诱骗策略。",
            keyTopics = listOf(
                "跳频遥控与超宽带数字图传压制干扰机理",
                "便携式反制枪与固定式全向干扰天线波束成形",
                "GPS/北斗/GLONASS卫星导航信号诱骗与虚假航路注入",
                "干扰有效压制比、有效作用距离与功率预算计算",
                "电磁辐射安全防护与对民航/民用通信频段电磁兼容"
            )
        )
    )

    val ALL_SUBJECTS = listOf(PRIMARY_SUBJECT) + EXTENSION_SUBJECTS
}
