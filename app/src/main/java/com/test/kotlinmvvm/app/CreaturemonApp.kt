package com.test.kotlinmvvm.app

import android.app.Application
import android.arch.persistence.room.Room
import com.test.kotlinmvvm.model.room.CreatureDatabase

class CreaturemonApp: Application() {

    companion object {
        lateinit var database:CreatureDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this,CreatureDatabase::class.java,"creature_database").build()
    }
}