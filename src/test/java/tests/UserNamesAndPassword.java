package tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class UserNamesAndPassword {

    public Object[][] readExcel() throws IOException {
        FileInputStream fileForm = new FileInputStream("src/test/resources/UserNamesAndPassword.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileForm);
        XSSFSheet sheet = workbook.getSheet("UserNamesAndPassword");
        int totalRows = sheet.getLastRowNum();
        int totalColums = sheet.getRow(0).getPhysicalNumberOfCells();

        Object data[][] = new Object[totalRows][totalColums];
        for (int i = 0; i < totalRows; i++) {
            data[i][0] = sheet.getRow(i + 1).getCell(0).toString();
            data[i][1] = sheet.getRow(i + 1).getCell(1).toString();

        }
        return data;
    }

    @DataProvider(name = "UserNamesAndPassword")
    public Object[][] excelFormData() throws IOException {
        return new UserNamesAndPassword().readExcel();
    }
}
