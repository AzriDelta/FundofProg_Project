/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalassignment;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Daily {
    
    
    public Daily(Account[] Acct, int hold){
        int counter=0;
    
        
        try{
            Scanner s=new Scanner(new FileInputStream(Acct[hold].getName() + ".txt"));
            Scanner t=new Scanner(new FileInputStream(Acct[hold].getName() + ".txt"));
            
            //String[] s1=new String[];
            
            String a;
            
            
            while(s.hasNext()){
                a=s.next();
                counter++;
            }
            //System.out.println(counter);
            
        }catch(Exception e){
//******************************************************************************
                
            }
                try{
                    int no=counter/3;
                
                String[] date=new String[no];
              
                double[] income=new double[no];
                double[] expenses=new double[no];
                int i=0;
                Scanner t=new Scanner(new FileInputStream("Azri.txt"));
                while(t.hasNext()){
                date[i]=t.next();
                income[i]=t.nextDouble();
                expenses[i]=t.nextDouble();
                
                
                System.out.println(date[i]+"  "+income[i]+"  "+expenses[i]);
                //System.out.println(income[i]);
                //System.out.println(expenses[i]);
                i++;
            }
                double amount=0;
                double amount1=0;
                
                
                System.out.println("***Income***");
                for(int j=0;j<income.length;j++){
                    System.out.println(income[j]);
                    
                    amount+=income[j];
                    
                    
                }
                
                System.out.println("***Expenses***");
                for(int k=0;k<expenses.length;k++){
                    System.out.println(expenses[k]);
                    amount1+=expenses[k];
                }
                
                    System.out.println("Your Total Income : "+amount);
                    System.out.println("Your Total Expenses : "+amount1);
                    System.out.println("");
                
                
                 }catch(Exception e){
                
            }
            
            
            
        }
    
}
