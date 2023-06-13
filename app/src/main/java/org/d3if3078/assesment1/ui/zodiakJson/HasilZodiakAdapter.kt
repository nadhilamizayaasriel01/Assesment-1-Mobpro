package org.d3if3078.assesment1.ui.zodiakJson

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3078.assesment1.R
import org.d3if3078.assesment1.databinding.ListItemBinding
import org.d3if3078.assesment1.model.HasilZodiak
import org.d3if3078.assesment1.network.HasilZodiakApi


class HasilZodiakAdapter : RecyclerView.Adapter<HasilZodiakAdapter.ViewHolder>() {

    private val data = mutableListOf<HasilZodiak>()

    fun updateData(newData: List<HasilZodiak>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hasilZodiak: HasilZodiak) = with(binding) {
            judulZodiak.text = hasilZodiak.judulZodiak
            deskripsinya.text = hasilZodiak.deskripsinya.toString()

            Glide.with(gambarnya.context)
                .load(HasilZodiakApi.getHasilZodiakUrl(hasilZodiak.gambar))
                .error(R.drawable.tidak_ada_internet)
                .into(gambarnya)

            root.setOnClickListener {
                val message = "{hasilZodiak.judulZodiak} diklik!"
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}