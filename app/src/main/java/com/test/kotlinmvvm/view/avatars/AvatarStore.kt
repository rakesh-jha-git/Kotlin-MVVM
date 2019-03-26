

package com.test.kotlinmvvm.view.avatars


import com.test.kotlinmvvm.R
import com.test.kotlinmvvm.model.Avator

object AvatarStore {
  val AVATARS: List<Avator> by lazy {
    val avatars = mutableListOf<Avator>()

    avatars.add(Avator(R.drawable.creature_app_whistle_1))
    avatars.add(Avator(R.drawable.creature_bear_sleepy))
    avatars.add(Avator(R.drawable.creature_bird_blue_fly_1))
    avatars.add(Avator(R.drawable.creature_bug_insect_happy))
    avatars.add(Avator(R.drawable.creature_bug_spider))
    avatars.add(Avator(R.drawable.creature_cat_derp))
    avatars.add(Avator(R.drawable.creature_cow_01))
    avatars.add(Avator(R.drawable.creature_dino_01))
    avatars.add(Avator(R.drawable.creature_dog_bone))
    avatars.add(Avator(R.drawable.creature_duck_yellow_1))
    avatars.add(Avator(R.drawable.creature_frog_hungry))
    avatars.add(Avator(R.drawable.creature_head_fox))
    avatars.add(Avator(R.drawable.creature_head_pig))
    avatars.add(Avator(R.drawable.creature_head_tiger))
    avatars.add(Avator(R.drawable.creature_monkey_happy))
    avatars.add(Avator(R.drawable.creature_monster_purple))
    avatars.add(Avator(R.drawable.creature_monster_slug))
    avatars.add(Avator(R.drawable.creature_monster_yeti_1))
    avatars.add(Avator(R.drawable.creature_owl_attack_1))
    avatars.add(Avator(R.drawable.creature_panda_fun))
    avatars.add(Avator(R.drawable.creature_penguin_plane))
    avatars.add(Avator(R.drawable.creature_rat))
    avatars.add(Avator(R.drawable.creature_skunk))
    avatars.add(Avator(R.drawable.creature_square_bunny))
    avatars.add(Avator(R.drawable.creature_wolf_crazy))

    avatars
  }
}