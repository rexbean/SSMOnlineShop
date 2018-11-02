# Logback
## Modules
- logback-access: Third party software can read the log file from here
- logback-classis: advanced log4j, has all API of SLF4j easy to immigrate to other log system
- logback-core: provide fundamental service for previous
## Tag
- logger: store the log object ,log type/level
  - level :
    - TRACE
    - **DEBUG**
    - **INFO**
    - WARN
    - **ERROR**
- appender: set the output path of the log files
- layout: format the output of the log
## Configuration
- logback.xml
``` XML
<?xml version = "1.0" encoding = "UTF-8"?>
<configuration scan = "true" scanPeriod = "60 seconds" debug = "false">
  <!--Define some parameter constant(property)-->
  <property name = "log.level" value = "debug"/>
  <property name = "log.maxHistory" value = "30"/>
  <property name = "log.filePath" value = "${catalina.base}/logs/webapps"> <!--Tomcat root path-->
  <property name = "log.pattern" 
            value = "%d{yyyy-MM-dd HH:mm:ss.SSS}[%thread] %-5level % logger{50} - %msg%n"/>
  <appender name = "consoleAppender" class = "ch.qos.logback.aore.ConsoleAppender">
    <!--Event => byte[] => file-->
    <encoder>
      <pattern>${log.pattern}</pattern>
    </encoder>
  </appender>
  <!--RollingFileAppender: append with the time passing by-->
  <appender name = "debugAppender" class = "ch.qos.logback.core.rolling.RollingFileAppender">
    <encoder>
      <file>${log.filePath}/debug.log</file>
      <rollingPolicy class = "ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <!--File name-->
        <fileNamePattern>${log.filePath}/debug/debug.%d{yyyy-MM-dd}.log.gz
        </fileNamePattern>
    </encoder>
  </appender>
</configuration>
```
