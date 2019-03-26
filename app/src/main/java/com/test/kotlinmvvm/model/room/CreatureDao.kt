package com.test.kotlinmvvm.model.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.test.kotlinmvvm.model.Creature

@Dao
interface CreatureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCreature(creature: Creature)

    @Delete
    fun deleteAllCreature(vararg creature: Creature)


    @Query("Select * from creature_table order by name ASC")
   fun getAllCreatures():LiveData<List<Creature>>
}