package com.example.bottomsheetdialog_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUI()
        showCardPayment()

    }

    private fun setUpUI() {
        val bottomSheet: View = findViewById(R.id.bottom_sheet)
        val paymentBtn: Button = findViewById(R.id.payment_btn)
        val sheetBehavior = BottomSheetBehavior.from(bottomSheet)

        sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        paymentBtn.setOnClickListener {
            if (sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
        }
    }

    private fun showCardPayment() {
        val cash_layout = findViewById<LinearLayout>(R.id.cash_layout)
        val card_layout = findViewById<LinearLayout>(R.id.card_layout)
        val card_checkbox = findViewById<CheckBox>(R.id.card_checkbox)
        val cash_checkbox = findViewById<CheckBox>(R.id.cash_checkbox)
        cash_layout.setOnClickListener {
            if (cash_checkbox.isChecked) {
                cash_checkbox.isChecked = false
            } else {
                cash_checkbox.isChecked = true
                card_checkbox.isChecked = false
            }
        }
        card_layout.setOnClickListener {
            if (card_checkbox.isChecked) {
                card_checkbox.isChecked = false
            } else {
                card_checkbox.isChecked = true
                cash_checkbox.isChecked = false
            }
        }
    }
}