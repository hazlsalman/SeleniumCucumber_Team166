
  Feature: Kullanici toplu olarak verilen listedeki urunleri aratir

    Scenario Outline: TC15 kullanici verilen herbir kelimenin bulunabildigini test eder

      Given kullanici "toUrl" anasayfaya gider
      When arama kutusuna "<aranacakKelimeler>" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And kodlari 1 saniye bekletir


      Examples:
      |aranacakKelimeler|
      |phone            |
      |apple            |
      |samsung          |
      |java             |
      |bag              |
      |travel           |


