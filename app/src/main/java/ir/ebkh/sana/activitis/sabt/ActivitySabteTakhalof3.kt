package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.database.Cursor
import android.graphics.Typeface
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

import kotlinx.android.synthetic.main.sabt_takhalof3.*


class ActivitySabteTakhalof3 : AppCompatActivity() {


    var fard_selected=""

    var list_of_persons_meliCode: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof3)
        persons_count_txt.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))



        persons_count_txt.setText(listOfSelectedMeliCods.size.toString() + " نفر")
        //TODO تهیه لیست افراد از دیتا بیس
        listOfPesons.clear()
        listOfPesons.add("فرد متخلف")

        val dbData1: Cursor = database.query(
            "persons",
            arrayOf("first_name", "last_name","kode_meli"),
            null,
            null,
            null,
            null,
            null,
            null
        )
        if (dbData1.moveToFirst())
        {
            do {
                var listName = dbData1.getString(dbData1.getColumnIndex("first_name")) + " " +
                        dbData1.getString(dbData1.getColumnIndex("last_name")) + " (" +
                        dbData1.getString(dbData1.getColumnIndex("kode_meli")) + ")"

                list_of_persons_meliCode.add(dbData1.getString(dbData1.getColumnIndex("kode_meli")))
                listOfPesons.add(listName)

            }while (dbData1.moveToNext())
            dbData1.close()
        }
        dbData1.close()


        //تنظیمات اسپینر انتخاب فرد متخلف
        list_persons_sppiner.setTitle("جستجو و انتخاب کنید")
        list_persons_sppiner.setPositiveButton("تایید")
        val sp4 = findViewById(R.id.list_persons_sppiner) as Spinner
        val adapter4: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
            listOfPesons)
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp4.setAdapter(adapter4)
        sp4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                if (position>0)
                    fard_selected = list_of_persons_meliCode.get(position-1)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        //اضافه کردن فرد جدید به دیتا بیس
        btn_takhalof3_add_fard.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_takhalof3_add_fard.setImageResource(R.drawable.pushed_btn_plus)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_takhalof3_add_fard.setImageResource(R.drawable.btn_plus)
            }
            false
        })
        btn_takhalof3_add_fard.setOnClickListener {
            val intent = Intent(this, ActivitySabteFard::class.java)
            startActivity(intent)

        }

        btn_sabt_motekhalef_add_persons.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabt_motekhalef_add_persons.setImageResource(R.drawable.pushed_btn_add_motekhalef)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabt_motekhalef_add_persons.setImageResource(R.drawable.btn_add_motekhalef)
            }
            false
        })
        btn_sabt_motekhalef_add_persons.setOnClickListener {

                if (fard_selected != "" && !isExistInList(listOfSelectedMeliCods, fard_selected)) {
                    listOfSelectedMeliCods.add(fard_selected)

                    persons_count_txt.setText(listOfSelectedMeliCods.size.toString() + " نفر")

                    Toast.makeText(
                        applicationContext,
                        "کد ملی "+fard_selected + " به لیست اضافه شد",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (fard_selected == "")
                        Toast.makeText(
                            applicationContext,
                            "کسی انتخاب نشده است.",
                            Toast.LENGTH_SHORT
                        ).show()
                    if (isExistInList(listOfSelectedMeliCods, fard_selected))
                        Toast.makeText(
                            applicationContext,
                            "فرد انتخاب شده تکراری است.",
                            Toast.LENGTH_SHORT
                        ).show()
                }


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
        }

        list_motekhalef.setOnClickListener {
            val intent = Intent(this, ActivityListFard::class.java)
            startActivity(intent)
        }
    }



    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof2::class.java)
        startActivity(intent)
        finish()

    }


    fun isExistInList(list: MutableList<String>, item: String): Boolean {

        var isEIL=false
        if ( list.size>0)
            for (i in 0..list.size-1)
            {
                if (list[i]==item) isEIL=true
            }
        return isEIL
    }
}
