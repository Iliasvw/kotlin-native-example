package app.vw.ilias.android.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import app.vw.ilias.android.R
import app.vw.ilias.android.utils.SharedPrefsUtils
import ilias.vw.libs.Cart

class CreateCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_cart)
        var cart: Cart? = SharedPrefsUtils.getCart(this)
        if(cart != null) {
            goToStore(cart)
        }

        initGui()
    }

    private fun initGui() {
        findViewById<Button>(R.id.create_btn).setOnClickListener(View.OnClickListener {
            val text: String = (findViewById<EditText>(R.id.cartName)).text.toString()
            if(text == null || text.equals("")) {
                Toast.makeText(this, "Please fill in a valid name for your cart", Toast.LENGTH_LONG).show()
            } else {
                goToStore(Cart(text))
            }
        })
    }

    private fun goToStore(cart: Cart) {
        SharedPrefsUtils.cacheCart(cart, this)
        var intent: Intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }
}
