/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */

public class NaiveAuditLogger {

    private static NaiveAuditLogger instance;

    private NaiveAuditLogger() {
        System.out.println("Naive Logger Created!");
    }

    public static NaiveAuditLogger getInstance() {

        if (instance == null) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            instance = new NaiveAuditLogger();
        }

        return instance;
    }
}
