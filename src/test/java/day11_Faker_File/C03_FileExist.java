package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {


    @Test
    public void test01() {
        System.out.println( System.getProperty("user.dir"));
        // C:\Users\gulsah\IdeaProjects\com.Batch59JUnit
        System.out.println(System.getProperty("user.home"));
       // C:\Users\gulsah BİLGİSAYARIMIN BANA ÖZEL KISMINI VERDİ

       // C:\Users\gulsah\IdeaProjects\com.Batch59JUnit\src\test\java\day05_Junit //YOLUVERDİ

       // C:\Users\gulsah\Downloads  :DOWNLOAD IN
       // C:\Users\gulsah\Desktop    :MASA ÜSTÜMÜN DESKTOPU

        //masa üstündeki text dosyasının varlıgını test edelim
        //C:\Users\gulsah\Desktop\text.txt
        String dosyayolu=System.getProperty("user.home")+ "\\Desktop\\text.txt";//desktop text.txt hepımız için aynı
        System.out.println(dosyayolu);//user home ise faklı kısım


        /*Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
javada dosyaya erisim icin dosya yoluna yani path e ihtiyac vardir
Her bilgisayarin kullanici adi farkli olacagindan masa ustu
dosya yoluda birbirinden farkli olacaktir
testlerimizin tum bilgisayarlarda calismasi icin
dosya yolunu DINAMIK yapmak zorundayiz
*/

//bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim=System.getProperty("user.home");

//herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";//buranın olup olamadıgını test ediyoruz

        String masaUstuDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));//bu bize true yada false yazdıracak true
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));
    }
}
