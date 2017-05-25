/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab02.main;

import com.mycompany.lab02.models.DailyRentedItem;
import com.mycompany.lab02.models.Item;
import com.mycompany.lab02.models.WeeklyRentedItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Константин
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the lab 02!");
        System.out.println("This application calculates total price of rented items");
        
        List <Item> itemList = new ArrayList();
        
        String itemInput = "Rake daily 1.10\n" +
            "\n" +
            "Mower weekly 35.00\n" +
            "\n" +
            "Tiller weekly 45.00\n" +
            "end";
        
        itemList = readInitialItemsData(itemInput);
        //itemList.add(new DailyRentedItem("item 1 - daily", BigDecimal.valueOf(10.0)));
        //itemList.add(new WeeklyRentedItem("item 2 - weekly", BigDecimal.valueOf(30.0)));
        
        System.out.println("\nAvailable items:");
        for (Item item: itemList){
            System.out.println(item.toString());
            System.out.println();
        }
        
        String rentedItems = "Rake 2\n" +
            "Tiller 16\n" +
            "end";
        
        BigDecimal totalPrice = calcualteTotalPrice(rentedItems, itemList);
        System.out.println("\n Total price: " + totalPrice);
        
    }
    
    public static List<Item> readInitialItemsData(String input){
        List<Item> itemList = new ArrayList();
        
        Scanner scanner = new Scanner(input);
        Boolean endOfSection = false;
        
        String itemType = "";
        String itemName = "";
        BigDecimal itemPrice = BigDecimal.valueOf(-1);
        
        while (!endOfSection && scanner.hasNextLine()){
            
            
            itemName = scanner.next();
            if (itemName.equalsIgnoreCase("END")){
                endOfSection = true;
                break;
            }
            
            itemType = scanner.next();
            itemPrice = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
            if (itemType.equalsIgnoreCase("weekly")){
                itemList.add(new WeeklyRentedItem(itemName, itemPrice));
            }
            else if (itemType.equalsIgnoreCase("daily")){
                itemList.add(new DailyRentedItem(itemName, itemPrice));
            }
            else {
                System.out.println("ERROR-002: Unknown itemType");
            }
        }
        
        return itemList;
    }
    
    
    public static BigDecimal calcualteTotalPrice(String input, List<Item> itemList){
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        
        Scanner scanner = new Scanner(input);
        Boolean endOfSection = false;
        
        String itemName = "";
        int numberOfDays = -1;
        
        while (!endOfSection && scanner.hasNextLine()){
            itemName = scanner.next();
            
            if (itemName.equalsIgnoreCase("END")){
                endOfSection = true;
                break;
            }
            numberOfDays = scanner.nextInt();
            
            int counter = 0;
            for (Item item : itemList){
                counter++;
                if (item.getName().equalsIgnoreCase(itemName)){
                    totalPrice = totalPrice.add(item.getPriceForPeriod(numberOfDays));
                    System.out.println("\nRented item: " + itemName);
                    System.out.println("Number of days: " + numberOfDays + "\n");
                    break;
                }
                else if (counter == itemList.size()){
                    System.out.println("ERROR-003: Item not found!");
                }
            }

        }
        
        return totalPrice;
    }
}
