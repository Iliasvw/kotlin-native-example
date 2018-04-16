import UIKit
import SharediOS

class StoreViewController: UIViewController {
    var cart: SOSCart!
    var products: [SOSProduct]!
    
    override func viewDidLoad() {
        //self.navigationItem.title = self.cart.name
    }
}

extension StoreViewController: UITableViewDelegate {
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

extension StoreViewController: UITableViewDataSource {
    
    /*func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 75
    }*/
    
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
