package com.example.recycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.example.recycle.databinding.ItemCrimeBinding

class CrimeAdapter(private val crimes: List<Crime>?) :
    RecyclerView.Adapter<CrimeAdapter.ViewHolder>() {
    private var onClickListener: View.OnClickListener? = null
    private var currentIndex = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCrimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crime = crimes!![position]
        holder.binding.bigTitle.text = crime.bigtitle
        holder.binding.Date.text = crime.date
        if (crime.isSolved){
            holder.binding.imageView.visibility = View.VISIBLE;
        }else {
            holder.binding.imageView.visibility = View.INVISIBLE;
        }
        holder.itemView.isSelected = currentIndex == position
    }

    override fun getItemCount(): Int {
        return crimes!!.size
    }

    fun setCurrentIndex(position: Int) {
        notifyItemChanged(currentIndex)
        notifyItemChanged(position)
        currentIndex = position
    }

    fun setOnClickListener(onClickListener: View.OnClickListener?) {
        this.onClickListener = onClickListener
    }

    inner class ViewHolder(var binding: ItemCrimeBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        init {
            itemView.tag = this
            itemView.setOnClickListener(onClickListener)
        }
    }
}