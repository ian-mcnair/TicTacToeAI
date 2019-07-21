package com.example.tictactoeai

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var turn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun markButton(view: View){
        val button = view as Button
        if (button.text.isEmpty()) {
            button.text = if (turn) "X" else "O"
            button.setTextColor(if (turn) Color.RED else Color.BLUE)
            turn = !turn
        }
    }

    private fun TableLayout.getButtons(): List<Button> {
        val buttons = arrayListOf<Button>()
        for (i in 0 until childCount) {
            val row = getChildAt(i) as TableRow
            for (j in 0 until row.childCount) {
                buttons.add(row.getChildAt(j) as Button)
            }
        }
        return buttons
    }

    fun clearBoard(view: View){
        val buttons = ttt_table.getButtons()
        for (button in buttons) {
            button.text = ""
        }
    }
}
