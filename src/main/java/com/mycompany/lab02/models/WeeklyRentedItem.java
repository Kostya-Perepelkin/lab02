/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab02.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Константин
 */
public class WeeklyRentedItem extends Item{
    
    public WeeklyRentedItem(String name, BigDecimal weeklyPrice){ // FIXME move this constructor to the super class
        super(name, weeklyPrice);
    }

    @Override
    public BigDecimal getPriceForPeriod(int numberOfDays) {
       //minimum period is 7 days
       BigDecimal totalPrice = BigDecimal.valueOf(0);
       BigDecimal weeklyPrice = super.getPeriodPrice();
       if (numberOfDays > 7){
           //calcualte price for perios exceeding 7 days on dayly basis 
           int numberOfWeeks = numberOfDays / 7;
           totalPrice = weeklyPrice.multiply(BigDecimal.valueOf(numberOfWeeks));
           BigDecimal pricePerDay = weeklyPrice.divide(BigDecimal.valueOf(7), 2, RoundingMode.HALF_UP);
           totalPrice = totalPrice.add(pricePerDay.multiply(BigDecimal.valueOf(numberOfDays % 7)));
       }
       else if (numberOfDays > 0){
           totalPrice = weeklyPrice;
       }
       else {
           System.out.println("ERROR-004: Incorrect number of days");
       }
       return totalPrice;
    }
    
    @Override
    public String toString(){
        String result = "";
        result += "Item name: \t\t" + super.getName() + " \n";
        result += "Min period for rent: \t" + "7 days" + " \n";
        result += "Price for rent: \t" + super.getPeriodPrice() + " per 7 days";
        return result;
    }
    
}
