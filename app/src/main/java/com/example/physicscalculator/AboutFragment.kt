package com.example.physicscalculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.physicscalculator.databinding.FragmentAboutBinding
import com.example.physicscalculator.databinding.FragmentTimeBinding



class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val rootView = binding.root

        var addresses : Array<String>  = arrayOf("shoemakerc24@hsnet.ahsd.org")

        binding.callButton.setOnClickListener { view->
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:5704239646")
            }
            startActivity(intent)
        }

        binding.websiteButton.setOnClickListener { view->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hs.ahsd.org/"))
            startActivity(intent)

        }

        binding.locationButton.setOnClickListener { view->
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:41.49322222515837, -75.72444286096044")
            }
            startActivity(intent)
        }

        binding.emailButton.setOnClickListener { view->
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, addresses)
            }
            startActivity(intent)
        }

        return rootView
    }
}