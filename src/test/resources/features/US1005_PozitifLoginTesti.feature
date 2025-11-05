
  Feature: US1005 Kullanici gecerli bilgilerle sisteme giris yapar
    @rapor @paralel1
    Scenario: TC10 kullanici gecerli bilgilerle sisteme giris yapabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      When account linkine basar
      Then email olarak "toGecerliMail" girer
      And password olarak "toGecerliPassword" girer
      And sign in butonuna basar
      Then basarili olarak giris yapilabildigini test eder
      And kodlari 2 saniye bekletir
      Then logout butonuna basarak cikis yapar
