package com.test.kotlinmvvm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "creature_table")
data  class Creature(
    val creatureAttributes:CreatureAttributes,
    val hitPoints:Int,
    @PrimaryKey @NonNull val name:String,
    val drawable:Int=0

)