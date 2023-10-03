package uz.gita.examfinal2.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.examfinal2.R
import uz.gita.examfinal2.data.model.TextData
import uz.gita.examfinal2.databinding.ItemCategoryBinding

class TextAdapter : ListAdapter<TextData, TextAdapter.EventHolder>(EventDiffUtil) {

    private var clickListener: ((TextData) -> Unit)? = null

    object EventDiffUtil : DiffUtil.ItemCallback<TextData>() {
        override fun areItemsTheSame(oldItem: TextData, newItem: TextData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TextData, newItem: TextData): Boolean {
            return oldItem.title == newItem.title
        }

    }

    inner class EventHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (getItem(adapterPosition).checked) {
                    binding.root.background = ContextCompat.getDrawable(binding.root.context, R.drawable.bg_category_checked)
                    binding.txtCategory.setTextColor(Color.WHITE)
                    getItem(adapterPosition).checked = !getItem(adapterPosition).checked
                } else {
                    binding.root.background = ContextCompat.getDrawable(binding.root.context, R.drawable.bg_category_unchecked)
                    binding.txtCategory.setTextColor(Color.BLUE)
                    getItem(adapterPosition).checked = !getItem(adapterPosition).checked
                }
                clickListener?.invoke(getItem(adapterPosition))
            }

        }

        fun bind() {
            getItem(adapterPosition).apply {
                binding.txtCategory.text = this.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder = EventHolder(
        ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind()
    }

    fun setClickListener(block: (TextData) -> Unit) {
        clickListener = block
    }

}