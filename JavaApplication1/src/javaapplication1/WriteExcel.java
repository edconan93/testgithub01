/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author Vu Hoang Hiep
 */
import java.io.File;
import java.io.IOException;
import java.util.Date;

import jxl.*;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

public class WriteExcel {
 
    public static void main(String[] args) {
 
        try {
            File exlFile = new File("write_test.xls");
            WritableWorkbook writableWorkbook = Workbook
                    .createWorkbook(exlFile);
 
            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Sheet1", 0);
 
            //Create Cells with contents of different data types.
            //Also specify the Cell coordinates in the constructor
            Label label = new Label(0, 0, "Label (String)");
          
            DateTime date = new DateTime(1, 10, new Date());
            Boolean bool = new Boolean(2, 0, true);
            Number num = new Number(3, 0, 9.99);
 
            //Add the created Cells to the sheet
            writableSheet.addCell(label);
            writableSheet.addCell(date);
            writableSheet.addCell(bool);
            writableSheet.addCell(num);
 
            //Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
 
}
