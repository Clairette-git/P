/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 *
 * @author Clairette
 */
public class MobileAccountTest {
    public static Operation INSERT_ACCOUNTS =
            Operations.insertInto("MobileAccount")
            .columns("phone","mobileBalance","airtimeBalance","ownerNames","description")
                   .values("0788",10000,2000,"Muhorakeye","save")
                .values("0783",15000,3000,"Uwishema","save").build();
    
    public static Operation DELETE_ACCOUNTS =
            Operations.deleteAllFrom("MobileAccount");
}
