import Toast_Swift
import UIKit
import SharediOS

class StoreViewController: UIViewController {
    var products: [SOSProduct]!
    @IBOutlet weak var tableView: UITableView!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "showProductDetails"?:
            let selection = tableView.indexPathForSelectedRow!
            let prodDetailsController = segue.destination as! ProductDetailViewController
            prodDetailsController.product = products[selection.row]
            tableView.deselectRow(at: selection, animated: true)
        case "showCheckout"?:
            break
        default:
            fatalError("No segue found")
        }
    }
}

extension StoreViewController: UITableViewDelegate {}

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
