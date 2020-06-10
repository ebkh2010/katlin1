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
    var motorSelected=""
    var car_motor_count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof4)
        car_motor_counter_txt.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))

        car_motor_count=listOfSelectedMotorPelaks.size+listOfSelectedCArPelaks.size

        car_motor_counter_txt.setText(car_motor_count.toString() + "وسیله ")

        ///////////////////////
        //تنظیمات لیست خودرو
        ///////////////////////

        //TODO تهیه لیست خودرو از دیتا بیس
        listOfCars.clear()
        listOfCars.add("انتخاب خودرو")
        cars_list()

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
                    carSelected = listOfCars.get(position)
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

            if (carSelected != "" && carSelected !="انتخاب خودرو" && !isExistInList(listOfSelectedCArPelaks, carSelected)) {
                listOfSelectedCArPelaks.add(carSelected)

                car_motor_count=listOfSelectedMotorPelaks.size+listOfSelectedCArPelaks.size

                car_motor_counter_txt.setText(car_motor_count.toString() + "وسیله ")

                Toast.makeText(
                    applicationContext,
                    "پلاک "+carSelected + " به لیست اضافه شد",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                if (carSelected == "" || carSelected =="انتخاب خودرو")
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

        btn_add_car.setOnClickListener {
            val intent = Intent(this, ActivitySabteKhodro::class.java)
            startActivity(intent)
            fullfinish()
        }


        //////////////////////
        //تنظیمات لیست موتور سیکلت
        /////////////////////

        //TODO تهیه لیست موتور سیکلت از دیتا بیس
        listOfMotors.clear()
        listOfMotors.add("انتخاب موتور")
        motors_list()

        //تنظیمات اسپینر انتخاب موتور سیکلت
        searchablespinner_add_motor.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_motor.setPositiveButton("تایید")
        val spmotor = findViewById(R.id.searchablespinner_add_motor) as Spinner
        val adaptermotor: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
            listOfMotors)
        adaptermotor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spmotor.setAdapter(adaptermotor)
        spmotor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                if (position>0)
                    motorSelected = listOfMotors.get(position)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

        btn_sabt_motor.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_select_car.setImageResource(R.drawable.pushed_btn_add_car)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_select_car.setImageResource(R.drawable.btn_add_car)
            }
            false
        })
        btn_sabt_motor.setOnClickListener {

            if (motorSelected != "" && motorSelected != "انتخاب موتور" && !isExistInList(listOfSelectedMotorPelaks, motorSelected)) {
                listOfSelectedMotorPelaks.add(motorSelected)

                car_motor_count=listOfSelectedMotorPelaks.size+listOfSelectedCArPelaks.size

                car_motor_counter_txt.setText(car_motor_count.toString() + "وسیله ")

                Toast.makeText(
                    applicationContext,
                    "پلاک "+motorSelected + " به لیست اضافه شد",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                if (motorSelected == "" || motorSelected == "انتخاب موتور")
                    Toast.makeText(
                        applicationContext,
                        "موتور سیکلتی انتخاب نشده است.",
                        Toast.LENGTH_SHORT
                    ).show()
                if (isExistInList(listOfSelectedMotorPelaks, motorSelected))
                    Toast.makeText(
                        applicationContext,
                        "موتور سیکلت انتخاب شده تکراری است.",
                        Toast.LENGTH_SHORT
                    ).show()
            }


        }

        add_motor.setOnClickListener {
            val intent = Intent(this, ActivitySabteMotor::class.java)
            startActivity(intent)
            fullfinish()
        }

        list_car_motor.setOnClickListener {
            val intent = Intent(this, ActivityListCarAndMotors::class.java)
            startActivity(intent)
            fullfinish()
        }

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
            fullfinish()
        }



    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof3::class.java)
        startActivity(intent)
        fullfinish()

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

    fun cars_list(){
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
    }

    fun motors_list() {
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
    }

    private fun fullfinish(){
        b17.setImageDrawable(null)
        b18.setImageDrawable(null)
        b19.setImageDrawable(null)
        b20.setImageDrawable(null)
        btn_add_car.setImageDrawable(null)
        btn_select_car.setImageDrawable(null)
        add_motor.setImageDrawable(null)
        btn_sabt_motor.setImageDrawable(null)
        list_car_motor.setImageDrawable(null)
        btn_sabtetakhalof4.setImageDrawable(null)

        sabt_takhalof4_mail_layout.removeAllViews()

        finish()
    }
}
