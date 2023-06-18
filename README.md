# Falling Letters Mobile Game( Düşen Harfler Kelime Oyunu)  

## Proje Raporu ve daha fazla bilgi için Proje Raporu.pdf

***Android*** ***ve*** ***IOS*** ***platformu*** ***üzerinde***
***yerel*** ***depolamayı*** ***da*** ***kullanarak*** ***mobil***
***oyun(uygulama)*** ***geliştirme***

***Anahtar*** ***Kelimeler:*** ***mobil*** ***programlama,***
***android,*** ***java,*** ***sql,*** ***mobil*** ***oyun***

**Projenin** **Özeti**

Yazılım laboratuvarı 2 projesi olarak bizden mobil oyun programlama
olarak bir "kelime oyunu" yapılması istendi. Proje isterlerini
incelediğimizde bizden android veya ios üzerine uygulama geliştirmemiz
isteniyordu.

Biz bu proje için bizden istenenler doğrultusunda programlama dilleri
arasından JAVA yı seçtik ve platform olarakta Android üzerine yazmaya
karar verdik.

Projemizin isterleri üzerine öncelikle Türkçe kelime havuzunu SQLite
database kullanarak words.db adında bir dosyaya kaydettik. Daha sonra bu
karışık harflerden oluşturulan kelimeleri bu databaseden kontrol
edilerek puan kazanılabilen bir kelime oyunu olan mobil uygulamamızı
yapmış bulunmaktayız.

> **I.** **GİRİŞ**

Projenin konusu Android ve IOS platformu üzerinde yerel depolamayı da
kullanarak mobil oyun(uygulama) geliştirme . Bize sunulan dil
seçenekleri arasından JAVA yı kullanmayı uygun gördük. Oyunun fazlasıyla
kelimeye sahip olabilmesi için internet üzerinden düzenlenmiş bir 50.000
üzerinde kelime sayısı olan dosyayı edindik. Bunu DBeaver programı
aracılığı ile SQLite local database e aktarıldı. Türkçe alfabesinde olan
29 harfi karışık bir şekilde oyun ekranına düşürtüp oyuncunun bu
harflerden localde bulunan kelimeleri oluşturulmasını amaçlayan bir
oyun.

> **II.** **YÖNTEM**

Bu projede kullanılan yöntem 2 aşamada anlatılacaktır.

**1.Aşama:** Öncelikle bir kelime oyunu tasarlayacağımız için bir kelime
databseine ihtiyacımız vardı. Bunun için internet üzerinde yaptığımız
araştırmalarda Türkçe kelimeleri toparlayıp bir araya getirilmiş bir
dosyayı edindik. Sonrasında bu dosyayı kullanabilmek için .txt
dosyasının içine bütün kelimeleri aktardık. Bu işlemlerden sonra DBeaver
uygulaması üzerinden SQLite database connection oluşturduk. Bu
connection içerisine .txt kelime dosyamızı aktarabilmek için .txt dosyasını online converter üzerinden .csv dosyasına
dönüştürdük. Sonrasında connection sayfası içinde import data seçeneğini
seçip .csv dosyamızı seçtik ve connection içine import etmiş olduk. Bu
local veri tabanımızda bulunan kelime veri tabanımızı proje
dosyalarımızın içinde kullanabilmek için bir database dosyası olarak
words.db adında proje dosyamızın içine ekledik. Bu database dosyası
projeyi Android Studio üzerinden .apk dosyasına dönüştürdüğümüzde .apk
dosyası üzerinde gelmiyordu. Bunun için bu database dosyasını proje
içinde assets adında klasör oluşturup içine attık. Sonrasında proje
çalıştığında bu database dosyasını data klasörü içine gönderdik. SQLite
üzerinden kullancağımız veri tabanını projemiz içerisinde daha rahat
kullanabilmek için DBHelper.java adında bir java classı oluşturduk. Bu
class içinde veri tabanına erişmek için veri tabanı pathi, veri tabanı
ismi, kelimelerin bulunduğu tablo ismi ve kelimelerin bulunduğu sütun
ismi değişkenleri bulunmaktadır. Bu class içindeki fetchData fonksiyonu
oyuncunun oluşturmuş olduğu kelimenin words.db dosyası içinde olup
olmadığını kontrol edip sonucu döndüren fonksiyondur. writeData ise
oyuncunun önceden oynadığı oyunlarda elde ettiği skorlar ve bunların
tarih-saat bilgilerini scores adındaki SQLite tablosuna kaydeder.
getCursor da yine veri tabanı bağlantısı sağlanıp scores tablosunu
skorlara göre azalan sırayla cursor u geri döndürür. getDataScore ve
getDataDate fonksiyonlarında ise skorları ve tarih-saat bilgilerini
arrayliste eklenir. Oyuncu tarafından gönderilen kelimenin veri
tabanımızda bulunup bulunmadığının kontrolü için ise DBHelper classından
bir nesne oluşturulur. Sonrasında bir cursor nesnesi de oluşturulup bu
cursor nesnesine DBHelper içinde bulunan fetchData fonksiyonu
aracılığıyla sorgulanır. Eğer oyuncu tarafından girilen kelime veri
tabanımızda bulunuyorsa cursorveri tabanı üzerinde bulduğu sonuç 0'dan
büyük ise aratılan kelime veri tabanında bulunmakta demektir.

