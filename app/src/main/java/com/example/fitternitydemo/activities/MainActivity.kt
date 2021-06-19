package com.example.fitternitydemo.activities

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.HandlerCompat.postDelayed
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.fitternitydemo.R
import com.example.fitternitydemo.adapters.TagsAdapter
import com.example.fitternitydemo.adapters.ViewPagerAdapter
import com.example.fitternitydemo.databinding.ActivityMainBinding
import com.example.fitternitydemo.datamodels.instudioresponse.ProductTag
import com.example.fitternitydemo.fragments.FirstFragment
import com.example.fitternitydemo.fragments.SecondFragment
import com.example.fitternitydemo.utils.customDialog
import com.google.android.material.tabs.TabLayout
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var blogsAdapter: TagsAdapter
    var headerList = ArrayList<ProductTag>()


    private val tabIcons = intArrayOf(
            R.drawable.studio,
            R.drawable.home
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        getWindow().setStatusBarColor(Color.WHITE)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);


        setupViewPager(binding.viewpager);

        binding.tabs.setupWithViewPager(binding.viewpager);

        binding.city.setOnClickListener {
            customDialog(this,"Select Location","mumbai")
        }


        setupTabIcons();

        setupTabIconColor()


    }

    private fun setupTabIconColor() {

        val tabIconColor: Int = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        binding.tabs.getTabAt(0)?.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)

        binding.tabs.setOnTabSelectedListener(
                object : TabLayout.ViewPagerOnTabSelectedListener(binding.viewpager) {
                    override fun onTabSelected(tab: TabLayout.Tab) {
                        super.onTabSelected(tab)
                        val tabIconColor: Int = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
                        tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab) {
                        super.onTabUnselected(tab)
                        val tabIconColor: Int = ContextCompat.getColor(applicationContext, R.color.black)
                        tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                    }
                }
        )
    }

    private fun setupTabIcons() {
        binding.tabs.getTabAt(0)?.setIcon(tabIcons[0])
        binding.tabs.getTabAt(1)?.setIcon(tabIcons[1])
    }

    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(), getString(R.string.workout_in_studio))
        adapter.addFragment(SecondFragment(), getString(R.string.workout_at_home))
        viewpager.setAdapter(adapter)
    }


     fun setList(productTags: List<ProductTag>) {
         headerList.clear()
         headerList = productTags as ArrayList<ProductTag>
         binding.recycler.setLayoutManager(LinearLayoutManager(this, RecyclerView.HORIZONTAL, false))
         blogsAdapter = TagsAdapter(this, headerList)
         binding.recycler.setAdapter(blogsAdapter)

    }


}