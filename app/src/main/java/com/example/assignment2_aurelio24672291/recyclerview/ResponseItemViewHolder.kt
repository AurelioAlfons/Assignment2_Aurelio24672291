package com.example.assignment2_aurelio24672291.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2_aurelio24672291.R
import com.example.assignment2_aurelio24672291.data.ResponseItem

// Purpose Response Item View Holder file:
// - Takes Response IItem object and display properties (Name,ID,Year,Medium,Details,Button)
// - Visibility for available descriptions (If not hide the button)
// - Navigation to Details Fragment when clicked "Show Data"

// ViewHolder class to bind the data to the RecyclerView item
class ResponseItemViewHolder(
    itemView: View,
    private val navigationFunction: (ResponseItem) -> Unit // Lambda function for navigation
) : RecyclerView.ViewHolder(itemView) {

    // View references
    private val titleTextView: TextView = itemView.findViewById(R.id.itemNametext)
    private val artistTextView: TextView = itemView.findViewById(R.id.itemIdText)
    private val yearTextView: TextView = itemView.findViewById(R.id.itemYeartext)
    private val mediumTextView: TextView = itemView.findViewById(R.id.itemMediumtext)
    private val detailsTextView: TextView = itemView.findViewById(R.id.detailsText)
    private val navigationButton: Button = itemView.findViewById(R.id.navigationButton)

    // Bind data to views
    fun bind(responseItem: ResponseItem) {
        // Set text for artwork title, artist, year, and medium
        titleTextView.text = responseItem.artworkTitle
        artistTextView.text = "Artist: ${responseItem.artist}"
        yearTextView.text = "Year: ${responseItem.year}"
        mediumTextView.text = "Medium: ${responseItem.medium}"

        // Check if description is available to show details and button
        val showDetails = if (responseItem.description.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
        // Show or hide "More details" text
        detailsTextView.visibility = showDetails
        // Show or hide navigation button
        navigationButton.visibility = showDetails

        // Set click listener only if details are available
        if (showDetails == View.VISIBLE) {
            navigationButton.setOnClickListener {
                navigationFunction(responseItem) // Navigate to details screen
            }
        }
    }
}
