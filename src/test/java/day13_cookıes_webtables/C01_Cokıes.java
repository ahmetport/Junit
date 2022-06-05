package day13_cookıes_webtables;

import Utilitıes.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cokıes extends TestBase {
    // 1- Amazon anasayfaya gidin
//2- tum cookie’leri listeleyin
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
//5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
//6- eklediginiz cookie’nin sayfaya eklendigini test edin
//7- ismi skin olan cookie’yi silin ve silindigini test edin
//8- tum cookie’leri silin ve silindigini test edin

    @Test
    public void test01() {
        // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac = 1;
        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + ".ci cookıe:" + each);
            System.out.println("name: " + each.getName());
            System.out.println("value:" + each.getValue());
            sayac++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookıeSayısı = cookiesSet.size();
        Assert.assertTrue(cookıeSayısı > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
 //key ve value ikilisi sadec map te oldugu için for kullanarak bunları karşılaştırıyorum
        for (Cookie each : cookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")) {  //İSMİ GETNAME İLE ÇAGIRDIK VE İ18 İLE KARŞILAŞTIRDIK
                Assert.assertEquals("USD", each.getValue());//NAME İSİMLER EŞİTİSE VALUE NUN USD OLDUGUNU TEST ET
            }

        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

        Cookie cookıe = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookıe);
        int sayac1 = 1;
        cookiesSet = driver.manage().getCookies();
        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + ".ci cookıe:" + each);
            sayac1++;


        }



        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(cookıe));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());



















    }
}