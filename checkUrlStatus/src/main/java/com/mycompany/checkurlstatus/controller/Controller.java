package com.mycompany.checkurlstatus.controller;

import com.mycompany.checkurlstatus.controller.eMailController.*;
import com.mycompany.checkurlstatus.controller.inputoutputDataController.FileManipulate;
import com.mycompany.checkurlstatus.model.WebSite;
import java.util.List;

public class Controller {

    public static void startApp() {

        String inputFile = FileManipulate.chooseFile();
        if (inputFile != null) {
            CatalogEmail ce = new CatalogEmail(FileManipulate.readEmailFromCsvFile(inputFile));
            List<WebSite> listOfWebSite = ce.getWebStatusFromEmails();
            FileManipulate.saveFile(listOfWebSite);
        }
    }
}
