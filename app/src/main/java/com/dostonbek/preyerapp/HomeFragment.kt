package com.dostonbek.preyerapp

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dostonbek.preyerapp.databinding.FragmentHomeBinding
import java.util.Locale


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val languages = arrayOf("Uzbek", "Arab", "Qirg'iz", "Qazag'", "Turkish", "English")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        binding.compassQibla.setOnClickListener {
           val intent=Intent(requireContext(), CompasQibla::class.java)
            startActivity(intent)
        }
        binding.languageButton.setOnClickListener{
            showLanguageDialog()

        }
        binding.news.setOnClickListener {
                val openOrder = Intent(android.content.Intent.ACTION_VIEW)
                openOrder.data = Uri.parse("https://islom.uz")
                startActivity(openOrder)

        }
        binding.tasbeh.setOnClickListener {
            findNavController().navigate(R.id.tasbehFragment)
        }
        binding.time.setOnClickListener {
           val intent =Intent(requireContext(),NomozTimes::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    private fun showLanguageDialog() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Select Language")
            .setItems(languages) { _, which ->
                changeLanguage(languages[which])


            }

            .show()
            .setCanceledOnTouchOutside(false)


    }
    private fun changeLanguage(selectedLanguage: String) {
        val locale = when (selectedLanguage) {
            "Uzbek" -> Locale("uz")
            "English" -> Locale("enm")
            "Arab"-> Locale("ar")
            "Qazag'" -> Locale("kk")
            "Qirg'iz" -> Locale("ky")
            "Turkish"-> Locale("tr")
            else -> Locale.getDefault()
        }
        val configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        requireActivity().recreate()

    }


}