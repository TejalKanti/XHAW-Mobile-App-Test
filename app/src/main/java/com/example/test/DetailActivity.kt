package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * DetailActivity.kt
 *
 * Displays the detailed information for whichever
 * service or package the customer selected.
 */

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Initialize header.
        HeaderHelper.setupHeader(this)

        // Find detail controls.
        val detailIcon =
            findViewById<ImageView>(
                R.id.detailIcon
            )

        val detailName =
            findViewById<TextView>(
                R.id.detailName
            )

        val detailPrice =
            findViewById<TextView>(
                R.id.detailPrice
            )

        val detailDescription =
            findViewById<TextView>(
                R.id.detailDescription
            )

        val calculateButton =
            findViewById<Button>(
                R.id.detailCalculateButton
            )


        // Receive information from the Services or Packages Activity.
        val itemName =
            intent.getStringExtra(
                "itemName"
            ) ?: "Gaming Experience"

        val itemPrice =
            intent.getDoubleExtra(
                "itemPrice",
                0.0
            )

        val itemDescription =
            intent.getStringExtra(
                "itemDescription"
            ) ?: ""

        val itemIcon =
            intent.getIntExtra(
                "itemIcon",
                0
            )

        // Display the information.
        detailName.text = itemName

        detailPrice.text =
            String.format(
                "R%,.2f per person",
                itemPrice
            )

        detailDescription.text =
            itemDescription

        // Display the user's supplied icon.
        if (itemIcon != 0) {

            detailIcon.setImageResource(
                itemIcon
            )
        }
/*
        // Open the separate fee calculator.
        calculateButton.setOnClickListener {

            NavigationHelper.openFeeCalculator(
                this
            )
        } */
    }
}