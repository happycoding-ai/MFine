package com.ayurva.mfineapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide
import java.util.ArrayList

class SearchViewAdapter(var context: Context, var userDataList: List<SymptomsModel>) :
    RecyclerView.Adapter<SearchViewAdapter.RecyclerviewHolder>() {
    var filteredUserDataList: List<SymptomsModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerviewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerviewHolder, position: Int) {

        holder.binding.tvSymptomName.text = filteredUserDataList[position].tvSymptoms
        Glide.with(holder.itemView).load(filteredUserDataList[position].ivUrl).into(holder.binding.ivImage)

//        holder.mTvSymptomName.setText(filteredUserDataList[position].tvSymptoms)
//        Glide.with(holder.mIvImage).load(filteredUserDataList[position].ivUrl).into(holder.mIvImage)
//        ItemAnimation.animateFadeIn(holder.itemView, position)

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, SymptomDetailActivity::class.java)
            intent.putExtra("symptomsName", filteredUserDataList[position].tvSymptoms)
            context.startActivity(intent)
        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(context, SymptomDetailActivity::class.java)
//            intent.putExtra("symptomsName", filteredUserDataList[position].tvSymptoms)
//            context.startActivity(intent)
//        }
//        holder.mIvImage.setOnClickListener {
//
//        }
    }

    override fun getItemCount(): Int {
        return filteredUserDataList.size
    }

    class RecyclerviewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

//    class RecyclerviewHolder(itemView: ItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
//        var mIvImage: ImageView
//        var mTvSymptomName: TextView
//
//        init {
//            mIvImage = itemView.findViewById(R.id.ivImage)
//            mTvSymptomName = itemView.findViewById(R.id.tvSymptomName)
//        }
//    }

    val filter: Filter
        get() = object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val Key = charSequence.toString()
                filteredUserDataList = if (Key.isEmpty()) {
                    userDataList
                } else {
                    val lstFiltered: MutableList<SymptomsModel> = ArrayList()
                    for (row in userDataList) {
                        if (row.tvSymptoms.toLowerCase().contains(Key.toLowerCase())) {
                            lstFiltered.add(row)
                        }
                    }
                    lstFiltered
                }
                val filterResults = FilterResults()
                filterResults.values = filteredUserDataList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredUserDataList = filterResults.values as List<SymptomsModel>
                notifyDataSetChanged()
            }
        }

    init {
        filteredUserDataList = userDataList
    }
}