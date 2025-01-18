package scisrc.mobiledev.firstuiassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var backToMainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        backToMainBtn = findViewById(R.id.loginBackToMainBtn)

        backToMainBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        val signUpTextView = findViewById<TextView>(R.id.signUpTextView)

        val text = "Don't have an account? Sign Up"

        val spannable = SpannableString(text)
        val boldSpan = StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan, text.indexOf("Sign Up"), text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        signUpTextView.text = spannable

        signUpTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}