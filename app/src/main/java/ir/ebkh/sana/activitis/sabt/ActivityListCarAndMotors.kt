package ir.ebkh.sana.activitis.sabt



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.sabt.Adapters.CustomAdapter
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.list_car_motors.*
import java.util.*


class ActivityListCarAndMotors : AppCompatActivity() {


    var listcarmotor = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_car_motors)

        listcarmotor.clear()
        mergelists(listcarmotor,listOfSelectedCArPelaks,"خودرو: ")
        mergelists(listcarmotor,listOfSelectedMotorPelaks,"موتور سیکلت: ")
        
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val adapter = CustomAdapter(listcarmotor)

        recyclerView.adapter = adapter
    }

    fun mergelists (list: ArrayList<String>, pelaks: ArrayList<String>,txt: String){

    for (i in 0..pelaks.size-1)
    {
        list.add(txt + "("+pelaks[i]+")")
    }

    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivitySabteTakhalof4::class.java)
        startActivity(intent)
        carlist_layout.removeAllViews()
        finish()
    }
}