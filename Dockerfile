FROM jac18281828/javadev:latest

WORKDIR /build

ENV JAVA_HOME=/usr/lib/jvm/default-java

COPY . .

CMD mvn -U clean compile package &&  java -jar /build/target/benchmarks.jar
