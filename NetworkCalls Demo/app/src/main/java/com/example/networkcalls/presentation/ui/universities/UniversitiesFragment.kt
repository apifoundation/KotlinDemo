package com.example.networkcalls.presentation.ui.universities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkcalls.R
import com.example.networkcalls.presentation.ui.university.University
import kotlinx.android.synthetic.main.universities_fragment.*


class UniversitiesFragment : Fragment() {

    private lateinit var viewModel: UniversitiesViewModel
    private val universityAdapter = UniversitiesAdapter()

    private var searchKeyword = ""

    //Step 2a

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.universities_fragment, container, false)
    }

    //Step 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this).get(UniversitiesViewModel::class.java)


        vUniversities.adapter = universityAdapter
    }
}