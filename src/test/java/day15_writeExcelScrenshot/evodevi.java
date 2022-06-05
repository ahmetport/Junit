package day15_writeExcelScrenshot;

import Utilitıes.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class evodevi extends TestBase {
   // Yeni bir test method olusturalim readExcel2()
//- 1.satirdaki 2.hucreye gidelim ve yazdiralim
//- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
//- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
//- Satir sayisini bulalim
//- Fiziki olarak kullanilan satir sayisini bulun
//- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
       Workbook workbook= WorkbookFactory.create(fis);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim//
        Sheet sheet=workbook.getSheet("sayfa1");
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(1);
        System.out.println(cell);
        System.out.println("*******************");


        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdirali
        String hücre=  workbook.getSheet("sayfa1").getRow(0).getCell(1).toString();
        System.out.println(hücre);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        int satırNo=2;
        int sutunNo=4;
        String expectedData="Kabil";

        String actualBaşkent=workbook.getSheet("sayfa1").getRow(1).getCell(3).toString();
        System.out.println(actualBaşkent);

        Assert.assertEquals(expectedData,actualBaşkent);

        //- Satir sayisini bulalim
        int satırSayısı=workbook.getSheet("sayfa1").getLastRowNum();
        System.out.println(satırSayısı);

        //- Fiziki olarak kullanilan satir sayisini bulun
        int kullanılanSatırSayısı=workbook.getSheet("sayfa1").getPhysicalNumberOfRows();
        System.out.println(kullanılanSatırSayısı);

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String>ülkeler=new HashMap<>();
        int satırİndex=workbook.getSheet("sayfa1").getLastRowNum();

        for (int i = 0; i <=satırİndex ; i++) {
            String key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("sayfa1").getRow(i).getCell(1).toString();
            String value1=workbook.getSheet("sayfa1").getRow(i).getCell(2).toString();

            ülkeler.put(key,value);

        }
        System.out.println(ülkeler);










    }


}
