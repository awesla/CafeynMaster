package com.cafeyn.presentation.ui.news.listing

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cafeyn.domain.models.MyNews
import com.cafeyn.presentation.databinding.ItemNewsBinding

internal class MyNewsAdapter :
    ListAdapter<MyNews, MyNewsAdapter.NewsViewHolder>(DiffItemCallback) {

    internal var itemClickListener: ((MyNews) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(
            newsInfo = getItem(position),
            itemClickListener = itemClickListener
        )

    internal class NewsViewHolder(private val itemNewsBinding: ItemNewsBinding) :
        RecyclerView.ViewHolder(itemNewsBinding.root) {
        fun bind(
            newsInfo: MyNews,
            itemClickListener: ((MyNews) -> Unit)?
        ) {

            with(itemNewsBinding) {
                picture.load(newsInfo.thumbnailUrl)
                textTitle.text = newsInfo.title

                itemView.setOnClickListener { itemClickListener?.invoke(newsInfo) }
            }
        }
    }

    private object DiffItemCallback : DiffUtil.ItemCallback<MyNews>() {
        override fun areItemsTheSame(oldItem: MyNews, newItem: MyNews) =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: MyNews, newItem: MyNews) =
            oldItem == newItem
    }
}