package za.ac.iie.bitetime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<ViewGroup>(R.id.main)
        mainLayout.setBackgroundResource(R.drawable.bg)

        val txtsuggestMeal = findViewById<TextView>(R.id.textView)
        val btnPrepareMeal = findViewById<Button>(R.id.btnCook)
        val btnReset = findViewById<Button>(R.id.btnClear)
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTT)

        btnPrepareMeal.setOnClickListener {
            val enterTimeOfDay = edtTimeOfDay.text.toString().lowercase().trim()
            val mealSuggestion: String

            mealSuggestion = when (enterTimeOfDay) {
                "morning" -> "Breakfast: oatmeal, berry parfait, banana and water"
                "mid morning" -> "Morning Snack: veggie sticks with hummus, slice of pizza, mango coconut chia pudding"
                "afternoon" -> "Lunch: McDonald's, quinoa salad, chicken lettuce wraps"
                "mid afternoon" -> "Snack: peanut butter chocolate bites, spiced trail mix, mini hotdogs"
                "night" -> "Dinner: RedBull, lasagna, nothing in the fridge"
                else -> "Invalid input — please enter: morning, mid morning, afternoon, mid afternoon, night"
            }

            txtsuggestMeal.text = mealSuggestion
        }

        btnReset.setOnClickListener {
            edtTimeOfDay.text.clear()
            txtsuggestMeal.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets