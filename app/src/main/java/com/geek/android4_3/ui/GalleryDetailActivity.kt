package com.geek.android4_3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geek.android4_3.databinding.ActivityGalleryDetailBinding
import com.geek.android4_3.ui.adapter.MainAdapter

class GalleryDetailActivity : AppCompatActivity() {

    private lateinit var ui: ActivityGalleryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = ActivityGalleryDetailBinding.inflate(layoutInflater)
        setContentView(ui.root)

        checkIntent()
    }

    private fun checkIntent() {
        val urls = intent.getStringExtra(GalleryActivity.image_key)
        if (!urls.isNullOrEmpty())
            initViews(urls)
    }

    private fun initViews(urls: String) {
        val adapter = MainAdapter(stringToArray(urls), object : MainAdapter.Listener {
            override fun onLongClick(id: Int) {}
        })
        ui.rvDetail.adapter = adapter

    }

    private fun stringToArray(s: String): ArrayList<String> {
        val list = s.trim().splitToSequence(' ')
            .filter { it.isNotEmpty() } // or: .filter { it.isNotBlank() }
            .toMutableList()

        return list as ArrayList<String>
    }
}