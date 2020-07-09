package com.example.tap;

public class ContactData {
    private String image;
    private String name;
    private String number;

    public ContactData(String image, String name, String number){
        this.image = "default.png";
        this.name = name;
        this.number = number;
    }

    public String getImage()
    {
        return this.image;
    }

    public String getName()
    {
        return this.name;
    }

    public String getNumber()
    {
        return this.number;
    }
}
