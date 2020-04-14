package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var doneButton: Button
    lateinit var nicknameTextView: TextView
    lateinit var inputMethodManager: InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.nickname_edit)
        doneButton = findViewById(R.id.done_button)
        nicknameTextView = findViewById(R.id.nickname_text)
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)

        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)

        }

    }

    private fun addNickname(view: View) {


        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE


        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        nicknameTextView.visibility = View.VISIBLE
    }


    private fun updateNickname(view: View) {

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
        inputMethodManager.showSoftInput(editText, 0)
    }


}
