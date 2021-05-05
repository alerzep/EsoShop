package com.esotiq.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private String colour;
    private String size;
    private String category;
    private int quantity;
    private double priceNetto;
    private double priceBrutto;

    public Model() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceNetto() {
        return priceNetto;
    }

    public void setPriceNetto(double priceNetto) {
        this.priceNetto = priceNetto;
    }

    public double getPriceBrutto() {
        return priceBrutto;
    }

    public void setPriceBrutto(double priceBrutto) {
        this.priceBrutto = priceBrutto;
    }

    @Override
    public String toString() {
        return "Model to " + model + "\n" +
                " Kolor: " + colour + "\n" +
                " rozmiar: " + size + "\n" +
                " kategoria: " + category + "\n" +
                " cena netto: " + priceNetto + "\n" +
                " cena brutto: " + priceBrutto + "\n" +
                " ilość: " + quantity;
    }
}
