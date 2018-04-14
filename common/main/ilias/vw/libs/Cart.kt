package ilias.vw.libs

class Cart {
    var name: String
    private var cartLines: List<CartLine> = mutableListOf()

    constructor(name: String) {
        this.name = name
    }

    fun getCartLines(): List<CartLine> {
        return this.cartLines
    }

    fun addCartLine(cartLine: CartLine) {
        this.cartLines += cartLine
    }

    fun getTotalPrice(): Double {
        var totalPrice: Double = 0.0

        for (line in cartLines) {
            totalPrice += line.getTotalPrice()
        }

        return totalPrice
    }

    fun removeCartLine(cartLine: CartLine) {
        this.cartLines -= cartLine
    }
}