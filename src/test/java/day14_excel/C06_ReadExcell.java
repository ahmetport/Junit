package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcell {

    @Test
    public void test01() throws IOException {
        //excell dosyasındaki tüm verileri classımıza alıp bir java objesine stor edelim
        //her seferinde excelle ulaşıp satır sutun ugraşmayalım
        //database yapısınd aolan exceli koyabilecegimiz en uygun java objesi map tir


        Map<String,String> ülkeler=new HashMap<>();
        //  7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatırİndex=workbook.getSheet("sayfa1").getLastRowNum();


        for (int i = 0; i <=sonSatırİndex ; i++) {
            //key i.satırdaki 0 indexındeki datadır
            String key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();

            //value ise i.satırdaki 1.,2ve 3 indexdeki dataların birleşimi olacak
            String value=workbook.getSheet("sayfa1").getRow(i).getCell(1).toString()
                    +", " +workbook.getSheet("sayfa1").getRow(i).getCell(2).toString()
                    +", " +workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();

            ülkeler.put(key,value);


        }
        System.out.println(ülkeler);
        //listede gana oldugunu test edelim
        Assert.assertTrue(ülkeler.keySet().contains("Ghana"));
    }
}
