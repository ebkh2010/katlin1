package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.main.G
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.sabt_fard.*

class ActivitySabteFard : AppCompatActivity() {




    var list_of_gender_spiner = arrayOf("جنسیت", "مرد", "زن","دو جنسه","نامشخص")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard)

        for (i in 0..10) listOfData.add("")

        val sp = findViewById(R.id.spinner_sabt_gender) as Spinner
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list_of_gender_spiner)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.setAdapter(adapter1)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                listOfData[4] = list_of_gender_spiner.get(position)

            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }


        btn_sabtefard.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtefard.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtefard.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtefard.setOnClickListener {

            listOfData[0] = sabt_fard_kodmelli.text.toString()
            listOfData[1] = sabt_fard_name.text.toString()
            listOfData[2] = sabt_fard_famil.text.toString()
            listOfData[3] = sabt_fard_father_name.text.toString()

            if (listOfData[0]!="" && listOfData[1]!="" && listOfData[2]!="" && listOfData[3]!="" && listOfData[4]!="جنسیت"
                && !existMelliCode(listOfData[0]))
            {
                val intent = Intent(this, ActivitySabteFard2::class.java)
                startActivity(intent)
                fullfinish()
            }
            else if (existMelliCode(listOfData[0]))
            {
                Toast.makeText(applicationContext,"کد ملی تکراری است.", Toast.LENGTH_LONG).show()
            }
            else if (listOfData[0]=="" || listOfData[1]=="" || listOfData[2]=="" || listOfData[3]=="" || listOfData[4]=="جنسیت")
            {
                Toast.makeText(applicationContext,"داده ها ناقص است.", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun existMelliCode(cod: String): Boolean {
        var ret=false

        val dbData: Cursor = database.query(
            "persons",
            arrayOf("kode_meli"),
            null,
            null,
            null,
            null,
            null,
            null
        )
        if (dbData.moveToFirst())
        {
            do {
               if (cod==dbData.getString(dbData.getColumnIndex("kode_meli")))
                   ret= true
            }while (dbData.moveToNext())
            dbData.close()
        }
        return ret
    }

    override fun onBackPressed() {
        var intent = Intent(this, ActivitySabteTakhalof3::class.java)
        if (refrense_activity=="sabttakhalof3")
            startActivity(intent)
        else if (refrense_activity=="sabtemakan"){
            intent = Intent(this, ActivitySabteMakan::class.java)
            startActivity(intent)
        }
        fullfinish()
    }

    private fun fullfinish(){
        b25.setImageDrawable(null)
        b26.setImageDrawable(null)
        b27.setImageDrawable(null)
        b28.setImageDrawable(null)
        btn_sabtefard.setImageDrawable(null)
        sabt_fard_mail_layout.removeAllViews()
        finish()
    }
}

//کد ملی یونیک است یعنی اگر طرف کد ملی تکراری زد نباید کلید بعدی عمل کند و به گونه ای نشان دهد که کد ملی تکراری است