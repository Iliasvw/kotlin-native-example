package app.vw.ilias.android.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import app.vw.ilias.android.R
import com.squareup.picasso.Picasso
import ilias.vw.libs.Product
import kotlinx.android.synthetic.main.row_layout.view.*


class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(product: Product) {
        itemView.name.text = product.getName()
        itemView.price.text = "€" + product.getPrice().toString()
        itemView.productImage.setImageResource(product.getProductImage())
        val context = itemView.productImage.context
        Picasso.with(context).load(product.getProductImage()).resize(400, 400)
                .centerCrop().into(itemView.productImage)
    }
}