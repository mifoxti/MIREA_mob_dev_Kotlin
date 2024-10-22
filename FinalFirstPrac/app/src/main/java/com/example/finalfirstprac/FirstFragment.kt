package com.example.finalfirstprac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalfirstprac.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.navBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            Toast.makeText(requireContext(), "Вы переходите на второй фрагмент",Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}