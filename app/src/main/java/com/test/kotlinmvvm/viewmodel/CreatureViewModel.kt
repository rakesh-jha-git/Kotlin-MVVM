package com.test.kotlinmvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.kotlinmvvm.model.*
import com.test.kotlinmvvm.model.room.CreatureRoomRepository

class CreatureViewModel(private val creatureGenerator: CreatureGenerator= CreatureGenerator(),
                        private val roomRepository: CreatureRoomRepository= CreatureRoomRepository()): ViewModel() {


    private val creatureLiveData= MutableLiveData<Creature>()

    private val saveLiveData=MutableLiveData<Boolean>()

    fun getCreatureLiveData():LiveData<Creature> = creatureLiveData

    fun getSaveLiveData():LiveData<Boolean> = saveLiveData


     var name=""
    var intelligence=0
    var strength=0
    var endurance=0
    var drawable=0


    lateinit var creature: Creature

    fun updateCreature(){
        val creatureAttributes=CreatureAttributes(intelligence,strength,endurance)
        creature=creatureGenerator.generateCreature(creatureAttributes,name,drawable)
        creatureLiveData.postValue(creature)
    }

    fun attributeSelected(attributeType: AttributeType,position: Int){

        when(attributeType){
            AttributeType.INTELLIGANCE ->
                intelligence= AttributeStore.INTELLIGENCE[position].value
            AttributeType.ENDURANCE  ->
                endurance=AttributeStore.ENDURANCE[position].value
            AttributeType.STRENGTH  ->
                strength=AttributeStore.STRENGTH[position].value
        }
        updateCreature()
    }

    fun drawableSelected(drawable: Int){
      this.drawable=drawable
       updateCreature()
    }

    fun saveCreature(){
        return if (canSaveCreature()){
            roomRepository.saveCreature(creature);
            saveLiveData.postValue(true)
        }else{
            saveLiveData.postValue(false)
        }

    }

    fun canSaveCreature():Boolean{
      return intelligence!=0 && endurance!=0 && strength!=0
        && name.isNotEmpty() && drawable!=0
    }
}