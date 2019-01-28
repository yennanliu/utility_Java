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

# 5) set up producer 
kafka-console-producer  --broker-list  127.0.0.1:9092 --topic first_topic 
# if start from a new broker not in the list --> still be fine, BUT ALWAYS CREATE A TOPIC BEFORE USING IT 
kafka-console-producer  --broker-list  127.0.0.1:9092 --topic new_topic 

# 6) set up producer property 
kafka-console-producer  --broker-list  127.0.0.1:9092 --topic first_topic --producer-property acks=all  

# 7) set up cosumer  (NOW, OPEN THE OTHER TERMIANL AND RUN THE BELOW COMMAND )
kafka-console-consumer   --bootstrap-server  127.0.0.1:9092 --topic first_topic 






