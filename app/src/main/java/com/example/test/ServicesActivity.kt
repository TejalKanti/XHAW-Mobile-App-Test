package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * ServicesActivity.kt
 *
 * Displays the three individual gaming experiences.
 *
 * The page also provides:
 * - Search
 * - Service detail navigation
 * - Packages navigation
 * - Separate fee calculator navigation
 * - Reusable header
 * - Reusable footer
 */

class ServicesActivity : AppCompatActivity() {
    // Container holding service cards.
    private lateinit var servicesContainer: LinearLayout
    // Search box.
    private lateinit var serviceSearch: EditText
     // Stores the original list so that searching works and does not destroy the original data.
    private val services = ArenaData.services

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        // Set up the header
        HeaderHelper.setupHeader(this)

        // Finds XML Controls
        servicesContainer =
            findViewById(R.id.servicesContainer)

        serviceSearch =
            findViewById(R.id.serviceSearch)

        val viewPackagesButton =
            findViewById<Button>(
                R.id.viewPackagesButton
            )

        val calculateFeesButton =
            findViewById<Button>(
                R.id.calculateFeesButton
            )
        // Display the services
        displayServices(services)

        // Sets up the search
        serviceSearch.setOnEditorActionListener { _, _, _ ->

            filterServices()

            false
        }

        // Filters whenever the text changes.
        serviceSearch.addTextChangedListener(
            object : android.text.TextWatcher {

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

                    filterServices()
                }

                override fun afterTextChanged(
                    s: android.text.Editable?
                ) {
                }
            }
        )

         // Open Packages page
        viewPackagesButton.setOnClickListener {

            NavigationHelper.openPackages(this)
        }

/*         // Open the separate fee calculator.
        calculateFeesButton.setOnClickListener {

            NavigationHelper.openFeeCalculator(this)
        } */
    }


     // Filters the services according to the customer's search text.
    private fun filterServices() {

        val searchText =
            serviceSearch.text
                .toString()
                .trim()
                .lowercase()

        val filteredServices =
            services.filter {

                it.name.lowercase()
                    .contains(searchText)
            }

        displayServices(filteredServices)
    }

    // Displays the service cards
    private fun displayServices(
        items: List<ArenaItem>
    ) {

        servicesContainer.removeAllViews()


         // If nothing matches the search, show a message.
        if (items.isEmpty()) {

            val noResults =
                TextView(this)

            noResults.text =
                "No services found."

            noResults.textSize = 16f

            noResults.setPadding(
                16,
                30,
                16,
                30
            )

            servicesContainer.addView(
                noResults
            )

            return
        }

        // Create a card for every service.
        items.forEach { service ->

            val itemView =
                LayoutInflater.from(this)
                    .inflate(
                        R.layout.item_arena,
                        servicesContainer,
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
                service.iconResId
            )
            // Display service name.
            name.text = service.name

            // Display service price.
            price.text =
                String.format(
                    "R%,.2f per person",
                    service.price
                )

            // Clicking the card opens the separate detail page.
            itemView.setOnClickListener {

                NavigationHelper.openDetails(
                    this,
                    service
                )
            }

            servicesContainer.addView(
                itemView
            )
        }
    }
}