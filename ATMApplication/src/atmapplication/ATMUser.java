/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapplication;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class ATMUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount[] bankObjects = null;
        ATM atm = new ATM();
        bankObjects = atm.instantiateBankAccountObjects(); 
        String accountNo = JOptionPane.showInputDialog(null, "Please enter your bank account number.", "ATM", JOptionPane.QUESTION_MESSAGE);
        String password = JOptionPane.showInputDialog(null, "Please enter your password.", "ATM", JOptionPane.QUESTION_MESSAGE);
        
        int result = atm.validateUsernameAndPassword(bankObjects, accountNo, password);
        if (result == -1) {
            JOptionPane.showMessageDialog(null, "Invalid password, please reenter!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (result == -2) {
            JOptionPane.showMessageDialog(null, "Invalid account number, please reenter!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String option = "-1";
            do {
                BankAccount object = new BankAccount();
                object = atm.setCurrentBankObject(bankObjects[result]);
                option = JOptionPane.showInputDialog(null, "Enter your option:\n\n"
                        + "1. Check the balance\n"
                        + "2. Withdraw\n"
                        + "3. Deposit Cash\n"
                        + "4. Change Password\n"
                        + "5. Exit","ATM", JOptionPane.QUESTION_MESSAGE);
                switch(option) {
                    case "1":
                        double balance = object.getBalance();
                        JOptionPane.showMessageDialog(null, "Balance: $"+ balance);
                        break;
                    case "2":
                        while (true) {
                        String amount1 = JOptionPane.showInputDialog(null, "Please enter the amount to withdraw: (Balance: $"+object.getBalance()+")", "ATM", JOptionPane.QUESTION_MESSAGE);
                        try {
                        double amt1 = Double.parseDouble(amount1);
                        int withdrawResults = atm.withdrawCash(object, amt1);
                        if (withdrawResults == 1) {
                            JOptionPane.showMessageDialog(null, "New balance: $"+object.getBalance());
                            break;
                        } else if (withdrawResults == 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount!! The amount to withdraw must be greater than 0 and less than $"+object.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid amount!! The amount to withdraw must be greater than 0 and less than $"+object.getBalance());

                        }                     
                        } catch(NumberFormatException e) {
                         JOptionPane.showMessageDialog(null, "Invalid number, please reenter!", "Error", JOptionPane.ERROR_MESSAGE);   
                         }
                        }
                         break;
                    case "3":
                        while (true) {
                        String amount2 = JOptionPane.showInputDialog(null, "Please enter the amount to deposit: (Balance: $"+object.getBalance()+")", "ATM", JOptionPane.QUESTION_MESSAGE);
                        try {
                        double amt2 = Double.parseDouble(amount2);
                        int depositResults = atm.addCash(object, amt2);
                        if (depositResults == 1) {
                           JOptionPane.showMessageDialog(null, "New balance:$"+object.getBalance()); 
                           break;
                        } else if (depositResults == 0) {
                             JOptionPane.showMessageDialog(null, "Invalid amount!! The amount to be deposit must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);  
                        }  else {
                             JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);  
                        }        
                        } catch(NumberFormatException e) {
                         JOptionPane.showMessageDialog(null, "Invalid number, please reenter!", "Error", JOptionPane.ERROR_MESSAGE);   
                        }    
                        }
                    break;
                    case "4":
                        String firstPassword = JOptionPane.showInputDialog(null, "Please enter the new password:", "ATM", JOptionPane.QUESTION_MESSAGE);
                        if (firstPassword.length() > 0) {
                            String secondPassword = JOptionPane.showInputDialog(null, "Please reenter the new password:", "ATM", JOptionPane.QUESTION_MESSAGE);
                            if (secondPassword.length() > 0) {
                                 if (atm.validateChangePassword(firstPassword, secondPassword)) {
                                     boolean changePasswordResults = atm.changePassword(object, firstPassword);
                                     if (changePasswordResults) {
                                         JOptionPane.showMessageDialog(null, "Password changed.", "ATM", JOptionPane.QUESTION_MESSAGE);
                                     } else {
                                         JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);   
                                     }
                                 } else {
                                     JOptionPane.showMessageDialog(null, "Password does not match.", "Error", JOptionPane.ERROR_MESSAGE);   
                                 }                               
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a password.", "Error", JOptionPane.ERROR_MESSAGE);   
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a password.", "Error", JOptionPane.ERROR_MESSAGE);   
                        }
                    break;
                    case "5":
                        break;
                    default:
                         JOptionPane.showMessageDialog(null, "Invalid option!! Please enter in the range from 1 to 5.", "Error", JOptionPane.ERROR_MESSAGE);   
                         break;
                }
        } while(!option.equals("5"));
     }
    }
}
