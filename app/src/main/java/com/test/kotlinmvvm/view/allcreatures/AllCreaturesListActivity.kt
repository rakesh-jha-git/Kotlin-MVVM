package com.test.kotlinmvvm.view.allcreatures

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.test.kotlinmvvm.R
import com.test.kotlinmvvm.view.creature.CreatureActivity
import com.test.kotlinmvvm.viewmodel.AllCreaturesViewModel
import kotlinx.android.synthetic.main.activity_all_creatures.*
import kotlinx.android.synthetic.main.content_all_creatures.*

class  AllCreaturesListActivity:AppCompatActivity(){

    private lateinit var viewModel:AllCreaturesViewModel

    private val adapter = CreatureAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_all_creatures)
        setSupportActionBar(toolbar)
        viewModel=ViewModelProviders.of(this).get(AllCreaturesViewModel::class.java)

        creaturesRecyclerView.layoutManager=LinearLayoutManager(this)
        creaturesRecyclerView.adapter=adapter

        viewModel.getAllCreaturesLiveData().observe(this, Observer { creatures ->
            creatures?.let {
                adapter.updateCreatures(creatures)
            } })

        fab.setOnClickListener {
            startActivity(Intent(this, CreatureActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_all -> {
                viewModel.clearAllCreatures()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}