package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            1.Yeni bir class olusturalim (Homework)
            2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
            3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
            4.https://www.walmart.com/ sayfasina gidin.
            5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
            6. Tekrar “facebook” sayfasina donun
            7. Sayfayi yenileyin
            8. Sayfayi tam sayfa (maximize) yapin
            9.Browser’i kapatin
         */

        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve
        // sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.navigate().to("https://www.facebook.com");
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED\n" +
                                    "Actual Title : " +actualTitle);
        }

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.
        String expectedUrlIcerik="facebook";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url test PASSED");
        }else {
            System.out.println("Url test FAILED"+
                                "Actual Url : "+ actualUrl);

        }

        // 4.https://www.walmart.com/ sayfasina gidin.
        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.


        driver.navigate().to("https://www.walmart.com/");
        actualTitle= driver.getTitle();
        String expectedTitleIcerik="Walmart.com";
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart Title testi PASSED");
        }else {
            System.out.println("Walmart Title testi FAILED\n" +
                    "Actual Title : " +actualTitle);
        }

        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // 7. Sayfayi yenileyin
        driver.navigate().refresh();

        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9.Browser’i kapatin
        Thread.sleep(1000);
        driver.close();

    }
}