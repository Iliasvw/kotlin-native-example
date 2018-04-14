import UIKit
import SharediOS

class ProductCell: UITableViewCell {
    
    @IBOutlet weak var nameLabel: UILabel!
    
    var product: SOSProduct! {
        didSet {
            nameLabel.text = product.getName()
        }
    }
}

