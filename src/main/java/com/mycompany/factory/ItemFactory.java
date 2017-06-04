/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factory;

import com.mycompany.lab02.models.DailyRentedItem;
import com.mycompany.lab02.models.Item;
import com.mycompany.lab02.models.WeeklyRentedItem;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class ItemFactory {
    
    public Item getItem(String itemType, String itemName, BigDecimal itemPrice){
        if (itemType == null) {
            return null;
        }		
        if (itemType.equalsIgnoreCase("weekly")){
            return new DailyRentedItem(itemName, itemPrice);
            
        } else if(itemType.equalsIgnoreCase("daily")){
            return new WeeklyRentedItem(itemName, itemPrice);
        }
        else{
            System.out.println("ERROR-002: Unknown itemType");
            return null;
        }
    }
}
