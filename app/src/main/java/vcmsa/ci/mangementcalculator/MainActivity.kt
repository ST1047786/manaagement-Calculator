package vcmsa.ci.mangementcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var rdInstall: RadioButton
    private lateinit var rdBuild: RadioButton
    private lateinit var rdAssemble: RadioButton
    private lateinit var cbWood: CheckBox
    private lateinit var cbNail: CheckBox
    private lateinit var cbHinges: CheckBox
    private lateinit var etHours: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvTotalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        rdInstall =findViewById(R.id.rdInstall)
        rdBuild =findViewById(R.id.rdBuild)
        rdAssemble =findViewById(R.id.rdAssemble)
        cbWood = findViewById(R.id.cbWood)
        cbNail = findViewById(R.id.cbNail)
        cbHinges =findViewById(R.id.cbHinges)
        etHours  = findViewById(R.id.etHours)
        btnCalculate =findViewById(R.id.btnCalculate)
        tvTotalPrice =findViewById(R.id.tvTotalPrice)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun calculate() {
        var materialCost = 0

        if (cbWood.isChecked) materialCost += 500
        if (cbNail.isChecked) materialCost += 20
        if (cbHinges.isChecked) materialCost += 30

        // G
        val hoursText = etHours.text.toString()
        if (hoursText.isEmpty()) {
            Toast.makeText(this, "Please enter the number of hours.", Toast.LENGTH_SHORT).show()
            return
        }

        val hours = hoursText.toIntOrNull()
        if (hours == null || hours <= 0) {
            Toast.makeText(this, "Enter a valid positive number of hours.", Toast.LENGTH_SHORT).show()
            return
        }

        // Check if at least one material is selected
        if (!cbWood.isChecked && !cbNail.isChecked && !cbHinges.isChecked) {
            Toast.makeText(this, "Please select at least one material.", Toast.LENGTH_SHORT).show()
            return
        }

        // verify if tasked have been selected
        val radioGroupTasks = null
        if (radioGroupTasks == -1) {
            Toast.makeText(this, "Please select a task.", Toast.LENGTH_SHORT).show()
            return
        }

        // total price calculated
        val totalCost = materialCost * hours
        tvTotalPrice.text = "Total Estimated Cost: R$totalCost.00"
    }




}