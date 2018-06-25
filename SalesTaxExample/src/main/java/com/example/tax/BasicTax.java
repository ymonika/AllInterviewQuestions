package com.example.tax;

import com.example.model.Product;

public class BasicTax {
    public double calculateBasicTax(Product product) {
        return product.isNonTaxableProducts() ? 0.00 : product.getPrice() * 0.10;
    }

    public double calculateImportedTax(Product product) {
        return product.isImported() ? product.getPrice() * 0.05 : 0.00;
    }
}
