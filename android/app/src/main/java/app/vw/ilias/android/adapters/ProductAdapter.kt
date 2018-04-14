package app.vw.ilias.android.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.vw.ilias.android.R
import app.vw.ilias.android.activities.ProductDetailActivity
import app.vw.ilias.android.adapters.viewholders.ProductViewHolder
import ilias.vw.libs.Product

class ProductAdapter(list: List<Product>, private val context: Context) : RecyclerView.Adapter<ProductViewHolder>() {
    private var list: List<Product> = mutableListOf()

    init {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        val holder = ProductViewHolder(v)
        return holder

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(list[position])
        holder.itemView.setOnClickListener({
            val intent: Intent = Intent(context, ProductDetailActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putSerializable("product", list[position])
            intent.putExtra("extra", bundle)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}