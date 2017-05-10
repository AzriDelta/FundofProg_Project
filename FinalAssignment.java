/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalassignment;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class FinalAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner a = new Scanner(System.in);
        
        char codeMenu = ' ';
        int hold = 0;
        int countLogin = 0;
        int exit = 0;
        int exit1 = 0;
        boolean condition = true;
        Account[] Acct = new Account[10];
        //boolean exitCondition''
        
        while (codeMenu != '5')
        {
            if (countLogin < 1)
            {
                Login(Acct);
                countLogin++;
            }
            
            
            codeMenu=Menu(); //showing the menu
            
            if (codeMenu == '1')
            {
                hold = Login(Acct);
            }
            
            else if(codeMenu == '2')
            {
                Asset(Acct, hold);
            }
            
            else if(codeMenu == '3')
            {
                Income(Acct, hold);
            }
            
            /*else if (codeMenu == '4')
            {
                Income(Acct, hold);
            } */
            
            else if (codeMenu == '4')
            {
                Report(Acct, hold);
            }
            
            
        }
        
        Exit(Acct);
        
        
        
        
        System.out.println("You have exited the program");
    }

    public static char Menu() //display menu
    {
        Scanner a = new Scanner(System.in);
        char codeMenu = ' ';
        
        
            System.out.println("------MENU------");
            System.out.println("1. Login");
            System.out.println("2. Asset");
            System.out.println("3. Income and Expenses");
            //System.out.println("4. Expense");
            System.out.println("4. Reporting");
            System.out.println("5. Exit");
            
            System.out.println("");
            System.out.print("Enter your choice: ");
            String hold = a.next();
            codeMenu = hold.charAt(0);
            
        //}
            
        
        return codeMenu;
    
    }
    
    public static int Login(Account Acct[]) //login module
    {
        Scanner a = new Scanner(System.in);
        int i=0;
        String codeLogin;
        char codeLogin1 = ' ';
        String [] name = new String [5];
        
        
        System.out.println("-----1. LOGIN-----");
        System.out.println("");
        
        try
        {
            Scanner scan = new Scanner (new FileInputStream("Account.txt"));
            
            System.out.println("---EXISTING ACCOUNT(S)---");
            System.out.println("No.\tName");
            
            
            while(scan.hasNextLine()) //ini untuk baca account dari Account.txt
            {
                String input = scan.nextLine();
                
                String[] parts = input.split("\t");
                name[i] = parts[0]; // 004
                double asset = Double.parseDouble(parts[1]);
                Acct[i] = new Account(name[i], asset);
                
                //System.out.print((i+1) + ")\t" + name[i] + "\t" + asset);
                System.out.print((i+1) + ")\t" + name[i]);
                System.out.println("");
                i++;

            }
            
            System.out.println("");
            System.out.println("");
            System.out.print("Choose which account to login: (enter 0 to create new account): ");
            codeLogin = a.next();
            codeLogin1 = codeLogin.charAt(0);
            
            if(codeLogin1 == '0') //to add new account
            {
                try
                {
                    PrintWriter outputStream = new PrintWriter(new FileOutputStream("Account.txt", true));
                    
                    System.out.println("");
                    System.out.print("Enter the name of the new account: ");
                    String nameHold = a.next();
                    //System.out.println("");
                    System.out.print("Enter the asset of the new account: ");
                    double assetHold = a.nextDouble();
                    
                    Acct[i] = new Account(nameHold, assetHold);
                    outputStream.print(nameHold + "\t" + assetHold);
                    //outputStream.println();
                    outputStream.close();
                    
                    PrintWriter outputStream1 = new PrintWriter(new FileOutputStream(nameHold +".txt")); //to create a new text file for account
                    //outputStream1.println(assetHold);
                    
                    outputStream1.close();
                }
                
                catch (IOException e) 
                {
                    System.out.println("Problem with file output"); 
                }
                System.out.println("");
            }
            
           
            System.out.println("");
            System.out.println("");
            scan.close();
        }
        
        catch (IOException e)
        {
            System.out.println("Problem with file output"); 
        }
        
        int return1 = Character.getNumericValue(codeLogin1);
        
        
        return (return1-1);
        
    }
    
    public static void Asset(Account Acct[], int hold)//utk asset module
    {
        System.out.println();
        System.out.println("-----2. ASSET-----");
        System.out.println("Your account: ");
        //System.out.println("Money:\t" + Acct[hold].getAsset());
        
        String [] asset = new String[10];
        int[] assetNum = new int [10];
        int i=0;
        
        try
        {
            Scanner a = new Scanner(new FileInputStream(Acct[hold].getName() + "Asset.txt"));
            Scanner kb = new Scanner(System.in);
            
            while (a.hasNext())
            {
                asset[i] = a.next();
                assetNum[i] = a.nextInt();
                
                i++;
            }
            
            for (int j=0; j<i; j++)
            {
                System.out.println((j+1) + ") " + asset[j] + "\t" + assetNum[j]);
            }
            System.out.println("");
            System.out.println("a. Add");
            System.out.println("b. Update");
            System.out.println("c. Delete");
            //System.out.println("d. Display Asset");
            System.out.println("d. Exit Asset");
            System.out.print("Enter your choice: ");
            String input1 = kb.next();
            char code = input1.charAt(0);
            
            if (code == 'a')
            {
                System.out.print("Enter the name of the new asset: ");
                String name = kb.next(); //nanti check yang ini
                kb.nextLine();
                System.out.print("Enter the price of the new asset: ");
                int quantity = kb.nextInt();
                
                asset[i] = name;
                assetNum[i] = quantity;
                
                System.out.println("");
                System.out.println("After update");
                for (int j=0; j <=i; j++)
                {
                    System.out.println((j+1) + ") " + asset[j] + "\t" + assetNum[j]);
                }

                PrintWriter print = new PrintWriter (new FileOutputStream(Acct[hold].getName() + "Asset.txt"));

                for (int j=0; j <=i; j++)
                {
                    print.println(asset[j] + "\t" + assetNum[j]);
                }


                a.close();
                print.close();
                
            }
            
            else if (code == 'b')
            {
                System.out.print("Enter the record you want to update (enter the number): ");
                int input = kb.nextInt();

                System.out.print("New name: ");
                String name = kb.next();

                System.out.print("New price: ");
                int quantity = kb.nextInt();

                //int input1 = input - 1;

                //for(int k = input; input < i; input++)
                //{
                    //date[input-1] = date[input];
                asset[input-1] = name;
                assetNum[input-1] = quantity;
                //}

                System.out.println("");
                System.out.println("After update");
                for (int j=0; j <i; j++)
                {
                    System.out.println((j+1) + ") " + asset[j] + "\t" + assetNum[j]);
                }

                PrintWriter print = new PrintWriter (new FileOutputStream(Acct[hold].getName() + "Asset.txt"));

                for (int j=0; j <i; j++)
                {
                    print.println(asset[j] + "\t" + assetNum[j]);
                }


                a.close();
                print.close();
            }
            
            else if (code == 'c')
            {
                System.out.print("Enter the record you want to delete: ");
                int input = kb.nextInt();

                //System.out.print("New name: ");
                //String name = kb.next();

                //System.out.print("New quantity: ");
                //int quantity = kb.nextInt();

                //int input1 = input - 1;

                //for(int k = input; input < i; input++)
                //{
                    //date[input-1] = date[input];
                    //asset[input-1] = a.next();
                for (int l=(input-1); l<(i-1); l++)
                {
                    asset[l] = asset[l+1];
                    assetNum[l] = assetNum[l+1];
                }

                System.out.println("");
                System.out.println("After update");
                for (int j=0; j <i-1; j++)
                {
                    System.out.println((j+1) + ") " + asset[j] + "\t" + assetNum[j]);
                }

                PrintWriter print = new PrintWriter (new FileOutputStream(Acct[hold].getName() + "Asset.txt"));

                for (int j=0; j <i-1; j++)
                {
                    print.println(asset[j] + "\t" + assetNum[j]);
                }


                a.close();
                print.close();
            }
            
            /* else if (code == 'd')
            {
                System.out.println("Current Asset:");
                for (int j=0; j <i-1; j++)
                {
                    System.out.println((j+1) + ") " + asset[j] + "\t" + assetNum[j]);
                }
                
            } */
            
            else if (code == 'd')
            {
                Menu();
            }
            
            else
                System.out.println("Error");
            
            
            a.close();
        }
        
        catch (Exception e)
        {
            
        }
        
        System.out.println();
        System.out.println();
    }
    
    public static void Income (Account Acct[], int hold) //utk income module
    {
        Scanner a = new Scanner(System.in);
        double income, expense;
        String date;
        
        try
        {
            
            PrintWriter outputStream = new PrintWriter (new FileOutputStream(Acct[hold].getName() + ".txt", true));
            BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
            
            
            System.out.println("");
            System.out.println("-----3. INCOME & EXPENSE-----");
             System.out.print("Enter the date (dd/mm): ");
            date=a.nextLine();
            System.out.print("Enter the Income: ");
            income = a.nextDouble();
            System.out.print("Enter the Expense: ");
            expense = a.nextDouble();
            a.nextLine();
           
            
            Acct[hold].Income(income);
            Acct[hold].Expense(expense);
            
            
            outputStream.print("\r\n" + date + "\t" + income + "\t" + expense);
 
            outputStream.close();
        }
        catch (IOException e)
        {
            System.out.println("Problem with file output"); 
        }
    }
    
    /* public static void Expense (Account Acct[], int hold) //utk expense module
    {
        Scanner a = new Scanner(System.in);
        double expense;
        String date;
        
        try
        {
            //Scanner inputStream = new Scanner(new FileInputStream(Acct[hold].getName() + ".txt"));
            PrintWriter outputStream = new PrintWriter (new FileOutputStream(Acct[hold].getName() + ".txt", true));
            
            
            System.out.println("");
            System.out.println("-----4. EXPENSE-----");
            System.out.print("Enter the EXPENSE: ");
            expense = a.nextDouble();
            a.nextLine();
            System.out.println("Enter the date: ");
            date=a.nextLine();
            
            Acct[hold].Expense(expense);
            
            outputStream.print("\r\n" + date + "\t" + "-" + expense);
           
            outputStream.close();
        }
        catch (IOException e)
        {
            System.out.println("Problem with file output"); 
        }
        
    } */
    
    public static void Report(Account[] Acct, int hold) //for reporting
    {
        Scanner kb = new Scanner (System.in);
        String input1;
        
        System.out.println("---4. REPORTING---");
        System.out.println("a. Daily");
        //System.out.println("b. Weekly");
        System.out.println("b. Monthly");
        System.out.println("c. Update");
        System.out.println("d. Delete");
        
        System.out.print("Enter your choice: ");
        input1 = kb.next();
        char choice = input1.charAt(0);
        
        if (choice == 'a')
        {
            Daily a=new Daily (Acct, hold);
        }
        
        /* else if (choice == 'b')
        {
            
        } */
        
        else if (choice == 'b')
        {
            Monthly c=new Monthly (Acct, hold);
        }
        
        else if (choice == 'c')
        {
            UpdateReport(Acct, hold);
        }
        
        else if (choice == 'd')
        {
            DeleteReport(Acct, hold);
            //Monthly c=new Monthly (Acct, hold);
        }
        
        else
        {
            System.out.println("Error");
            Menu();
        }       
        
        
        
        /* try
        {
            Scanner a = new Scanner(new FileInputStream(Acct[hold].getName() + ".txt"));
            String input;
            String [] date = new String[100];
            
            String [] transaction = new String[100];
            
            int i=0;
            
            outer:
            while(a.hasNextLine())
            {
                input = a.nextLine();
                
                if(input == null)
                {
                    break outer;
                }
                
                else
                {
                    String [] inputHold  = input.split("\t");

                    date[i] = inputHold[0];
                  
                    transaction[i] = inputHold[1];
               
                    i++;
                   
                }
            }
            
            System.out.println("i: " +i);
 
            outer1:
            for(int pass=1; pass<i; pass++)
            {
                for(int j=0; j<(i-1); j++)
                {
                  
                    if(date[j].compareToIgnoreCase(date[j+1]) > 0)
                    {


                        String holdDate = date[j];        
                        date[j] = date[j+1];  
                        date[j+1] = holdDate;

                        String holdTrans = transaction[j];
                        transaction[j] = transaction[j+1];
                        transaction[j+1] = holdTrans;

                    }
                }
            }
            System.out.println("");
            System.out.println("After sorting");
            
            for(int x=0; x<i; x++)
            {
                System.out.println(date[x] + "\t" + transaction[x]);
            }
            
            System.out.println("");
            System.out.println("");
            
            a.close();
        }
        
        catch (IOException e)
        {
            System.out.println("Problem with file output"); 
        }  */
    }
    
    public static void DeleteReport(Account[] Acct, int hold)
    {
        try
        {
            int i=0;
            Scanner a = new Scanner (new FileInputStream(Acct[hold].getName() + ".txt"));
            Scanner b = new Scanner(System.in);
            String[] date=new String[10];
            double[] income=new double[10];
            double[] expenses=new double[10];
            //String[] splitDate=new String[10];
            
            while(a.hasNext())
            {
                date[i]=a.next();
                income[i]=a.nextDouble();
                expenses[i]=a.nextDouble();
                
                i++;
                //System.out.println("Count:" + i);
            }
            //System.out.println("No.\tDate\tIncome\tExpense");
            
            for (int j=0; j <i; j++)
            {
                System.out.println((j+1)+ "\t" + date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            System.out.print("Enter the record you want to delete: ");
            int input = b.nextInt();
            
            int input1 = input - 1;
            
            for(int k = input; input < i; input++)
            {
                date[input-1] = date[input];
                income[input-1]=income[input];
                expenses[input-1]=expenses[input];
            }
            
            System.out.println("");
            System.out.println("After delete");
            for (int j=0; j <i-1; j++)
            {
                System.out.println((j+1)+ "\t" + date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            PrintWriter print = new PrintWriter (new FileOutputStream(Acct[hold].getName() + ".txt"));
            
            for (int j=0; j <i-1; j++)
            {
                print.println(date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            
            a.close();
            print.close();
        }
        
        catch (Exception e)
        {
            
        }
    }
    
    public static void UpdateReport(Account Acct [], int hold)
    {
        try
        {
            int i=0;
            Scanner a = new Scanner (new FileInputStream(Acct[hold].getName() + ".txt"));
            Scanner b = new Scanner(System.in);
            String[] date=new String[10];
            double[] income=new double[10];
            double[] expenses=new double[10];
            //String[] splitDate=new String[10];
            
            while(a.hasNext())
            {
                date[i]=a.next();
                income[i]=a.nextDouble();
                expenses[i]=a.nextDouble();
                
                i++;
                //System.out.println("Count:" + i);
            }
            //System.out.println("No.\tDate\tIncome\tExpense");
            
            for (int j=0; j <i; j++)
            {
                System.out.println((j+1)+ "\t" + date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            System.out.print("Enter the record you want to update (enter the number): ");
            int input = b.nextInt();
            
            System.out.print("New income: ");
            double newInc = b.nextDouble();
            
            System.out.print("New expenses: ");
            double newExp = b.nextDouble();
            
            //int input1 = input - 1;
            
            //for(int k = input; input < i; input++)
            //{
                //date[input-1] = date[input];
                income[input-1]=newInc;
                expenses[input-1]=newExp;
            //}
            
            System.out.println("");
            System.out.println("After update");
            for (int j=0; j <i; j++)
            {
                System.out.println((j+1)+ "\t" + date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            PrintWriter print = new PrintWriter (new FileOutputStream(Acct[hold].getName() + ".txt"));
            
            for (int j=0; j <i; j++)
            {
                print.println(date[j] + "\t" + income[j] + "\t" + expenses[j]);
            }
            
            
            a.close();
            print.close();
        }
        
        catch (Exception e)
        {
            
        }
    }
    
    
    public static void Exit(Account Acct[]) //untuk update file Account sebelum exit
    {
        int i=0;
        
        try
        {
            Scanner scan = new Scanner (new FileInputStream("Account.txt"));
        
            while(scan.hasNextLine())
            {
                String input = scan.nextLine();
                
                 i++;

            }
            
            
            PrintWriter outputStream = new PrintWriter (new FileOutputStream("Account.txt"));
            
            for (int j=0; j<i; j++)
            {
                outputStream.println(Acct[j].getName() + "\t" + Acct[j].getAsset()); //BUG LOOP INFINITELY BILA i=1, condition dalam for (int j=0) jadi bengong
                //outputStream.println();
            }
            
            //System.out.println("1111");
            scan.close();
            outputStream.close();
        }
        
        catch (IOException e)
        {
            System.out.println("Problem with file output"); 
        }
        
        //exit();
        
        //return 1;
        //System.out.println();
        //System.out.println("Aku dah keluar");
        //return 1;
        
    }
    
    
}
