import UIKit
import SharediOS

class CartLineCell: UITableViewCell {
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var quantityLabel: UILabel!
    
    var cartLine: SOSCartLine! {
        didSet {
            nameLabel.text = cartLine.getProduct().getName()
            priceLabel.text = "€ \(cartLine.getProduct().getPrice())"
            quantityLabel.text = "\(cartLine.getQuantity())"
            nameLabel.lineBreakMode = .byWordWrapping
            nameLabel.numberOfLines = 0
        }
    }
}
