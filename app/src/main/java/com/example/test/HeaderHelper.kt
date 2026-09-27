package com.example.test

import android.app.Activity
import android.view.View

/*
 * HeaderHelper.kt
 *
 * Controls the reusable header used by the
 * Services and Packages pages.
 *
 * The business logo itself is loaded from header.xml.
 */

object HeaderHelper {

    // Sets up the menu button.
    fun setupHeader(activity: Activity) {

        // Finds the menu button from header.xml
        val menuButton =
            activity.findViewById<View>(
                R.id.menuButton
            )

        /*
         * Open the drop-down navigation when
         * the user presses MENU.
         */
        menuButton?.setOnClickListener {

            NavigationHelper.showNavigationMenu(
                activity,
                menuButton
            )
        }
    }
}