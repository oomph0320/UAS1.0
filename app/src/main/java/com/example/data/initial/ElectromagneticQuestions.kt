package com.example.data.initial

import com.example.data.model.Question
import com.example.data.model.QuestionType
import com.example.data.model.QuizOption

val electromagneticQuestions: List<Question> = listOf(
    Question(
        id = "em-single-001",
        type = QuestionType.SINGLE,
        question = "电磁压制干扰（Noise Jamming）使无人机接收机失锁的核心物理判据是：",
        options = listOf(
            QuizOption("A", "接收机输入端信干比（J/S）低于最低解调门限"),
            QuizOption("B", "干扰机频率必须恰好等于光速"),
            QuizOption("C", "无人机机身温度上升"),
            QuizOption("D", "遥控器电池瞬间放电完毕"),
        ),
        answer = listOf("A"),
        explanation = "无线电通信解调要求信噪比（SNR）或信干比（J/S）达到特定阈值，压制干扰通过强噪声淹没信号使误码率急剧上升达100%，引发链路失步断连。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-002",
        type = QuestionType.SINGLE,
        question = "在反无人机应用中，针对宽带跳频无人机，点频瞄准式干扰相比阻塞式宽带干扰的优势在于：",
        options = listOf(
            QuizOption("A", "能量集中在当前跳频瞬间频点，干扰功率利用效率极高"),
            QuizOption("B", "可以发射紫外线"),
            QuizOption("C", "完全不需要天线"),
            QuizOption("D", "永远不需要侦察接收机配合"),
        ),
        answer = listOf("A"),
        explanation = "阻塞式宽带干扰把有限功率分散在数百兆带宽上，功率谱密度极低；瞄准式干扰实时引导功率发射至跳变信道，功率谱密度可提高数十倍。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-003",
        type = QuestionType.SINGLE,
        question = "民用GPS L1频段与北斗B1频段的中心工作频率分别位于：",
        options = listOf(
            QuizOption("A", "GPS L1: 1575.42 MHz ; 北斗 B1I: 1561.098 MHz"),
            QuizOption("B", "433 MHz 和 900 MHz"),
            QuizOption("C", "2.4 GHz 和 5.8 GHz"),
            QuizOption("D", "10 GHz 和 24 GHz"),
        ),
        answer = listOf("A"),
        explanation = "卫星导航L波段中心频点标准：GPS L1为1575.42MHz，北斗二号/三号民用B1I为1561.098MHz，B1C为1575.42MHz。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-004",
        type = QuestionType.SINGLE,
        question = "高功率微波武器（HPM）攻击无人机蜂群时，微波能量侵入无人机内部电路主要通过哪两种耦合途径？",
        options = listOf(
            QuizOption("A", "前门耦合（经接收天线输入）与后门耦合（经机壳缝隙/线缆耦合）"),
            QuizOption("B", "化学渗透与分子扩散"),
            QuizOption("C", "气压差与声波共振"),
            QuizOption("D", "红外辐射与热胀冷缩"),
        ),
        answer = listOf("A"),
        explanation = "高功率电磁脉冲通过无人机通信天线直接进入前端放大器（前门耦合），或通过缝隙、接口和电源线感应出破坏性浪涌电压击毁CMOS芯片（后门耦合）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-005",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点5] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-006",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点6] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-007",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点7] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-008",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点8] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-009",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点9] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-010",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点10] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-011",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点11] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-012",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点12] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-013",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点13] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-014",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点14] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-015",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点15] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-016",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点16] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-017",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点17] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-018",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点18] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-019",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点19] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-020",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点20] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-021",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点21] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-022",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点22] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-023",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点23] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-024",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点24] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-025",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点25] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-026",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点26] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-027",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点27] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-028",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点28] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-029",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点29] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-030",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点30] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-031",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点31] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-032",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点32] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-033",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点33] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-034",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点34] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-035",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点35] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-036",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点36] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-037",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点37] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-038",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点38] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-039",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点39] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-040",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点40] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-041",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点41] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-042",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点42] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-043",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点43] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-044",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点44] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-045",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点45] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-046",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点46] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-047",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点47] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-048",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点48] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-049",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点49] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-050",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点50] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-051",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点51] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-052",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点52] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-053",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点53] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-054",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点54] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-055",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点55] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-056",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点56] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-057",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点57] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-058",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点58] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-059",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点59] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-060",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点60] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-061",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点61] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-062",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点62] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-063",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点63] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-064",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点64] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-065",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点65] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-066",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点66] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-067",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点67] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-068",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点68] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-069",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点69] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-070",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点70] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-071",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点71] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-072",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点72] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-073",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点73] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-074",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点74] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-075",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点75] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-076",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点76] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-077",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点77] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-078",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点78] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-079",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点79] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-080",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点80] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-081",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点81] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-082",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点82] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-083",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点83] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-084",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点84] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-085",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点85] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-086",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点86] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-087",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点87] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-088",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点88] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-089",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点89] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-090",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点90] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-091",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点91] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-092",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点92] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-093",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点93] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-094",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点94] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-095",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点95] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-096",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点96] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-097",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点97] 天线增益（Antenna Gain，单位dBi）数值提高3dB，意味着在主瓣轴线方向上的辐射功率密度：",
        options = listOf(
            QuizOption("A", "增强为原来的 2 倍"),
            QuizOption("B", "增强为原来的 3 倍"),
            QuizOption("C", "减半"),
            QuizOption("D", "增加 10 倍"),
        ),
        answer = listOf("A"),
        explanation = "分贝（dB）采用对数度量，功率每增加3dB对应物理功率密度翻倍（10 * log10(2) ≈ 3.01 dB）。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-098",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点98] 在便携式无人机干扰枪设计中，通常选用高效率固态功率放大器芯片工艺为：",
        options = listOf(
            QuizOption("A", "氮化镓（GaN）高电子迁移率晶体管"),
            QuizOption("B", "真空电子管"),
            QuizOption("C", "硅二极管"),
            QuizOption("D", "发光二极管LED"),
        ),
        answer = listOf("A"),
        explanation = "GaN（氮化镓）作为第三代宽禁带半导体，具有击穿电场高、工作频带宽、功率密度大、能量转换效率高的优势，是现代便携功放核心。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-099",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点99] 针对无人机采用的直接序列扩频（DSSS）通信技术，要对其进行有效噪声压制，干扰信号带宽应：",
        options = listOf(
            QuizOption("A", "覆盖扩频伪随机码调制后的全扩频码片带宽"),
            QuizOption("B", "小于1Hz"),
            QuizOption("C", "无限大"),
            QuizOption("D", "只覆盖直流偏置"),
        ),
        answer = listOf("A"),
        explanation = "扩频通信通过扩频增益抑制窄带干扰，若要彻底淹没DSSS信号，压制噪声必须覆盖其伪码扩频后的大射频带宽。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-single-100",
        type = QuestionType.SINGLE,
        question = "[电磁干扰技术专业考点100] 卫星导航信号到达地表天线处的微弱接收功率电平量级通常仅约为：",
        options = listOf(
            QuizOption("A", "-130 dBm 左右（仅约 10⁻¹⁶ 瓦特，极易被微弱功率干扰淹没）"),
            QuizOption("B", "1000 瓦特"),
            QuizOption("C", "10 dBm"),
            QuizOption("D", "100 瓦特"),
        ),
        answer = listOf("A"),
        explanation = "导航卫星轨道高达2万公里，到达地面的信号极其微弱，甚至淹没于自然热噪声底之下，因此毫瓦级微小干扰即可使GNSS接收机失锁。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-multi-001",
        type = QuestionType.MULTI,
        question = "反无人机电磁干扰设备按干扰机理与信号样式通常划分为哪些类型？",
        options = listOf(
            QuizOption("A", "射频噪声压制干扰（宽带阻塞/扫频/瞄准）"),
            QuizOption("B", "欺骗性干扰（GNSS星历欺骗/伪距牵引）"),
            QuizOption("C", "协议重放与指令注入式劫持干扰"),
            QuizOption("D", "超宽带强电磁脉冲（EMP/HPM）破坏性干扰"),
        ),
        answer = listOf("A", "B", "C", "D"),
        explanation = "电磁对抗手段涵盖从阻断通信链路的压制干扰、伪造导航指令的欺骗干扰，到烧毁内部元器件的高能微波脉冲硬杀伤。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-multi-002",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合2] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-003",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合3] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-004",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合4] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-005",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合5] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-006",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合6] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-007",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合7] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-008",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合8] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-009",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合9] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-010",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合10] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-011",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合11] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-012",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合12] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-013",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合13] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-014",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合14] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-015",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合15] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-016",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合16] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-017",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合17] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-018",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合18] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-019",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合19] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-020",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合20] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-021",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合21] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-022",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合22] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-023",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合23] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-024",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合24] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-025",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合25] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-026",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合26] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-027",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合27] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-028",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合28] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-029",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合29] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-030",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合30] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-031",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合31] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-032",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合32] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-033",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合33] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-034",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合34] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-035",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合35] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-036",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合36] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-037",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合37] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-038",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合38] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-039",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合39] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-multi-040",
        type = QuestionType.MULTI,
        question = "[电磁干扰技术多维综合40] 在设计用于城市低空防御的定向射频干扰发射系统时，抑制天线副瓣（Side Lobe）电平的核心目的是：",
        options = listOf(
            QuizOption("A", "防止副瓣强辐射对侧方及后方正常城市通信、特警专网产生严重电磁污染"),
            QuizOption("B", "集中更多发射功率进入主瓣，提高对目标的有效压制距离"),
            QuizOption("C", "避免近距离操作人员受到大功率侧向微波辐射伤害"),
            QuizOption("D", "使天线外壳变软"),
        ),
        answer = listOf("A", "B", "C"),
        explanation = "低副瓣天线设计确保电磁辐射严格聚焦于目标方向，降低同频伴随干扰与操作人员辐射暴露，是现代绿色防空的核心指标。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-judge-001",
        type = QuestionType.JUDGE,
        question = "只要无人机机身表面喷涂了吸波隐身涂层，电磁干扰枪发出的射频压制信号就完全无法阻断其图传和遥控链路。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("B"),
        explanation = "错误。无线电通信是通过无人机外露或外置的天线系统接收电磁波的，吸波涂层无法阻挡进入天线端口的同频强干扰信号。",
        topic = "电磁干扰技术",
        difficulty = 1
    ),
    Question(
        id = "em-judge-002",
        type = QuestionType.JUDGE,
        question = "氮化镓（GaN）功放由于具备更高的击穿电压和工作结温，在同等输出功率下比传统LDMOS功放体积更小、更省电。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。GaN高功率固态器件大幅缩小了便携设备功放体积并显著改善散热与电池续航。",
        topic = "电磁干扰技术",
        difficulty = 1
    ),
    Question(
        id = "em-judge-003",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析3] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-004",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析4] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-005",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析5] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-006",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析6] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-007",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析7] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-008",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析8] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-009",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析9] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-010",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析10] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-011",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析11] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-012",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析12] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-013",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析13] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-014",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析14] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-015",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析15] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-016",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析16] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-017",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析17] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-018",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析18] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-019",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析19] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-020",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析20] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-021",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析21] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-022",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析22] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-023",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析23] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-024",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析24] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-025",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析25] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-026",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析26] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-027",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析27] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-028",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析28] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-029",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析29] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-judge-030",
        type = QuestionType.JUDGE,
        question = "[电磁干扰技术正误辨析30] 对民用无人机仅实施GNSS导航频段压制时，无人机由于无法获取卫星位置，一般会丧失定点悬停能力并漂移，但飞手依然握有遥控操控权。",
        options = listOf(
            QuizOption("A", "正确"),
            QuizOption("B", "错误"),
        ),
        answer = listOf("A"),
        explanation = "正确。单纯压制GNSS只会使飞控切入姿态模式（ATTI），若遥控2.4G/5.8G链路未被压制，飞手仍能操纵摇杆控制飞行姿态与航向。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-001",
        type = QuestionType.FILL,
        question = "通过发射与无人机工作频段相同的强电磁噪声，使接收机信干比严重恶化的干扰方式统称为______干扰。",
        options = emptyList(),
        answer = listOf("压制式", "噪声压制", "阻塞式"),
        explanation = "压制式干扰通过能量淹没破坏接收机解调。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-002",
        type = QuestionType.FILL,
        question = "卫星导航欺骗技术根据注入信号与真实卫星的相对伪距动态关系，可分为生成式欺骗与______欺骗。",
        options = emptyList(),
        answer = listOf("转发式", "转发"),
        explanation = "欺骗干扰分为自身计算星历合成的生成式与截获真实信号延迟放大的转发式。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-003",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空3] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-004",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空4] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-005",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空5] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-006",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空6] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-007",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空7] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-008",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空8] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-009",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空9] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-010",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空10] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-011",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空11] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-012",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空12] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-013",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空13] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-014",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空14] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-fill-015",
        type = QuestionType.FILL,
        question = "[电磁干扰技术核心填空15] 高功率微波武器系统主要通过天线端口引入的前门耦合和机身间隙感应的______耦合毁伤目标。",
        options = emptyList(),
        answer = listOf("后门", "后门耦合"),
        explanation = "后门耦合指强脉冲通过电缆导线缝隙进入电路内部产生破坏性浪涌。",
        topic = "电磁干扰技术",
        difficulty = 2
    ),
    Question(
        id = "em-short-001",
        type = QuestionType.SHORT,
        question = "分析在防范黑飞无人机时，采用“定向电磁干扰枪”与“全向大功率基站干扰机”在战术使用、防御范围及连带电磁风险方面的差异。",
        options = emptyList(),
        answer = listOf("差异对比：\n1. 战术使用与部署：干扰枪便携轻便、单兵机动响应快、由人工目视或单兵设备瞄准视距目标定向射击；全向基站通常固定式或车载部署，与雷达自动联动，可形成无死角全向防护电磁罩。\n2. 防御范围与距离：干扰枪采用高增益定向天线，主瓣能量聚焦，压制距离通常在1~2km；全向基站功率发散至360度，有效压制半径通常为1~3km，需要更大峰值发射总功率。\n3. 连带电磁风险：干扰枪波束极窄（通常20~30度），瞄空发射，对地面周边非目标方向无线电通信干扰极低，安全性高；全向基站360度大功率辐射，极易压制覆盖区内的居民WiFi、运营商公网以及机场调度通信，伴生电磁污染重，需严格受控开启。"),
        explanation = "考查不同形态电磁反制装备的作战效能与环境兼容性权衡。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-002",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述2] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-003",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述3] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-004",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述4] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-005",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述5] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-006",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述6] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-007",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述7] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-008",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述8] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-009",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述9] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-010",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述10] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-011",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述11] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-012",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述12] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-013",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述13] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-014",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述14] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    ),
    Question(
        id = "em-short-015",
        type = QuestionType.SHORT,
        question = "[电磁干扰技术原理与应用论述15] 阐述GNSS卫星导航欺骗技术（星历欺骗与时间欺骗）引导非授权无人机降落在预定安全区域的实现机理。",
        options = emptyList(),
        answer = listOf("实现机理：1. 侦测获取目标无人机当前的近似经纬度与时间；2. 发射机功率微调，发射与真实卫星同频同结构但功率略高（3~6dB）的虚假伪距信号，使无人机GNSS接收机平滑由真实卫星跟踪环路锁定至虚假信号；3. 渐进式微调发射信号的时延与多普勒频移，使解算出的自身虚拟位置向特定方向偏离；4. 飞控为了修正'虚假偏差'会自动操纵机翼/旋翼反向飞行，从而被平稳牵引至防御方设定的安全捕获区迫降或触发禁飞区程序降落。"),
        explanation = "考查精确微功率卫星导航诱骗的闭环控制物理过程。",
        topic = "电磁干扰技术",
        difficulty = 3
    )
);
