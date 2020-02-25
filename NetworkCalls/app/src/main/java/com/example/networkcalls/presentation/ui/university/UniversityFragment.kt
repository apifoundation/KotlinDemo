package com.example.networkcalls.presentation.ui.university

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.networkcalls.R


class UniversityFragment() : Fragment() {

    companion object {
        private const val ARG_UNIVERSITY = "university"

        fun newInstance(university: University) =
            UniversityFragment()
    }

    private lateinit var viewModel: UniversityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.university_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UniversityViewModel::class.java)
        // TODO: Use the ViewModel

    }

}
