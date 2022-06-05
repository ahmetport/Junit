package day15_writeExcelScrenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void test01() throws IOException {
       // 1) Yeni bir Class olusturalim WriteExcel
       // 2) Yeni bir test method olusturalim writeExcelTest()
       // 3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

       // 4) 5.hucreye yeni bir cell olusturalim
        // 5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("sayfa1").getRow(0).createCell(4).setCellValue("nufus");

       // 6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("sayfa1").getRow(1).createCell(4).setCellValue(150000);
      // 8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("sayfa1").getRow(14).createCell(4).setCellValue(5400000);
       // 9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //10)Dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();
    }
}
