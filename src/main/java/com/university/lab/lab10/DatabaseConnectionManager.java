/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.lab.lab10;

/**
 *
 * @author natas
 */
public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instance;
    private static int constructorCount = 0;

    private DatabaseConnectionManager() {
        constructorCount++;
        System.out.println("Database Connection Created!");
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public void executeQuery(String moduleName, String sql) {
        System.out.println(moduleName + " executing: " + sql);
    }

    public static int getConstructorCount() {
        return constructorCount;
    }
}
