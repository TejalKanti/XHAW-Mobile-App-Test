package com.example.test

/*
 * FOUR GAMING PACKAGES:
 *
 * Each item contains:
 *
 * name        = Name of the service/package
 * price       = Display price
 * iconResId   = Icon used on the card. Android Vector Drawable resource ID
 * description = Information about the service/package
 * isPackage   = Identifies whether the item is a package or an individual service.
 */

data class ArenaItem(
    val name: String,
    val price: Double,
    val iconResId: Int,
    val description: String,
    val isPackage: Boolean
)

/*
 * ArenaData is an object file containing the information displayed throughout
 * the Services and Packages screens.
 */

object ArenaData {

    /*
     * GAMING PACKAGES
     * These are the four main packages offered by the
     * Gaming Arena.
     */

    val packages = listOf(

        // Package 1: The Ultimate Gamer Pass
        ArenaItem(
            // Name displayed on the package card.
            name = "The Ultimate Gamer Pass",
            // Price displayed on the package card.
            price = 1500.00,
            // Icon displayed above/next to the package.
            iconResId = R.drawable.ultimate,
            // Description displayed when the package information is viewed.
            description =
                "This package provides full-day access to all " +
                        "gaming facilities at The Next Level Gaming and " +
                        "E-sports Arena. It is aimed at dedicated gamers " +
                        "who want maximum value. It includes PC gaming, " +
                        "console gaming, high-speed internet, snack vouchers " +
                        "and tournament participation.",
            // true means that this item is a package.
            isPackage = true
        ),

        // Package 2: The VIP Gaming Experience
        ArenaItem(
            name = "The VIP Gaming Experience",
            price = 1500.00,
            iconResId = R.drawable.vip,
            description =
                "This premium option offers a personalized gaming " +
                        "experience with hospitality services. It includes " +
                        "a booth, premium equipment, catering, priority " +
                        "booking and a personal gaming assistant.",
            isPackage = true
        ),

        // Package 3: The E-Sports Training Package
        ArenaItem(
            name = "The E-Sports Training Package",
            price = 1500.00,
            iconResId = R.drawable.esports,
            description =
                "This package focuses on skill development through " +
                        "strategy coaching, team communication training, " +
                        "match analysis, practice sessions and performance " +
                        "feedback.",

            isPackage = true
        ),

        // Package 4: The Birthday Party Package
        ArenaItem(
            name = "The Birthday Party Package",
            price = 1500.00,
            iconResId = R.drawable.party,
            description =
                "This package offers a gaming-themed birthday " +
                        "celebration with a reserved party space, multiplayer " +
                        "competitions, themed decorations, catering, prizes " +
                        "and event coordination.",
            isPackage = true
        )
    )


    /*
     * INDIVIDUAL SERVICES / EXPERIENCES
     *
     * These are the three individual experiences offered
     * separately from the larger packages.
     */

    val services = listOf(

        // Service 1: Virtual Reality Experience
        ArenaItem(
            name = "The Virtual Reality Experience",
            price = 750.00,
            iconResId = R.drawable.vr,
            description =
                "This immersive experience includes a VR headset, " +
                        "a game library, professional support, a safety " +
                        "briefing and a session lasting 60 to 90 minutes.",
            // false means that this is an individual service.
            isPackage = false
        ),

        // Service 2: Racing Simulator Challenge
        ArenaItem(
            name = "The Racing Simulator Challenge",
            price = 750.00,
            iconResId = R.drawable.racing,
            description =
                "This experience includes a racing simulator, " +
                        "multiple track options, leaderboard competition, " +
                        "vehicle variety, telemetry and a 60-minute session.",
            isPackage = false
        ),

        // Service 3: Escape Room Challenge
        ArenaItem(
            name = "The Escape Room Challenge",
            price = 750.00,
            iconResId = R.drawable.escape,
            description =
                "This challenge provides a team-based gaming " +
                        "experience involving puzzles, communication, " +
                        "strategy and problem solving.",
            isPackage = false
        )
    )


    /*
     * This combines the package list and service list.
     * Returns both packages and services.
     * It can be useful later if the application needs to display every available
     * offering in one screen.


    val allItems: List<ArenaItem>
        get() = packages + services  */
}
