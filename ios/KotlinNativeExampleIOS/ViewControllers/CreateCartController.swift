import Toast_Swift
import UIKit
import SharediOS
class CreateCartController: UIViewController {
    @IBOutlet weak var nameField: UITextField!
    
    override func viewDidLoad() {
        if CachingUtils.getCartFromCache() != nil {
            performSegue(withIdentifier: "showStore", sender: self)
        }
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "showStore"?:
            let store = segue.destination as! StoreViewController
            let cart: SOSCart? = SOSCart(name: nameField.text!)
            CachingUtils.cacheCart(cart: cart!)
            store.products = []
            store.products.append(SOSProduct(name: "Playstation 4", price: 399.95, description: "Playstation 4 gaming console", productImage: "ps4"))
            store.products.append(SOSProduct(name: "Xbox One", price: 324.95, description: "Xbox One gaming console", productImage: "xbox"))
            store.products.append(SOSProduct(name: "Sony HD TV", price: 699.95, description: "Ultra HD Sony LCV TV", productImage: "sony"))
            store.products.append(SOSProduct(name: "Netflix 1 month", price: 9.95, description: "Netflix card to use Netflix for one month", productImage: "netflix"))
            store.products.append(SOSProduct(name: "Macbook Pro 2017", price: 2399.95, description: "Macbook Pro 2017 with 16GB of RAM and 256GB of HDD", productImage: "macbook"))
            nameField.text = ""
        default:
            fatalError("No segue found")
        }
    }
    
   @IBAction func createCart() {
        if let text = nameField.text {
            if text != "" {
                performSegue(withIdentifier: "showStore", sender: self)
            }
        }
    }
}

