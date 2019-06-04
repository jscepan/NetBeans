///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.checkurlstatus.controller.eMailController;
//
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadExcelFile {
//        private static String FILE_PATH = "proba.xls";
// 
//    private static List getStudentsListFromExcel() {
//        List studentList = new ArrayList();
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(FILE_PATH);
// 
//            // Using XSSF for xlsx format, for xls use HSSF
//            Workbook workbook = new XSSFWorkbook(fis);
// 
//            int numberOfSheets = workbook.getNumberOfSheets();
// 
//            //looping over each workbook sheet
//            for (int i = 0; i < numberOfSheets; i++) {
//                Sheet sheet = workbook.getSheetAt(i);
//                Iterator rowIterator = sheet.iterator();
// 
//                //iterating over each row
//                while (rowIterator.hasNext()) {
// 
//                    Student student = new Student();
//                    Row row = rowIterator.next();
//                    Iterator cellIterator = row.cellIterator();
// 
//                    //Iterating over each cell (column wise)  in a particular row.
//                    while (cellIterator.hasNext()) {
// 
//                        Cell cell = cellIterator.next();
//                        //The Cell Containing String will is name.
//                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
//                            student.setName(cell.getStringCellValue());
// 
//                            //The Cell Containing numeric value will contain marks
//                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
// 
//                            //Cell with index 1 contains marks in Maths
//                            if (cell.getColumnIndex() == 1) {
//                                student.setMaths(String.valueOf(cell.getNumericCellValue()));
//                            }
//                            //Cell with index 2 contains marks in Science
//                            else if (cell.getColumnIndex() == 2) {
//                                student.setScience(String.valueOf(cell.getNumericCellValue()));
//                            }
//                            //Cell with index 3 contains marks in English
//                            else if (cell.getColumnIndex() == 3) {
//                                student.setEnglish(String.valueOf(cell.getNumericCellValue()));
//                            }
//                        }
//                    }
//                    //end iterating a row, add all the elements of a row in list
//                    studentList.add(student);
//                }
//            }
// 
//            fis.close();
// 
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return studentList;
//    }
// 
// 
//
//}
