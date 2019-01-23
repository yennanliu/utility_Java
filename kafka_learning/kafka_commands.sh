#!/bin/sh


#################################################################
#  KAFKA CLI COMMANDS   
#################################################################


# 1) kafka-topics: show all commands as list doc.   
kafka-topics 

# 2) # run kafka-topics ref on zoopkeer (its port)
# the number of replication-factor should always less then number of broker 
kafka-topics  --zookeeper  127.0.0.1:2181 --topic first_topic --create  --partitions 3 --replication-factor 1

# 3) list the infromation inside topic 
kafka-topics  --zookeeper  127.0.0.1:2181 --list 

# 3) describe the the topic 
kafka-topics  --zookeeper  127.0.0.1:2181 --topic first_topic --describe 

# 4) delete the topic 
kafka-topics  --zookeeper  127.0.0.1:2181 --topic second_topic --create  --partitions 6 --replication-factor 1
kafka-topics  --zookeeper  127.0.0.1:2181 --list 
kafka-topics  --zookeeper  127.0.0.1:2181 --topic second_topic --delete   # just mark the topic for deletion 










