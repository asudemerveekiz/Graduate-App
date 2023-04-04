package com.example.mezunapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Haberler : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myArrayList: ArrayList<News>
    lateinit var imageID : Array<Int>
    lateinit var heading: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haberler)

        imageID= arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.j,
            R.drawable.k
        )

        heading = arrayOf(
            "2022-2023 Bahar Dönemi Derslikleri",
            "Staj Süreçlerinde Önemli Değişiklik",
            "Erasmus Bilgilendirme Toplantısı 04.04.23 Salı günü 14.00'da yapılacaktır.",
            "Erasmus Kontenjan Tablosu",
            "TÜBİTAK BİÇABA - Birlikte Çalışıp Birlikte Başaracağız Programı’nı Çağrıya Açıyoruz.",
            "2022-2023 Güz Dönemi Mezuniyet sınavları",
            "ÖNEMLİ - 2022 -2023 Bahar Yarıyılı Ara ve Bitirme Projeleri Hk.",
            "2022-2023 Güz Dönemi Ara ve Bitirme Proje Final Sunum Programı",
            "ACM SRC ESWEEK 2022 En iyi Bilimsel Araştırma Ödülü Yıldız'da",
            "BT Ders Kontenjanları Hk."

        )

        myRecyclerView = findViewById(R.id.recyclerView)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)
        myArrayList = arrayListOf<News>()
        getUserData()

    }
    private fun getUserData(){
        for (i in imageID.indices){
            val news = News(imageID[i],heading[i])
            myArrayList.add(news)
        }
        myRecyclerView.adapter = MyAdapter(myArrayList)

    }
}