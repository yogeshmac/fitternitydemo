package com.example.fitternitydemo.adapters

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitternitydemo.R
import com.example.fitternitydemo.datamodels.instudioresponse.*
import java.util.*




//import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
class ChallengeAdapter(//    static String sel_cat, sel_cat_id;
        private val context: Context,
        trainerList: ArrayList<ChallengeDatum>) : RecyclerView.Adapter<ChallengeAdapter.MyViewHolder>() {
    private val trainerList: ArrayList<ChallengeDatum>

    init {
        this.trainerList = trainerList
    }
    var holder: MyViewHolder? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.challenge_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        this.holder = holder
        val tags: ChallengeDatum = trainerList[position]

        Glide.with(context).load(tags.appImage).placeholder(R.drawable.ic_launcher_foreground).into(holder.image_prof)

    }

    override fun getItemCount(): Int {
        return trainerList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(
            protected var view: View) : RecyclerView.ViewHolder(view) {


        var image_prof: ImageView

        init {
            image_prof = view.findViewById<View>(R.id.image_cover) as ImageView
        }
    }


}