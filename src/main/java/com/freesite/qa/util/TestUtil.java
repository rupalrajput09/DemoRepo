package com.freesite.qa.util;

import com.freesite.qa.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {


    public static long pageLoad_TimeOut = 50;
    public static long implicit_Wait = 50;

    public static String TestData_Sheet_Path = "C:\\Users\\Rupal\\IdeaProjects\\AutomateSelProject\\src\\main\\java\\com\\freesite\\qa\\testdata\\FreeCrmTestData.xlsx";

    static Workbook workbook;
   public static Sheet sheet;
    //static String sheetName = "contacts";

    public static Object[][] getTestData(String sheetName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(TestData_Sheet_Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //System.out.println(sheet.getLastRowNum()+ "-----" + sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }

   /* public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
      //  FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }*/
}
