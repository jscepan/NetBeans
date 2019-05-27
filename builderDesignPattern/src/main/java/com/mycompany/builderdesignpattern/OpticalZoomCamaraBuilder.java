package com.mycompany.builderdesignpattern;
public class OpticalZoomCamaraBuilder extends CamaraBuilder {

    @Override
    public void buildOpticalZome() {
        this.cam.setOpticalZoom("50X optical zoom");
    }

    @Override
    public void buildDigitalZome() {
        this.cam.setDigitalZoom("None");
    }

    @Override
    public void buildDisplay() {
        this.cam.setDisplaySize("6 inch LED");
    }

    @Override
    public void buildMemory() {
        this.cam.setInMemorySize("32GB");
    }
    
}
