package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.sabt_fard.*

class ActivitySabteFard : AppCompatActivity() {




    var list_of_gender_spiner = arrayOf("جنسیت", "مرد", "زن","دو جنسه","نامشخص")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard)

        val sp = findViewById(R.id.spinner_sabt_gender) as Spinner
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list_of_gender_spiner)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.setAdapter(adapter1)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                gender = list_of_gender_spiner.get(position)

            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }


        btn_sabtefard.setOnClickListener {


            kode_meli= sabt_fard_kodmelli.text.toString()
            name = sabt_fard_name.text.toString()
            lastname = sabt_fard_famil.text.toString()
            fathername = sabt_fard_father_name.text.toString()


            val intent = Intent(this, ActivitySabteFard2::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof::class.java)
        startActivity(intent)
        finish()

    }
}

//کد ملی یونیک است یعنی اگر طرف کد ملی تکراری زد نباید کلید بعدی عمل کند و به گونه ای نشان دهد که کد ملی تکراری است