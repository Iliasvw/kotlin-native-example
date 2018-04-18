import UIKit
import SharediOS

class ProductCell: UITableViewCell {
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    
    var product: SOSProduct! {
        didSet {
            nameLabel.text = product.getName()
            priceLabel.text = String(format: "€ %.2f", product.getPrice())
        }
    }
}

