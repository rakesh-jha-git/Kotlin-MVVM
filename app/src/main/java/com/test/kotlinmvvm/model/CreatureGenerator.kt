package com.test.kotlinmvvm.model

class CreatureGenerator{

    fun generateCreature(attributes:CreatureAttributes,name:String="",drawable:Int =0):Creature{
       val hitpoints=5* attributes.intelligence+
               4* attributes.strength
              +3* attributes.endurance

        return Creature(attributes,hitpoints,name,drawable)

    }
}