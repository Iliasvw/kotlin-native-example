import UIKit
import SharediOS

class ProductCell: UITableViewCell {
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var productImage: UIImageView!
    
    var product: SOSProduct! {
        didSet {
            productImage.image = UIImage(named: product.getProductImage())
            nameLabel.text = product.getName()
            priceLabel.text = String(format: "€ %.2f", product.getPrice())
        }
    }
}

