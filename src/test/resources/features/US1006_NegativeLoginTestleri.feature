
  Feature: US1006 Kullanici yanlis bilgilerle sisteme giris yapamaz

    Scenario: TC11 kullanici gecerli email ve gecersiz password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      When account linkine basar
      And email olarak "toGecerliMail" girer
      And password olarak "toGecersizPassword" girer
      Then sign in butonuna basar
      And kodlari 2 saniye bekletir
      When Sisteme giris yapilamadigini test eder

    @paralel2
    Scenario: TC12 kullanici gecersiz email ve gecerli password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      When account linkine basar
      And email olarak "toGecersizMail" girer
      And password olarak "toGecerliPassword" girer
      Then sign in butonuna basar
      When Sisteme giris yapilamadigini test eder




    Scenario: TC13 kullanici gecersiz email ve gecersiz password ile giris yapamamali

      Given kullanici testotomasyonu anasayfaya gider
      When account linkine basar
      And email olarak "toGecersizMail" girer
      And password olarak "toGecersizPassword" girer
      Then sign in butonuna basar
      And kodlari 2 saniye bekletir
      When Sisteme giris yapilamadigini test eder
      And sayfayi kapatir