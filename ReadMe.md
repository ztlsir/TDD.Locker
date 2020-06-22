# Locker
储物柜TDD练习

## Locker Tasking
Given 储物柜没满 When 存包 Then 获得一张有效票据

Given 储物柜已满 When 存包 Then 存包失败，提示储物柜已满

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据

## Primary Locker Robot Tasking
Given 机器人管理2个储物柜，2个储物柜都没满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，第1个储物柜已满，第2个储物柜未满 When 存包 Then 获得一张有效票据，包存到第2个储物柜

Given 机器人管理2个储物柜，第1个储物柜未满，第2个储物柜已满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，2个储物柜都已满 When 存包 Then 存包失败，提示储物柜已满

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据

## Smart Locker Root Tasking
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

## Locker Robot Manager Tasking
Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot
When 存包
Then 获得一张有效票据，包存到第一个机器人PrimaryLockerRobot管理的locker

Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
When 存包
Then 获得一张有效票据，包存到第一个机器人SmartLockerRobot管理的locker

Given LockerRobotManager管理着2个没有容量的机器人和2个有容量的locker
When 存包
Then 获得一张有效票据，包存到第1个locker

Given LockerRobotManager管理着2个没有容量的机器人和2个locker，第1个locker没有容量，第2个locker有容量
When 存包
Then 获得一张有效票据，包存到第2个locker

Given LockerRobotManager管理着2个没有容量的机器人和2个没有容量的locker
When 存包
Then 存包失败，提示储物柜已满

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第1个locker
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第2个locker
When 取包
Then 取包成功

Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张伪造票据
When 取包
Then 取包失败，提示非法票据