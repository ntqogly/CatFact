package com.example.catfact

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfact.databinding.ItemFactBinding
import com.example.catfact.models.CatFact

class CatAdapter : ListAdapter<CatFact, CatAdapter.CatViewHolder>(Comparator()) {

    private var catFactList: List<CatFact> = listOf()
        @SuppressLint("NotifyDataSetChanged") set(value) {
            field = value
            notifyDataSetChanged()
        }

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFactBinding.bind(view)
        fun bind(catFact: CatFact) {
            binding.tvFact.text = catFact.fact
        }
    }

    class Comparator : DiffUtil.ItemCallback<CatFact>() {
        override fun areItemsTheSame(oldItem: CatFact, newItem: CatFact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CatFact, newItem: CatFact): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fact, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount() = catFactList.size

    override fun onBindViewHolder(catViewHolder: CatViewHolder, position: Int) {
        catViewHolder.bind(getItem(position))
    }

}