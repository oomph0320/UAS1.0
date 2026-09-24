# UAS 1.0 (Unmanned Autonomous System / 无人自主系统)

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-ROS%20%2F%20Embedded%20%2F%20Linux-green.svg)]()
[![Status](https://img.shields.io/badge/Status-Active%20Development-brightgreen.svg)]()

> UAS 1.0 是一个面向无人自主系统（无人机 / 无人车 / 机器人）的控制、感知与决策平台，旨在提供稳定高效的底层驱动控制与上层自主导航、规划能力的软硬件协同解决方案。

---

## 目录

- [项目简介](#项目简介)
- [核心特性](#核心特性)
- [系统架构](#系统架构)
- [软硬件依赖](#软硬件依赖)
- [快速上手](#快速上手)
- [目录结构](#目录结构)
- [开发路线 (Roadmap)](#开发路线-roadmap)
- [贡献指南](#贡献指南)
- [许可证](#许可证)

---

## 项目简介

**UAS 1.0**（Unmanned Autonomous System 1.0）聚焦于无人系统的自主化任务执行。系统整合了动力学控制、多传感器数据融合（IMU、GNSS、激光雷达/视觉）、路径规划与避障算法，适用于科研实验验证及工业级自主作业场景。

---

## 核心特性

- **多模态传感器融合**：支持 IMU、GPS/RTK、LiDAR、RGB-D 相机等多传感器时间同步与位姿估计。
- **高鲁棒性控制层**：集成经典 PID、LQR 及自适应/模型预测控制（MPC）算法，确保抗扰动能力。
- **自主导航与规划**：内置全局与局部路径规划算法（如 A*、Hybrid A*、TEB、DWA 等），实现动态避障。
- **模块化通信设计**：采用松耦合架构，适配 ROS/ROS 2、CAN 总线及 MAVLink 通信协议。
- **仿真与实物无缝迁移**：支持 Gazebo / AirSim / Webots 仿真环境的一键部署与测试。

---

## 系统架构

```text
+-------------------------------------------------------------+
|                      任务与决策层 (Decision)                  |
|          [有限状态机 / 行为树 / 任务航线规划 / 智能决策]         |
+-------------------------------------------------------------+
                              |
+-------------------------------------------------------------+
|                      规划与感知层 (Planning & Perception)   |
|          [SLAM / 点云分割 / 目标识别 / 全局与局部路径规划]       |
+-------------------------------------------------------------+
                              |
+-------------------------------------------------------------+
|                      估计与控制层 (Estimation & Control)     |
|          [EKF状态估计 / 姿态控制 / 轨迹跟踪 / 故障诊断]          |
+-------------------------------------------------------------+
                              |
+-------------------------------------------------------------+
|                      底层硬件与驱动 (Hardware & Drivers)      |
|          [传感器驱动 / 电机驱动 / CAN / 串口 / 遥测链路]          |
+-------------------------------------------------------------+
```

---

## 软硬件依赖

### 软件环境
- **操作系统**：Ubuntu 20.04 / 22.04 LTS
- **中间件**：ROS Noetic / ROS 2 (Humble)
- **编译工具**：CMake (>= 3.16), GCC/G++ (>= 9.4)
- **核心依赖库**：
  - Eigen 3
  - OpenCV
  - PCL (Point Cloud Library)

### 硬件支持 (可选参考)
- **计算平台**：Jetson Orin / Xavier / 树莓派 / 工控机 / STM32
- **感知传感器**：Livox LiDAR / 深度相机 (Intel RealSense) / 组合导航系统

---

## 快速上手

### 1. 克隆代码仓库

```bash
git clone https://github.com/oomph0320/UAS1.0.git
cd UAS1.0
```

### 2. 安装依赖

```bash
# 更新子模块（如果有）
git submodule update --init --recursive

# 安装 ROS 系统依赖
rosdep install --from-paths src --ignore-src -r -y
```

### 3. 编译构建

```bash
# 创建工作空间并编译（根据项目实际构建工具选择）
mkdir -p build && cd build
cmake ..
make -j$(nproc)

# 若为 ROS 工作空间：
# catkin_make
# 或 colcon build --symlink-install
```

### 4. 运行示例

```bash
# 启动基础节点 / 仿真环境
source devel/setup.bash  # 或 source install/setup.bash
roslaunch uas_bringup uas_system.launch
```

---

## 目录结构

```text
UAS1.0/
├── config/              # 配置文件与参数设置 (YAML, XML, JSON)
├── docs/                # 设计文档、原理图及 API 说明
├── launch/              # 启动脚本与测试用例
├── scripts/             # 自动化构建与辅助部署工具
├── src/                 # 核心功能实现源码
│   ├── control/         # 底层与高层控制器
│   ├── driver/          # 传感器与外设驱动接口
│   ├── navigation/      # 建图、定位与路径规划
│   └── perception/      # 视觉与雷达点云感知处理
├── tests/               # 单元测试与基准测试
├── CMakeLists.txt       # 构建编译配置
└── README.md            # 项目说明文档
```

---

## 开发路线 (Roadmap)

- [x] 系统架构与底层通信接口搭建
- [ ] 多传感器联合标定与时间同步优化
- [ ] 复杂动态障碍物环境下的实时避障算法验证
- [ ] 硬件实机闭环飞行/巡线/越障测试
- [ ] 多机协同通信与集群作业功能扩展

---

## 贡献指南

欢迎提交 Issue 和 Pull Request！

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/NewFeature`)
3. 提交修改 (`git commit -m 'Add some NewFeature'`)
4. 推送分支 (`git push origin feature/NewFeature`)
5. 新建 Pull Request

---

## 许可证

本项目采用 [MIT License](LICENSE) 开源许可。
