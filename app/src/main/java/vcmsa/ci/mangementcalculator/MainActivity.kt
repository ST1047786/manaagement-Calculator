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
    private lateinit var rdGroupTask: RadioGroup
    private lateinit var cbWood: CheckBox
    private lateinit var cbNail: CheckBox
    private lateinit var cbHinges: CheckBox
    private lateinit var etHours: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvTotalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        rdGroupTask =findViewById(R.id.rdGroupTask)
        cbWood = findViewById(R.id.cbWood)
        cbNail = findViewById(R.id.cbNail)
        cbHinges =findViewById(R.id.cbHinges)
        etHours  = findViewById(R.id.etHours)
        btnCalculate =findViewById(R.id.btnCalculate)
        tvTotalPrice =findViewById(R.id.tvTotalPrice)

        btnCalculate.setOnClickListener{
            calculate()
        }
    }
    private fun calculate() {

        val hoursText = etHours.text.toString()//checks validity of hours
        if (hoursText.isEmpty()|| hoursText.toIntOrNull()== null ||hoursText.toInt()<=0){
            Toast.makeText(this, "Please enter the number of hours.", Toast.LENGTH_SHORT).show()
            return
        }
        // verify if tasked have been selected

        val rdGroupTasks
        if (rdGroupTasks.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select a task.", Toast.LENGTH_SHORT).show()
            return

        }
        val hours = hoursText.toInt()
        var materialCost = 0

        if (cbWood.isChecked) materialCost += 500
        if (cbNail.isChecked) materialCost += 20
        if (cbHinges.isChecked) materialCost += 30

        if (materialCost ==0){
            Toast.makeText(this,"please select at least one material",Toast.LENGTH_SHORT).show()
            return
        }

        // total price calculated
        val totalCost = materialCost * hours
        tvTotalPrice.text = "Total Estimated Cost: R$totalCost.00"
    }




}