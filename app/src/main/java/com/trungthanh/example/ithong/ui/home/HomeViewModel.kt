package com.trungthanh.example.ithong.ui.home

import android.app.Application
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.trungthanh.example.ithong.repository.*
import com.trungthanh.example.ithong.ui.models.ButtonUI
import com.trungthanh.example.ithong.ui.models.ViolationGroupUI
import com.trungthanh.example.ithong.ui.models.ViolationUI

class HomeViewModel constructor(
    private val application: Application
) : ViewModel() {

    private val violationGroupRepository : ViolationGroupRepository
    private val violationRepository: ViolationRepository

    private val listViolationGroup: LiveData<List<ViolationGroup>>
    val listViolationGroupUI : LiveData<List<ViolationGroupUI>>

    private val listViolation : LiveData<List<Violation>>
    val listViolationUI : LiveData<List<ViolationUI>>

    private val _navigateViolation = MutableLiveData<Event<Boolean>>()
    val navigateViolation : LiveData<Event<Boolean>> = _navigateViolation

    private val _navigateIndex = MutableLiveData<Event<NavDirections>>()
    val navigateIndex : LiveData<Event<NavDirections>> = _navigateIndex

    //go to search fragment
    private val _navigateSearch = MutableLiveData<Event<NavDirections>>()
    val navigateSearch : LiveData<Event<NavDirections>> = _navigateSearch

    private val _btnSearch = MutableLiveData<ButtonUI>().apply {
        value = ButtonUI(
            onClick = {
                val action = HomeFragmentDirections.actionHomeFragmentToShareFragment()
                _navigateSearch.postValue(Event(action))
            }
        )
    }
    val btnSearch : LiveData<ButtonUI> = _btnSearch
    init {
        val violationGroupDao = AppDatabase.getDatabase(application,viewModelScope).violationGroupDao()
        val violationDao = AppDatabase.getDatabase(application,viewModelScope).violationDao()
        val transportDao = AppDatabase.getDatabase(application,viewModelScope).transportTypeDao()

        violationGroupRepository = ViolationGroupRepository(violationGroupDao)
        violationRepository = ViolationRepository(violationDao)
        transportRepository = TransportRepository(transportDao)

        listViolationGroup = violationGroupRepository.getAllViolationGroupUI()
        listViolationGroupUI = Transformations.map(listViolationGroup){
            it.map { violationGroup ->
                ViolationGroupUI(
                    violationGroup = violationGroup,
                    onClick = {
                        _navigateViolation.postValue(Event(true))
                    }
                )
            }
        }
        listViolation = violationRepository.getAllViolation()
        listViolationUI = Transformations.map(listViolation){
            it.map { violation ->
                ViolationUI(
                    violation = violation,
                    onClick = {
                        val id = violation.id
                        if(id != null){
                            val action = HomeFragmentDirections.actionHomeFragmentToIndexFragment(id)
                            _navigateIndex.postValue(Event(action))
                        }
                    }
                )
            }
        }

        listTransport = transportRepository.getAllTransport()
        listTransportUI  = Transformations.map(listTransport) {
            it.map { transportType ->
                TransportUI(
                    transportType = transportType,
                    onClick = {
                        //  _navigateViolation.postValue(Event(true))
                    }
                )
            }
        }

    }
}