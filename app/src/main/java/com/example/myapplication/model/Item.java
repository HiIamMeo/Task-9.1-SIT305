package com.example.myapplication.model;

public class Item {

    private int item_id;
    private String radioOption;
    private String username;
    private String phone;
    private String description;
    private String date;
    private String location;

    //int item_id,
    public Item( String radioOption, String name, String phone, String description, String date, String location) {
        //this.item_id = item_id;
        this.radioOption = radioOption;
        this.username = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public Item( int item_id, String radioOption, String name, String phone, String description, String date, String location) {
        this.item_id = item_id;
        this.radioOption = radioOption;
        this.username = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public Item() {
    }


    public int getItem_id() { return item_id; }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getRadioOption() { return radioOption; }
    public void setRadioOption(String radioOption) {
        this.radioOption = radioOption;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        this.location = location;
    }

}
