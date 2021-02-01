package com.example.sharedpreferenceapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sharedpreferenceapp.databinding.ActivityMainBinding

private const val sharedPreferenceName = "com.example.sharedpreferenapp"
class MainActivity : AppCompatActivity() {

  private lateinit var binding : ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSharedPreferences = getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE)

        val key1 = "key1"
        val email = "aledleonv@gmail.com"

        //escribir en las shared Preferences

        mSharedPreferences.edit().putString(key1, email).apply()
        mSharedPreferences.edit().putInt("key2", 100).apply()
        mSharedPreferences.edit().putFloat("key3", 4.5F).apply()

    //leer datos

    val emailObtenido = mSharedPreferences.getString(key1, "")
        binding.TextView.text = emailObtenido


        //borrar de 1 a travez de la key

        mSharedPreferences.edit().remove("key2").apply()

        //Borra SharedPreferences nuclear

        mSharedPreferences.edit().clear().apply()



    }
}