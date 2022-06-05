package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Read_Excell {

    @Test
    public void test01() throws IOException {
      //İNPUT OLARAK VERİLEN SATIR NO SUTUN NO DEGERLERİNİ PARAMETRE OLARAK ALIP O CELL DEKİ
        //DATAYI STRİNG OLARAK BANA DÖNDÜREN BİR METHOD OLUŞTURUN

        int satırNo=12;
        int sutunNo=2;
        //DÖNEN STRİNGİN CEZAYİR OLDUGUNU TEST EDİN
        String expectedData="Cezayir";

       String actualData= banaGetir(satırNo-1,sutunNo-1);//satır no ile ındex farklı oldugundan -1 dedik excel index ile çalışır
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaGetir(int satırindex, int sutunindex) throws IOException {
        String istenendata="";
        String DosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(DosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenendata=workbook.getSheet("sayfa1").getRow(satırindex).getCell(sutunindex).toString();
        return istenendata;
    }
}
