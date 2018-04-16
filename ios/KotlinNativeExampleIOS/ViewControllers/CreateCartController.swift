//
//  ViewController.swift
//  KotlinNativeExampleIOS
//
//  Created by Ilias Van Wassenhove on 2/04/18.
//  Copyright © 2018 Ilias Van Wassenhove. All rights reserved.
//

import UIKit
//import KotlinNativeFramework
import SharediOS
class CreateCartController: UIViewController {
    @IBOutlet weak var nameField: UITextField!
    override func viewDidLoad() {
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
            store.cart = SOSCart(name: nameField.text!)
            store.products = []
            for _ in 1...10 {
                store.products.append(SOSProduct(name: "Playstation 4", price: 399.95, description: "Playstation 4 gaming console", productImage: 1))
            }
        default:
            fatalError("No segue found")
        }
    }
}

