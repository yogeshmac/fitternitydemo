package com.example.fitternitydemo.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.example.fitternitydemo.R
import com.example.fitternitydemo.activities.MainActivity
import com.example.fitternitydemo.adapters.CentreAdapter
import com.example.fitternitydemo.adapters.ChallengeAdapter
import com.example.fitternitydemo.adapters.CustomAdapter
import com.example.fitternitydemo.adapters.LiveAdapter
import com.example.fitternitydemo.databinding.FragmentFirstBinding
import com.example.fitternitydemo.databinding.FragmentSecondBinding
import com.example.fitternitydemo.datamodels.athomeresponse.AtHomeResponse
import com.example.fitternitydemo.datamodels.instudioresponse.*
import com.example.fitternitydemo.interfaces.AtHomeApiResponse
import com.example.fitternitydemo.viewmodels.FirstFragmentViewmodel
import com.example.fitternitydemo.viewmodels.SecondFragmentViewmodel
import java.util.ArrayList

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() , AtHomeApiResponse {

    private lateinit var binding: FragmentSecondBinding

    lateinit var secondFragmentViewmodel: SecondFragmentViewmodel
    lateinit var activity:MainActivity

    var liveList = ArrayList<UpcomingClassesDatum>()
    private lateinit var centreAdapter: LiveAdapter


    var challengeList = ArrayList<ChallengeDatum>()
    private lateinit var challengeAdapter: ChallengeAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding  = DataBindingUtil.inflate(
                inflater, R.layout.fragment_second, container, false)

        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondFragmentViewmodel = ViewModelProviders.of(this).get(SecondFragmentViewmodel:: class.java)
        binding.home = secondFragmentViewmodel

        binding.liveRecycler.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        centreAdapter = LiveAdapter(activity,liveList )
        binding.liveRecycler.setAdapter(centreAdapter)


        binding.challengeRecycler.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        challengeAdapter = ChallengeAdapter(activity,challengeList )
        binding.challengeRecycler.setAdapter(challengeAdapter)

        secondFragmentViewmodel!!.apiResponses = this
        binding.progressbar.visibility = View.VISIBLE
        secondFragmentViewmodel!!.getData()


        binding.swipeRefresh.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            binding.progressbar.visibility = View.VISIBLE
            secondFragmentViewmodel!!.getData()
        })
    }

    override fun error(s: String) {
        Toast.makeText(context,s, Toast.LENGTH_LONG).show()

    }


    override fun success(response: AtHomeResponse) {
        binding.progressbar.visibility = View.GONE
        binding.swipeRefresh.setRefreshing(false)

        Glide.with(activity).load(response.personalTraining.image).dontAnimate().into(binding.imgPt);
        binding.txtPt.text = response.personalTraining.title
        binding.txtPtDesc.text = response.personalTraining.description

        binding.txtDiscountOnepass.text = response.onepassPre.campaign.title
        Glide.with(activity).load(response.onepassPre.campaign.image).into(binding.imgDiscountOnepass);
        binding.containerOnepass.setBackgroundColor(ContextCompat.getColor(activity, R.color.discount_color));


        //live stream
        liveList.clear()
        liveList.addAll(response.upcomingClasses.data)
        centreAdapter.notifyDataSetChanged()

        binding.txtBook.text = response.upcomingClasses.title
        binding.txtAllCategoryTitle.text = response.upcomingClasses.description

        binding.txtDiscount.text = response.upcomingClasses.campaign.title
        Glide.with(activity).load(response.upcomingClasses.campaign.image).into(binding.imgDiscount);
        binding.containerDiscount.setBackgroundColor(ContextCompat.getColor(activity, R.color.discount_color));

        binding.txtChallenge.text = response.challenge.title
        binding.txtChallengeTitle.text = response.challenge.description


        challengeList.clear()
        challengeList.addAll(response.challenge.data)
        challengeAdapter.notifyDataSetChanged()

        binding.txtChallenges.text = response.challenge.campaign.title
        Glide.with(activity).load(response.challenge.campaign.image).into(binding.imgChallenge);
        binding.containerChallenge.setBackgroundColor(ContextCompat.getColor(activity, R.color.discount_color));

    }


}