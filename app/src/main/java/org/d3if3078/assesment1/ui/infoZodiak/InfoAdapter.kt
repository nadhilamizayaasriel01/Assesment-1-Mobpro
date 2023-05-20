package org.d3if3078.assesment1.ui.infoZodiak

import android.icu.text.IDNA.Info
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.databinding.ListInfoFragmentBinding
import org.d3if3078.assesment1.model.InfoZodiak

class InfoAdapter  : RecyclerView.Adapter<InfoAdapter.ViewHolder>(){

    private val info = mutableListOf<InfoZodiak>()

    fun updateInfo(newInfo: List<InfoZodiak>){
        info.clear()
        info.addAll(newInfo)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListInfoFragmentBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(infoZodiak: InfoZodiak) = with(binding){
           judulZodiak .text = infoZodiak.jenis_zodiak
            tanggal.text = infoZodiak.tanggal
            gambarZodiak.setImageResource(infoZodiak.gambar)

            root.setOnClickListener{
                val pesan = root.context.getString(R.string.pesan, infoZodiak.jenis_zodiak)
                Toast.makeText(root.context, pesan, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListInfoFragmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(info[position])
    }

    override fun getItemCount(): Int {
        return info.size
    }
}