package com.aim.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

    public static void main(String[] args){

        DatabaseConnectionManager dcm = new DatabaseConnectionManager(
                "localhost",
                "hplussport",
                "postgres",
                "password"
        );
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);

            Customer customer = new Customer();
            customer.setFirstName("George");
            customer.setLastName("Washington");
            customer.setEmail("gwashington@wh.gov");
            customer.setAddress("555 5555 555");
            customer.setCity("Mavleb");
            customer.setState("MV");
            customer.setPhone("980 (78767) 0000");
            customer.setZipCode("hjajdsjgjsgjs");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);

            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);

            dbCustomer.setEmail("john.adams@wg.gov");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);

            customerDAO.delete(dbCustomer.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
