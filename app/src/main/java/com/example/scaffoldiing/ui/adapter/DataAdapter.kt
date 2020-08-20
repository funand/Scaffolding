package com.example.scaffoldiing.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.scaffoldiing.R
import com.example.scaffoldiing.model.Team
import com.squareup.picasso.Picasso
import com.weightwatchers.ww_exercise_01.util.ItemDiffCallback
import kotlinx.android.synthetic.main.team_details.view.*
import kotlin.random.Random

typealias ClickListener = (Team) -> Unit

class DataAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var mDataset: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.team_details, parent, false
        ) as LinearLayout

        val viewHolder =
            ViewHolder(view)
        view.setOnClickListener { clickListener(mDataset[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun getItemCount() = mDataset.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var team = mDataset.get(position)

        holder.bind(team)
        holder.itemView.setBackgroundColor(randomColor())
    }

    fun updateDataset(dataset: List<Team>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(this.mDataset, dataset))
        this.mDataset = dataset
        diffResult.dispatchUpdatesTo(this)
    }

    private fun randomColor() = Color.rgb(
        Random.nextInt(100) + 45,
        Random.nextInt(150) + 44,
        Random.nextInt(1650) + 30
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(teams: Team) {
            val teamLogoImg = teams.strTeamBadge

            teamLogoImg?.let { team_logo ->
                Picasso.get().load(team_logo).fit().into(itemView.team_logo as ImageView)
            }

            itemView.team_name.text = teams.strTeam
        }
    }
}