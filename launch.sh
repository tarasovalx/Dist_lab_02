mvn -X package

start-dfs.sh
start-yarn.sh

hadoop fs -rm airports.csv
hadoop fs -rm flights.csv
hdfs dfs -rm -r output

hadoop fs -copyFromLocal airports.csv
hadoop fs -copyFromLocal flights.csv

export HADOOP_CLASSPATH=target/lab_02-1.0-SNAPSHOT.jar

rm output -r

hadoop FlightsJoinApp flights.csv airports.csv output
hadoop fs -copyToLocal output
