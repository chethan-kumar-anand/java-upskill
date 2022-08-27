package com.practice.proxy;

/**
 * Proxy class is like a wrapper around the real subject.
 * It can be used to handle non-functional features of the method such as logging, validation, lazy loading etc...
 * @author Chethan Kumar
 */
public class ProxyImage implements Image {

    private Image realImage;
    private boolean isOwner;

    String imagePath;

    public ProxyImage(String imagePath, boolean isOwner) {
        super();
        if (imagePath == null || imagePath.isEmpty()) {
            System.err.println("[Proxy Image] Invalid image path...");
            System.exit(1);
        }

        this.imagePath = imagePath;
        this.isOwner = isOwner;
    }

    @Override
    public void close() {
        if (this.realImage == null) {
            System.err.println("[Proxy Image] No image loaded to close...");
        } else {
            this.realImage.close();
        }
    }

    @Override
    public void delete() {
        if (this.isOwner) {
            this.realImage.delete();
        } else {
            System.err.println("[Proxy Image] Only image owners can delete image");
        }
    }

    @Override
    public void show() {
        this.load();
        System.out.println("[Proxy Image] Image loading...");
        this.realImage.show();
    }

    private void load() {
        if (this.realImage == null) {
            this.realImage = new RealImage(imagePath);
        }
    }

}
