package com.codepath.articlesearch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CelebrityAdapter(private val context: Context, private val celebrities: List<Celebrity>) :
    RecyclerView.Adapter<CelebrityAdapter.ViewHolder>() {

    //Helper method


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_celebrity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val celebrity = celebrities[position]
        holder.bind(celebrity)
    }

    override fun getItemCount() = celebrities.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaActorImage = itemView.findViewById<ImageView>(R.id.mediaPersonUrl)
        private val nameTextView = itemView.findViewById<TextView>(R.id.mediaName)
        private val popularityTextView = itemView.findViewById<TextView>(R.id.mediaPopularity)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(celebrity: Celebrity) {
            nameTextView.text = celebrity.name
            //popularityTextView.text = movie.popularity
            popularityTextView.text = celebrity.popularity


            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+ celebrity.imageUrl)
                .into(mediaActorImage)
        }

        override fun onClick(v: View?) {
            // Get selected article
//            val article = articles[absoluteAdapterPosition]
//
//            //  Navigate to Details screen and pass selected article
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra(ARTICLE_EXTRA, article)
//            context.startActivity(intent)
        }
    }

}