package com.mycompany.checkurlstatus.controller.eMailController;

import static com.mycompany.checkurlstatus.controller.eMailController.CheckWebSiteUrl.isSiteLiveHttp;
import com.mycompany.checkurlstatus.model.Email;
import com.mycompany.checkurlstatus.model.WebSite;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogEmail {

    private List<Email> listOfEmail;

    public CatalogEmail() {
    }

    public CatalogEmail(List<Email> listOfEmail) {
        this.listOfEmail = listOfEmail;
    }

    public List<Email> getListOfEmail() {
        return listOfEmail;
    }

    public void setListOfEmail(List<Email> listOfEmail) {
        this.listOfEmail = listOfEmail;
    }

    @Override
    public String toString() {
        return "CatalogEmail{" + "listOfEmail=" + listOfEmail + '}';
    }

    public List getWebStatusFromEmails() {
        List<WebSite> listOfWebSite = new ArrayList<>();
        for (Email email : listOfEmail) {
            String urlWebSite = convertEmailToWebUrl(email.getEmail());
            System.out.println(urlWebSite);
            System.out.println();
            listOfWebSite.add(new WebSite(urlWebSite, isSiteLiveHttp(urlWebSite)));
        }
        return listOfWebSite;
    }

    public static String convertEmailToWebUrl(String inputUrlEMail) {
        String parsedString = (inputUrlEMail.split("@")[1]);
        System.out.println(parsedString.lastIndexOf("[a-zA-Z_0-9]"));
        parsedString = parsedString.substring(0, parsedString.lastIndexOf("\\w"));
        System.out.println("a sad je: " + parsedString);
        String urlWebSite = "http://www." + parsedString + "/";
        return urlWebSite;
    }
}
