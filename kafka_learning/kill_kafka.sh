 #!/bin/sh


#################################################################
#  KILL RUNNING KAFKA 
#################################################################


PIDS="`ps -ef | grep kafka | egrep "kafka"  | awk '{print $2}'`"
echo kafka PIDS: $PIDS

for pid in ${PIDS}; 
	do { echo "Killing $pid"; kill -7 $pid; }; 
done;