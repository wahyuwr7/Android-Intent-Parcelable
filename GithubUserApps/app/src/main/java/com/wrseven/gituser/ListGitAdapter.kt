package com.wrseven.gituser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListGitAdapter(private val listUser : ArrayList<Data>) : RecyclerView.Adapter<ListGitAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_git, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClick(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        fun bind(data: Data) {
            Glide.with(itemView.context)
                    .load(data.photo)
                    .apply(RequestOptions().override(55,55))
                    .into(imgPhoto)
            tvName.text = data.name
            tvUsername.text = data.username
        }
    }

    interface OnItemClickCallback{
        fun onItemClick(data: Data)
    }
}