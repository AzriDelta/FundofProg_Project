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
public class Monthly {
    
    public Monthly(Account[] Acct, int hold){
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
                
                double amount=0;
                double amount1=0;
                String[] sd;
                double JanExp = 0, JanInc = 0,FebInc=0,FebExp=0,MarchInc=0,MarchExp=0,AprilInc=0,AprilExp=0,MayInc=0,MayExp=0,JuneInc=0,JuneExp=0;
                double JulyInc=0,JulyExp=0,AugustInc=0,AugustExp=0,SeptInc=0,SeptExp=0,OctInc=0,OctExp=0,NovInc=0,NovExp=0,DecInc=0,DecExp=0;
                
                while(t.hasNext()){
                date[i]=t.next();
                income[i]=t.nextDouble();
                expenses[i]=t.nextDouble();
                
                
                sd=date[i].split("/");
                //System.out.println(sd[1]);
               // double c=Double.parseDouble(sd[1]);
                
                
                
                if(sd[1].equals("01")){
                    //amount+=income[i];
                    JanInc +=income[i];
                    JanExp += expenses[i];
                    //amount1+=expenses[i];
                    //System.out.println("January:\nIncome:"+amount+"\nExpenses:"+amount1);
                    
                    continue;
                }
                else if(sd[1].equals("02")){
                    FebInc+=income[i];
                    FebExp+=expenses[i];
                    //System.out.println("FEBRUARY:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }
                else if(sd[1].equals("03")){
                    MarchInc+=income[i];
                    MarchExp+=expenses[i];
                    //System.out.println("March:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }
                else if(sd[1].equals("04")){
                    AprilInc+=income[i];
                    AprilExp+=expenses[i];
                    //System.out.println("April:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }
                else if(sd[1].equals("05")){
                    MayInc+=income[i];
                    MayExp+=expenses[i];
                    //System.out.println("May:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }
                else if(sd[1].equals("06")){
                    JuneInc+=income[i];
                    JuneExp+=expenses[i];
                    //System.out.println("June:\nIncome:"+amount+"\nExpenses:"+amount1);
                   continue;
                    
                }
                else if(sd[1].equals("07")){
                    JulyInc+=income[i];
                    JulyExp+=expenses[i];
                    //System.out.println("July:\nIncome:"+amount+"\nExpenses:"+amount1);
                   continue;
                    
                }
                else if(sd[1].equals("08")){
                    AugustInc+=income[i];
                    AugustExp+=expenses[i];
                    //System.out.println("August:\nIncome:"+amount+"\nExpenses:"+amount1);
                   continue;
                    
                }else if(sd[1].equals("09")){
                    SeptInc+=income[i];
                    SeptExp+=expenses[i];
                    //System.out.println("September:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }else if(sd[1].equals("10")){
                    OctInc+=income[i];
                    OctExp+=expenses[i];
                    //System.out.println("October:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }else if(sd[1].equals("11")){
                    NovInc+=income[i];
                    NovExp+=expenses[i];
                    //System.out.println("November:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }else if(sd[1].equals("12")){
                    DecInc+=income[i];
                    DecExp+=expenses[i];
                    //System.out.println("December:\nIncome:"+amount+"\nExpenses:"+amount1);
                    continue;
                    
                }
                else {
                    break;
                }

                
                
               //i++;
            }
                    System.out.println("January:\nIncome:" + JanInc + "\nExpenses:" + JanExp);
                    System.out.println();
                    System.out.println("FEBRUARY:\nIncome:" + FebInc + "\nExpenses:" + FebExp);
                    System.out.println();
                    System.out.println("March:\nIncome:" + MarchInc + "\nExpenses:" + MarchExp);
                    System.out.println();
                    System.out.println("April:\nIncome:" + AprilInc + "\nExpenses:" + AprilExp);
                    System.out.println();
                    System.out.println("May:\nIncome:" + MayInc + "\nExpenses:" + MayExp);
                    System.out.println();
                    System.out.println("June:\nIncome:" + JuneInc + "\nExpenses:" + JuneExp);
                    System.out.println();
                    System.out.println("July:\nIncome:" + JulyInc + "\nExpenses:" + JulyExp);
                    System.out.println();
                    System.out.println("August:\nIncome:" + AugustInc + "\nExpenses:" + AugustExp);
                    System.out.println();
                    System.out.println("September:\nIncome:" + SeptInc + "\nExpenses:" + SeptExp);
                    System.out.println();
                    System.out.println("October:\nIncome:" + OctInc + "\nExpenses:" + OctExp);
                    System.out.println();
                    System.out.println("November:\nIncome:" + NovInc + "\nExpenses:" + NovExp);
                    System.out.println();
                    System.out.println("December:\nIncome:" + DecInc + "\nExpenses:" + DecExp);
                    System.out.println("");
                //i++;
                //System.out.println(amount);
}catch(Exception e){
    
}
    }
}