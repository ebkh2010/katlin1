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
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.sabt_takhalof4.*


class ActivitySabteTakhalof4 : AppCompatActivity() {


    var carSelected=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof4)
        car_motor_counter_txt.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))

        ///////////////////////
        //تنظیمات لیست خودرو
        ///////////////////////
        //TODO تهیه لیست خودرو از دیتا بیس
        listOfCars.clear()
        listOfCars.add("انتخاب خودرو")

        val dbData2: Cursor = database.query(
            "car",
            arrayOf("car_pelak","name"),
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
                var listcar = dbData2.getString(dbData2.getColumnIndex("car_pelak")) + " " +
                        dbData2.getString(dbData2.getColumnIndex("name"))

                listOfCars.add(dbData2.getString(dbData2.getColumnIndex("car_pelak")))

            }while (dbData2.moveToNext())
            dbData2.close()
        }
        dbData2.close()

        //تنظیمات اسپینر انتخاب خودرو
        searchablespinner_add_car.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_car.setPositiveButton("تایید")
        val spcar = findViewById(R.id.searchablespinner_add_car) as Spinner
        val adaptercar: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
            listOfCars)
        adaptercar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spcar.setAdapter(adaptercar)
        spcar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                if (position>0)
                    carSelected = listOfCars.get(position-1)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        btn_select_car.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_select_car.setImageResource(R.drawable.pushed_btn_add_car)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_select_car.setImageResource(R.drawable.btn_add_car)
            }
            false
        })
        btn_select_car.setOnClickListener {

            if (carSelected != "" && !isExistInList(listOfSelectedCArPelaks, carSelected)) {
                listOfSelectedCArPelaks.add(carSelected)

                car_motor_counter_txt.setText(listOfSelectedCArPelaks.size.toString() + "وسیله ")

                Toast.makeText(
                    applicationContext,
                    "پلاک "+carSelected + " به لیست اضافه شد",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (carSelected == "")
                    Toast.makeText(
                        applicationContext,
                        "خودرویی انتخاب نشده است.",
                        Toast.LENGTH_SHORT
                    ).show()
                if (isExistInList(listOfSelectedCArPelaks, carSelected))
                    Toast.makeText(
                        applicationContext,
                        "خودرو انتخاب شده تکراری است.",
                        Toast.LENGTH_SHORT
                    ).show()
            }


        }



        //////////////////////
        //تنظیمات لیست موتور سیکلت
        /////////////////////
        //TODO تهیه لیست خودرو از دیتا بیس
        listOfMotors.clear()
        listOfMotors.add("انتخاب موتور")

        val dbData3 = database.query(
            "motor",
            arrayOf("motor_pelak","motor_name"),
            null,
            null,
            null,
            null,
            null,
            null
        )
        if (dbData3.moveToFirst())
        {
            do {
                var listmotor = dbData3.getString(dbData3.getColumnIndex("motor_pelak")) + " " +
                        dbData3.getString(dbData3.getColumnIndex("motor_name"))

                listOfMotors.add(dbData3.getString(dbData3.getColumnIndex("motor_pelak")))

            }while (dbData3.moveToNext())
            dbData3.close()
        }
        dbData3.close()
        searchablespinner_add_motor.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_motor.setPositiveButton("تایید")


        btn_sabtetakhalof4.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof4.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof4.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof4.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof5::class.java)
            startActivity(intent)
            finish()
        }

        btn_add_car.setOnClickListener {
            val intent = Intent(this, ActivitySabteKhodro::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof3::class.java)
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
