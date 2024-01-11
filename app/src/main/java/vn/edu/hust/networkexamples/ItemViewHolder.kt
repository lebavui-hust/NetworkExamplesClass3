package vn.edu.hust.networkexamples

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.networkexamples.databinding.ItemLayoutBinding

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageAvatar: ImageView
    val textName: TextView
    val textEmail: TextView
    val textAddress: TextView
    val root: View
    init {
        root = itemView
        imageAvatar = itemView.findViewById(R.id.image_avatar)
        textName = itemView.findViewById(R.id.text_name)
        textEmail = itemView.findViewById(R.id.text_email)
        textAddress = itemView.findViewById(R.id.text_address)
    }
}