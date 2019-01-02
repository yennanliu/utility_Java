#!/bin/sh

# STEP 1) Make sure the file system is like below 
<<COMMENT1
"""
yennanliu@yennanliu-MacBook-Pro:~/utility_Java/spark_learning/Sparkjob$ tree --si
.
├── [ 792]  build.gradle
├── [  96]  gradle
│   └── [ 128]  wrapper
│       ├── [ 54k]  gradle-wrapper.jar
│       └── [ 232]  gradle-wrapper.properties
├── [5.0k]  gradlew
├── [2.4k]  gradlew.bat
└── [  96]  in
    └── [2.4M]  2016-stack-overflow-survey-responses.csv

3 directories, 6 files
yennanliu@yennanliu-MacBook-Pro:~/utility_Java/spark_learning/Sparkjob$ 


"""
COMMENT1

# STEP 2) build dependencies 
./gradlew jar  

<<COMMENT1
"""
yennanliu@yennanliu-MacBook-Pro:~/utility_Java/spark_learning/Sparkjob$ ./gradlew jar  

:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:jar

BUILD SUCCESSFUL

Total time: 38.042 secs
yennanliu@yennanliu-MacBook-Pro:~/utility_Java/spark_learning/Sparkjob$ 

"""
COMMENT1

# step 3) Run Spark app via spark-submit 
### to fix :  build user-defined java script to jar ###
/Users/yennanliu/spark/bin/spark-submit StackOverFlowSurvey-spark.jar



