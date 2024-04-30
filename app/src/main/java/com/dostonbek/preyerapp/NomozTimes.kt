package com.dostonbek.preyerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dostonbek.preyerapp.databinding.ActivityNomozTimesBinding
import com.dostonbek.preyerapp.model.Item

class NomozTimes : AppCompatActivity(), SalatView {
    private lateinit var binding: ActivityNomozTimesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNomozTimesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener {

            if (binding.cityName.text.toString().isEmpty()){
                Toast.makeText(this,R.string.suggestion,Toast.LENGTH_SHORT).show()

            }else {


                SalatPresenter(this).getDataFromApi("${binding.cityName.text}")
                Toast.makeText(this, R.string.happines, Toast.LENGTH_SHORT).show()
            }

    }}

    override fun onDataCompleteFromApi(salat: Item) {
        binding.subuh.text=salat.fajr
        binding.dzuhur.text=salat.dhuhr
        binding.asr.text=salat.asr
        binding.maghrib.text=salat.maghrib
        binding.isya.text=salat.isha
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error -------> ${throwable.localizedMessage}")
    }
}