/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

  private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

        for (int i = 0; i < sheet.getRows(); i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                System.out.println(i+" "+j);
          Cell cell = sheet.getCell(j, i);
          
          
        }
      }
        Cell cell2 = sheet.getCell(7, 16);
        System.out.println(cell2.getContents().toString());
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    ReadExcel test = new ReadExcel();
    test.setInputFile("ReportWarning2G140731145051.xls");
    test.read();
  }

} 