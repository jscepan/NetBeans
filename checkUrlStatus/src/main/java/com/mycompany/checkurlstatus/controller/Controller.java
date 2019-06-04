package com.mycompany.checkurlstatus.controller;

import com.mycompany.checkurlstatus.controller.eMailController.*;
import com.mycompany.checkurlstatus.controller.inputoutputDataController.FileManipulate;
import com.mycompany.checkurlstatus.model.WebSite;
import java.util.List;

public class Controller {
    
    public static void startApp() {
        CatalogEmail ce = new CatalogEmail(FileManipulate.readEmailFromCsv("Email.csv"));
        System.out.println(ce.getListOfEmail());
        List<WebSite> listOfWebSite = ce.getWebStatusFromEmails();
        System.out.println(listOfWebSite);
    }
}
