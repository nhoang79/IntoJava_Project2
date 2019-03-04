import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Project 2:
 *      #11. Deposits and Withdrawal Files
 *      #14. FileDisplay Class
 * @author Ngan
 */
public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {
      
     /** #11 Deposits and Withdrawal Files 
     *   1. Create a Deposits file & write four deposits amount into file
     *   2. Create a Withdrawal file & write four withdrawals amount into file
     */ 
        
        //Creating a file called Deposits
            PrintWriter depositsFile = new PrintWriter("Deposits.txt");
        
        /** Writing four amount of deposits 
        * that were made into saving account during 
        * the month into Deposits file
        */
            depositsFile.println("100.00");
            depositsFile.println("125.00");
            depositsFile.println("78.92");
            depositsFile.println("37.55");
        
        //Closing the Deposit file
            depositsFile.close();
        
        //Creating a file called Withdrawals
            PrintWriter withdrawalsFile = new PrintWriter("Withdrawls.txt");
        
        /** Writing four amount of withdrawals
        * that were made into saving account during 
        * the month into Deposits file
        */
            withdrawalsFile.println("29.88");
            withdrawalsFile.println("110.00");
            withdrawalsFile.println("27.52");
            withdrawalsFile.println("50.00");
            withdrawalsFile.println("12.90");
        
        //Closing the Withdrawals file
            withdrawalsFile.close();
       
       //Creating an instance of SavingsAccount & set starting balance to $500
       SavingsAccount userAccount = new SavingsAccount(500.00,5.0);
       
       
       //Data Fields
       double startingBalance = 500.00;
       double yearlyIntRate = 5.0;
       double depositsValue;
       double withdrawalValue;
       double balance;
       
        //Open Deposits file
       File myFile = new File("Deposits.txt");
       
       //Create a Scanner object to read values from Deposits file
       Scanner deposits = new Scanner(myFile);
       
       while (deposits.hasNext())
       {
          depositsValue = deposits.nextDouble();
          userAccount.set_depositAmount(depositsValue);
       }
       
       //Closing Deposits file
       deposits.close();
       
        //Open Withdrawals file
       File myWithdrawal = new File("Withdrawls.txt");
       
       //Create a Scanner object to read values from Withdrawals file
       Scanner withdrawals = new Scanner(myWithdrawal);
       
       while (withdrawals.hasNext())
       {
           withdrawalValue = withdrawals.nextDouble();
           userAccount.set_withdrawalAmount(withdrawalValue);
       }
       //Closing withdrawal file
       withdrawals.close();
       
       userAccount.calcMonthlyInterestRate(yearlyIntRate/12);
      
       //Displaying results
       System.out.print("The ending balance is: $");
       userAccount.showResult();

       //To make output's window easier to see
             System.out.print("\n");
        
        
        //Output Format
        System.out.println("The output below are for #14 \n");
             
/** #14 Testing FileDisplay Class
*/
        
        //Create a text file to test fileDisplay class
        PrintWriter textFile = new PrintWriter("TextFile.txt");
        
        //Writing into file
        textFile.println("Me Before You");
        textFile.println("The Hunger Games");
        textFile.println("Wonder Woman");
        textFile.println("It");
        textFile.println("Jumanji: Welcome To The Jungle");
        textFile.println("Stranger Things");
        textFile.println("Gotham");
        textFile.println("The Flash");
        
        //Close textFile
        textFile.close();
        
        //Creating an instance of FileDisplay class
        FileDisplay fileName = new FileDisplay("textFile.txt");
        
        //Testing displayHead method
        System.out.println("Displaying first five lines "
                            + "of contents from TextFile: ");
        fileName.displayHead();
        
        //Output Format
        System.out.print("\n");
        
        //Testing displayContents method
        System.out.println("Displaying all contents from TextFile: ");
        fileName.displayContents();
        
        //Output Format
        System.out.print("\n");
        
        //Testing displayWithLineNumbers method
        System.out.println("Displaying contents from textFile with sequence"
                + " number that is followed by a colin");
        fileName.displayWithLineNumbers();
       
    }
    
}
