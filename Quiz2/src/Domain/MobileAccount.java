/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Clairette
 */
public class MobileAccount {
   private String phoneNumber;
   private Double mobileBalance;
   private Double airtimeBalance;
   private String ownerNames;
   private String description;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getMobileBalance() {
        return mobileBalance;
    }

    public void setMobileBalance(Double mobileBalance) {
        this.mobileBalance = mobileBalance;
    }

    public Double getAirtimeBalance() {
        return airtimeBalance;
    }

    public void setAirtimeBalance(Double airtimeBalance) {
        this.airtimeBalance = airtimeBalance;
    }

    public String getOwnerNames() {
        return ownerNames;
    }

    public void setOwnerNames(String ownerNames) {
        this.ownerNames = ownerNames;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
   
}
