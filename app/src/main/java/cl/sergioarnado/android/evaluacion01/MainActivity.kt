package cl.sergioarnado.android.evaluacion01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import cl.sergioarnado.android.evaluacion01.restaurat.CuentaMesa
import cl.sergioarnado.android.evaluacion01.restaurat.ItemMesa
import cl.sergioarnado.android.evaluacion01.restaurat.ItemMenu
val formatoPeso = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("es", "CL"))

class MainActivity : AppCompatActivity() {
    var tvtotal: TextView? = null
    var switchTotal: Switch? = null
    var etcantidad1: EditText? = null
    var etcantidad2: EditText? = null
    var tvprecio1: TextView? = null
    var tvprecio2: TextView? = null
    var tvvalorcomida: TextView? = null
    var tvvalorpropina: TextView? = null
    var tvvalortotal: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchTotal = findViewById<Switch>(R.id.switchTotal)
        etcantidad1 = findViewById<EditText>(R.id.etcantidad1)
        etcantidad2 = findViewById<EditText>(R.id.etcantidad2)
        tvprecio1 = findViewById<TextView>(R.id.tvprecio1)
        tvprecio2 = findViewById<TextView>(R.id.tvprecio2)
        tvvalorcomida = findViewById<TextView>(R.id.tvvalorcomida)
        tvvalorpropina = findViewById<TextView>(R.id.tvvalorpropina)
        tvvalortotal = findViewById<TextView>(R.id.tvvalortotal)
        tvtotal = findViewById<TextView>(R.id.tvtotal)

        switchTotal?.setOnClickListener{
            val cuentaMesa = CuentaMesa ()
            val cantidad_1 = etcantidad1?.text.toString().toIntOrNull() ?: 0
            val cantidad_2 = etcantidad2?.text.toString().toIntOrNull() ?: 0
            val pastelDeChoclo = ItemMenu("Pastel de Choclo", 12000.0)
            val cazuela = ItemMenu("Cazuela", 10000.0)

            cuentaMesa.agregarPedido(ItemMesa(pastelDeChoclo, cantidad_1))
            cuentaMesa.agregarPedido(ItemMesa(cazuela, cantidad_2))

            val totalSinPropina = cuentaMesa.calcularTotalSinPropina()
            val propina = cuentaMesa.calcularPropina()
            val totalConPropina = cuentaMesa.calcularTotalConPropina()

            tvvalorcomida?.text = formatoPeso.format(totalSinPropina)
            tvvalorpropina?.text = formatoPeso.format(propina)
            tvvalortotal?.text = formatoPeso.format(totalConPropina)
            tvprecio1?.text = formatoPeso.format(pastelDeChoclo.precio)
            tvprecio2?.text = formatoPeso.format(cazuela.precio)
        }
    }

}







