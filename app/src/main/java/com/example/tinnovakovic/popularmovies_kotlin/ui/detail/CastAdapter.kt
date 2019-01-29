package com.example.tinnovakovic.popularmovies_kotlin.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tinnovakovic.popularmovies_kotlin.Const.BASE_IMAGE_URL
import com.example.tinnovakovic.popularmovies_kotlin.R
import com.example.tinnovakovic.popularmovies_kotlin.data.CastResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cast_list_item.view.*

class CastAdapter (val castCallBack: (CastResult) -> Unit) : RecyclerView.Adapter<CastAdapter.CastHolder>() {

    private var castData: List<CastResult> = listOf()

    override fun getItemCount(): Int = castData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cast_list_item, parent, false)
        return CastHolder(view)    }

    override fun onBindViewHolder(holder: CastHolder, position: Int) {
        holder.bind(castData[position])
    }

    fun setData(data: List<CastResult>) {
        castData = data
        notifyDataSetChanged()
    }

    class CastHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(cast: CastResult) {
            Picasso.with(itemView.context)
                    .load(BASE_IMAGE_URL + cast.profilePath)
                    .into(itemView.castmemberThumbnail)

            itemView.characterName.text = cast.character
            itemView.actorName.text = cast.name

        }
    }
}