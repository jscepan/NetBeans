package com.mycompany.checkurlstatus.model;

public class WebSite {

    private Email email;
    private String urlWebSite;
    private int responseCode;
    private String UrlRedirectedWebSite;

    public WebSite() {
    }

    public WebSite(Email email, String urlWebSite, int responseCode) {
        this.email = email;
        this.urlWebSite = urlWebSite;
        this.responseCode = responseCode;
    }

    public WebSite(Email email, String urlWebSite, int responseCode, String UrlRedirectedWebSite) {
        this.email = email;
        this.urlWebSite = urlWebSite;
        this.responseCode = responseCode;
        this.UrlRedirectedWebSite = UrlRedirectedWebSite;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getUrlWebSite() {
        return urlWebSite;
    }

    public void setUrlWebSite(String urlWebSite) {
        this.urlWebSite = urlWebSite;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getUrlRedirectedWebSite() {
        return UrlRedirectedWebSite;
    }

    public void setUrlRedirectedWebSite(String UrlRedirectedWebSite) {
        this.UrlRedirectedWebSite = UrlRedirectedWebSite;
    }

    @Override
    public String toString() {
        return "WebSite{" + "email=" + email + ", urlWebSite=" + urlWebSite + ", responseCode=" + responseCode + ", UrlRedirectedWebSite=" + UrlRedirectedWebSite + '}';
    }


}
