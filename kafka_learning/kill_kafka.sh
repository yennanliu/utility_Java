 #!/bin/sh


#################################################################
#  KILL RUNNING KAFKA 
#################################################################

# STEP 1) KILL KAFKA, ZOOKEEPER  
PIDS="`ps -ef | grep kafka | egrep "kafka"  | awk '{print $2}'`"
echo kafka PIDS: $PIDS

for pid in ${PIDS}; 
	do { echo "Killing $pid"; kill -7 $pid; }; 
done;

PIDS="`ps -ef | grep zookeeper | egrep "zookeeper"  | awk '{print $2}'`"
echo kafka PIDS: $PIDS

for pid in ${PIDS}; 
	do { echo "Killing $pid"; kill -7 $pid; }; 
done;


# STEP 2) REMOVE kafka-logs/.lock
# https://stackoverflow.com/questions/37294996/apache-kafka-failed-to-acquire-lock-on-file-lock-in-tmp-kafka-logs