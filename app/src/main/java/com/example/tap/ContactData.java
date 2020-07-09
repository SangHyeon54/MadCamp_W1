package com.example.tap;
import android.graphics.drawable.Drawable;

public class ContactData {
    private int image;
    private String name;
    private String number;

    public ContactData(int image, String name, String number){
        this.image = image;
        this.name = name;
        this.number = number;
    }

    public int getImage()
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

    public void setImage(int image)
    {
        this.image = image;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }
}
