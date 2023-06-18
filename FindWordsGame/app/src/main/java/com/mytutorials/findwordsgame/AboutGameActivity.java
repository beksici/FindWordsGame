package com.mytutorials.findwordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_game);

        // Toolbar'i ayarla
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hakkında");*/

        // TextView'i ayarla
        TextView textView1 = findViewById(R.id.textView1);
        String aboutText1 = "\n\tOyun Yapısı:\n\n" +
                "\t-- Oyun 8x10’luk( yani 8 sütun 10 satır olacak) bir alan üzerinde kelime seçilerek anlamlı kelimeler " +
                "oluşturulacaktır. Her bir " +
                "matris alanına bir harf gelecek şekilde tasarlanmıştır. Harfler yukarıdan aşağı yönde " +
                "düşmektedir. En üst kısmından aşağıya doğru birim birim tabana kadar inmesi beklenmektedir.\n"+"\t-- Oyun ilk başladığında yukarıdan aşağıya doğru 3 satır tamamen dolu olacak şekilde rastgele " +
                "harfler indirilecek ve oyuna başlanacaktır.\n"+"\t-- Harfler anlamlı bir kelime oluşturulabilmesi için sesli veya sessiz harf karışık gelmesi " +
                "gerekmektedir. \n"+"\t-- Oyun başlangıcından sonra belirlenen süre aralıklarında yukarıdan aşağıya doğru rastgele " +
                "herhangi bir sütundan harf düşmesi beklenmektedir. Harfler sesli veya sessiz olmak üzere " +
                "karışık bir şekilde olması gereklidir.\n"+"\t-- Harf düşmesi işlemi ilk başta 5 saniyede bir gerçekleşecektir. Bu süre puanın her 100 ve " +
                "katlarına ulaştığında bir saniye azalacaktır. Azalma işlemi 1 saniye ulaşıncaya kadar devam " +
                "edecektir. 1 saniye ulaştığında oyunun devamında bu süre ile harf düşmesi beklenmektedir. \n" +
                "\t\t\t\tpuan 100 olduğunda 4 saniye\n" +
                "\t\t\t\tpuan 200 olduğunda 3 saniye\n" +
                "\t\t\t\tpuan 300 olduğunda 2 saniye\n" +
                "\t\t\t\tpuan 400 olduğunda 1 saniye düşecek ve o şekilde oyun devam edecektir.\n"+"\t-- Oyun içerisinde doğru kelimenin oluşturulması ile puan hesaplanması beklenmektedir. Puan " +
                "hesaplaması için oluşturulan kelimenin harflerine bağlı olacak şekilde puan hesaplanacaktır. " +
                "Her bir harfin belli puanı bulunmaktadır. Bu harf puanlarına bakılarak kelimenin puanı " +
                "hesaplanıp genel puana eklenecektir. Her harfin puanı aşağıdaki tabloda yer almaktadır.";
        int startIndex = aboutText1.indexOf("Oyun Yapısı:");
        int endIndex = startIndex + "Oyun Yapısı:".length();
        textView1.setText(aboutText1, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable) textView1.getText();
        spannable.setSpan(new RelativeSizeSpan(1.5f), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.BLACK), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        ImageView aboutImage = findViewById(R.id.imageView);
        aboutImage.setImageResource(R.drawable.about_image);

        // TextView'i ayarla
        TextView textView2 = findViewById(R.id.textView2);
        String aboutText2 = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tÖrnek Puan hesaplama:\n" +
                "\t\t\t“Mobil” kelimesinin puanı 2+2+3+1+1 =9 puandır.\n\n"+"\t-- Harf doğru ise puan hesaplandıktan sonra harfler ekrandan kaybolacak ve üstündeki harfler " +
                "aşağıya doğru hareket edecektir. Yani aralarda boşluklar olmayacaktır.\n"+"\t-- Oluşturulan kelimenin yanlış olma durumu kayıt altına alınacaktır. 3 kez yanlış girilmesi " +
                "durumunda tüm sütunlardan harfler düşecektir ve hatalı kelime sayısı sıfırlanacaktır. Her üç " +
                "yanlış kelime girilmesinde aynı işlem gerçekleşecektir.\n"+"\t-- Oyun bir sütunun yukarıya doğru harfler ile tamamen dolması ile sonlanacaktır. " +
                "Sonlandırdıktan sonra puanı güncel puan listesine eklenecektir. Güncel puan listesi sıralı bir " +
                "şekilde olmalıdır. En üstte en yüksek puandan en düşük puana kadar sıralanması " +
                "beklenmektedir.";
        textView2.setText(aboutText2);




    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AboutGameActivity.this,FirstPageActivity.class);
        finish();
        startActivity(intent);
    }
}