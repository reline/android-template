package com.github.reline.androidtemplate.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.github.reline.androidtemplate.MainApplication
import com.github.reline.androidtemplate.R
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel
    private val adapter = WordRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as MainApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        view.findViewById<Button>(R.id.submit).setOnClickListener {
            val input = view.findViewById<EditText>(R.id.input).text.toString()
            viewModel.onSubmitClicked(input)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.allWords.observe(viewLifecycleOwner, Observer { words ->
            adapter.submitList(words)
        })
    }

}
