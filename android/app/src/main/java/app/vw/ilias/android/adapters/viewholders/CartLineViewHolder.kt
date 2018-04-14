package app.vw.ilias.android.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import ilias.vw.libs.CartLine
import ilias.vw.libs.Product
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_layout_cartline.view.*

/**
 * Created by ilias on 14/04/18.
 */
class CartLineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(cartLine: CartLine) {
        itemView.checkout_product_name.text = cartLine.getProduct().getName()
        itemView.checkout_product_price.text = "€" + cartLine.getTotalPrice().toString()
        itemView.checkout_product_quantity.text = cartLine.getQuantity().toString()
    }
}