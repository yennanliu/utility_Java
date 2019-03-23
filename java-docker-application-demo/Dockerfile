FROM java:8
   COPY . /var/www/java
   WORKDIR /var/www/java
   RUN javac Sample.java
   RUN javac ForLoopExample.java
   CMD ["java", "Sample"]
   CMD ["java", "ForLoopExample"]


