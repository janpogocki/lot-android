package com.lot.android.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lot.android.R
import kotlinx.android.synthetic.main.activity_passengers.*

class PassengersActivity : AppCompatActivity() {

    var adults = 1
    var teenagers = 0
    var children = 0
    var infants = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passengers)

        addersListners()
        removersListeners()

        fab.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            intent.putExtras(getIntent())
            intent.putExtra("adults", adults)
            intent.putExtra("teenagers", teenagers)
            intent.putExtra("children", children)
            intent.putExtra("infants", infants)
            startActivity(intent)
        }
    }

    private fun addersListners() {
        button_add_adult.setOnClickListener {
            adults += 1
            text_adult.text = "Adults: ${adults}"
        }

        button_add_teenager.setOnClickListener {
            teenagers += 1
            text_teenager.text = "Teenagers: ${teenagers}"
        }

        button_add_children.setOnClickListener {
            children += 1
            text_children.text = "Children: ${children}"
        }

        button_add_infant.setOnClickListener {
            infants += 1
            text_infant.text = "Infants: ${infants}"
        }
    }

    private fun removersListeners() {
        button_rem_adult.setOnClickListener {
            if (adults > 1) {
                adults -= 1
                text_adult.text = "Adults: ${adults}"
            }
        }

        button_rem_teenager.setOnClickListener {
            if (teenagers > 0) {
                teenagers -= 1
                text_teenager.text = "Teenagers: ${teenagers}"
            }
        }

        button_rem_children.setOnClickListener {
            if (children > 0) {
                children -= 1
                text_children.text = "Children: ${children}"
            }
        }

        button_rem_infant.setOnClickListener {
            if (infants > 0) {
                infants -= 1
                text_infant.text = "Infants: ${infants}"
            }
        }
    }
}
