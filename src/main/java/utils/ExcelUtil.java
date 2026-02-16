package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    public static File writeUsedCars(String city, List<String> models, File target) {
        target.getParentFile().mkdirs();
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Used Cars " + city);
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("City");
            header.createCell(1).setCellValue("Car Model");

            int rowNum = 1;
            for (String m : models) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(city);
                row.createCell(1).setCellValue(m);
            }

            try (FileOutputStream fos = new FileOutputStream(target)) {
                wb.write(fos);
            }
            return target;
        } catch (IOException e) {
            throw new RuntimeException("Failed to write Excel file: " + target, e);
        }
    }
}