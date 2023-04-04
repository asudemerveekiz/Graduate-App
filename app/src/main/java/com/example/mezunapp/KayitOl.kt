package com.example.mezunapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mezunapp.databinding.ActivityKayitOlBinding

class KayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.btnKaydet.setOnClickListener {
           var ad = binding.kayitAdi.text.toString()
           var soyad = binding.kayitSoyadi.text.toString()
           var girisYili = binding.girisYili.text.toString()
           var mezuniyetYili = binding.mezuniyetYili.text.toString()
           var kullaniciAdi = binding.kayitKullaniciAdi.text.toString()
           var kullaniciParola = binding.kayitParola.text.toString()

           var SharedPreferences = this.getSharedPreferences("KullaniciBilgiler", MODE_PRIVATE)
           var editor = SharedPreferences.edit()

           //add data

           //first four lines won't be used for authentication, just for store the user's info
           editor.putString("ad","$ad" ).apply()
           editor.putString("soyad","$soyad" ).apply()
           editor.putString("girisYili","$girisYili" ).apply()
           editor.putString("mezuniyetYili","$mezuniyetYili" ).apply()
           //two lines below will be used for authentication
           editor.putString("kullaniciAdi","$kullaniciAdi" ).apply()
           editor.putString("kullaniciParola","$kullaniciParola" ).apply()
           Toast.makeText(applicationContext,"Kayıt Başarılı!",Toast.LENGTH_LONG).show()

           //after pull data from edit text to xml, clear all edit texts
           binding.kayitAdi.text.clear()
           binding.kayitSoyadi.text.clear()
           binding.girisYili.text.clear()
           binding.mezuniyetYili.text.clear()
           binding.kayitKullaniciAdi.text.clear()
           binding.kayitParola.text.clear()



       }






        binding.btnGiriseDon.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}