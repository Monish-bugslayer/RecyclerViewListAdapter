package com.example.recyclerviewlistadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.recyclerviewlistadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var view:ConstraintLayout
    private lateinit var feedsAdapter:FeedAdapter
    private lateinit var feeds:MutableList<Feeds>
    private lateinit var news:MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        view=binding.root
        setContentView(view)
        feeds= mutableListOf()
        news= mutableListOf()
        feedsAdapter=FeedAdapter(feeds)
        for(i in 1..40){
            feeds.add(Feeds(R.drawable.img1,"Sri Lankan women cricketers' fees hiked three times the original"))
            news.add(resources.getString(R.string.newsA))
            feeds.add(Feeds(R.drawable.img2,"BBC the Most 'Bhrasht Bakwaas Corporation' in World: BJP After Income Tax 'Survey"))
            news.add(resources.getString(R.string.newsB))
        }
        binding.recyclerView.adapter=feedsAdapter
        feedsAdapter.submitList(feeds)
        feedsAdapter.setOnClickListner(object : OnItemClickListner{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, EntireFeed::class.java)
                intent.putExtra("Headlines", feeds[position].headlines)
                intent.putExtra("Picture", feeds[position].img)
                intent.putExtra("news", news[position])
                startActivity(intent)
            }

        })

    }
}