package com.ayurva.mfineapplication.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ayurva.mfineapplication.Model.ExploreCategoryModel
import com.ayurva.mfineapplication.databinding.ExploreMoreCategoryLayoutBinding


class CategoryViewHolder(private val view: ExploreMoreCategoryLayoutBinding) : RecyclerView.ViewHolder(view.root) {

    fun setCategoryData(model: ExploreCategoryModel) {
        view.apply {
            Glide.with(view.categoryImage).load(model.categoryImage).into(view.categoryImage)
            view.categoryName.text = model.categoryName
            view.categoryDesc.text = model.categoryDescription
        }
    }
}