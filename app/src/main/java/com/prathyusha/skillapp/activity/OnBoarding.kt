package com.prathyusha.skillapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.prathyusha.skillapp.model.IntroSlide
import com.prathyusha.skillapp.R
import com.prathyusha.skillapp.adapter.IntroSliderAdapter

class OnBoarding : AppCompatActivity() {

    lateinit var skip:TextView
    lateinit var introSlideViewPager: ViewPager2
    lateinit var indicatorsContainer:LinearLayout
    lateinit var btn_started:Button
    lateinit var txtNext:TextView
    private val introSlideAdapter = IntroSliderAdapter(
            listOf(
                    IntroSlide(
                            "Get Updates from Your Position",
                            "Get update your resume and postion here  to gain more oppurtunity \n",
                            R.drawable.illus1
                    ),
                    IntroSlide(
                            "Get offers from companies",
                            "Get update your resume and postion here  to gain more oppurtunity \n",
                            R.drawable.illus2
                    )
            )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_on_boarding)
        introSlideViewPager=findViewById(R.id.introSliderViewPager)
        indicatorsContainer=findViewById(R.id.indicatorsContainer)
        btn_started=findViewById(R.id.btn_started)
        skip=findViewById(R.id.skip)
        txtNext=findViewById(R.id.txtNext)
        txtNext.setOnClickListener {
            if ( introSlideViewPager.currentItem + 1 < introSlideAdapter.itemCount){
                introSlideViewPager.currentItem += 1
            }

        }
        skip.setOnClickListener {
            Intent(applicationContext, LoginActivity::class.java)
                    .also { startActivity(it) }
        }

        introSlideViewPager.adapter=introSlideAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSlideViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
                if(position==0){
                    btn_started.visibility=View.INVISIBLE
                }
                else{
                    btn_started.visibility=View.VISIBLE
                }
                btn_started.setOnClickListener {
                    Intent(applicationContext, LoginActivity::class.java)
                            .also { startActivity(it) }
                }
            }
        })
    }

    private fun setupIndicators(){
        val indicators= arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams=
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for(i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.indicators_inactive
                        )
                )
                this?.layoutParams=layoutParams
            }

            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount=indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorsContainer[i] as ImageView
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable
                        (
                                applicationContext, R.drawable.indicators_active
                        )
                )
            }
            else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable
                        (
                                applicationContext, R.drawable.indicators_inactive
                        )
                )
            }
        }
    }
}

