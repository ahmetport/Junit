package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcelll {

     @Test
    public void readexcelltest() throws IOException {
       //  7. Dosya yolunu bir String degiskene atayalim
         String dosyaYolu="src/resources/ulkeler.xlsx";
       //  8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
         FileInputStream fis=new FileInputStream(dosyaYolu);
        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
         Workbook workbook= WorkbookFactory.create(fis);
        // 10. WorkbookFactory.create(fileInputStream)
       //  11. Sheet objesi olusturun workbook.getSheetAt(index)
         Sheet sheet=workbook.getSheet("sayfa1");
        // 12. Row objesi olusturun sheet.getRow(index)
         Row row=sheet.getRow(3);
         //13. Cell objesi olusturun row.getCell(index)
         Cell cell=row.getCell(3);
         System.out.println(cell);
         //3 index teki satırın 3 indexındeki datanuın cezayir oldugunu test edin
         String expected="cezayir";
         String actual=cell.toString();
         Assert.assertEquals(expected,actual);

     }
}
