import UIKit
import SharediOS
class CreateCartController: UIViewController {
    @IBOutlet weak var nameField: UITextField!
    
    override func viewDidLoad() {
        if(CachingUtils.getCartFromCache() != nil) {
            performSegue(withIdentifier: "showStore", sender: self)
        }
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "showStore"?:
            let store = segue.destination as! StoreViewController
            let cart: SOSCart? = SOSCart(name: nameField.text!)
            CachingUtils.cacheCart(cart: cart!)
            store.products = []
            for i in 1...10 {
                store.products.append(SOSProduct(name: "Playstation 4\(i)", price: 399.95, description: "Playstation 4 gaming console with description \(i)"))
            }
        default:
            fatalError("No segue found")
        }
    }
}

