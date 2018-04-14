package app.vw.ilias.android.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import app.vw.ilias.android.R
import app.vw.ilias.android.adapters.CartLineAdapter
import app.vw.ilias.android.adapters.ProductAdapter
import app.vw.ilias.android.utils.SharedPrefsUtils
import ilias.vw.libs.Cart
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.row_layout_cartline.*

class CheckoutActivity : AppCompatActivity() {

    private lateinit var cart: Cart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        this.cart = SharedPrefsUtils.getCart(this)!!
        checkout_title.text = "Shopping cart: " + this.cart.name.toUpperCase()
        val adapter = CartLineAdapter(this.cart, this.cart.getCartLines(), this)
        recyclerview_checkout.adapter = adapter
        recyclerview_checkout.layoutManager = LinearLayoutManager(this)
        val itemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = 1000
        itemAnimator.removeDuration = 1000
        recyclerview_checkout.itemAnimator = itemAnimator
        updateTotalPrice()
    }

    fun updateTotalPrice() {
        total_price.text = "Total price: €" + this.cart.getTotalPrice()
    }
}
