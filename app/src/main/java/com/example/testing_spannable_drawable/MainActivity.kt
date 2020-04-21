package com.example.testing_spannable_drawable

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ImageSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.testText)

        val spannableString = SpannableString("I want THIS to be clicked  ")

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(this@MainActivity, "Clicked this", Toast.LENGTH_SHORT).show()
            }
        }

        val clickableSpan2 = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // We display a Toast. You could do anything you want here.
                Toast.makeText(this@MainActivity, "Clicked Image", Toast.LENGTH_SHORT).show()
            }
        }

        val styleSpan = StyleSpan(Typeface.BOLD_ITALIC)

        spannableString.setSpan(clickableSpan, 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableString.setSpan(styleSpan, 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val imageSpan = ImageSpan(this, R.drawable.ic_help_outline_black_24dp,
            ImageSpan.ALIGN_BASELINE)

        spannableString.setSpan(clickableSpan2, spannableString.length - 1, spannableString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableString.setSpan(imageSpan, spannableString.length - 1, spannableString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.highlightColor = Color.TRANSPARENT
        textView.text = spannableString
    }
}