**2.Aşama:** Oyun ekranında 80 adet ImageView i LinearLayout içine
oluşturarak 11\*8 bir matris görünümü oluşturduk. Başta bütün bu
ImageView lerin hepsi enabled ve invisible şekilde oyuna başlanır. Fakat
projenin isterine baktığımızda oyun başladığında 3 satır art arda olacak
şekilde düşmesi bekleniyordu. Biz de bu düşme görüntüsünü verebilmek
için 11. Satırda yazdığımız generate fonksiyonları yardımı ile alfabeden
belirli bir harf seçip bu satıra atadıktan sonra satır kontrolü yaparak
örneğin 10.satırda bulunan bir resim visibledir. Düşme eylemi yapılmadan
önce aşağıdaki 9.satıra bakılır. Eğer 9.satır invisible ise 10.satır
invisible 9.satır visible olup 10.satırın resmini 9.satıra atanır. Ta ki
bir aşağı satır visible olana kadar bu işleme devam edilir. Elbette bu işlem UI da
görünebilmesi için belirli gecikmeler atanır. Biz bu projede gecikmeyi
handler yardımı ile yaptık ve düşme görüntüsünü bu şekilde elde ettik.
Oyun başladığında ilk 3 satır düştükten sonra oyuncu artık kelime
oluşturabilir. Skorumuz oyun başladığında 0 olduğu için 100 olana kadar
düşme eylemi dahil 6 saniyede bir her skorun 100 katlarında düşme hızı
birer saniye azalarak skor 500 ve yukarısına geldiğinde ise düşme
aralığımız ise 2 saniye sabit olacak şekilde oyuna devam edilmektedir.
Bu düşme saniye aralıklarında tıpki oyun başında olduğu gibi yazdığımız
generate fonksiyonlarını kullanarak rastgele bir kolondan rastgele bir
harf bir yukarıda anlattığımız gibi handler yardımı ile düşme efekti
verilerek düşme eylemi gerçekleştirilir. 10.satırda visible olan bir
harf var ise oyuncuya son bir şans verilir. Eğer harfin bulunduğu kolonu
11.satırına harf düşmesi sonucunda oyun biter. Oyuncu bu durumdan sonra
ekranda bir AlertDialog görecektir. Burada oyuncumuzun skoru
bulunacaktır. Yine oyuncumuz isterse new butonuna tıklayarak yeni oyun
oynayabilir ve skoru skor tablosuna eklenir. Exit tuşuna basarak oyun
açılış ekranına geridönebilir.

Kullanılan IDE ve Programlar: Android Studio Code
(JAVA), DBeaver, MySql

FirstPageActivity.java (activity_first_page.xml) -- Açılış ekranı

MainActivity.java (activity_main.xml) -- Oyun ekranı

ScoreTableActivity.java (activity_score_table.xml) -- Skor Tablosu
ekranı

AboutGameActivity.java(activity_about_game.xml) -- Oyun Hakkında ekranı

DBHelper.java -- Database class


**SÖZDE** **KOD**

1-BAŞLA

2-Açılış ekranı başlat

3-EĞER new game tıklanırsa GİT 4

4-BAŞLAT Oyun ekranını EĞER oyun biterse GİT 9

5-EĞER skor tablosu tıklanırsa GİT 6

6-GÖSTER skor tablosu

7-EĞER about tıklanırsa GİT 8

8-GÖSTER about ekranı

9- EĞER new tıklanırsa GİT 4 DEĞİLSE GİT 2

10- EĞER exit tıklanırsa GİT 11

11- BİTİR

> **III.** **DENEYSEL** **SONUÇLAR**


**IV.SONUÇ**
>
> Bu projede bir mobil oyunun birçok aşamasının olduğu basit bir kelime
> kontrolü için bile elimizde kelimelerin bulunduğu bir veri tabanı
> gerekliliği aynı zamanda bu veri tabanı bağlantısının hızlı olabilmesi
> için kullanıcının dahili hafızasına kaydetme gerekliliğini gördük. Her
> ne kadar basit gibi görünse de yukarıdan aşağıya düşen bir harf
> arkasında birçok senkronizasyon problemi doğuran bir işlem olduğunu
> gördük.
>
> **KAYNAKLAR**
>
> • Intro to Java Programming,
> Comprehensive Version (10th Edition) Y. Daniel Liang
>
> • Nexis-Java ile Android (Youtube)
>
> • https://stackoverflow.com/questions/70095527/only-white-screen-appears-when-i-run-my-app-using-view-binding-in-avd
>
> • https://developer.android.com/reference/android
>
> • Android Studio ile Programlama - Aysan Ethem Narman
>
> • https://stackoverflow.com/questions/45618391/heart-shaped-button-in-android
>
> • https://youtu.be/AdlxIdYus14
> 
>  • https://www.c-sharpcorner.com/UploadFile/8836be/how-to-set-different-events-on-successive-clicks-on-same-but/
>
> • https://www.tutorialspoint.com/android/android_animations.html
>
> • http://androidosbeginning.blogspot.com/2010/09/gif-animation-in-android.html
>
> • https://stackoverflow.com/questions/28937106/how-to-make-custom-dialog-with-rounded-corners-in-android
>
> • https://stackoverflow.com/questions/9544737/read-file-from-assets
>
> • https://youtu.be/KvbwUnPeNBw
>
>• https://www.tutorialspoint.com/get-current-time-and-date-on-android
>
>• https://stackoverflow.com/questions/3013021/embed-a-database-in-the-apk-of-a-distributed-application-android
