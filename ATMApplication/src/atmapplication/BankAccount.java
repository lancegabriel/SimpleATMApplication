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

public class BankAccount {
    private String accountNo;
    private String password;
    private double balance;

    public BankAccount() { }
    public BankAccount(String accountNo, String password, double balance) {
        this.accountNo = accountNo;
        this.password = password;
        this.balance = balance;
    }
    
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
   
    public void deductBalance(double balance) {
        this.balance -= balance;
    }
    
    public void addBalance(double balance) {
        this.balance += balance;
    }
}
