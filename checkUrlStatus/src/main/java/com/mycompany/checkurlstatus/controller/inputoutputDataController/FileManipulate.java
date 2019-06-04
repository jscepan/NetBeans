package com.mycompany.checkurlstatus.controller.inputoutputDataController;

import com.mycompany.checkurlstatus.controller.Controller;
import com.mycompany.checkurlstatus.controller.eMailController.CatalogEmail;
import com.mycompany.checkurlstatus.model.Email;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManipulate {

    public static List readEmailFromCsv(String inputFile) {
        List<Email> list = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
            String line = br.readLine();
            while (line != null) {
                Email email = new Email(line);
                list.add(email);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public static void writeEmailToCsv(List list, String inputFile) {
        try ( BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
            String line = br.readLine();
            while (line != null) {
                Email email = new Email(line);
                list.add(email);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
