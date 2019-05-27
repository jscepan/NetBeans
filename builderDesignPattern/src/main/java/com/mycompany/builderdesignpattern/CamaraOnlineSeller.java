package com.mycompany.builderdesignpattern;
public class CamaraOnlineSeller {
    public static void main(String[] args) {
        CamaraMaker cm = new CamaraMaker();
        
        System.out.println("creat cam with opt.zoom");
        
        CamaraBuilder ozcb = new OpticalZoomCamaraBuilder();
        
        cm.setCamaraBuilder(ozcb);
        cm.constructCamara();
        Camara cam = cm.getCamara();
        
        System.out.println(cam);
    }
}
