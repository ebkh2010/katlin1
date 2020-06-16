package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.sabt_fard.*
import kotlinx.android.synthetic.main.sabt_fard2.*
import kotlinx.android.synthetic.main.sabt_fard3.*
import kotlinx.android.synthetic.main.sabt_fard4.*


class ActivitySabteFard4 : AppCompatActivity() {


    private var isRegistred=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard4)

        btn_back_sabtefard4.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_back_sabtefard4.setImageResource(R.drawable.pushed_save_and_back)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_back_sabtefard4.setImageResource(R.drawable.save_and_back)
            }
            false
        })
        btn_back_sabtefard4.setOnClickListener {
            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name,gender," +
                    "father_name,tavalod_date,tavalod_city,tahsilat,taahol,job,job_comment," +
                    "modile_number,phone_number,other_phone_numbers) " +
                    "VALUES ('"+ listOfData[0]+"','"+ listOfData[1]+"','"+ listOfData[2]+"','"+
                    listOfData[4]+"','"+ listOfData[3]+"','"+ listOfData[5]+"','"+ listOfData[6]+"','"+
                    listOfData[8]+"','"+ listOfData[7]+"','"+ listOfData[9]+"','"+ listOfData[10]+"','"+
                    sabt_fard_mobile.text.toString()+"','"+ sabt_fard_phone.text.toString()+"','"+
                    sabt_fard_other_numbers.text.toString()+"')";

            try {
                database.execSQL(sqlq)
                isRegistred=true
            }catch (e: NumberFormatException) {
                println("kodmelli")
                isRegistred=false
            }


            var intent = Intent(this, ActivitySabteTakhalof3::class.java)
            if (refrense_activity=="sabttakhalof3")
                startActivity(intent)
            else if (refrense_activity=="sabtemakan"){
                intent = Intent(this, ActivitySabteMakan::class.java)
                startActivity(intent)
            }
            fullfinish()
        }

        btn_new_sabtefard4.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_new_sabtefard4.setImageResource(R.drawable.pushed_save_and_new_person)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_new_sabtefard4.setImageResource(R.drawable.save_and_new_person)
            }
            false
        })
        btn_new_sabtefard4.setOnClickListener {

            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name,gender," +
                    "father_name,tavalod_date,tavalod_city,tahsilat,taahol,job,job_comment," +
                    "modile_number,phone_number,other_phone_numbers) " +
                    "VALUES ('"+ listOfData[0]+"','"+ listOfData[1]+"','"+ listOfData[2]+"','"+
                    listOfData[4]+"','"+ listOfData[3]+"','"+ listOfData[5]+"','"+ listOfData[6]+"','"+
                    listOfData[8]+"','"+ listOfData[7]+"','"+ listOfData[9]+"','"+ listOfData[10]+"','"+
                    sabt_fard_mobile.text.toString()+"','"+ sabt_fard_phone.text.toString()+"','"+
                    sabt_fard_other_numbers.text.toString()+"')";


            try {
                database.execSQL(sqlq)

            }catch (e: NumberFormatException) {
                println("kodmelli")

            }


            val intent = Intent(this, ActivitySabteFard::class.java)
            startActivity(intent)
            fullfinish()
        }

    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard2::class.java)
        startActivity(intent)
        finish()

    }

    private fun fullfinish(){
        b37.setImageDrawable(null)
        b38.setImageDrawable(null)
        b39.setImageDrawable(null)
        b40.setImageDrawable(null)
        btn_back_sabtefard4.setImageDrawable(null)
        btn_new_sabtefard4.setImageDrawable(null)
        sabt_fard4_mail_layout.removeAllViews()
        listOfData=null
        finish()
    }
}
