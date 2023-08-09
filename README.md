Calculator App
This is a simple calculator application written in Java 17, featuring a graphical user interface for performing arithmetic and trigonometric calculations.

Prerequisites
Java 17
Getting Started
Clone this repository to your local machine.
Compile and run the MainApp class to launch the calculator application.
bash
Copy code
javac MainApp.java
java MainApp
Testing
The program's functionality has been tested using JUnit Jupiter, a testing framework for Java. You can find the test cases in the respective package within the test directory.

To run the tests:

bash
Copy code
javac -cp junit-platform-console-standalone-<version>.jar:. TestPackageName.java
java -jar junit-platform-console-standalone-<version>.jar --class-path . --scan-class-path
Code Quality
The codebase adheres to SOLID principles and maintains a clean architecture. However, there are minor code smells related to duplicated code in some parts of the program. Overall, the codebase is well-organized and follows best practices.

