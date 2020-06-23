package com.ztlsir;

/**
 *todo Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到SmartLockerRobot管理的locker
 *
 *todo Given LockerRobotManager管理着2个机器人、和2个有容量的locker，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 *
 *todo Given LockerRobotManager管理着2个没有容量的机器人和2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 *
 *todo Given LockerRobotManager管理着2个没有容量的机器人和2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 *
 *todo Given LockerRobotManager管理着2个机器人，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 *
 *todo Given LockerRobotManager管理着2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 *
 *todo Given LockerRobotManager管理着2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 *
 *todo Given LockerRobotManager管理着2个没有容量的机器人和2个没有容量的locker
 * When 存包
 * Then 存包失败，提示储物柜已满
 *
 *todo Given LockerRobotManager管理着2个没有容量的机器人
 * When 存包
 * Then 存包失败，提示储物柜已满
 *
 *todo Given LockerRobotManager管理着2个没有容量的locker
 * When 存包
 * Then 存包失败，提示储物柜已满
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第1个locker的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第2个locker的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的locker，一张包存在第1个locker的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的locker，一张包存在第2个locker的有效票
 * When 取包
 * Then 取包成功
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 *
 *todo Given LockerRobotManager管理着2个有容量的机器人，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 *
 *todo Given LockerRobotManager管理着2个有容量的locker，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 * */
public class LockerRobotManagerTest {
}
