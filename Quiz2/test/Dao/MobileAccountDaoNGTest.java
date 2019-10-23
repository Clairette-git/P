/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.MobileAccount;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Clairette
 */
public class MobileAccountDaoNGTest extends GenericTest{
    
    public MobileAccountDaoNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        executeOperation(MobileAccountTest.INSERT_ACCOUNTS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        executeOperation(MobileAccountTest.DELETE_ACCOUNTS);
    }

    @Test
    public void testCreateMobileAccount() throws Exception {
           MobileAccount acc=new MobileAccount();
      MobileAccountDao dao=new MobileAccountDao();
      double d=3000;
      double bal=4000;
        acc.setPhoneNumber("900");
        acc.setMobileBalance(d);
       acc.setAirtimeBalance(bal);
        acc.setOwnerNames("Uwishema");
        acc.setDescription("save");
       String msg= dao.createMobileAccount(acc);
        assertEquals(msg,"Account created");
    }

    @Test
    public void testAllAccounts() throws Exception {
    }

    @Test
    public void testBuyAirtime() throws Exception {
        String num="0788";
        double amount=2000;
        String msg=new MobileAccountDao().buyAirtime(num, amount);
        assertEquals(msg,"Airtime bought");
    }

    @Test
    public void testTransferMoney() throws Exception {
        String num="0788";
        String num2="0783";
        double amount=2000;
        String msg=new MobileAccountDao().transferMoney(num, num2, amount);
        assertEquals(msg,"Transfer successful");
    }

    @Test
    public void testCheckBalance() throws Exception {
        String phone="0788";
        Double balance=new MobileAccountDao().checkBalance(phone);
        assertEquals(2000.0,balance);
    }

    @Test
    public void testUpdateMoneyBalance() {
         String num="0788";
        double amount=4000;
        String msg=new MobileAccountDao().updateMoneyBalance(num, amount);
        assertEquals(msg,"Money updated");
    }
    

     @Test(expectedExceptions = RuntimeException.class)
    public void testCreateDuplicate() throws RuntimeException, AirtimeException{
        try {
              MobileAccount acc=new MobileAccount();
      MobileAccountDao dao=new MobileAccountDao();
     double d=3000;
      double bal=4000;
        acc.setPhoneNumber("0783");
       acc.setMobileBalance(d);
       acc.setAirtimeBalance(bal);
        acc.setOwnerNames("Uwishema");
            new MobileAccountDao().createMobileAccount(acc);
        } catch (SQLException ex) {
            Logger.getLogger(MobileAccountDaoNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
     @Test(expectedExceptions = AirtimeException.class)
    public void airtimNeg() throws AirtimeException,RuntimeException{
         try {
              MobileAccount acc=new MobileAccount();
      MobileAccountDao dao=new MobileAccountDao();
     double d=3000;
      double bal=-4000;
        acc.setPhoneNumber("999");
       acc.setMobileBalance(d);
       acc.setAirtimeBalance(bal);
        acc.setOwnerNames("Uwishema");
            new MobileAccountDao().createMobileAccount(acc);
        } catch (SQLException ex) {
            Logger.getLogger(MobileAccountDaoNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   @Test(expectedExceptions = AirtimeException.class)
    public void testTransferNeg() throws Exception {
        String num="0788";
        String num2="0788";
        double amount=2000;
        new MobileAccountDao().transferMoney(num, num2, amount);
      //  assertEquals(msg,"Transfer successful");
    }}