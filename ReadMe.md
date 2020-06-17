# Locker
储物柜TDD练习

## Tasking
Given 储物柜没满 When 存包 Then 获得一张有效票据

Given 储物柜已满 When 存包 Then 提示存包失败

Given 一张有效票据 When 取包 Then 取包成功

Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据

Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据