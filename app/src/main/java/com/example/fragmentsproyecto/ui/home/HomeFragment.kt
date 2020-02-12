package com.example.fragmentsproyecto.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fragmentsproyecto.R

//Creamos la clase HomeFragment de tipo Fragment
class HomeFragment : Fragment() {

    //definimos la variable del viewModel que corresponda a cada Fragment
    private lateinit var homeViewModel: HomeViewModel

    //cremoas funcion onCreateView pasandole los parametros
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Cargamos el viewModel
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}