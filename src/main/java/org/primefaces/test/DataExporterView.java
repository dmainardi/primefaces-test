/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maina
 */
@Named
@ViewScoped
public class DataExporterView implements Serializable {

    private List<Product> products;

    @Inject
    private ProductService service;
    
    private ProductLazyDataModel lazyProducts;

    @PostConstruct
    public void init() {
        products = service.getProducts(100);
        lazyProducts = new ProductLazyDataModel(service);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public ProductLazyDataModel getLazyProducts() {
        return lazyProducts;
    }

    public void setLazyProducts(ProductLazyDataModel lazyProducts) {
        this.lazyProducts = lazyProducts;
    }

}
