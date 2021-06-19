package com.example.fitternitydemo.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.fitternitydemo.R
import com.example.fitternitydemo.activities.WebViewActivity
import com.example.fitternitydemo.datamodels.instudioresponse.CampaignElement
import java.util.*


class CustomAdapter //        this.namesArray = namesArray;
    (
    private val activity: Context,
    //    private Integer[] imagesArray;
    private val imagesArray: ArrayList<CampaignElement>
) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = (activity as Activity).layoutInflater
        val viewItem: View = inflater.inflate(R.layout.item_cover, container, false)
        val imageView =
            viewItem.findViewById<View>(R.id.image_cover) as ImageView
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
        //        imageView.setImageResource(imagesArray[position]);
      Glide.with(activity).load(imagesArray.get(position).image).placeholder(R.drawable.ic_launcher_foreground).into(imageView);


        viewItem.setOnClickListener{
            val i2 = Intent(activity, WebViewActivity::class.java)
            activity.startActivity(i2)
            activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
        }

        (container as ViewPager).addView(viewItem)
        return viewItem
    }

    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return imagesArray.size
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        // TODO Auto-generated method stub
        return view === `object` as View
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        // TODO Auto-generated method stub
        (container as ViewPager).removeView(`object` as View)
    }



}