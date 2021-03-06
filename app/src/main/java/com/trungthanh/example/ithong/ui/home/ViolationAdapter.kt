package com.trungthanh.example.ithong.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trungthanh.example.ithong.ui.models.ViolationUI

class ViolationAdapter : ListAdapter<ViolationUI,ViolationAdapter.ViolationViewHolder>(ViolationAdapter.ViolationDiffUtil) {

    private lateinit var binding : ItemViolationBinding

    inner class ViolationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(violationUI : ViolationUI){
            binding.tvTitleViolation.text = violationUI.violation.name
            binding.tvValueViolation.text = violationUI.violation.fines

            itemView.setOnClickListener {
                violationUI.onClick()
            }
        }
    }
    object ViolationDiffUtil: DiffUtil.ItemCallback<ViolationUI>(){
        override fun areContentsTheSame(oldItem: ViolationUI, newItem: ViolationUI): Boolean {
            return oldItem.violation == newItem.violation
        }

        override fun areItemsTheSame(oldItem: ViolationUI, newItem: ViolationUI): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViolationViewHolder {
        binding = ItemViolationBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViolationViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViolationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}