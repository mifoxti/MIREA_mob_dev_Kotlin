package com.example.finalfirstprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalfirstprac.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.toThirdBtn.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            Toast.makeText(requireContext(), "Вы переходите на третий фрагмент",Toast.LENGTH_SHORT).show()
        }
        binding.toFirstBtn.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            Toast.makeText(requireContext(), "Вы возвращаетесь на первый фрагмент",Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


}