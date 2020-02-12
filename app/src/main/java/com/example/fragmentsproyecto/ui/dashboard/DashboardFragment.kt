package com.example.fragmentsproyecto.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fragmentsproyecto.R

//Creamos la clase DashboardFragment de tipo Fragment
class DashboardFragment : Fragment() {

    //definimos la variable del viewModel que corresponda a cada Fragment
    private lateinit var dashboardViewModel: DashboardViewModel

    //cremoas funcion onCreateView pasandole los parametros
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Cargamos el viewModel
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}