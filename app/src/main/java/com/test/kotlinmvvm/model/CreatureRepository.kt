package com.test.kotlinmvvm.model

import android.arch.lifecycle.LiveData

interface CreatureRepository{

    fun saveCreature(creature:Creature)

    fun getAllCreature():LiveData<List<Creature>>

    fun clearAllCreatures()
}