/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.test;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
@Named(value = "dtView")
@ViewScoped
public class CarView implements Serializable {

    private List<Car> cars;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(10);
    }

    public void onCellEditInt(CellEditEvent event) {
    }

    public List<Car> getCars() {
        return cars;
    }
    
    public List<String> getBrands() {
        return service.getBrands();
    }
     
    public List<String> getColors() {
        return service.getColors();
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
}
