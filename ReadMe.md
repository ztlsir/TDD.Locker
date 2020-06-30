# Locker
储物柜TDD练习

## Locker Tasking
```
Given 储物柜没满 When 存包 Then 获得一张有效票据

Given 储物柜已满 When 存包 Then 存包失败，提示储物柜已满

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
```

## Primary Locker Robot Tasking
```
Given 机器人管理2个储物柜，2个储物柜都没满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，第1个储物柜已满，第2个储物柜未满 When 存包 Then 获得一张有效票据，包存到第2个储物柜

Given 机器人管理2个储物柜，第1个储物柜未满，第2个储物柜已满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，2个储物柜都已满 When 存包 Then 存包失败，提示储物柜已满

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据

Given 机器人管理0个储物柜 When 存包 Then 提示存包失败
```

## Smart Locker Root Tasking
```
Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为5
When 存包
Then 获得一张有效票据，包存到第1个储物柜

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为4
When 存包
Then 获得一张有效票据，包存到第1个储物柜

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为4，第2个储物柜容量为5
When 存包
Then 获得一张有效票据，包存到第2个储物柜

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为0，第2个储物柜容量为5
When 存包
Then 获得一张有效票据，包存到第2个储物柜

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为0
When 存包
Then 获得一张有效票据，包存到第1个储物柜

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为0，第2个储物柜容量为0
When 存包
Then 存包失败，提示储物柜已满

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据
When 通过SmartLockerRoot取包
Then 取包成功

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，一张伪造票据
When 通过SmartLockerRoot取包
Then 取包失败，提示非法票据

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过PrimaryLockerRoot存包取得的一张有效票据
When 通过SmartLockerRoot取包
Then 取包成功

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据
When 通过PrimaryLockerRoot取包
Then 取包成功

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为1，第2个储物柜容量为0
When 存包
Then 获得一张有效票据，包存到第1个储物柜，第1个储物柜存满

Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为1，第2个储物柜容量为0
When 先存包,再通过SmartLockerRoot取包
Then 第1个储物柜有余量，第2个储物柜存满

Given SmartLockerRoot管理着0个储物柜
When 存包
Then 存包失败，提示储物柜已满
```

## Locker Robot Manager Tasking
```
Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot
When 存包
Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker

Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
When 存包
Then 获得一张有效票据，包存到SmartLockerRobot管理的locker

Given LockerRobotManager管理着2个机器人、和2个有容量的locker，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
When 存包
Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker

Given LockerRobotManager管理着2个没有容量的机器人和2个有容量的locker
When 存包
Then 获得一张有效票据，包存到第1个locker

Given LockerRobotManager管理着2个没有容量的机器人和2个locker，第1个locker没有容量，第2个locker有容量
When 存包
Then 获得一张有效票据，包存到第2个locker

Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
When 存包
Then 获得一张有效票据，包存到SmartLockerRobot管理的locker

Given LockerRobotManager管理着2个机器人，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
When 存包
Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker

Given LockerRobotManager管理着2个有容量的locker
When 存包
Then 获得一张有效票据，包存到第1个locker

Given LockerRobotManager管理着2个locker，第1个locker没有容量，第2个locker有容量
When 存包
Then 获得一张有效票据，包存到第2个locker

Given LockerRobotManager管理着2个没有容量的机器人和2个没有容量的locker
When 存包
Then 存包失败，提示储物柜已满

Given LockerRobotManager管理着2个没有容量的机器人
When 存包
Then 存包失败，提示储物柜已满

Given LockerRobotManager管理着2个没有容量的locker
When 存包
Then 存包失败，提示储物柜已满

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第1个locker的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第2个locker的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的locker，一张包存在第1个locker的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的locker，一张包存在第2个locker的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张伪造票据
When 取包
Then 取包失败，提示非法票据

Given LockerRobotManager管理着2个有容量的机器人，一张伪造票据
When 取包
Then 取包失败，提示非法票据

Given LockerRobotManager管理着2个有容量的locker，一张伪造票据
When 取包
Then 取包失败，提示非法票据

Given LockerRobotManager管理着0个机器人和0个locker
When 存包
Then 存包失败，提示储物柜已满
```

## Locker Robot Director Tasking
```
Given Director管理1个manager，manager管理1个Locker，余量和容量分别为：2和4
When 获取报表
Then 获得报表：
M 2 4
  L 2 4

Given Director管理1个manager，manager管理2个Locker，余量分别为：2和1，容量分别为：6和8
When 获取报表
Then 获得报表：
M 3 14
  L 2 6
  L 1 8

Given Director管理1个manager，manager管理1个PrimaryLockerRobot，PrimaryLockerRobot管理了2个Locker，余量分别为：3和2，容量分别为：9和10
When 获取报表
Then 获得报表：
M 5 19
  R 5 19
    L 3 9
    L 2 10

Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个SmartLockerRobot，PrimaryLockerRobot管理了3个Locker，余量分别为：1、4、4，容量分别为：13、10、11，SmartLockerRobot管理了1个Locker，余量分别为：2和5，容量分别为：11和12
When 获取报表
Then 获得报表：
M 16 57
  R 9 34
    L 1 13
    L 4 10
    L 4 11
  R 7 23
    L 2 11
    L 5 12

Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：6和16，Locker余量和容量分别为：3和10
When 获取报表
Then 获得报表：
M 9 26
  L 3 10
  R 6 16
    L 6 16

Given Director管理2个manager，manager1管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和6，Locker余量和容量分别为：7和15；manager2管理1个SmartLockerRobot和1个Locker，SmartLockerRobot管理了1个Locker，余量和容量分别为：1和12，Locker余量和容量分别为：2和9
When 获取报表
Then 获得报表：
M 9 21
  L 7 15
  R 2 6
    L 2 6
M 3 21
  L 2 9
  R 1 12
    L 1 12

Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：4和12，Locker余量和容量分别为：1和9；Director未管理1个PrimaryLockerRobot，该PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和18
When 获取报表
Then 获得报表：
M 5 21
  L 1 9
  R 4 12
    L 4 12
```