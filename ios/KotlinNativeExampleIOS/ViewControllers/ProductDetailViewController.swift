import UIKit
import SharediOS

class ProductDetailViewController: UIViewController {
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var numberField: UITextField!
    @IBOutlet weak var addBtn: UIButton!
    var product: SOSProduct!
    private var cart: SOSCart!
    
    override func viewDidLoad() {
        self.navigationItem.title = self.product.getName()
        self.numberField.keyboardType = UIKeyboardType.numberPad
        nameLabel.text = product.getName()
        priceLabel.text = "€ " + String(format: "%.2f", product.getPrice())
        numberField.text = "1"
        self.cart = CachingUtils.getCartFromCache()
    }
    
    @IBAction func addCartLine() {
        let count = numberField.text!
        let cartLine: SOSCartLine = SOSCartLine(product: product, quantity: Int32(count)!)
        self.cart.addCartLine(cartLine: cartLine)
        CachingUtils.cacheCart(cart: self.cart)
        for item in cart.getCartLines() {
            print("Item: \(item.getProduct().getName()), \(item.getQuantity()), \(item.getTotalPrice())")
        }
    }
}
