# Lab Task 09 – Creational Design Patterns: The Singleton Pattern

## Objective
To understand and implement the Singleton design pattern in Java by ensuring that only one instance of a class is created and shared across different modules. The lab also demonstrates lazy initialization, shared state consistency, race conditions, and thread-safe object creation using Double-Checked Locking.

## Task 1 – Centralized Database Connection Manager
Implemented a Lazy Singleton class named `DatabaseConnectionManager`. Its private constructor prevents external object creation, while the static `getInstance()` method ensures that only one instance is created. Three university modules, StudentPortal, FeeBillingService, and AttendanceTracker, use the same database manager. Reference equality, identity hash codes, and constructor count are used to verify the Singleton implementation.

## Task 2 – CampusPrint Spooler Queue
Implemented a Singleton class named `PrintSpooler` using a LinkedList-based FIFO queue. Two simulated laboratory clients, SoftwareLab1 and NetworkingLab2, submit print jobs to the same shared queue. The jobs are processed sequentially in First In, First Out order. Synchronized methods protect queue operations from concurrent modifications.

## Task 3 – Exposing and Fixing Race Conditions
First, implemented a naive Lazy Singleton named `NaiveAuditLogger` without synchronization. Five concurrent threads request its instance, demonstrating how multiple objects can be created due to a race condition.

Next, implemented a thread-safe `AuditLogger` using the volatile keyword and Double-Checked Locking with synchronization. The five threads receive the same object instance, demonstrating safe initialization under multithreading.

## Conclusion
The lab demonstrates how the Singleton design pattern helps control object creation and maintain shared resources. Lazy initialization avoids unnecessary object creation, shared state allows multiple modules to access the same resource, and Double-Checked Locking ensures thread-safe initialization. The implementation also highlights the importance of carefully managing global state and synchronization in multithreaded applications.
