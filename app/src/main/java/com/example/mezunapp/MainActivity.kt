package com.example.mezunapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mezunapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("KullaniciBilgiler", MODE_PRIVATE)
        binding.btnGirisYap.setOnClickListener{
            //check whether the entered information is the same as the information in data base
            //data in KullaniciBilgiler.xml file
            var kayitliKullanici = preferences.getString("kullaniciAdi","")
            var kayitliParola = preferences.getString("kullaniciParola","")

            var girisKullanici = binding.girisKullaniciAdi.text.toString()
            var girisParola = binding.girisParola.text.toString()

            if(girisKullanici!= "" && girisParola!=""){
                if (girisKullanici ==kayitliKullanici && girisParola == kayitliParola){
                    intent = Intent(applicationContext,Haberler::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı!",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(applicationContext,"Bilgilerinizi Girmediniz!",Toast.LENGTH_LONG).show()
            }


        }

        binding.btnKayitOl.setOnClickListener{
            intent = Intent(applicationContext,KayitOl::class.java)
            startActivity(intent)
        }
    }
}