package scisrc.mobiledev.firstuiassignment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    private lateinit var backToMainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        backToMainBtn = findViewById(R.id.registBackToMainBtn)

        backToMainBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        val loginTextView = findViewById<TextView>(R.id.loginTextView)

        val text = "Already have an account? Login"

        val spannable = SpannableString(text)
        val boldSpan = StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan, text.indexOf("Login"), text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        loginTextView.text = spannable

        loginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}