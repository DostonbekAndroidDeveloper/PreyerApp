package com.dostonbek.preyerapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!NetworkUtils.isNetworkAvailable(this)) {
            showNoInternetDialog()
        }

    }
    private fun showNoInternetDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Internet is disconnected")

        builder.setMessage("Please check your internet connection")
            .setPositiveButton("Try Again") { dialog, which ->
                // Check internet connection again
                if (!NetworkUtils.isNetworkAvailable(this@MainActivity)) {
                    // Show the dialog again if the internet is still disconnected
                    showNoInternetDialog()
                }
            }


        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
        alertDialog.setCanceledOnTouchOutside(false)

    }
}
/*
Asosiy aholisi Islom diniga eʼtiqod qiladigan davlatlar

Ozarbayjon
Albaniya
Jazoir
Afgʻoniston
Bangladesh
Baxrayn
Bosniya va Gersegovina
Bruney
Burkina Faso
Gambiya
Gvineya
Jibuti
Misr
Indoneziya
Iordaniya
Iroq
Eron
Yaman
Qozogʻiston
Qatar
Qirgʻiziston
Komor orollari
Fil suyagi qirgʻogʻi
Quvayt
Livan
Liviya
Mavritaniya
Malayziya
Mali
Maldiv
Marokash
Niger
Nigeriya
BAA
Ummon
Pokiston
Falastin
Saudiya Arabistoni
Senegal
Syerra Leone
Suriya
Somali
Sudan
Tojikiston
Tunis
Turkmaniston
Turkiya
Oʻzbekiston
Chad
Eritreya
 */