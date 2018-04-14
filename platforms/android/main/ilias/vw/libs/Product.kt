package ilias.vw.libs

import java.io.Serializable

actual class Product: Serializable {
    private val name: String
    private val price: Double
    private val description: String
    private val productImage: Int

    actual constructor(name: String, price: Double, description: String, productImage: Int) {
        this.name = name;
        this.price = price
        this.description = description
        this.productImage = productImage
    }

    actual fun getName(): String {
        return "Android: " + this.name
    }

    actual fun getPrice(): Double {
        return this.price
    }

    actual fun getDescription(): String {
        return this.description
    }

    actual fun getProductImage(): Int {
        return this.productImage
    }
}