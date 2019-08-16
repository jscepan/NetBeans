package com.mycompany.checkurlstatus.controller.inputoutputDataController;

import com.mycompany.checkurlstatus.controller.Controller;
import com.mycompany.checkurlstatus.model.Email;
import com.mycompany.checkurlstatus.model.WebSite;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileManipulate {

    public static List readEmailFromCsvFile(String inputFile) {
        List<Email> list = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
            String line = br.readLine();
            while (line != null) {
                if (line.toString().contains("@")) {
                    Email email = new Email(parseText(line));
                    list.add(email);
                }
                    line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void writeWebSiteToCsv(List<WebSite> list, String outputFile) {
        try ( BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));) {
            for (WebSite webSite : list) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(webSite.getEmail().getEmail());
                oneLine.append(",");
                oneLine.append(webSite.getUrlWebSite());
                oneLine.append(",");
                oneLine.append(webSite.getResponseCode());
                oneLine.append(",");
                if (webSite.getUrlRedirectedWebSite() != null) {
                    oneLine.append(webSite.getUrlRedirectedWebSite());
                    oneLine.append(",");
                }
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileManipulate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManipulate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String parseText(String inputText) {
        Pattern pattern = Pattern.compile("^.*[a-zA-Z]$");
        Matcher m = pattern.matcher(inputText);
        while (m.matches() == false) {
            inputText = inputText.substring(0, inputText.length() - 1);
            m = pattern.matcher(inputText);
        }
        return inputText;
    }

    public static String chooseFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String fn = f.getName();
                String e = "";
                int i = fn.lastIndexOf('.');
                if (i > 0 && i < fn.length() - 1) {
                    e = fn.substring(i + 1).toLowerCase();
                }
                if (e.equals("csv")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "csv files";
            }

        });
        String path = null;
        if (JFileChooser.CANCEL_OPTION == jfc.showOpenDialog(null)) {
        } else if (jfc.getSelectedFile() != null) {
            path = jfc.getSelectedFile().getPath();
        }
        return path;
    }

    public static void saveFile(List<WebSite> listOfWebSite) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String fn = f.getName();
                String e = "";
                int i = fn.lastIndexOf('.');
                if (i > 0 && i < fn.length() - 1) {
                    e = fn.substring(i + 1).toLowerCase();
                }
                if (e.equals("csv")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "csv files";
            }
        });
        if (JFileChooser.CANCEL_OPTION == jfc.showSaveDialog(null)) {
        } else if (jfc.getSelectedFile() != null) {
            FileManipulate.writeWebSiteToCsv(listOfWebSite, jfc.getSelectedFile() + ".csv");
        }
    }

}
