package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G.database
import ir.ebkh.sana.main.G.listOfDataMakan
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import kotlinx.android.synthetic.main.sabt_takhalof5.*
import java.util.*


class ActivitySabteTakhalof5 : AppCompatActivity() {

    var  place=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof5)

        list_places()
        searchablespinner_makantakhalof.setTitle("جستجو و انتخاب کنید")
        searchablespinner_makantakhalof.setPositiveButton("تایید")
        val spmakan = findViewById(R.id.searchablespinner_makantakhalof) as Spinner
        val adaptermakan: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, listOfDataMakan)
        adaptermakan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spmakan.setAdapter(adaptermakan)
        spmakan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                place= listOfDataMakan.get(position)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }


        btn_sabtetakhalof5.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof5.setImageResource(R.drawable.pushedd_sabte_sana)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof5.setImageResource(R.drawable.sabte_sana)
            }
            false
        })
        btn_sabtetakhalof5.setOnClickListener {
            val intent = Intent(this, ActivityEstelam::class.java)
            startActivity(intent)
            fullfinish()
        }

        btn_add_place.setOnClickListener {
            val intent = Intent(this,ActivitySabteMakan::class.java)
            startActivity(intent)
            fullfinish()
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof4::class.java)
        startActivity(intent)
        fullfinish()

    }


    private fun list_places(){
        listOfDataMakan.clear()
        listOfDataMakan.add("مکان")
        val dbData2: Cursor = database.query(
            "place",
            arrayOf("shahr","name_vahed","senf_vahed"),
            null,
            null,
            null,
            null,
            null,
            null
        )
        if (dbData2.moveToFirst())
        {
            do {
//                var listcar = dbData2.getString(dbData2.getColumnIndex("shahr")) + " " +
//                        dbData2.getString(dbData2.getColumnIndex("name_vahed"))
                listOfDataMakan.add(dbData2.getString(dbData2.getColumnIndex("name_vahed"))+
                        "("+dbData2.getString(dbData2.getColumnIndex("senf_vahed"))+")")

            }while (dbData2.moveToNext())
            dbData2.close()
        }
        dbData2.close()
    }


    private fun fullfinish(){
        b21.setImageDrawable(null)
        b22.setImageDrawable(null)
        b23.setImageDrawable(null)
        b24.setImageDrawable(null)
        btn_add_place.setImageDrawable(null)
        btn_sabt_makantakhalof.setImageDrawable(null)
        list_amaken_takhalof.setImageDrawable(null)
        btn_sabtetakhalof5.setImageDrawable(null)
        sabt_takhalof5_mail_layout.removeAllViews()
        finish()
    }
}
