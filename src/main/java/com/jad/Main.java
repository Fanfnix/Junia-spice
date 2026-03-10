package com.jad;

import com.jad.connector.DBConnector;
import com.jad.service.MachineToolService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MachineToolService machineToolService = new MachineToolService(DBConnector.getInstance());
        machineToolService.getAll().forEach(System.out::println);
    }
}