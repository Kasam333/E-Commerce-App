package com.example.craft.fragments.loginRegister

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.craft.R
import com.example.craft.databinding.FragmentSplashScreenBinding


class SplashScreenFragment: Fragment(R.layout.fragment_splash_screen)  {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(Runnable {
            findNavController().navigate(R.id.action_splashScreenFragment_to_introductionFragment)
        }, 3500)

    }
}