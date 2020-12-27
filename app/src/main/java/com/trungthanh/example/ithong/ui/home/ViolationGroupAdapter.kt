package com.trungthanh.example.ithong.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trungthanh.example.ithong.ui.models.ViolationGroupUI
import com.trungthanh.example.ithong.ui.models.ViolationUI

class ViolationGroupAdapter constructor(
    val contextFragment: Context,
    val listViolationUI: LiveData<List<ViolationUI>>,
    val shareViolationGroupId : MutableLiveData<Int>
)
    : ListAdapter<ViolationGroupUI, ViolationGroupAdapter.ViolationGroupViewHolder>(ViolationGroupAdapter.ViolationGroupDiffUtil){

    private lateinit var binding: ItemViolationGroupBinding

    inner class ViolationGroupViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(violationGroupUI: ViolationGroupUI){
            binding.tvViolationGroupName.text = violationGroupUI.violationGroup.groupName

            val violationAdapter = ViolationAdapter()

            listViolationUI.observe(contextFragment as LifecycleOwner, { list ->
                violationAdapter.submitList(list)
            })

            binding.listViolation.apply {
                adapter = violationAdapter
                layoutManager = GridLayoutManager(contextFragment,2,
                    GridLayoutManager.HORIZONTAL, false)
            }

            binding.btnViolationMore.setOnClickListener {
                violationGroupUI.onClick()
                shareViolationGroupId.postValue(violationGroupUI.violationGroup.groupID)
            }
        }
    }

    object ViolationGroupDiffUtil: DiffUtil.ItemCallback<ViolationGroupUI>(){
        override fun areItemsTheSame(oldItem: ViolationGroupUI, newItem: ViolationGroupUI): Boolean {
            return oldItem.violationGroup == newItem.violationGroup
        }

        override fun areContentsTheSame(oldItem: ViolationGroupUI, newItem: ViolationGroupUI): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViolationGroupViewHolder {
        binding = ItemViolationGroupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViolationGroupViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViolationGroupViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}