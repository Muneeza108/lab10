/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */
public class SoftwareLab1 {

    public void submitJobs() {

        PrintSpooler spooler = PrintSpooler.getInstance();

        spooler.addPrintJob("SoftwareLab1", "JavaLab.pdf");
        spooler.addPrintJob("SoftwareLab1", "Assignment.docx");
    }
}
