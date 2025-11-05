
  Feature: US1004 KUllanici parametre kullanarak istedigi kelimeyi aratir

    @paralel2
    Scenario: TC08 Kullanici istedigi kelimeyi aratabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna "bag" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And kodlari 5 saniye bekletir



    Scenario: TC09 Kullanici bazi kelimeleri bulamamali

      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna "cokoprens" yazip aratir
      Then arama sonucunda urun bulunamadigini test eder
      And kodlari 1 saniye bekletir
