Animals App
===========
This is solution for the “animals” coding task. It originates from: <br/>
http://www.starling-software.com/en/employment/interview-process

Requirements
------------
* Java 8
* Maven 3.5.3

Testing
-------
####To run test with mutation and coverage calculation use:
~~~
$ mvn clean test -P pitest
~~~
####To run findbugs use:
~~~
$ mvn clean compile -P findbugs
~~~

Build
-----
####To build artifact run:
~~~
$ mvn clean package
~~~

Run
---
### after that you can run app using:
~~~
$ java -jar core/target/animals.jar -f <file>
~~~

