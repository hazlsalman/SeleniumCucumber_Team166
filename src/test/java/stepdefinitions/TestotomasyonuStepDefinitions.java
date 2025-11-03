package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestotomasyonuStepDefinitions {

    TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {

       testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {

        String bulunamadiYazisi=ConfigReader.getProperty("toBulunamadiYazisi");

        String actualAramaSonucYazisi=testOtomasyonuPage.aramaSonucuElementi.getText();

        Assertions.assertNotEquals(bulunamadiYazisi,actualAramaSonucYazisi);

    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {

        Driver.quitDriver();

    }


    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {

        testOtomasyonuPage.aramaKutusu.sendKeys("dress"+Keys.ENTER);
    }

    @When("arama kutusuna travel yazip aratir")
    public void aramaKutusunaTravelYazipAratir() {

        testOtomasyonuPage.aramaKutusu.sendKeys("travel"+Keys.ENTER);
    }


    @Then("ilk urunu tiklar")
    public void ilk_urunu_tiklar() {
       testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
    }

    @Then("acilan sayfadaki urun isminin case sensitive olmadan phone icerdigini test eder")
    public void acilan_sayfadaki_urun_isminin_case_sensitive_olmadan_phone_icerdigini_test_eder() {

        String expectedUrunIsimIcerik="phone";
        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));

    }


    @When("arama kutusuna {string} yazip aratir")
    public void arama_kutusuna_yazip_aratir(String aranacakUrun) {

        testOtomasyonuPage.aramaKutusu.sendKeys(aranacakUrun+Keys.ENTER);

    }

    @And("kodlari {int} saniye bekletir")
    public void kodlariSaniyeBekletir(int saniye) {

        ReusableMethods.bekle(saniye);

    }

    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {

        String expectedAramaSonucYazisi=ConfigReader.getProperty("toBulunamadiYazisi");
        String actualArmaSonucYazisi=testOtomasyonuPage.aramaSonucuElementi.getText();

        Assertions.assertEquals(expectedAramaSonucYazisi,actualArmaSonucYazisi);

    }

    @When("account linkine basar")
    public void account_linkine_basar() {
       testOtomasyonuPage.accountLinki.click();
    }

    @Then("email olarak {string} girer")
    public void email_olarak_girer(String congigDosyasiEmail) {

        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(ConfigReader.getProperty(congigDosyasiEmail));

    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configDosyasiPassword) {

       testOtomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(ConfigReader.getProperty(configDosyasiPassword));
    }

    @Then("sign in butonuna basar")
    public void sign_in_butonuna_basar() {

       testOtomasyonuPage.loginSayfasiSubmitButton.click();
    }

    @Then("basarili olarak giris yapilabildigini test eder")
    public void basarili_olarak_giris_yapilabildigini_test_eder() {

        Assertions.assertTrue(testOtomasyonuPage.logOutButton.isDisplayed());
    }

    @Then("logout butonuna basarak cikis yapar")
    public void logout_butonuna_basarak_cikis_yapar() {

        testOtomasyonuPage.logOutButton.click();

    }


    @When("Sisteme giris yapilamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {
       Assertions.assertTrue(testOtomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
    }


    @And("acilan sayfadaki urun isminin case sensitive olmadan config dosyasindaki toAranacakKelime icerdigini test eder")
    public void acilanSayfadakiUrunIsmininCaseSensitiveOlmadanConfigDosyasindakiToAranacakKelimeIcerdiginiTestEder() {
        String expectedUrunIsimIcerik=ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));
    }

    @When("arama kutusuna config dosyasindaki toAranacakKelime yazip aratir")
    public void aramaKutusunaConfigDosyasindakiToAranacakKelimeYazipAratir() {
       testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String configDosyasiUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(configDosyasiUrl));

    }
}
