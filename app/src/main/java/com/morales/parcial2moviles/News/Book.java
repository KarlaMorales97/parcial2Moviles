package com.morales.parcial2moviles.News;

import java.io.Serializable;

/**
 * Created by Karla on 03/06/2018.
 */

public class Book implements Serializable {

    private String Tittle, Category, Description;
    private int Thumbal;

    public Book() {
    }

    public Book(String tittle, String category, String description, int thumbal) {
        Tittle = tittle;
        Category = category;
        Description = description;
        Thumbal = thumbal;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbal() {
        return Thumbal;
    }

    public void setThumbal(int thumbal) {
        Thumbal = thumbal;
    }
}
