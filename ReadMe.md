# Locker
储物柜TDD练习

## Locker Tasking
Given 储物柜没满 When 存包 Then 获得一张有效票据

Given 储物柜已满 When 存包 Then 提示存包失败

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据

## Primary Locker Robot Tasking
Given 机器人管理2个储物柜，2个储物柜都没满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，第1个储物柜已满，第2个储物柜未满 When 存包 Then 获得一张有效票据，包存到第2个储物柜

Given 机器人管理2个储物柜，第1个储物柜未满，第2个储物柜已满 When 存包 Then 获得一张有效票据，包存到第1个储物柜

Given 机器人管理2个储物柜，2个储物柜都已满 When 存包 Then 提示存包失败

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
