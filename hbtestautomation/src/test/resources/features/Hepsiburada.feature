Feature: Hepsiburada.com uzerinden aninda havale odeme seceneklerinin calistiginin kontrol edilmesi

  Scenario: Kullanici girisi yapilarak sepete urun eklenmesi
    Given "https://www.hepsiburada.com/" sayfasindayim
    When Click "Giris Yap Menu"
    When Click "Giris Yap"
    When Fill in "Username or phone" field with "hepsiburadatesting@gmail.com"
    And Click "Giris Yap Button"
    And Fill in "Password" field with "Hb260916"
    And Click "Giris Yap Button"
    Then Verifiy that the login was successful with "hepsi burada" user
    When Fill in "Search Area" field with "Dönüşüm - Franz Kafka"
    And Click "Search Button"
    And Click "Sepete Ekle"
