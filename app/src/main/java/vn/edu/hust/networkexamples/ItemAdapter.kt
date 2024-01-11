package vn.edu.hust.networkexamples

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vn.edu.hust.networkexamples.databinding.ItemLayoutBinding
import vn.edu.hust.networkexamples.models.Post
import vn.edu.hust.networkexamples.models.User

class ItemAdapter(val users: List<User>, val activity: SecondActivity): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = users[position]

        holder.textName.text = user.name
        holder.textEmail.text = user.email
        holder.textAddress.text = user.address.street + ", " + user.address.city

        Glide.with(holder.imageAvatar)
            .load("https://lebavui.github.io${user.avatar.thumbnail}")
            .into(holder.imageAvatar)

        holder.root.setOnClickListener {
            val uri = Uri.parse("geo:${user.address.geo.lat},${user.address.geo.lng}")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            activity.startActivity(mapIntent)
        }
    }
}