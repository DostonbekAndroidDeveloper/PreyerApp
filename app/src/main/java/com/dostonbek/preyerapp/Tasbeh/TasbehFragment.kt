package com.dostonbek.preyerapp.Tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dostonbek.preyerapp.databinding.FragmentTasbehBinding


class TasbehFragment : Fragment() {
    private lateinit var binding: FragmentTasbehBinding
    private var allNumber: Int = 0
    private var count: Int = 0
    private var viewCount: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTasbehBinding.inflate(layoutInflater)
        var isClicked = false
        binding.choice.text = 33.toString()

        binding.choiceLayout.setOnClickListener {



            if (isClicked) {
                binding.choice.text = "99"
                binding.tt.text = "99"




            } else {
                binding.choice.text = "33"
                binding.tt.text = "33"

            }
            isClicked = !isClicked

        }


        binding.mainButton.setOnClickListener {
            allNumber++
            count++
            viewCount++
            binding.textCount.text = count.toString()
            binding.allNumber.text = allNumber.toString()
            binding.viewNumber.text = viewCount.toString()

            binding.remove.setOnClickListener {
                allNumber = 0
                count = 0
                viewCount = 0

                binding.textCount.text = count.toString()
                binding.allNumber.text = allNumber.toString()
                binding.viewNumber.text = viewCount.toString()
            }

            if (count.toString() == binding.choice.text) {
                count = 0
                viewCount = 0
            }


        }

        return binding.root
    }



}