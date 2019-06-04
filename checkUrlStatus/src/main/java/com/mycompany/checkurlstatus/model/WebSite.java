package com.mycompany.checkurlstatus.model;
public class WebSite {
    private String urlWebSite;
    private int responseCode;

    public WebSite() {
    }

    public WebSite(String urlWebSite, int responseCode) {
        this.urlWebSite = urlWebSite;
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getUrlWebSite() {
        return urlWebSite;
    }

    public void setUrlWebSite(String urlWebSite) {
        this.urlWebSite = urlWebSite;
    }

    @Override
    public String toString() {
        return "WebSite{" + "urlWebSite=" + urlWebSite + ", responseCode=" + responseCode + '}';
    }
    
    
}
