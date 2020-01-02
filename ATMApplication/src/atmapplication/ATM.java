/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapplication;

/**
 *
 * @author User
 */
public class ATM {
    private BankAccount[] bankObjects = new BankAccount[3];

    public ATM() {
    }
     
    public double checkAccountBalance(BankAccount bankObj) {
        if (bankObj != null) {
            return bankObj.getBalance();
        }
        return 0.0;
    }
    
    public int validateUsernameAndPassword(BankAccount[] bankArray, String accountNo, String password) {
        int counter = 0;
        for (BankAccount item: bankArray) {
            if (item.getAccountNo().equals(accountNo)) {
                if (item.getPassword().equals(password)) {
                return counter;
                } else {
                return -1;
                }
            } 
            counter++;
        }
        return -2;
    }
     
    public BankAccount setCurrentBankObject(BankAccount bankObj) {
        BankAccount bankaccount = new BankAccount();
        if (bankObj != null) {
        bankaccount = bankObj;
        }
        return bankObj;
    }
    
    public int withdrawCash(BankAccount bankObj, double amount) {
        if (bankObj != null && amount > 0.0) {
            if (bankObj.getBalance() >= amount) {
                bankObj.deductBalance(amount);
                return 1;                
            } else {
                return 0;
            }
        } else {
            return -1;
        }      
    }
    
    public int addCash(BankAccount bankObj, double amount) {
        if (bankObj != null) {
            if (amount <= 0.0) {
                return 0;
            } else {
                bankObj.addBalance(amount);
                return 1;
            }
        } else {
            return -2;
        }
    }
    
    public boolean changePassword(BankAccount bankObj, String newPassword) {
        if (bankObj != null) {
           bankObj.setPassword(newPassword);
           return true;
        } else {
            return false;
        }
    }
    
    public boolean validateChangePassword(String firstPassword, String secondPassword) {
        return firstPassword.equals(secondPassword);
    }
    
    public BankAccount[] instantiateBankAccountObjects() {
         BankAccount bankAccount1 = new BankAccount("2353535", "Password1", 200.0);
         BankAccount bankAccount2 = new BankAccount("5252525", "Password2", 300.0);
         BankAccount bankAccount3 = new BankAccount("7575757", "Password3", 999.0);
         bankObjects[0] = bankAccount1;
         bankObjects[1] = bankAccount2;
         bankObjects[2] = bankAccount3;   
         
         return bankObjects;
    }
}
