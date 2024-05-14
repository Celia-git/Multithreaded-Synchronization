# Multithreaded-Synchronization
@author Celia Hough<br>  
Original Java OOP written for Intro to Operating Systems class.
Multithreaded program which uses reentrant lock to simulate traffic across a one lane bridge.
Cars inherit thread; Main creates simultaneous Eastbound and Westbound traffic by starting new threads.
Bridge class uses synchronization to simulate crossing.<br>  
## To Run in CLI
- clone the repo and navigate to its folder
- compile Java code in one line<br>  
  -ie, on Windows:
  ```
  javac Main.java Bridge.java Car.java
  ```
- run Main<br>  
  -ie, on Windows:
  ```
  java Main
  ```
