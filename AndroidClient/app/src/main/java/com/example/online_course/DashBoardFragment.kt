package com.example.online_course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.online_course.databinding.FragmentDashBoardBinding
import com.example.online_course.databinding.FragmentWelcomeBinding

class DashBoardFragment : Fragment() {
    private var _binding: FragmentDashBoardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

}