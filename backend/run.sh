#!/bin/bash

echo "$PWD"

mvn spring-boot:run -D spring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" &
while true; do
  inotifywait -e modify,create,delete,move -r . && mvn compile
done
