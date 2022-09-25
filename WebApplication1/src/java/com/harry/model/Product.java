/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.model;

/**
 *
 * @author leeti
 */
public class Product {
    private int id;
    private String description;
    private int price;
    private String pname;
    private int buynum;
    public Product() {
    }

    public Product(int id, String pname, String description, int price) {
        this.id = id;
        this.description = description;
        this.pname = pname;
        this.price = price;
    }
    public Product(int id, String pname, String description, int price ,int buynum) {
        this.id = id;
        this.description = description;
        this.pname = pname;
        this.price = price;
        this.buynum = buynum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int id) {
        this.buynum = buynum;
    }
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + '}';
    }
}
