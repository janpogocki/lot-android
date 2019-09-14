package com.lot.android.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lot.android.R
import com.lot.android.api.dataClasses.Spot
import com.lot.android.ui.adapters.CardStackAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import kotlinx.android.synthetic.main.activity_customize_trip.*

class CustomizeTripActivity : AppCompatActivity(), CardStackListener {

    private val manager by lazy { CardStackLayoutManager(this, this) }
    private var selectedHashtags = mutableListOf<String>()
    private val spots = createSpots()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_trip)

        card_stack_view.layoutManager = manager
        card_stack_view.adapter = CardStackAdapter(spots, card_stack_view, manager)
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        if (direction == Direction.Left) {
            saveChoosenCard()
        }
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardRewound() {
    }

    private fun saveChoosenCard() {
        val hashtag = spots[manager.topPosition - 1].hashtag
        selectedHashtags.add(hashtag)
        Toast.makeText(this, hashtag, Toast.LENGTH_SHORT).show()
    }

    private fun createSpots(): List<Spot> {
        val spots = ArrayList<Spot>()
        spots.add(Spot("lemur", R.drawable.lemur))
        spots.add(Spot("lemur1", R.drawable.lemur))
        spots.add(Spot("lemur2", R.drawable.lemur))
        spots.add(Spot("lemur3", R.drawable.lemur))
        return spots
    }


}
