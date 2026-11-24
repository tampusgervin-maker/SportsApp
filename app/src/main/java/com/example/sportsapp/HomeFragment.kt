package com.example.sportsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<View>(R.id.card_featured_football).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_football)
        }

        view.findViewById<View>(R.id.card_featured_basketball).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_basketball)
        }

        view.findViewById<View>(R.id.card_featured_tennis).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_tennis)
        }

        view.findViewById<View>(R.id.btn_go_to_my_sports).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_mySports)
        }
    }
}
