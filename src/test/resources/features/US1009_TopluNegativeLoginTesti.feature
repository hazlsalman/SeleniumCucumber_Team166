
  Feature: US1009 Kullanici liste olarak verilen bilgilerle giris yapamaz

    Scenario Outline: TC16 liste olarak verilen gecersiz bilgilerle giris yapilamamali

      Given kullanici testotomasyonu anasayfaya gider
      Then account linkine basar
      When email olarak listede verilen "<verilenEmail>" girer
      And password olarak listede verilen "<verilenPassword>" girer
      And kodlari 2 saniye bekletir
      And sign in butonuna basar
      Then Sisteme giris yapilamadigini test eder



      Examples:
        |verilenEmail    		|verilenPassword    |
        |esra@fmail.com  		|1234555            |
        |gamze@gmail.com 	    |mesela123          |
        |zehra@zmail.com 	    |asdf4321           |
        |ayca@amail.com  	    |6543241tre65       |
        |gulnur@gmail.com	    |123ert678          |
