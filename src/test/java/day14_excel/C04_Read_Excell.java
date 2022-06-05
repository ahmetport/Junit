package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_Read_Excell {
    @Test
    public void test01() throws IOException {
        //  7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //ingilizce başkentler sutununu yazdıralım
       int sonSatır= workbook.getSheet("sayfa1").getLastRowNum();//190 index verdi excelde 191 tane var
        System.out.println(sonSatır);
        String satırDakiData="";
       for (int i = 0; i <= sonSatır; i++) {
           satırDakiData=C03_Read_Excell.banaGetir(i,1);
           System.out.println(satırDakiData);
       }

        }


    }

