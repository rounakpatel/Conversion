
import android.os.Bundle
import android.support.Conversion.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : Conversion() {
    var btnConvert: Button? = null
    var etMiles: EditText? = null
    var etFeets: EditText? = null
    var etInches: EditText? = null
    var tvResult: TextView? = null
    var cbMetres: CheckBox? = null
    var result = 0f
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etMiles = findViewById(R.id.etMiles)
        etFeets = findViewById(R.id.etFeets)
        etInches = findViewById(R.id.etInches)
        btnConvert = findViewById(R.id.btnConvert)
        tvResult = findViewById(R.id.tvResult)
        cbMetres = findViewById(R.id.cbMetres)
        btnConvert.setOnClickListener(object : OnClickListener() {
            fun onClick(view: View?) {
                doConversion()
            }
        })
    }

    private fun findViewById(tvResult: Any): TextView? {

    }

    private fun doConversion() {
        result = 0f
        if (!etMiles?.getText().toString().equals("")) {
            result = result + etMiles?.getText().toString().trim().toFloat() * 160934 //1 mile equals 160934 cms
        }
        if (!etFeets?.getText().toString().equals("")) {
            result =
                result + (etFeets?.getText().toString().trim().toFloat() * 30.48).toFloat() //1 feet equals 30.48 cms
        }
        if (!etInches?.getText().toString().equals("")) {
            result = result + (etInches?.getText().toString().trim().toFloat() * 2.54).toFloat() //1 inch equals 2.54 cms
        }
        if (cbMetres?.isChecked() == true) {
            result = result / 100
            tvResult?.setText("Result:$result metres")
        } else {
            tvResult?.setText("Result:$result cm")
        }
    }
}