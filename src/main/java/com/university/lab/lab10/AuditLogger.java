/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */

public class AuditLogger {

    private static volatile AuditLogger instance;

    private AuditLogger() {
        System.out.println("Thread-Safe Logger Created!");
    }

    public static AuditLogger getInstance() {

        if (instance == null) {

            synchronized (AuditLogger.class) {

                if (instance == null) {
                    instance = new AuditLogger();
                }
            }
        }

        return instance;
    }
}