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
        case "showProducts"?:
            let productsController = segue.destination as! ProductsViewController
            productsController.cart = SOSCart(name: nameField.text!)
            productsController.products = []
            for i in 1...10 {
                productsController.products.append(SOSProduct(name: "Product \(i)"))
            }
        default:
            fatalError("No segue found")
        }
    }
}

