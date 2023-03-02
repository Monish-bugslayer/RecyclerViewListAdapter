package com.example.recyclerviewlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.recyclerviewlistadapter.databinding.ActivityEntireFeedBinding

class EntireFeed : AppCompatActivity() {
    private lateinit var binding:ActivityEntireFeedBinding
    private lateinit var view:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEntireFeedBinding.inflate(layoutInflater)
        view=binding.root
        setContentView(view)
        val headlines=binding.textView
        val img=binding.image
        val newsContent=binding.content
        val bundle:Bundle?= intent.extras
        headlines.text=bundle!!.getString("Headlines")
        img.setImageResource(bundle.getInt("Picture"))
        newsContent.text=bundle.getString("news")






    }
}