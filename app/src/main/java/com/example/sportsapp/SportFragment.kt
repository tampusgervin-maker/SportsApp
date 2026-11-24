package com.example.sportsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

/** One class reused by every sport destination in the nav graph (name/description come as arguments). */
class SportFragment : Fragment() {

    private data class Event(val title: String, val detail: String)
    private data class News(val title: String, val detail: String)
    private data class SportDetails(
        val iconRes: Int,
        val events: List<Event>,
        val news: List<News>
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_sport, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("sportName").orEmpty()
        val description = arguments?.getString("sportDescription").orEmpty()

        view.findViewById<TextView>(R.id.sport_name).text = name
        view.findViewById<TextView>(R.id.sport_description).text = description

        val details = getSampleData(name)
        view.findViewById<ImageView>(R.id.sport_icon).setImageResource(details.iconRes)

        if (details.events.size >= 2) {
            view.findViewById<TextView>(R.id.event1_title).text = details.events[0].title
            view.findViewById<TextView>(R.id.event1_detail).text = details.events[0].detail
            view.findViewById<TextView>(R.id.event2_title).text = details.events[1].title
            view.findViewById<TextView>(R.id.event2_detail).text = details.events[1].detail
        }

        if (details.news.size >= 2) {
            view.findViewById<TextView>(R.id.news1_title).text = details.news[0].title
            view.findViewById<TextView>(R.id.news1_detail).text = details.news[0].detail
            view.findViewById<TextView>(R.id.news2_title).text = details.news[1].title
            view.findViewById<TextView>(R.id.news2_detail).text = details.news[1].detail
        }
    }

    private fun getSampleData(name: String): SportDetails {
        return when (name.lowercase()) {
            "football" -> SportDetails(
                iconRes = R.drawable.ic_football,
                events = listOf(
                    Event("Championship Final", "Saturday, 18:00 • National Stadium"),
                    Event("City League Derby", "Sunday, 15:30 • City Arena")
                ),
                news = listOf(
                    News("Dramatic Last-Minute Derby Win", "Striker scores a stunning header in stoppage time to secure victory."),
                    News("Star Player Returns from Injury", "Key midfielder cleared to play in upcoming championship match.")
                )
            )
            "basketball" -> SportDetails(
                iconRes = R.drawable.ic_basketball,
                events = listOf(
                    Event("All-Star Tournament", "Friday, 19:00 • Metropolitan Center"),
                    Event("Playoffs Game 1", "Sunday, 17:00 • Sports Dome")
                ),
                news = listOf(
                    News("Buzzer-Beater Thriller", "Unbelievable half-court shot at the buzzer seals dramatic comeback."),
                    News("New Assist Record Set", "Point guard delivers 18 assists in a single game record performance.")
                )
            )
            "tennis" -> SportDetails(
                iconRes = R.drawable.ic_tennis,
                events = listOf(
                    Event("Grand Open Final", "Saturday, 10:00 • Centre Court"),
                    Event("Summer Clay Cup", "Tuesday, 14:00 • Tennis Club")
                ),
                news = listOf(
                    News("Defending Champion Advances", "Fierce 3-set battle ends with victory for the tournament favorite."),
                    News("Wildcard Rising Star", "19-year-old newcomer reaches semi-finals after major upset.")
                )
            )
            "swimming" -> SportDetails(
                iconRes = R.drawable.ic_swimming,
                events = listOf(
                    Event("100m Freestyle Heats", "Saturday, 09:00 • Aquatic Center"),
                    Event("Inter-Club Relay Finals", "Sunday, 11:30 • Olympic Pool")
                ),
                news = listOf(
                    News("National Record Broken", "Swimmer shatters 200m butterfly record by over two seconds."),
                    News("Gold Medal Sweep", "Relay team delivers dominant performance in state championship.")
                )
            )
            "running" -> SportDetails(
                iconRes = R.drawable.ic_running,
                events = listOf(
                    Event("City Half-Marathon", "Sunday, 07:00 • Central Park Start"),
                    Event("5K Charity Trail Run", "Next Saturday, 08:30 • Forest Reserve")
                ),
                news = listOf(
                    News("Record Marathon Turnout", "Over 5,000 runners cross the finish line in successful annual marathon."),
                    News("Summer Training & Hydration Tips", "Coaches share essential guide for long-distance summer running.")
                )
            )
            else -> SportDetails(
                iconRes = R.drawable.ic_sports,
                events = listOf(
                    Event("Upcoming Event 1", "Saturday, 14:00 • Main Venue"),
                    Event("Upcoming Event 2", "Sunday, 16:00 • Main Venue")
                ),
                news = listOf(
                    News("Latest Sports Update", "Team completes intense training session ahead of weekend fixtures."),
                    News("Season Highlights", "Top plays and performances from this month's competitions.")
                )
            )
        }
    }
}
