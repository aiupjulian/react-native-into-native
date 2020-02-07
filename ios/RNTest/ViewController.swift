//
//  ViewController.swift
//  RNTest
//
//  Created by Julian Aiup on 07/02/2020.
//  Copyright © 2020 Julian Aiup. All rights reserved.
//

import UIKit
import React

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func highScoreButtonTapped(sender : UIButton) {
      NSLog("Hello")
      let jsCodeLocation = URL(string: "http://localhost:8081/index.bundle?platform=ios")
      let mockData:NSDictionary = ["list":
          [
              ["name":"Example parameter 1", "value":"42"],
              ["name":"Example parameter 2", "value":"10"]
          ]
      ]

      let rootView = RCTRootView(
          bundleURL: jsCodeLocation!,
          moduleName: "RNTestScreen",
          initialProperties: mockData as [NSObject : AnyObject],
          launchOptions: nil
      )
      let vc = UIViewController()
      vc.view = rootView
      self.present(vc, animated: true, completion: nil)
    }
}

