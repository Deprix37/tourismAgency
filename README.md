# Turizm Acentası Yönetim Sistemi
## Projenin Tanımı
Bu projenin temel amacı, otel sektöründe faaliyet gösteren işletmenin günlük operasyonlarını daha etkili bir şekilde yönetmesini sağlamak ve müşteri rezervasyon süreçlerini optimize etmektir.  <br/>
İki farklı kullanıcı tanımlanmıştır. Bunlar admin ve acente çalışanıdır. <br/>
Admin yetkisi ile giriş yapıldığında admin ekranı açılacak. Bu ekrandan, acente çalışanı listeleme, ekleme, silme, güncelleme ve kullanıcının rolüne (admin, employee) göre filtreleme yapılmaktadır. <br/>
Employee yetkisi ile giriş yapıldığında personel ekranı açılacak. Bu ekrandan Otel listeleme, ekleme, oda listeleme, ekleme, dönem listeleme, ekleme, fiyat Yönetimi, oda arama, rezervasyon listeleme, ekleme, silme, güncelleme yapılmaktadır. <br/>


##Kullanıcı Yönetimi

Kullanıcı yönetimi, admin tarafından sisteme erişecek kullanıcıları ekleme, çıkarma ve düzenleme işlemlerini gerçekleştirilir. Kullanıcılar username ve password girerek sisteme giriş yapar.<br/>
Admin, sisteme yeni bir kullanıcı eklerken kullanıcının rolünü (admin, personel) belirler.<br/>
Admin, mevcut kullanıcıların bilgilerini (ad, soyad, şifre vb.) düzenleyebilir.<br/>
Admin, kullanıcı hesabını silebilir.<br/>
Admin, kullanıcının rolüne (admin, personel) göre filtreleme yapabilir..<br/>

##Otel Yönetimi

Acente anlaşmalı olduğu otelleri, konum bilgileri ve diğer özellikleri ile birlikte sistemden yönetmeli. Otel eklenirken Otel Adı, Adres, E-posta, Telefon, Yıldız, Tesis Özellikleri, Pansiyon tipleri gibi diğer tanımlamalar yapılır. <br/>
Otel ekranı, otellerin listelendiği bir ekranı içerir. Bu ekran üzerinden otel ekleme işlemi gerçekleştirilebilir. Aynı zamanda var olan otellere sahip olduğu pansiyon tipi, tesis özelliği ve dönem bilgisi kaydedilmelidir. <br/>

##Oda Yönetimi

Acente çalışanı otellerden rezerv ettiği odaları sisteme ekler ve bu odalar üzerinden fiyatlandırma sağlar. 
Otellerin sahip olduğu oda tipleri tek kişilik oda (Single room), çift kişilik oda (Double room), junior suite oda, suite oda olacak şekilde 4 tip ile kısıtlı olacaktır. 
Aynı tipteki odaları sisteme tekrar tekrar eklemek yerine stok mantığı kullanılmaktadır. Ayrıca odalara ait özelliklerde girilmelidir.
