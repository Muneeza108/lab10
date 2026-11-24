/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {

    private static PrintSpooler instance;

    private Queue<String> printQueue;

    private PrintSpooler() {
        printQueue = new LinkedList<>();
    }

    public static PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public synchronized void addPrintJob(
            String labName, String documentName) {

        String job = labName + " - " + documentName;
        printQueue.add(job);

        System.out.println("Added: " + job);
    }

    public synchronized void processNextJob() {

        if (!printQueue.isEmpty()) {
            System.out.println("Processing: " + printQueue.poll());
        } else {
            System.out.println("No pending jobs.");
        }
    }

    public synchronized int getPendingJobCount() {
        return printQueue.size();
    }
}
