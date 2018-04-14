package app.vw.ilias.android.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import app.vw.ilias.android.R
import app.vw.ilias.android.utils.SharedPrefsUtils
import com.squareup.picasso.Picasso
import ilias.vw.libs.Cart
import ilias.vw.libs.CartLine
import ilias.vw.libs.Product
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var product: Product
    private lateinit var cart: Cart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        this.cart = SharedPrefsUtils.getCart(this)!!
        val bundle: Bundle = intent.getBundleExtra("extra")
        this.product = bundle.get("product") as Product

        detail_productImage.setImageResource(product.getProductImage())
        val context = detail_productImage.context
        Picasso.with(context).load(product.getProductImage()).resize(1000, 1000)
                .centerCrop().into(detail_productImage)
        detail_description.text = product.getDescription()
        detail_name.text = product.getName()

        add_product.setOnClickListener({
            var amount = product_amount.text.toString()
            if (amount != null && amount != "" && Integer.parseInt(amount) > 0) {
                this.cart.addCartLine(CartLine(this.product, Integer.parseInt(amount)))
                SharedPrefsUtils.cacheCart(this.cart, this)
                Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No valid amount", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_store, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.checkout -> goToCheckout()
            else -> {
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun goToCheckout() {
        startActivity(Intent(this, CheckoutActivity::class.java))
    }
}
