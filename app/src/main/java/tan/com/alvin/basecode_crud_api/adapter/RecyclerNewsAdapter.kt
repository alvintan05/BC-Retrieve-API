package tan.com.alvin.basecode_crud_api.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import tan.com.alvin.basecode_crud_api.R
import tan.com.alvin.basecode_crud_api.model.NewsModel

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
class RecyclerNewsAdapter(private val listNews: List<NewsModel>, private val listener: (NewsModel) -> Unit)
    : RecyclerView.Adapter<RecyclerNewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindItem(listNews[position], listener)
    }


    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val newsImage: ImageView = view.findViewById(R.id.content_image)
        private val newsTitle: TextView = view.findViewById(R.id.content_title)
        private val newsAuthor: TextView = view.findViewById(R.id.content_author)

        fun bindItem(newsItem: NewsModel, listener: (NewsModel) -> Unit) {
            newsTitle.text = newsItem.newsTitle
            newsAuthor.text = newsItem.newsAuthor
            Glide
                    .with(itemView.context)
                    .load(newsItem.newsImageUrl)
                    .into(newsImage)
        }
    }

}