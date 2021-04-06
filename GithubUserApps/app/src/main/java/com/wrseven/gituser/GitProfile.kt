package com.wrseven.gituser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class GitProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_profile)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.title = "User Details"

        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvUsername: TextView = findViewById(R.id.tv_detail_username)
        val tvCompany: TextView = findViewById(R.id.tv_detail_company)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvRepository: TextView = findViewById(R.id.tv_detail_repository)
        val tvFollowers: TextView = findViewById(R.id.tv_detail_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_detail_following)
        val ivPhoto: ImageView = findViewById(R.id.img_detail_photo)

        val dataGithubUser = intent.getParcelableExtra<Data>("KEY") as Data
        Log.d("GithubUserDetail", dataGithubUser.repository.toString())
        tvName.text = dataGithubUser.name
        tvUsername.text = dataGithubUser.username
        tvCompany.text = dataGithubUser.company
        tvLocation.text = dataGithubUser.location
        tvRepository.text = dataGithubUser.repository.toString()
        tvFollowers.text = dataGithubUser.followers.toString()
        tvFollowing.text = dataGithubUser.following.toString()
        ivPhoto.setImageResource(dataGithubUser.photo)
    }
}