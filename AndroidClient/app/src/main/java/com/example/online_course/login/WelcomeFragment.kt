package com.example.online_course.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.online_course.MainActivity
import com.example.online_course.R
import com.example.online_course.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnRegister = binding.registerBtn
        val btnLogin = binding.loginBtn
        val skipBtn = binding.skipBtn

        btnLogin.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }
        btnRegister.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        skipBtn.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}