package com.example.craft.fragments.loginRegister

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.craft.R
import com.example.craft.adapters.SliderAdapter
import com.example.craft.databinding.FragmentAccountOptionsBinding
import com.smarteist.autoimageslider.SliderView

class AccountOptionsFragment: Fragment(R.layout.fragment_account_options) {
    private lateinit var binding: FragmentAccountOptionsBinding
    private lateinit var sliderView: SliderView


    private var url1 =
        "https://www.samsonite.in/dw/image/v2/AAWQ_PRD/on/demandware.static/-/Sites-Samsonite/default/dw27ac8b95/images/sbl-veron-ii-laptop-backpack-tag-in/hi-res/145994_1041_hi-res_FRONT34_1.jpg?sw=500&sh=750"
    private var url2 =
        "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSfN_B-L1HiaIDBjuIjn4TtGY6Q8xAOjwdcJ-gH_BN6YCb_4ygd4o82S2L6Q-ifHXuArWxk5nT9ZJcfrcF1SEtC_2Raqb83y2JKLLNi_cWIkJf2GYldrOC8&usqp=CAE"
    private var url3 =
        "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQC_yVEtLvIhmdCgLxONGC4tbFBktFxeum0rEJNUBq2r1NCM-5nd7NfUU6QmpD5K_Vy-yU9emiyAjSVlpLVmgDI1tTOGETo2FYIL47P3KSXktiPS3Oj9ZMung&usqp=CAE"
    private var url4 =
        "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcR4lElzwlRI58l6zRSN53ZvxngFag3Z3fvYPzulRba5hK0A1whsD_6KaR_bac2m6yRpPiX9YPu2Xp9FHrhcWiCLAER9qrc_cbzqBg2jRZZ7r0xjXiY4dO14&usqp=CAE"



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountOptionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderView = view.findViewById(R.id.slider)

        // on below line creating variable for array list.
        val sliderDataArrayList: ArrayList<String> = ArrayList()
        // on below line adding urls in slider list.
        sliderDataArrayList.add(url1)
        sliderDataArrayList.add(url2)
        sliderDataArrayList.add(url3)
        sliderDataArrayList.add(url4)

        // on below line initializing our adapter class by passing our list to it.
        val adapter = SliderAdapter(sliderDataArrayList)

        // on below line setting auto cycle direction for slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(adapter)
        sliderView.scrollTimeInSec = 2
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()


        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_accountOptionsFragment_to_registerFragment)
        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_accountOptionsFragment_to_loginFragment)
        }

        return
    }
}
