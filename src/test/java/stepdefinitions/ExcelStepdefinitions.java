package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelStepdefinitions {

    Workbook workbook;
    Sheet sheet1;
    String satirdakiUrunIsmi;
    double satirdakiMinUrunAdeti;
    Integer testotomasyonundaBulunanSonucSayisi;
    String excelDosyaYolu;



    @When("excel dosyasi ile ilgili ayarlari yapip Sheet1'e gelir")
    public void excel_dosyasi_ile_ilgili_ayarlari_yapip_sheet1_e_gelir() throws IOException {

        excelDosyaYolu="src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
        workbook= WorkbookFactory.create(fileInputStream);
        sheet1= workbook.getSheet("Sheet1");

    }


    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urun_excelindeki_daki_urunun_min_miktarini_ve_urun_ismini_kaydeder(String calisilanSatirNoStr) {

        int calisilanSatirNo=Integer.parseInt(calisilanSatirNoStr);

        satirdakiUrunIsmi=sheet1.getRow(calisilanSatirNo-1).getCell(0).getStringCellValue();

        satirdakiMinUrunAdeti=sheet1.getRow(calisilanSatirNo-1).getCell(1).getNumericCellValue();

    }


    @Then("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urun_ismini_testotomasyonu_sayfasinda_arar_ve_sonuc_sayisini_kaydeder() {

        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi+ Keys.ENTER);

        String aramaSonucuStr=testOtomasyonuPage.aramaSonucuElementi.getText();
        aramaSonucuStr=aramaSonucuStr.replaceAll("\\D","");
        testotomasyonundaBulunanSonucSayisi=Integer.parseInt(aramaSonucuStr);

    }


    @Then("bulunan urun sayisinin excel'deki min. miktara esit veya fazla oldugunu test eder")
    public void bulunan_urun_sayisinin_excel_deki_min_miktara_esit_veya_fazla_oldugunu_test_eder() {

        Assertions.assertTrue(testotomasyonundaBulunanSonucSayisi>=satirdakiMinUrunAdeti);

    }


    @Then("bulunan sonuc sayisini excelde {string} daki {int}. sutuna yazdirir")
    public void bulunan_sonuc_sayisini_excelde_daki_sutuna_yazdirir(String calisilanSatirNoStr, Integer sutunNo) throws IOException {

        int calisilanSatirNo=Integer.parseInt(calisilanSatirNoStr);

        sheet1.getRow(calisilanSatirNo-1).createCell(sutunNo-1).setCellValue(testotomasyonundaBulunanSonucSayisi);

        FileOutputStream fileOutputStream=new FileOutputStream(excelDosyaYolu);

        workbook.write(fileOutputStream);

    }


}
