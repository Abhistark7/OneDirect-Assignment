# ASSIGNMENT #4

# Topics Covered: Java Multithreading.
 
Develop a multi-threaded java program where one thread reads the data from the database say, details of an Item from an mysql table. This thread builds an in-memory object, stores it in a collection. Simultaneously another thread should fetch already created Item objects from this collection and calculate the tax as per rules detailed in assignment#1 update the tax value in appropriate Item attribute and store it in a different collection. Finally print out the item details to console as detailed in assignment #1.
 
Implement such that the performance is optimal and thread race/dead lock is avoided.
 
Real Life Scenario:
Producer consumer mechanism.
 
Key Points:
Please make sure your database is setup and you are able to access it before starting with implementation of this assignment.
Use Java’s multithreading support for implementation.
Proper validation / info messages should be thrown on console where ever required.
Do appropriate exception handling where ever required.
Where ever required please write comments in the code to make it more understandable.
TDD methodology should be used
