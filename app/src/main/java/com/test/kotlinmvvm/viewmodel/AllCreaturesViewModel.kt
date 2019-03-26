package com.test.kotlinmvvm.viewmodel

import android.arch.lifecycle.ViewModel
import com.test.kotlinmvvm.model.room.CreatureRoomRepository

class AllCreaturesViewModel(private val repository: CreatureRoomRepository= CreatureRoomRepository()):ViewModel(){

    private  val allCreaturesLiveData=repository.getAllCreature()

   fun getAllCreaturesLiveData() = allCreaturesLiveData

    fun clearAllCreatures() =repository.clearAllCreatures()


}