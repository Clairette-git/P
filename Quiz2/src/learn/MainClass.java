/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import Dao.MobileAccountDao;
import Domain.MobileAccount;
import java.sql.SQLException;

/**
 *
 * @author Clairette
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        MobileAccount acc=new MobileAccount();
      MobileAccountDao dao=new MobileAccountDao();
      double d=3000;
      double bal=4000;
//        acc.setPhoneNumber("123");
//        acc.setMobileBalance(d);
//       acc.setAirtimeBalance(bal);
//        acc.setOwnerNames("Uwishema");
//        acc.setDescription("save");
       // dao.createMobileAccount(acc);
   
      double balance= dao.checkBalance("123");
        System.out.println(balance);
    }
    
}
