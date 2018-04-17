import UIKit
import SharediOS

class CheckoutViewController: UIViewController {
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    private var cart: SOSCart!
    
    override func viewDidLoad() {
        self.cart = CachingUtils.getCartFromCache()
        titleLabel.text = "Shopping cart: \(cart.name)"
        priceLabel.text = "Total price: € \(cart.getTotalPrice())"
    }
}

extension CheckoutViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, trailingSwipeActionsConfigurationForRowAt indexPath: IndexPath) -> UISwipeActionsConfiguration? {
        let deleteAction = UIContextualAction(style: .destructive, title: "Delete") {
            (action, view, completionHandler) in
            let cartLine: SOSCartLine = self.cart.getCartLines()[indexPath.row]
            self.cart.removeCartLine(cartLine: cartLine)
            tableView.deleteRows(at: [indexPath], with: .automatic)
            completionHandler(true)
        }
        return UISwipeActionsConfiguration(actions: [deleteAction])
    }
}

extension CheckoutViewController: UITableViewDataSource {
    
    /*func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
     return 75
     }*/
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return cart.getCartLines().count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cartlineCell", for: indexPath) as! CartLineCell
        cell.cartLine = cart.getCartLines()[indexPath.row]
        return cell
    }
}
