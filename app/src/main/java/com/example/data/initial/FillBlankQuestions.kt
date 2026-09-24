package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType

val fillBlankQuestions: List<Question> = listOf(
    Question(
        id = "caac-fill-01",
        type = QuestionType.FILL,
        question = "无人机的“最大起飞重量（MTOM）”是指______与______的总重量。",
        answer = listOf("无人机本身重量", "可抛弃载荷（如电池、任务设备）"),
        explanation = "最大起飞重量（Maximum Take-Off Mass）由机身空机净重与包含动力电池、燃油、任务传感器吊舱在内的全部负载总和构成。",
        topic = "无人机基础理论",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-02",
        type = QuestionType.FILL,
        question = "国际标准大气（ISA）条件下，海平面标准大气压强为______hPa，标准海平面气温为______℃。",
        answer = listOf("1013.25", "15"),
        explanation = "标准海平面气压设定为1013.25 hPa（百帕，约29.92英寸汞柱），标准基准气温为15摄氏度。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-03",
        type = QuestionType.FILL,
        question = "多旋翼无人机的“悬停效率”在动力学定义上为______与______的比值。",
        answer = listOf("悬停时产生的升力", "电机输入功率"),
        explanation = "悬停效率表征旋翼系统将电功率或轴功率转化为抵抗重力拉力（升力）的效率，常用单位为g/W（克/瓦）。",
        topic = "飞行原理与气动力学",
        difficulty = 2
    ),
    Question(
        id = "caac-fill-04",
        type = QuestionType.FILL,
        question = "无人机飞行参数中，“地速（Ground Speed）”是指______，“空速（Air Speed）”是指______。",
        answer = listOf("相对于地面的飞行速度", "相对于空气的飞行速度"),
        explanation = "地速指飞机相对于地表大地的绝对投影水平速度；空速指机身相对于周围气流介质的相对流动速度，两者相差风速矢量。",
        topic = "飞行原理与气动力学",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-05",
        type = QuestionType.FILL,
        question = "2026修订版规定，轻型无人机在适飞空域内飞行，需通过______完成飞行计划报备，报备信息包括______（至少2项）。",
        answer = listOf("无人机综合监管平台", "飞行时间、飞行范围、无人机识别码"),
        explanation = "操作人员通过国家统一建设的民用无人驾驶航空器综合管理平台（UOM平台）在线填报飞行时段、空域经纬度及航空器实名SN码。",
        topic = "法规与空域规则",
        difficulty = 2
    ),
    Question(
        id = "caac-fill-06",
        type = QuestionType.FILL,
        question = "我国法律法规规定，民用无人驾驶航空器所有者必须进行实名登记的最小起飞重量阈值为______克。",
        answer = listOf("250"),
        explanation = "最大起飞重量超过250克（含250克）的民用无人机所有者均必须通过UOM平台完成实名登记并张贴二维码标识。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-07",
        type = QuestionType.FILL,
        question = "多旋翼无人机的“悬停效率”在工程中通常用______（单位：g/W）表示，数值越高代表动力系统越省电。",
        answer = listOf("载重功率比"),
        explanation = "悬停效率通常以每瓦电功率能够产生多少克升力（g/W）来衡量，业内亦称载重功率比或力效。",
        topic = "动力与电池系统",
        difficulty = 2
    ),
    Question(
        id = "caac-fill-08",
        type = QuestionType.FILL,
        question = "申请民航局颁发的视距内民用无人驾驶航空器操控员执照，申请人年龄法定需年满______周岁。",
        answer = listOf("16"),
        explanation = "《民用无人机驾驶员管理规定》明确规定申请执照人员法定最低年龄须满16周岁。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-09",
        type = QuestionType.FILL,
        question = "常规非管制适飞空域飞行时，轻型无人机飞行真高一般不得超过______米，超过则需额外向空管部门提出申请。",
        answer = listOf("120"),
        explanation = "适飞空域允许轻型无人机自由飞行的真高天花板为120米（微型机限高50米），突破高度进入管制空间。",
        topic = "法规与空域规则",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-10",
        type = QuestionType.FILL,
        question = "无人机动力聚合物锂电池（LiPo）的单节标称电压为______V（满电为4.20V，放电截止约为2.75V~3.0V）。",
        answer = listOf("3.7"),
        explanation = "标准单节锂电芯标称电压为3.7V，工作平台电压主要集中在3.7V左右。",
        topic = "动力与电池系统",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-11",
        type = QuestionType.FILL,
        question = "工业级无人机视觉双目或激光毫米波避障系统的最大有效感知探测距离通常为______米。",
        answer = listOf("10-30"),
        explanation = "常见消费与轻型工业多旋翼避障雷达与视觉传感器的稳定探测感知距离一般在10米至30米区间。",
        topic = "飞行原理与飞控",
        difficulty = 2
    ),
    Question(
        id = "caac-fill-12",
        type = QuestionType.FILL,
        question = "飞行前实施磁罗盘校准时，需在远离钢筋强磁金属干扰环境下，通常需要将机体在空间完成水平与垂直各旋转______圈（或6个面标定）。",
        answer = listOf("1"),
        explanation = "磁罗盘双轴校准通常为水平旋转360度一周、再将机头朝下或垂直旋转360度一周，以测定三维地磁硬磁与软磁偏置向量。",
        topic = "飞行操作与维护",
        difficulty = 2
    ),
    Question(
        id = "caac-fill-13",
        type = QuestionType.FILL,
        question = "无人机技术指标中的“最大抗风等级”通常是指在保证姿态可控悬停状态下所能承受的最大环境______（单位m/s）。",
        answer = listOf("风速"),
        explanation = "抗风等级（如5级风、6级风）对应具体风速上限（如6级风对应10.8~13.8 m/s）。",
        topic = "航空气象与环境",
        difficulty = 1
    ),
    Question(
        id = "caac-fill-14",
        type = QuestionType.FILL,
        question = "根据民航CAAC规范规定，商业飞行作业团队与操控员的飞行日志原始数据档案需至少保存______年备查。",
        answer = listOf("2"),
        explanation = "CAAC运行规章要求民用无人机运行与维护日志文件至少妥善存档保存2年。",
        topic = "法规与空域规则",
        difficulty = 2
    )
)
