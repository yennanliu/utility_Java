#!/bin/sh


#################################################################
#  OSX : INSYALL KAFKA, ZOOPLEEPER LOCAL  
#################################################################


<<COMMENT1
# MAC OSX INTRO :

Install brew if needed: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

Download and Setup Java 8 JDK:

brew tap caskroom/versions
brew cask install java8
Download & Extract the Kafka binaries from https://kafka.apache.org/downloads

Install Kafka commands using brew: brew install kafka

Try Kafka commands using kafka-topics (for example)

Edit Zookeeper & Kafka configs using a text editor

zookeeper.properties: dataDir=/your/path/to/data/zookeeper

server.properties: log.dirs=/your/path/to/data/kafka

Start Zookeeper in one terminal window: zookeeper-server-start config/zookeeper.properties

Start Kafka in another terminal window: kafka-server-start config/server.properties
COMMENT1


<<COMMENT1
# SAMPLE INSTALL LOG : 

==> Installing dependencies for kafka: zookeeper
==> Installing kafka dependency: zookeeper
==> Downloading https://homebrew.bintray.com/bottles/zookeeper-3.4.13.mojave.bottle
==> Downloading from https://akamai.bintray.com/d1/d1e4e7738cd147dceb3d91b32480c20a
######################################################################## 100.0%
==> Pouring zookeeper-3.4.13.mojave.bottle.tar.gz
==> Caveats
To have launchd start zookeeper now and restart at login:
  brew services start zookeeper
Or, if you don't want/need a background service you can just run:
  zkServer start
==> Summary
🍺  /usr/local/Cellar/zookeeper/3.4.13: 244 files, 33.4MB
==> Installing kafka
==> Downloading https://homebrew.bintray.com/bottles/kafka-2.1.0.mojave.bottle.tar.
==> Downloading from https://akamai.bintray.com/c6/c64dce4c55608665ae1885e4c741eae4
######################################################################## 100.0%
==> Pouring kafka-2.1.0.mojave.bottle.tar.gz
==> Caveats
To have launchd start kafka now and restart at login:
  brew services start kafka
Or, if you don't want/need a background service you can just run:
  zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
==> Summary
🍺  /usr/local/Cellar/kafka/2.1.0: 164 files, 52.6MB
==> Caveats
==> zookeeper
To have launchd start zookeeper now and restart at login:
  brew services start zookeeper
Or, if you don't want/need a background service you can just run:
  zkServer start
==> kafka
To have launchd start kafka now and restart at login:
  brew services start kafka
Or, if you don't want/need a background service you can just run:
  zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
yennanliu@yennanliu-MacBook-Pro:~$ 
COMMENT1



### KAFKA ROUTE : /usr/local/etc/kafka/
### ZOOKEEPER ROUTE :  /usr/local/etc/zookeeper 


# STEP 0 : INSTALL JAVA 8 


# STEP 1 : INSTALL KAFKA 
# via brew 
brew install kafka 


# STEP 2 : INSTALL ZOOKEEPER 
# ZOOKEEPER should be installed as well when install kafka, since they are dependent 


# STEP 3 : TEST 
# sub-step 3-0 : config setting  
# (modify zoopkeeper config if needed ) : dataDir in zookeeper.properties file 
# (modify server config if needed ) : server.properties file 

# sub-step 3-1 : open 1 terminal and run : 
cd /usr/local/etc/kafka && zookeeper-server-start zookeeper.properties
# sub-step 3-2 : open the other terminal and run : 
cd /usr/local/etc/kafka && kafka-server-start server.properties

# zoopkeeper log file : dataDir=/Users/yennanliu/kafka_data/zookeeper   ( legacy :  /usr/local/var/lib/zookeeper ) 
# kafka log file : log.dirs=/Users/yennanliu/kafka_data/kafka    ( legacy : usr/local/var/lib/kafka-logs) 













