package com.example.model;

public class Product {

    private String productDesc;
    private double price;
    private boolean isImported;
    private boolean isNonTaxableProducts;

    public Product(String productDesc, Double price, boolean isImported) {
        this.productDesc = productDesc;
        this.price = price != null ? price : 0.0;
        this.isImported = isImported;
        this.isNonTaxableProducts = checkForProduct(productDesc);
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public boolean isNonTaxableProducts() {
        return isNonTaxableProducts;
    }

    public void setNonTaxableProducts(boolean nonTaxableProducts) {
        isNonTaxableProducts = nonTaxableProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", isImported=" + isImported +
                ", isNonTaxableProducts=" + isNonTaxableProducts +
                '}';
    }

    public boolean checkForProduct(String productDesc) {
        for (NonTaxableProducts nonTaxableProducts : NonTaxableProducts.values()) {
            if (nonTaxableProducts.value.equals(productDesc)) {
                return true;
            }
        }
        return false;
    }
}

enum NonTaxableProducts {
    BOOK("book"), FOOD("food"), MEDICAL("medical");
    String value;

    NonTaxableProducts(String value) {
        this.value = value;
    }
}