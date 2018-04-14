package app.vw.ilias.android.adapters

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import app.vw.ilias.android.R
import app.vw.ilias.android.activities.CheckoutActivity
import app.vw.ilias.android.adapters.viewholders.CartLineViewHolder
import app.vw.ilias.android.utils.SharedPrefsUtils
import ilias.vw.libs.Cart
import ilias.vw.libs.CartLine
import ilias.vw.libs.Product
import kotlinx.android.synthetic.main.row_layout_cartline.*
import kotlinx.android.synthetic.main.row_layout_cartline.view.*

class CartLineAdapter(cart: Cart, list: List<CartLine>, private val activity: CheckoutActivity) : RecyclerView.Adapter<CartLineViewHolder>() {
    private var list: List<CartLine> = mutableListOf()
    private lateinit var cart: Cart

    init {
        this.list = list
        this.cart = cart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartLineViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_cartline, parent, false)
        val holder = CartLineViewHolder(v)
        return holder

    }

    override fun onBindViewHolder(holder: CartLineViewHolder, position: Int) {
        holder.setData(list[position])
        holder.itemView.checkout_product_delete.setOnClickListener({
            list -= list[position]
            this.cart.removeCartLine(list[position])
            SharedPrefsUtils.cacheCart(this.cart, activity)
            this.activity.updateTotalPrice()
            notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}