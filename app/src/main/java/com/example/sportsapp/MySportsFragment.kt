package com.example.sportsapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MySportsFragment : Fragment() {

    // Each button -> navigation action defined in nav_graph.xml
    private val actions = mapOf(
        R.id.btn_football to R.id.action_mySports_to_football,
        R.id.btn_basketball to R.id.action_mySports_to_basketball,
        R.id.btn_tennis to R.id.action_mySports_to_tennis,
        R.id.btn_swimming to R.id.action_mySports_to_swimming,
        R.id.btn_running to R.id.action_mySports_to_running
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_my_sports, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        actions.forEach { (buttonId, actionId) ->
            view.findViewById<View>(buttonId).setOnClickListener {
                findNavController().navigate(actionId)
            }
        }

        val etSearch = view.findViewById<EditText>(R.id.et_search_sports)
        val tvNoSports = view.findViewById<TextView>(R.id.tv_no_sports)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?.trim()?.lowercase().orEmpty()
                var visibleCount = 0

                actions.keys.forEach { buttonId ->
                    val button = view.findViewById<Button>(buttonId)
                    val sportName = button.text.toString().lowercase()
                    if (sportName.contains(query)) {
                        button.visibility = View.VISIBLE
                        visibleCount++
                    } else {
                        button.visibility = View.GONE
                    }
                }

                tvNoSports.visibility = if (visibleCount == 0) View.VISIBLE else View.GONE
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
