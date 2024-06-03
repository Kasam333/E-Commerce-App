package com.example.craft.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.craft.R
import com.example.craft.adapters.SliderAdapter
import com.example.craft.databinding.FragmentIntroductionBinding
import com.smarteist.autoimageslider.SliderView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroductionFragment: Fragment(R.layout.fragment_introduction) {
    private lateinit var binding: FragmentIntroductionBinding
    private lateinit var sliderView: SliderView

    private var url1 =
        "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSQ_3qjh7X09Owc3r7EZazwNWbZp8HZm-3AJFFPFy5EblrV-0NK4A7Of7f5y248-N8DyrwL2ERvNGyr06yKTmjdb4xPjazPhoswpuerxd80JD9T4wkyIOibMQ&usqp=CAE"
        private var url2 =
        "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcR8rJ0wbGJLyXBGLsm-vWTKWR9O0hYA8sclESmD4T7Fu4FwLUyFeTZ7GOoeZXr1aaoIm1vf6nM5o3H9HNsVNSSstpQSD2QeI7fhfCoCpgddSpDSnLAyvbkP2g"
    private var url3 =
        "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRdJLA5M4J80f1_IlJKHaiJPvuk5ERfZR7vUgjpHFp_ucyujaNLPZUHQjk3AwsgJDrezh5SycbGuoBQ0OSHt99qJG3gGctHHd0bHn9cphRnRxvHv2hOjG_bXQ&usqp=CAE"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroductionBinding.inflate(inflater)
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


        // on below line initializing our adapter class by passing our list to it.
        val adapter = SliderAdapter(sliderDataArrayList)

        // on below line setting auto cycle direction for slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(adapter)
        sliderView.scrollTimeInSec = 2
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()


        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_introductionFragment_to_accountOptionsFragment)
        }

        return

    }

}