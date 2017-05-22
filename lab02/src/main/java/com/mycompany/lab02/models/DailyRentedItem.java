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
    
    BigDecimal dailyPrice;
    
    public DailyRentedItem(String name, BigDecimal dailyPrice){
        super.setName(name);
        this.setDailyPrice(dailyPrice);
    }
    
    public BigDecimal getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(BigDecimal dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public BigDecimal getPriceForPeriod(int numberOfDays) {
        return dailyPrice.multiply(BigDecimal.valueOf(numberOfDays));
    }
    
    @Override
    public String toString(){
        String result = "";
        result += "Item name: \t\t" + super.getName() + " \n";
        result += "Min period for rent: \t" + "1 day" + " \n";
        result += "Price for rent: \t" + dailyPrice + " per day";
        return result;
    }
}
