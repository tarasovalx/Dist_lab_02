mvn -X package

start-dfs.sh
start-yarn.sh

hdfs dfs -rm -r output

hadoop fs -copyFromLocal airports.csv
hadoop fs -copyFromLocal flights.csv

export HADOOP_CLASSPATH=./target/lab_02-1.0-SNAPSHOT.jar



hadoop bmstu.ru.FlightsJoinApp flights.csv airports.csv output
hadoop fs -copyToLocal output ~/labs_output/lab_02
