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



class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnRegister = view.findViewById<Button>(R.id.register_btn)
        val login = view.findViewById<Button>(R.id.login_btn)
        btnRegister.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        val mainBtn = view.findViewById<Button>(R.id.main_btn)
        val function: (View) -> Unit = {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        mainBtn.setOnClickListener(function)
    }


}