package com.practice.proxy;


/**
 * The Real subject only performs the functional part of requirement.
 * All non-functional things like logging, validation, lazy loading etc. will be handled by a proxy.
 * 
 * @author Chethan Kumar
 */
public class RealImage implements Image {

    public RealImage(String imagePath) {
        System.out.println("[Real Image] object created...");
    }

    @Override
    public void show() {
        System.out.println("[Real Image] showing...");
    }

    @Override
    public void delete() {
        System.out.println("[Real Image] deleted...");
    }

    @Override
    public void close() {
        System.out.println("[Real image] closing...");
    }
    
}
