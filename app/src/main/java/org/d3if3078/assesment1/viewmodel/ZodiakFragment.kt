package org.d3if3078.assesment1.viewmodel

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.databinding.FragmentZodiakBinding
import org.d3if3078.assesment1.db.ZodiakDb
import org.d3if3078.assesment1.model.HasilZodiak

class ZodiakFragment : Fragment() {

    private lateinit var binding: FragmentZodiakBinding

    private val viewModel: ZodiakViewModel by lazy {
        val db = ZodiakDb.getInstance(requireContext())
        val factory = ZodiakViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[ZodiakViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentZodiakBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnFind.setOnClickListener { findZodiak() }
        viewModel.getHasilZodiak().observe(requireActivity()) { showResult(it) }
        binding.btnShare.setOnClickListener { shareZodiak() }
        viewModel.getHasilZodiak()
    }

    private fun isInputEmpty(input: String): Boolean {
        return input.isNullOrBlank()
    }

    private fun isInputNumber(input: String): Boolean {
        return input.toIntOrNull() != null
    }

    fun isInputValid(input: String): Boolean {
        val regex = Regex("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$")
        return regex.matches(input)
    }

    private fun findZodiak() {
        val bintang = binding.inputZodiak.text.toString()

        if (isInputNumber(bintang)) {
            Toast.makeText(context, R.string.input_angka, Toast.LENGTH_SHORT).show()
            return
        } else if (isInputEmpty(bintang)) {
            Toast.makeText(context, R.string.input_kosong, Toast.LENGTH_SHORT).show()
            return
        } else if (isInputValid(bintang)) {
            Toast.makeText(context, R.string.input_kombinasi, Toast.LENGTH_SHORT).show()
            return
        } else if (bintang.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            Toast.makeText(context, R.string.input_simbol, Toast.LENGTH_LONG).show()
        } else {
            viewModel.findZodiak(bintang)
        }
    }

    private fun shareZodiak() {
        val pesan = getString(R.string.share)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, pesan)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager
            ) != null
        ) {
            startActivity(shareIntent)
        }
    }

    private fun showResult(result: HasilZodiak?) {
        if (result == null) return
        binding.judulZodiak.isVisible = true
        binding.deskripsinya.isVisible = true
        binding.gambar.isVisible = true


        binding.judulZodiak.text = result.judulZodiak
        binding.deskripsinya.text = getString(result.deskripsinya)
        binding.gambar.setImageResource(result.gambar)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menunya, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_zodiakFragment_to_historyFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(R.id.action_zodiakFragment_to_aboutFragment)
                return true
            }
            R.id.menu_info -> {
                findNavController().navigate(R.id.action_zodiakFragment_to_infoFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


