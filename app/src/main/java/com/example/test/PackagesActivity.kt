package com.example.test

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * PackagesActivity.kt
 *
 * Displays all four gaming packages.
 *
 * Includes:
 * - Search
 * - Package detail navigation
 * - Services navigation
 * - Separate fee calculation button
 * - Reusable header
 * - Reusable footer
 */

class PackagesActivity : AppCompatActivity() {

    // Container holding package cards.
    private lateinit var packagesContainer: LinearLayout
    // Package Search Field
    private lateinit var packageSearch: EditText
    // Stores the original list so that searching works and does not destroy the original data.
    private val packages = ArenaData.packages

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages)

        // Initialize  header.
        HeaderHelper.setupHeader(this)


        // Find XML controls.
        packagesContainer =
            findViewById(R.id.packagesContainer)

        packageSearch =
            findViewById(R.id.packageSearch)

        val viewServicesButton =
            findViewById<Button>(
                R.id.viewServicesButton
            )

        val calculateFeesButton =
            findViewById<Button>(
                R.id.calculateFeesButton
            )

        // Display the packages.
        displayPackages(packages)

        // Set up the search.
        packageSearch.addTextChangedListener(
            object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {

                    filterPackages()
                }

                override fun afterTextChanged(
                    s: Editable?
                ) {
                }
            }
        )

        // Open Services page
        viewServicesButton.setOnClickListener {

            NavigationHelper.openServices(this)
        }

/*        // Open the separate fee calculator.
        calculateFeesButton.setOnClickListener {
            NavigationHelper.openFeeCalculator(this)
                } */
    }

    // Filters packages according to the search input.
    private fun filterPackages() {

        val searchText =
            packageSearch.text
                .toString()
                .trim()
                .lowercase()

        val filteredPackages =
            packages.filter {

                it.name.lowercase()
                    .contains(searchText)
            }

        displayPackages(filteredPackages)
    }

    // Displays the package cards.
    private fun displayPackages(
        items: List<ArenaItem>
    ) {

        packagesContainer.removeAllViews()

        /*
         * No search results.
         */
        if (items.isEmpty()) {

            val noResults =
                TextView(this)

            noResults.text =
                "No packages found."

            noResults.textSize = 16f

            noResults.setPadding(
                16,
                30,
                16,
                30
            )

            packagesContainer.addView(
                noResults
            )

            return
        }

        // Create a card for every package.
        items.forEach { packageItem ->

            val itemView =
                LayoutInflater.from(this)
                    .inflate(
                        R.layout.item_arena,
                        packagesContainer,
                        false
                    )

            // Get card controls.
            val icon =
                itemView.findViewById<ImageView>(
                    R.id.itemIcon
                )

            val name =
                itemView.findViewById<TextView>(
                    R.id.itemName
                )

            val price =
                itemView.findViewById<TextView>(
                    R.id.itemPrice
                )

            // Display the user's supplied icon.
            icon.setImageResource(
                packageItem.iconResId
            )

            // Display package name.
            name.text =
                packageItem.name

            // Display package price.
            price.text =
                String.format(
                    "R%,.2f per person",
                    packageItem.price
                )

            // Open package detail page.
            itemView.setOnClickListener {

                NavigationHelper.openDetails(
                    this,
                    packageItem
                )
            }

            packagesContainer.addView(
                itemView
            )
        }
    }
}