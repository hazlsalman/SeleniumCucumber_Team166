
  Feature: US1007 Kullanici arama yaptigi urunun bulundugunu test eder
    @paralel1
    Scenario: TC14 kullanici aradigi kelimeyi barindiran urun bulunabildigini test eder

      Given kullanici "toUrl" anasayfaya gider
      When arama kutusuna config dosyasindaki toAranacakKelime yazip aratir
      And kodlari 1 saniye bekletir
      Then ilk urunu tiklar
      And acilan sayfadaki urun isminin case sensitive olmadan config dosyasindaki toAranacakKelime icerdigini test eder
