package ilias.vw.libs

expect class Product(name: String, price: Double,
                     description: String, productImage: Int) {
    fun getName(): String
    fun getPrice(): Double
    fun getDescription(): String
    fun getProductImage(): Int
}