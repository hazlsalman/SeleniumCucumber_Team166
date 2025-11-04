
Feature: US1010 Belirlenen bilgilerle giris yapilamadigi kontrol edilir

  Scenario Outline: TC17 belirlenen gecersiz bilgilerle giris yapilamamali

    Given kullanici testotomasyonu anasayfaya gider
    Then account linkine basar
    When email olarak "<verilenEmail>" girer
    And password olarak "<verilenPassword>" girer
    And kodlari 2 saniye bekletir
    And sign in butonuna basar
    Then Sisteme giris yapilamadigini test eder


    Examples:
      |verilenEmail    		|verilenPassword    |
      |toGecerliMail 		|toGecersizPassword |
      |toGecersizMail	    |toGecersizPassword |
      |toGecersizMail2 	    |toGecersizPassword2|
      |toGecersizMail  	    |toGecersizPassword |
      |toGecersizMail	    |toGecerliPassword  |
      |toGecersizMail2      |toGecersizPassword |
