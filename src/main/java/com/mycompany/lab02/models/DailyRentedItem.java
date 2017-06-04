/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab02.models;

import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class DailyRentedItem extends Item {
    
    public DailyRentedItem(String name, BigDecimal dailyPrice){ // FIXME move this constructor to the super class
        super(name, dailyPrice);
    }
    
    @Override
    public BigDecimal getPriceForPeriod(int numberOfDays) {
        return super.getPeriodPrice().multiply(BigDecimal.valueOf(numberOfDays));
    }
    
    @Override
    public String toString(){
        String result = "";
        result += "Item name: \t\t" + super.getName() + " \n";
        result += "Min period for rent: \t" + "1 day" + " \n";
        result += "Price for rent: \t" + super.getPeriodPrice() + " per day";
        return result;
    }
}
