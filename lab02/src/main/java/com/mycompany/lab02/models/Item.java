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
public abstract class Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract BigDecimal getPriceForPeriod(int numberOfDays);
}
