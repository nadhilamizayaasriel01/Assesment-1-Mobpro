package org.d3if3078.assesment1.ui.history

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3078.assesment1.databinding.ItemHistoryBinding
import org.d3if3078.assesment1.db.ZodiakEntity
import org.d3if3078.assesment1.model.findZodiak
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter : ListAdapter<ZodiakEntity, HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<ZodiakEntity>() {
                override fun areItemsTheSame(
                    oldData: ZodiakEntity, newData: ZodiakEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: ZodiakEntity, newData: ZodiakEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: ZodiakEntity) = with(binding) {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

            val hasilZodiak = item.findZodiak(itemView.resources)
            kategoriTextView.text = hasilZodiak.judulZodiak.substring(0, 1)
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(color)
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            judulTextView.text = hasilZodiak.judulZodiak
        }
    }
}