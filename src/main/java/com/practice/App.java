package com.practice;

import com.practice.proxy.Image;
import com.practice.proxy.ProxyImage;

/**
 * Driver class
 *
 * @author Chethan Kumar
 */
public class App 
{
    public static void main( String[] args ) {

        // proxy design pattern
        Image image = new ProxyImage("valid/path/to/image", true);

        image.close();
        image.show();
        image.close();
        image.delete();


        Image imageReadOnly = new ProxyImage("valid/path/to/image", false);

        imageReadOnly.show();
        imageReadOnly.delete();
        imageReadOnly.close();
    }
}
