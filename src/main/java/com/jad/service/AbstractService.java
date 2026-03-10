package com.jad.service;

import com.jad.connector.DBConnector;
import lombok.Getter;

import java.sql.Statement;

abstract class AbstractService {
    @Getter
    private final DBConnector dbConnector;

    AbstractService(final DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    protected Statement getStatement() {
        return this.dbConnector.getStatement();
    }

}