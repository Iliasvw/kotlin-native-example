package ilias.vw.libs

class Cart constructor(name: String) {
    var name: String = name
    private var cartLines: List<CartLine> = mutableListOf()

    fun getCartLines(): List<CartLine> {
        return this.cartLines
    }

    fun addCartLine(cartLine: CartLine) {
        this.cartLines += cartLine
    }

    fun getTotalPrice(): Double {
        var totalPrice = 0.0

        for (line in cartLines) {
            totalPrice += line.getTotalPrice()
        }

        return totalPrice
    }

    fun removeCartLine(cartLine: CartLine) {
        this.cartLines -= cartLine
    }
}