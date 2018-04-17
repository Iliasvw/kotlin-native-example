package ilias.vw.libs

class CartLine {
    private val product: Product
    private var quantity: Int

    constructor(product: Product, quantity: Int) {
        this.product = product
        this.quantity = quantity
    }

    fun getProduct(): Product {
        return this.product
    }

    fun getQuantity(): Int {
        return this.quantity
    }

    fun getTotalPrice(): Double {
        return product.getPrice() * quantity
    }

    fun add(quantity: Int) {
        this.quantity += quantity
    }
}