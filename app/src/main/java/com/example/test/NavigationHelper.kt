package com.example.test

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.PopupWindow
import android.widget.TextView

object NavigationHelper {

    // Open the Services page.
    fun openServices(context: Context) {

        val intent = Intent(
            context,
            ServicesActivity::class.java
        )

        context.startActivity(intent)
    }

    // Open the Packages page.
    fun openPackages(context: Context) {

        val intent = Intent(
            context,
            PackagesActivity::class.java
        )

        context.startActivity(intent)
    }

    /*
     * Opens the separate fee calculation page.
     *
     * Fees are deliberately NOT calculated directly
     * on the Services or Packages page.
     */
/*    fun openFeeCalculator(context: Context) {

        val intent = Intent(
            context,
            FeeCalculationActivity::class.java
        )

        context.startActivity(intent)
    } */

    // Open the detail page.
    fun openDetails(
        context: Context,
        item: ArenaItem
    ) {

        val intent = Intent(
            context,
            DetailActivity::class.java
        )
        // Pass data to the detail page.
        intent.putExtra(
            "itemName",
            item.name
        )

        intent.putExtra(
            "itemPrice",
            item.price
        )

        intent.putExtra(
            "itemDescription",
            item.description
        )

        intent.putExtra(
            "itemIcon",
            item.iconResId
        )

        intent.putExtra(
            "isPackage",
            item.isPackage
        )

        context.startActivity(intent)
    }

    // Show the navigation menu.
    fun showNavigationMenu(
        context: Context,
        anchor: View
    ) {

        // Inflate the menu layout.
        val menuView = View.inflate(
            context,
            R.layout.dropdown_menu,
            null
        )

        // Create the popup window.
        val popupWindow = PopupWindow(
            menuView,
            300,
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        // Find menu options.
        val services =
            menuView.findViewById<TextView>(
                R.id.menuServices
            )
        // Find menu options.
        val packages =
            menuView.findViewById<TextView>(
                R.id.menuPackages
            )
        // Find menu options.
        val fees =
            menuView.findViewById<TextView>(
                R.id.menuFees
            )

        // Close the menu.
        services.setOnClickListener {

            popupWindow.dismiss()

            openServices(context)
        }
        // Close the menu.
        packages.setOnClickListener {

            popupWindow.dismiss()

            openPackages(context)
        }

        // Fee calculator button.
        fees.setOnClickListener {

            popupWindow.dismiss()

//            openFeeCalculator(context)
        }

        // Display the menu.s
        popupWindow.showAsDropDown(
            anchor,
            -20,
            5
        )
    }
}