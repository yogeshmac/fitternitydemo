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
import com.example.fitternitydemo.datamodels.instudioresponse.Categorytag
import com.example.fitternitydemo.datamodels.instudioresponse.FitnessCentresDatum
import com.example.fitternitydemo.datamodels.instudioresponse.ProductTag
import com.example.fitternitydemo.datamodels.instudioresponse.UpcomingClassesDatum
import java.util.*




//import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
class LiveAdapter(//    static String sel_cat, sel_cat_id;
        private val context: Context,
        trainerList: ArrayList<UpcomingClassesDatum>) : RecyclerView.Adapter<LiveAdapter.MyViewHolder>() {
    private val trainerList: ArrayList<UpcomingClassesDatum>

    init {
        this.trainerList = trainerList
    }
    var holder: MyViewHolder? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.live_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        this.holder = holder
        val tags: UpcomingClassesDatum = trainerList[position]
        holder.name.setText(tags.name)
        holder.rating1.setText(tags.averageRating.toString())
        holder.location.setText(tags.slug)
        holder.rating2.setText(tags.totalRatingCount.toString()+"\nReviews")
        holder.calori.setText(tags.overlayDetails.get(0).text)
        holder.price.setText(context.getString(R.string.Rs)+" "+tags.specialPrice)
        Glide.with(context).load(tags.coverimage).placeholder(R.drawable.ic_launcher_foreground).into(holder.image_prof)

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
        var name: TextView
        var location: TextView
        var rating1: TextView
        var rating2: TextView
        var calori: TextView
        var price: TextView

        var image_prof: ImageView

        init {
            image_prof = view.findViewById<View>(R.id.image_cover) as ImageView
            name = view.findViewById<View>(R.id.name) as TextView
            location = view.findViewById<View>(R.id.location) as TextView
            rating1 = view.findViewById<View>(R.id.rating1) as TextView
            rating2 = view.findViewById<View>(R.id.rating2) as TextView
            calori = view.findViewById<View>(R.id.calori) as TextView
            price = view.findViewById<View>(R.id.price) as TextView
        }
    }


}