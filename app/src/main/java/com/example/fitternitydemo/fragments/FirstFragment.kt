package com.example.fitternitydemo.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.fitternitydemo.R
import com.example.fitternitydemo.activities.MainActivity
import com.example.fitternitydemo.adapters.CentreAdapter
import com.example.fitternitydemo.adapters.CustomAdapter
import com.example.fitternitydemo.adapters.DiscountAdapter
import com.example.fitternitydemo.adapters.TagsAdapter
import com.example.fitternitydemo.databinding.FragmentFirstBinding
import com.example.fitternitydemo.datamodels.instudioresponse.*
import com.example.fitternitydemo.interfaces.InStudioApiResponse
import com.example.fitternitydemo.viewmodels.FirstFragmentViewmodel
import java.util.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),
    InStudioApiResponse {

    lateinit var adapterBanner: CustomAdapter
    private lateinit var binding: FragmentFirstBinding
    var firstFragmentViewmodel : FirstFragmentViewmodel? = null;
    lateinit var activity:MainActivity
    var imageList = ArrayList<CampaignElement>()

    private lateinit var discountAdapter: DiscountAdapter
    var discountList = ArrayList<Categorytag>()

    private lateinit var centreAdapter: CentreAdapter
    var fitnessCentresList = ArrayList<FitnessCentresDatum>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

      binding  = DataBindingUtil.inflate(
                inflater, R.layout.fragment_first, container, false)

        return binding.getRoot()

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstFragmentViewmodel = ViewModelProviders.of(this).get(FirstFragmentViewmodel:: class.java)

        binding.viewPager.setInterval(3000)
        binding.viewPager.setCycle(true)
        binding.viewPager.startAutoScroll()

        binding.studio = firstFragmentViewmodel

        binding.discountRecycler.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        discountAdapter = DiscountAdapter(activity,discountList )
        binding.discountRecycler.setAdapter(discountAdapter)

        binding.centresRecycler.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        centreAdapter = CentreAdapter(activity,fitnessCentresList )
        binding.centresRecycler.setAdapter(centreAdapter)

        firstFragmentViewmodel!!.apiResponses = this
        binding.progressbar.visibility = View.VISIBLE
        firstFragmentViewmodel!!.getData()


        binding.swipeRefresh.setOnRefreshListener(OnRefreshListener {
            binding.progressbar.visibility = View.VISIBLE
            firstFragmentViewmodel!!.getData()
        })



    }

    override fun error(s: String) {
        Toast.makeText(context,s,Toast.LENGTH_LONG).show()
    }


    override fun success(response: InStudioResponse) {
        binding.progressbar.visibility = View.GONE

        binding.swipeRefresh.setRefreshing(false)

        //setting banner
        imageList.clear()
        imageList = response.campaigns as ArrayList<CampaignElement>
        setPagerForSlider()

        //settingTags
        activity.setList(response.productTags)


        //setting category

        binding.txtBook.text = response.categories.title
        binding.txtAllCategoryTitle.text = response.categories.text

        discountList.clear()
        discountList.addAll(response.categories.categorytags)
        discountAdapter.notifyDataSetChanged()

        binding.txtDiscount.text = response.categories.campaign.title
        Glide.with(activity).load(response.categories.campaign.image).into(binding.imgDiscount);
        binding.containerDiscount.setBackgroundColor(ContextCompat.getColor(activity, R.color.discount_color));


        //onepass
        Glide.with(activity).load(R.drawable.onepass).dontAnimate().into(binding.imgOnepass);
        Glide.with(activity).load(response.onepassPre.passes.image).dontAnimate().into(binding.imgOnepassBack);
        binding.txtOnepassH1.text = response.onepassPre.passes.header1
        binding.txtOnepassH2.text = response.onepassPre.passes.header2
        binding.txtOnepassDesc.text = response.onepassPre.passes.description
        binding.txtOnepassAccess.text = response.onepassPre.passes.subheader
        binding.txtOnepassDescHeader.text = response.onepassPre.passes.descHeader


        binding.txtDiscountOnepass.text = response.onepassPre.campaign.title
        Glide.with(activity).load(response.onepassPre.campaign.image).into(binding.imgDiscountOnepass);
        binding.containerOnepass.setBackgroundColor(ContextCompat.getColor(activity, R.color.discount_color));


        //fitness centres
        binding.txtCentres.text = response.fitnessCentres.title
        binding.txtCentreTitle.text = response.fitnessCentres.description

        fitnessCentresList.clear()
        fitnessCentresList.addAll(response.fitnessCentres.data)
        centreAdapter.notifyDataSetChanged()
    }


    private fun setPagerForSlider() {

        val container = binding.pagerContainer
        val pager = container.viewPager
        adapterBanner = CustomAdapter(activity,imageList)
        pager.adapter = adapterBanner
        pager.clipChildren = false
        //
        //
        pager.setOffscreenPageLimit(adapterBanner.getCount());

        pager.setClipChildren(false);


        pager.pageMargin = 30
    }




}