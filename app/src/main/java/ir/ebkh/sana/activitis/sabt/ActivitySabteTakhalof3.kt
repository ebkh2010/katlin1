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
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.sabt_takhalof3.*


class ActivitySabteTakhalof3 : AppCompatActivity() {


    var fard_selected=""
    var list_of_persons_spiner: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof3)


        //TODO تهیه لیست افراد از دیتا بیس
        list_of_persons_spiner.add("فرد متخلف")

        val dbData: Cursor = G.database.query(
            "persons",
            arrayOf("first_name", "last_name","kode_meli"),
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
                var listName = dbData.getString(dbData.getColumnIndex("first_name")) + " " +
                        dbData.getString(dbData.getColumnIndex("last_name")) + " (" +
                        dbData.getString(dbData.getColumnIndex("kode_meli")) + ")"


                list_of_persons_spiner.add(listName)

            }while (dbData.moveToNext())
            dbData.close()
        }

        
        //تنظیمات اسپینر انتخاب فرد متخلف
        list_persons_sppiner.setTitle("جستجو و انتخاب کنید")
        list_persons_sppiner.setPositiveButton("تایید")
        val sp4 = findViewById(R.id.list_persons_sppiner) as Spinner
        val adapter4: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
            list_of_persons_spiner)
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp4.setAdapter(adapter4)
        sp4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                fard_selected = list_of_persons_spiner.get(position)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        btn_takhalof3_add_fard.setOnClickListener {
            val intent = Intent(this, ActivitySabteFard::class.java)
            startActivity(intent)
            finish()
        }

        btn_sabtetakhalof3.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof3.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof3.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof3.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof4::class.java)
            startActivity(intent)
            finish()
        }
    }



    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof2::class.java)
        startActivity(intent)
        finish()

    }
}
