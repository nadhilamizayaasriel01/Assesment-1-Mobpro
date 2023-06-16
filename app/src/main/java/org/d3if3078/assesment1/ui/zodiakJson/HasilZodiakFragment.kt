package org.d3if3078.assesment1.ui.zodiakJson

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3078.assesment1.MainActivity
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
        viewModel.scheduleUpdater(requireActivity().application)
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

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                requestNotificationPermission()
            }

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                MainActivity.PERMISSION_REQUEST_CODE
            )
        }
    }
}