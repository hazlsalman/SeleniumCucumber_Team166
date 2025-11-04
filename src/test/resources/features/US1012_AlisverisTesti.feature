
Feature: US1010 kullanici alisveris yapar

  @wip
  Scenario: TC16 Kullanici istedigi urunu sepete ekledigini test eder

    Given kullanici "sauceUrl" anasayfaya gider
    And kodlari 1 saniye bekletir
    Then saucedemo username kutusuna "standard_user" yazar
    And saucedemo password kutusuna "secret_sauce" yazar
    And kodlari 1 saniye bekletir
    Then saucedemo login tusuna basar
    And ilk urunun ismini kaydeder ve bu urunun sayfasina gider
    When saucedemo add to Cart butonuna basar
    Then saucedemo alisveris sepetine tiklar
    And kodlari 1 saniye bekletir
    And sectigi urunun basarili olarak sepete eklendigini test eder
    And kodlari 1 saniye bekletir