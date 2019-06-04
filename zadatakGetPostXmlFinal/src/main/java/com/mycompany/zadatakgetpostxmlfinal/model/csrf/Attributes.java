package com.mycompany.zadatakgetpostxmlfinal.model.csrf;
public class Attributes{

    private String nonce_key;
    private String nonce;

    public Attributes() {
    }

    public Attributes(String nonce_key, String nonce) {
        this.nonce_key = nonce_key;
        this.nonce = nonce;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNonce_key() {
        return nonce_key;
    }

    public void setNonce_key(String nonce_key) {
        this.nonce_key = nonce_key;
    }

    @Override
    public String toString() {
        return "Attributes{" + "nonce_key=" + nonce_key + ", nonce=" + nonce + '}';
    }

}
