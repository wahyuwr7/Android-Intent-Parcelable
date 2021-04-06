package com.wrseven.gituser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Data>()
    private lateinit var listGitUser: ListGitAdapter
    private lateinit var rvGit: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGit = findViewById(R.id.rvUser)
        rvGit.setHasFixedSize(true)

        list.addAll(getListUser())
        showRecyclerList()
        setListClickAction()
    }

    @SuppressLint("Recycle")
    private fun getListUser(): ArrayList<Data> {
        val gitName = resources.getStringArray(R.array.name)
        val gitUserName = resources.getStringArray(R.array.username)
        val gitCompany = resources.getStringArray(R.array.company)
        val gitLocation = resources.getStringArray(R.array.location)
        val gitRepository = resources.getIntArray(R.array.repository)
        val gitFollowers = resources.getIntArray(R.array.followers)
        val gitFollowing = resources.getIntArray(R.array.following)
        val gitPhoto = resources.obtainTypedArray(R.array.avatar)

        val listUser = ArrayList<Data>()
        for (position in gitName.indices){
            val githubUser = Data(
                    gitName[position],
                    gitUserName[position],
                    gitCompany[position],
                    gitLocation[position],
                    gitRepository[position],
                    gitFollowers[position],
                    gitFollowing[position],
                    gitPhoto.getResourceId(position, - 1)
            )
            listUser.add(githubUser)
        }
        return listUser
    }

    private fun showRecyclerList(){
        rvGit.layoutManager = LinearLayoutManager(this)
        listGitUser = ListGitAdapter(list)
        rvGit.adapter = listGitUser
    }

    private fun setListClickAction() {
        listGitUser.setOnItemClickCallback(object : ListGitAdapter.OnItemClickCallback {
            override fun onItemClick(data: Data) {
                val intent = Intent(this@MainActivity, GitProfile::class.java)
                intent.putExtra("KEY", data)
                startActivity(intent)
            }
        })
    }
}