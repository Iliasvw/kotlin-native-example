import UIKit
import SharediOS

class ProductDetailViewController: UIViewController {
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var numberField: UITextField!
    @IBOutlet weak var productImage: UIImageView!
    @IBOutlet weak var addBtn: UIButton!
    var product: SOSProduct!
    private var cart: SOSCart!
    
    override func viewDidLoad() {
        self.navigationItem.title = self.product.getName()
        self.numberField.keyboardType = UIKeyboardType.numberPad
        nameLabel.text = product.getName()
        priceLabel.text = "€ " + String(format: "%.2f", product.getPrice())
        numberField.text = "1"
        descriptionLabel.text = product.getDescription()
        descriptionLabel.lineBreakMode = .byWordWrapping
        descriptionLabel.numberOfLines = 0
        self.cart = CachingUtils.getCartFromCache()
        self.productImage.image = UIImage(named: product.getProductImage())
    }
    
    @IBAction func addCartLine() {
        let count = Int32(numberField.text!)!
        if count > 0 {
            self.view.endEditing(true)
            let cartLine: SOSCartLine = SOSCartLine(product: product, quantity: count)
            self.cart.addCartLine(cartLine: cartLine)
            CachingUtils.cacheCart(cart: self.cart)
            self.view.makeToast("Product added!")
        }
    }
}
