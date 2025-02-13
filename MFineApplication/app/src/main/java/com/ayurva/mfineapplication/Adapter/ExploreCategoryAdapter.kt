package com.ayurva.mfineapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.Model.ExploreCategoryModel
import com.ayurva.mfineapplication.ViewHolder.CategoryViewHolder
import com.ayurva.mfineapplication.databinding.ExploreMoreCategoryLayoutBinding

class ExploreCategoryAdapter(private val categoryList: List<ExploreCategoryModel>) :
    RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ExploreMoreCategoryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val model = categoryList[position]
        holder.setCategoryData(model)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}