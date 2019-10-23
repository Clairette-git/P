/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.MobileAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clairette
 */
public class MobileAccountDao {
    public String createMobileAccount(MobileAccount acc) throws SQLException, AirtimeException{
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDatabase","root","marcletty");
            PreparedStatement ps=con.prepareStatement("insert into MobileAccount(phone,mobileBalance,airtimeBalance,ownerNames,description) values(?,?,?,?,?)");
           ps.setString(1,acc.getPhoneNumber());
           ps.setDouble(2,acc.getMobileBalance());
          if(acc.getAirtimeBalance()<0){
          throw new AirtimeException("");
          }
           ps.setDouble(3,acc.getAirtimeBalance());
          ps.setString(4,acc.getOwnerNames());
           ps.setString(5,acc.getDescription());
          
            ps.execute();
            con.close();
            return "Account created";
        }  catch (SQLException ex) {
           throw new RuntimeException("");
        }
        
    }
   
 public List <MobileAccount> AllAccounts() throws SQLException{
    List<MobileAccount> accounts = new ArrayList<>();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDatabase", "root", "marcletty");
        PreparedStatement ps=con.prepareStatement("select * from MobileAccount");
        ResultSet rs=ps.executeQuery();
         while(rs.next()){
              MobileAccount acc = new MobileAccount();
              acc.setPhoneNumber(rs.getString("phone"));
              acc.setMobileBalance(rs.getDouble("mobileBalance"));
              acc.setAirtimeBalance(rs.getDouble("airtimeBalance"));
              acc.setOwnerNames(rs.getString("ownerNames"));
              acc.setDescription(rs.getString("description"));
              accounts.add(acc);
          }      
    return accounts;
}
  
  
    public String buyAirtime(String phoneNumber,double amount) throws SQLException{
        List<MobileAccount> acc = AllAccounts();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDatabase","root","marcletty");
        PreparedStatement ps=con.prepareStatement("update MobileAccount set airtimeBalance=? where phone=?");
        for(MobileAccount acc1 : acc){
            if(acc1.getPhoneNumber().matches(phoneNumber))
      {
        double balance=acc1.getAirtimeBalance()+amount;
        ps.setDouble(1, balance);
        ps.setString(2,acc1.getPhoneNumber());
        ps.execute();
        con.close();
        
        }
        }
        return "Airtime bought";
    }  
    
    public String transferMoney(String phoneNumber1,String phoneNumber2,double transfer) throws SQLException, AirtimeException{
 List<MobileAccount> acc = AllAccounts();
 if(phoneNumber1==phoneNumber2){
 throw new AirtimeException("No similar");
 }
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDatabase","root","marcletty");
        for (MobileAccount acc1 : acc) {
            
            if (acc1.getPhoneNumber().matches(phoneNumber1)) {
                double balance = acc1.getMobileBalance() - transfer;
                PreparedStatement ps=con.prepareStatement("update MobileAccount set mobileBalance=? where phone=?");
                ps.setDouble(1,balance);
                ps.setString(2, acc1.getPhoneNumber());
                ps.execute();}
                if(acc1.getPhoneNumber().matches(phoneNumber2)){
              double bal=acc1.getMobileBalance()+transfer;
              PreparedStatement p=con.prepareStatement("update MobileAccount set mobileBalance=? where phone=?");
                p.setDouble(1, bal);
                p.setString(2, acc1.getPhoneNumber());
                p.execute();
              }
               
            
        }
         con.close();
    return "Transfer successful";
    }
    
    public Double checkBalance(String phoneNumber) throws SQLException{
        
        List<MobileAccount> acc=AllAccounts();
        double balance=0;
   for(MobileAccount acc1 : acc){
    if(acc1.getPhoneNumber().matches(phoneNumber)){
   
    balance=acc1.getAirtimeBalance();
    }
    }
     return balance ;
    
    }
     public String updateMoneyBalance(String phone,double amount){
        String message="Money updated"; 
       try {
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDatabase", "root", "marcletty");
            PreparedStatement ps=con.prepareStatement("update Student set mobileBalance=? where phone= ?");
           ps.setDouble(1,amount);
            ps.setString(2,phone);
          ps.execute();
            con.close();
              } catch (SQLException ex) {
          
        }
         return message;
   }
        public Boolean validateairtime(MobileAccount acc){
   int count=0;
   if(acc.getAirtimeBalance()<0){
   count ++;
   
   }
   if(count == 0){
   return false;
   
   }else{
   return true;
   }
   }
     
   }

