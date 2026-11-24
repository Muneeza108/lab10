/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */

public class NetworkingLab2 {

    public void submitJobs() {

        PrintSpooler spooler = PrintSpooler.getInstance();

        spooler.addPrintJob("NetworkingLab2", "NetworkReport.pdf");
    }
}