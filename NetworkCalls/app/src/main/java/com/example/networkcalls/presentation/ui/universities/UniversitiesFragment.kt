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
    private var searchCountry = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.universities_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this).get(UniversitiesViewModel::class.java)

        initButtons()
        vUniversities.adapter = universityAdapter
        init()
    }

    private fun init(){

        viewModel.universities.observe(viewLifecycleOwner, Observer<ArrayList<University>> { data ->

            if(data.size == 0){
                Toast.makeText(this.activity?.applicationContext, "No Universities found", Toast.LENGTH_LONG).show()
            }
            else universityAdapter.setData(data)

        })
    }

    private fun initButtons(){
        search_button.setOnClickListener {

            if(keyword.text.toString() != "" && keyword.text != null){
                searchKeyword = keyword.text.toString()
                searchCountry = country.text.toString()


//                viewModel.getUniversities(searchKeyword, searchCountry)
                viewModel.getUniversitiesUsingCoRoutine(searchKeyword, searchCountry)

            }
            else{
                Toast.makeText(this.activity?.applicationContext,"Keyword field must not be empty",Toast.LENGTH_LONG).show()
            }

        }
    }
}