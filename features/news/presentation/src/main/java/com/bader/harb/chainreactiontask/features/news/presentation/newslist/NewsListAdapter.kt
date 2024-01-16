package com.bader.harb.chainreactiontask.features.news.presentation.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bader.harb.chainreactiontask.features.news.domain.models.NewsListModel
import com.bader.harb.chainreactiontask.features.news.presentation.R
import com.bader.harb.chainreactiontask.features.news.presentation.databinding.ItemNewsBinding
import com.bumptech.glide.Glide

class NewsListAdapter(
    private var model: List<NewsListModel?>
) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>(), Filterable {

    var onNewsItemClick: ((newsListModel: NewsListModel?) -> Unit)? = null
    var onShareNewsItemClick: ((newsListModel: NewsListModel?) -> Unit)? = null

    var modelFiltered: MutableList<NewsListModel?>? = mutableListOf()

    init {
        modelFiltered?.addAll(model)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    fun getSizeList(): Int {
        return modelFiltered?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = modelFiltered?.get(position)
        holder.binding.model = model
        holder.binding.executePendingBindings()

        holder.binding.imageViewShare.setOnClickListener {
            onShareNewsItemClick?.invoke(model)
        }
        Glide.with(holder.binding.root.context).load(model?.url)
            .error(R.drawable.img_news_background)
            .placeholder(R.drawable.img_news_background).into(holder.binding.appCompatImageView)
    }

    override fun getItemCount() = modelFiltered?.size ?: 0

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    inner class ViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onNewsItemClick?.invoke(
                        modelFiltered?.get(position),
                    )
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence?.isNotEmpty() == true) {
                    filterResults.values = model.filter {
                        it?.title?.contains(charSequence, true) == true
                    }
                } else {
                    filterResults.values = model
                }
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                modelFiltered?.clear()
                modelFiltered?.addAll(filterResults.values as List<NewsListModel?>)
                notifyDataSetChanged()
            }
        }
    }

    interface OnClickSearchItemFieldListener {
        fun onClickItem(searchItem: NewsListModel?)
    }
}