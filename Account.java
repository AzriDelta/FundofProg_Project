/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalassignment;

/**
 *
 * @author USER
 */
public class Account {
     private String name;
    private double asset;

    public Account(String name, double asset) {
        this.name = name;
        this.asset = asset;
    }

    public String getName() {
        return name;
    }

    public double getAsset() {
        return asset;
    }

    public void Income(double income)
    {
        asset = asset + income;
    }
    
    public void Expense(double expense)
    {
        asset = asset - expense;
    }

    @Override
    public String toString() {
        return "Account{" + "name=" + name + ", asset=" + asset + '}';
    }
    
}
