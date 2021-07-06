package com.geek.android4_3.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geek.android4_3.R
import com.geek.android4_3.databinding.ActivityMainBinding
import com.geek.android4_3.ui.adapter.MainAdapter

class GalleryActivity : AppCompatActivity(), MainAdapter.Listener {

    private lateinit var ui: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private var listOfImage = arrayListOf<String>()
    private var sendImages = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        setupList()
        initViews()
        setupListener()
    }

    private fun setupList() {
        for (i in 1..3)
            listOfImage.addAll(resources.getStringArray(R.array.image_urls))
    }

    private fun initViews() {
        adapter = MainAdapter(listOfImage, this)
        ui.rvMainAdapter.adapter = adapter
    }

    override fun onLongClick(id: Int) {
        sendImages += listOfImage[id] + " "
    }

    private fun setupListener() {
        ui.btnSend.setOnClickListener {
            val intent = Intent(this, GalleryDetailActivity::class.java)
            intent.putExtra(image_key, sendImages)
            startActivity(intent)
        }
    }

    companion object {
        const val image_key = "SOME_IMAGE_KEY"
    }
}