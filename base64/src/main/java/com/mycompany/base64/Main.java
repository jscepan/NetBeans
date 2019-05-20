package com.mycompany.base64;

import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        //text for coding
        String proba = "Partizan je sampion";
        System.out.println("Tekst je bio" + proba);
        
        //coding of string
        String probaFormatiran = Base64.getEncoder().encodeToString(proba.getBytes());
        System.out.println("Tekst u base64: " + probaFormatiran);
        
        //decoding of string
        byte[] probaDecoding = Base64.getDecoder().decode(probaFormatiran);
        String probaVracen = new String(probaDecoding);
        System.out.println("Tekst vracen" + probaVracen);
    }
}
