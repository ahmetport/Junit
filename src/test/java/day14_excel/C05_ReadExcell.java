package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcell {

    @Test
    public void test01() throws IOException {
        //  7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa 2 ye gidip satır sayısının 24 kullanılan satır sayısının 12 oldugunu test edin
        int sonSatırİndex=workbook.getSheet("sayfa2").getLastRowNum();
        int expectedSatırSayısı=24;
        Assert.assertEquals(expectedSatırSayısı,sonSatırİndex+1);

        int kullanılanSatırSayısı=workbook.getSheet("sayfa2").getPhysicalNumberOfRows();//satırsayısını getiri
        int expectedKulanılanSatır=12;
        Assert.assertEquals(expectedSatırSayısı,kullanılanSatırSayısı);
    }
}
