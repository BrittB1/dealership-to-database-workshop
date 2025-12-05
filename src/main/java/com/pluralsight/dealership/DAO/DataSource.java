package com.pluralsight.dealership.DAO;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {
    private static BasicDataSource bds;

    /*
    /static block: executed once; the first time class is loaded into memory
    sets up database connection once when the app starts.
     */
    static {
        bds = new BasicDataSource();
        bds.setUrl("jdbc:mysql://localhost:3306/disney_dealership");
        bds.setPassword("root");
    }

    public static BasicDataSource getBds() {
        return bds;
    }
}
