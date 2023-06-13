package org.d3if3078.assesment1.ui.zodiakJson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3078.assesment1.databinding.FragmentHasilzodiakBinding
import org.d3if3078.assesment1.network.HasilZodiakApi

class HasilZodiakFragment : Fragment() {

    private val viewModel : HasilZodiakViewModel by lazy {
        ViewModelProvider(this)[HasilZodiakViewModel::class.java]
    }

    private lateinit var binding: FragmentHasilzodiakBinding
    private lateinit var myAdapter: HasilZodiakAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHasilzodiakBinding.inflate(layoutInflater, container, false)
        myAdapter = HasilZodiakAdapter()
        with(binding.recyclerView){
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner){
            myAdapter.updateData(it)
        }
        viewModel.getStatus().observe(viewLifecycleOwner){
            updateProgress(it)
        }
    }

    private fun updateProgress(status: HasilZodiakApi.ApiStatus) {
        when(status){
            HasilZodiakApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            HasilZodiakApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            HasilZodiakApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.networkError.visibility = View.VISIBLE
            }
        }

    }
}