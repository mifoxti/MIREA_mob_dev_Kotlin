package com.example.finalfirstprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalfirstprac.databinding.FragmentSecondBinding
import com.example.finalfirstprac.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.toSecBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
            Toast.makeText(requireContext(), "Вы возвращаетесь на второй фрагмент",Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}