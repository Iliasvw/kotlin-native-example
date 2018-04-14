import UIKit
import SharediOS

class ProductsViewController: UIViewController {
    var cart: SOSCart!
    var products: [SOSProduct]!
    //private var selectedPath: IndexPath!
    @IBOutlet weak var headLabel: UILabel!
    
    override func viewDidLoad() {
        self.headLabel.text = self.cart.name
    }
}

extension ProductsViewController: UITableViewDelegate {
    /*func tableView(_ tableView: UITableView, trailingSwipeActionsConfigurationForRowAt indexPath: IndexPath) -> UISwipeActionsConfiguration? {
        let editAction = UIContextualAction(style: .normal, title: "Edit") {
            (action, view, completionHandler) in
            self.indexPathToEdit = indexPath
            self.performSegue(withIdentifier: "editSpeler", sender: self)
            completionHandler(true)
        }
        
        let deleteAction = UIContextualAction(style: .destructive, title: "Delete") {
            (action, view, completionHandler) in
            self.spelers.remove(at: indexPath.row)
            self.tableView.deleteRows(at: [indexPath], with: .automatic)
            self.ref.child("teams").child(self.userID).child("spelers").setValue(JSONConverter.spelersToDict(spelers: self.spelers))
            completionHandler(true)
        }
        
        return UISwipeActionsConfiguration(actions: [deleteAction, editAction])
    }*/
}

extension ProductsViewController: UITableViewDataSource {
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return products.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "productCell", for: indexPath) as! ProductCell
        cell.product = products[indexPath.row]
        return cell
    }
}
