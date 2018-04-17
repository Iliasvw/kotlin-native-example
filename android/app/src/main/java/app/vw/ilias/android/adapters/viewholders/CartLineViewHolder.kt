package app.vw.ilias.android.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import ilias.vw.libs.CartLine
import kotlinx.android.synthetic.main.row_layout_cartline.view.*


class CartLineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(cartLine: CartLine) {
        itemView.checkout_product_name.text = cartLine.getProduct().getName()
        itemView.checkout_product_price.text = "€" + String.format("%.2f", cartLine.getTotalPrice())
        itemView.checkout_product_quantity.text = cartLine.getQuantity().toString()
    }
}