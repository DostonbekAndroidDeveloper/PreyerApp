package com.dostonbek.preyerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.dostonbek.preyerapp.databinding.ActivityCompasQiblaBinding

class CompasQibla : AppCompatActivity() {
    private lateinit var binding:ActivityCompasQiblaBinding

    private var currentCompassDegree = 0f
    private var  currentNeedleDegree= 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCompasQiblaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CompassQibla.Builder(this).onPermissionGranted { permission ->
            Toast.makeText(this, "onPermissionGranted $permission", Toast.LENGTH_SHORT).show()
        }. onGetLocationAddress { address ->
            binding.tvLocation.text= buildString {
                append(address.locality)
                append(",")
                append(address.subAdminArea)
            }
        }.onDirectionChangeListener { qiblaDirection ->
            binding.tvDirection.text = if(qiblaDirection.isFacingQibla) "You are facing Qibla"
            else "${qiblaDirection.needleAngle.toInt()}"
            val rotateCompass = RotateAnimation(
                currentCompassDegree, qiblaDirection.compassAngle, Animation.RELATIVE_TO_SELF,
                0.5F, Animation.RELATIVE_TO_SELF, 0.5F
            ).apply {
                duration=100
            }
            currentCompassDegree =qiblaDirection.compassAngle
            binding.ivCompass.startAnimation(rotateCompass)
            val rotateNeedle =
                RotateAnimation( currentNeedleDegree, qiblaDirection.needleAngle, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF,0.5f
            ).apply {
                duration=1000
            }
            currentNeedleDegree =qiblaDirection.needleAngle
            binding.ivNeedle.startAnimation(rotateNeedle)

        }.build()
    }
}

