/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // TASK 1: Database Connection Manager
        System.out.println("\n===== TASK 1: DATABASE SINGLETON =====");

        DatabaseConnectionManager db1 =
                DatabaseConnectionManager.getInstance();

        DatabaseConnectionManager db2 =
                DatabaseConnectionManager.getInstance();

        DatabaseConnectionManager db3 =
                DatabaseConnectionManager.getInstance();

        System.out.println("StudentPortal Hash: "
                + System.identityHashCode(db1));

        System.out.println("FeeBillingService Hash: "
                + System.identityHashCode(db2));

        System.out.println("AttendanceTracker Hash: "
                + System.identityHashCode(db3));

        db1.executeQuery("StudentPortal", "SELECT * FROM Students");
        db2.executeQuery("FeeBillingService", "SELECT * FROM Fees");
        db3.executeQuery("AttendanceTracker", "SELECT * FROM Attendance");

        System.out.println("db1 == db2: " + (db1 == db2));
        System.out.println("db2 == db3: " + (db2 == db3));

        System.out.println("Constructor Count: "
                + DatabaseConnectionManager.getConstructorCount());


        // TASK 2: Campus Print Spooler
        System.out.println("\n===== TASK 2: PRINT SPOOLER =====");

        SoftwareLab1 lab1 = new SoftwareLab1();
        NetworkingLab2 lab2 = new NetworkingLab2();

        lab1.submitJobs();
        lab2.submitJobs();

        PrintSpooler spooler1 = PrintSpooler.getInstance();
PrintSpooler spooler2 = PrintSpooler.getInstance();

System.out.println("Spooler 1 Hash: "
        + System.identityHashCode(spooler1));

System.out.println("Spooler 2 Hash: "
        + System.identityHashCode(spooler2));

System.out.println("Same Spooler: "
        + (spooler1 == spooler2));

PrintSpooler spooler = spooler1;

        System.out.println("Total Pending Jobs: "
                + spooler.getPendingJobCount());

        System.out.println("\nProcessing Jobs in FIFO Order:");

        while (spooler.getPendingJobCount() > 0) {
            spooler.processNextJob();
        }

        System.out.println("Remaining Jobs: "
                + spooler.getPendingJobCount());


        // TASK 3A: Naive Singleton
        System.out.println("\n===== TASK 3A: NAIVE SINGLETON =====");

        CountDownLatch naiveReady = new CountDownLatch(5);
        CountDownLatch naiveStart = new CountDownLatch(1);

        Thread[] naiveThreads = new Thread[5];

        for (int i = 0; i < 5; i++) {

            naiveThreads[i] = new Thread(() -> {

                naiveReady.countDown();

                try {
                    naiveStart.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                NaiveAuditLogger logger =
                        NaiveAuditLogger.getInstance();

                System.out.println(Thread.currentThread().getName()
                        + " Hash: "
                        + System.identityHashCode(logger));

            }, "Naive-Thread-" + (i + 1));

            naiveThreads[i].start();
        }

        naiveReady.await();
        naiveStart.countDown();

        for (Thread t : naiveThreads) {
            t.join();
        }


        // TASK 3B: Thread-Safe Singleton
        System.out.println("\n===== TASK 3B: THREAD-SAFE SINGLETON =====");

        CountDownLatch safeReady = new CountDownLatch(5);
        CountDownLatch safeStart = new CountDownLatch(1);

        Thread[] safeThreads = new Thread[5];

        for (int i = 0; i < 5; i++) {

            safeThreads[i] = new Thread(() -> {

                safeReady.countDown();

                try {
                    safeStart.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                AuditLogger logger = AuditLogger.getInstance();

                System.out.println(Thread.currentThread().getName()
                        + " Hash: "
                        + System.identityHashCode(logger));

            }, "Safe-Thread-" + (i + 1));

            safeThreads[i].start();
        }

        safeReady.await();
        safeStart.countDown();

        for (Thread t : safeThreads) {
            t.join();
        }

        System.out.println("\n===== ALL TASKS COMPLETED =====");
    }
}
