/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Clairette
 */
public class GenericTest {
       public void executeOperation(Operation op) throws SQLException{
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
DriverManagerDestination driver=new DriverManagerDestination("jdbc:mysql://localhost:3306/AccountDatabase","root","marcletty");
        DbSetup ds=new DbSetup(driver, op);
        ds.launch();
    }
}
