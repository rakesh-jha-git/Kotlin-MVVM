package com.test.kotlinmvvm.model.room

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.test.kotlinmvvm.app.CreaturemonApp
import com.test.kotlinmvvm.model.Creature
import com.test.kotlinmvvm.model.CreatureRepository

class  CreatureRoomRepository: CreatureRepository{

    private  val creatureDao:CreatureDao= CreaturemonApp.database.creatureDao()

    private val allCreatures:LiveData<List<Creature>>

    init {
        allCreatures=creatureDao.getAllCreatures()
    }

    override fun getAllCreature()=allCreatures

    override fun clearAllCreatures() {
         val creatureArray=allCreatures.value?.toTypedArray()

        if (creatureArray!=null){
            DeleteAsyncTask(creatureDao).execute(*creatureArray)
        }
    }

    override fun saveCreature(creature: Creature) {
        InsertAsyncTask(creatureDao).execute(creature)
    }


    private class InsertAsyncTask internal constructor(private val dao:CreatureDao): AsyncTask<Creature,Void,Void>(){

        override fun doInBackground(vararg params: Creature): Void ?{
            dao.insertCreature(params[0])
            return null
        }
    }
    private class DeleteAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.deleteAllCreature(*params)
            return null
        }
    }
}