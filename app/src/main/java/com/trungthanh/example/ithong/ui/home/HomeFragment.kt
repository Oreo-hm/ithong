package com.trungthanh.example.ithong.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.trungthanh.example.ithong.R


class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var violationGroupAdapter: ViolationGroupAdapter
    private val viewModel : HomeViewModel by viewModels(){
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return activity?.application?.let { HomeViewModel(it) } as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        violationGroupAdapter = ViolationGroupAdapter(requireContext(),viewModel.listViolationUI)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listViolationGroupUI.observe(viewLifecycleOwner, {
            violationGroupAdapter.submitList(it)
        })

        binding.listViolationGroup.apply {
            adapter = violationGroupAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }

        val transportAdapter = TransportAdapter(requireContext())

        //set list transport
        viewModel.listTransportUI.observe(viewLifecycleOwner, {
            transportAdapter.submitList(it)
        })

        binding.listTransport.apply {
            adapter = transportAdapter
            layoutManager = GridLayoutManager(requireContext(),3, GridLayoutManager.VERTICAL, false)
        }

        viewModel.navigateViolation.observe(viewLifecycleOwner, EventObserver{
            if(it){
                val action = HomeFragmentDirections.actionHomeFragmentToViolationFragment()
                findNavController().navigate(action)
            }
        })

        viewModel.navigateIndex.observe(viewLifecycleOwner, EventObserver{
            findNavController().navigate(it)
        })
//
//        viewModel.btnSearch.observe(viewLifecycleOwner, {btn ->
//            binding.bottomNav.setOnNavigationItemSelectedListener { item ->
//                when (item.itemId){
//                    R.id.btnSearch -> {
//                        btn.onClick()
//                        true
//                    }
//                    else -> {
//                        false
//                    }
//                }
//
//            }
//        })
//
//        viewModel.navigateSearch.observe(viewLifecycleOwner,EventObserver{
//            findNavController().navigate(it)
//        })
    }
}