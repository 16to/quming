#!/bin/sh
 
#切换到目录
cd /usr/local/app
date=`date`
 
#查询端口占用
lsof -i:8080
 
# $? -ne 0 不存在 $? -eq 0存在 
if [ $? -ne 0 ]
then
    nohup java -jar naming-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &
    echo $date  ":=============== restart ===============" >> monitoring.log
else
    echo $date  ":=============== is normal ==============" >> monitoring.log
fi