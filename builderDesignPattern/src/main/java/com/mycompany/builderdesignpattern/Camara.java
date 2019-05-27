package com.mycompany.builderdesignpattern;

public class Camara {

    private String opticalZoom;
    private String digitalZoom;
    private String displaySize;
    private String inMemorySize;

    public void setOpticalZoom(String opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public void setDigitalZoom(String digitalZoom) {
        this.digitalZoom = digitalZoom;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public void setInMemorySize(String inMemorySize) {
        this.inMemorySize = inMemorySize;
    }

    @Override
    public String toString() {
        return "Camara: " + "opticalZoom=" + opticalZoom + ", digitalZoom=" + digitalZoom + ", displaySize=" + displaySize + ", inMemorySize=" + inMemorySize;
    }
    
    
}
