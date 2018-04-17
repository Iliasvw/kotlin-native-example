package app.vw.ilias.android.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.TextView
import app.vw.ilias.android.R
import app.vw.ilias.android.adapters.ProductAdapter
import app.vw.ilias.android.utils.SharedPrefsUtils
import ilias.vw.libs.Cart
import ilias.vw.libs.Product
import android.view.MenuItem


class StoreActivity : AppCompatActivity() {

    private lateinit var cart: Cart
    private var products: List<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        initProducts()
        this.cart = SharedPrefsUtils.getCart(this)!!
        findViewById<TextView>(R.id.store_cart_name).setText("Shopping cart: " + this.cart.name.toUpperCase())
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ProductAdapter(this.products, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = 1000
        itemAnimator.removeDuration = 1000
        recyclerView.itemAnimator = itemAnimator
    }

    private fun initProducts() {
        this.products += Product("Playstation 4", 399.95, "Playstation 4 gaming console", R.drawable.ps4)
        this.products += Product("Xbox One", 324.95, "Xbox One gaming console", R.drawable.xbox)
        this.products += Product("Sony HD TV", 699.95, "Ultra HD Sony LCD TV", R.drawable.sony)
        this.products += Product("Netflix 1 month", 9.95, "Netflix card to use Netflix for one month", R.drawable.netflix)
        this.products += Product("Macbook Pro 2017", 2399.95, "Macbook Pro 2017 with 16GB of RAM and 256GB of HDD", R.drawable.macbook)
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
