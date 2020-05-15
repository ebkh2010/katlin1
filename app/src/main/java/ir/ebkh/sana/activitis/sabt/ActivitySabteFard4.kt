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


    var isRegistred=false

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
            mobile = sabt_fard_mobile.text.toString()
            phone = sabt_fard_phone.text.toString()
            other_numbers = sabt_fard_other_numbers.text.toString()

            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name,gender," +
                    "father_name,tavalod_date,tavalod_city,tahsilat,taahol,job,job_comment," +
                    "modile_number,phone_number,other_phone_numbers) " +
                    "VALUES ('"+kode_meli+"','"+name+"','"+lastname+"','"+gender+"','"+ fathername+"','"+
                    born_date+"','"+ born_city+"','"+ school_stat+"','"+ marage_stat+"','"+ job_stat+"','"+
                    job_comment_stat+"','"+mobile+"','"+ phone+"','"+ other_numbers+"')";

            try {
                database.execSQL(sqlq)
                isRegistred=true
            }catch (e: NumberFormatException) {
                println("kodmelli")
                isRegistred=false
            }

            if (isRegistred)
            {
                kode_meli=""
                name=""
                lastname=""
                gender=""
                fathername=""
                born_date=""
                born_city=""
                school_stat=""
                marage_stat=""
                job_stat=""
                job_comment_stat=""
                mobile=""
                phone=""
                other_numbers=""
            }



            val intent = Intent(this, ActivitySabteTakhalof3::class.java)
            startActivity(intent)
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
            mobile = sabt_fard_mobile.text.toString()
            phone = sabt_fard_phone.text.toString()
            other_numbers = sabt_fard_other_numbers.text.toString()

            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name,gender," +
                    "father_name,tavalod_date,tavalod_city,tahsilat,taahol,job,job_comment," +
                    "modile_number,phone_number,other_phone_numbers) " +
                    "VALUES ('"+kode_meli+"','"+name+"','"+lastname+"','"+gender+"','"+ fathername+"','"+
                    born_date+"','"+ born_city+"','"+ school_stat+"','"+ marage_stat+"','"+ job_stat+"','"+
                    job_comment_stat+"','"+mobile+"','"+ phone+"','"+ other_numbers+"')";


            try {
                database.execSQL(sqlq)
                isRegistred=true
            }catch (e: NumberFormatException) {
                println("kodmelli")
                isRegistred=false
            }

            if (isRegistred)
            {
                kode_meli=""
                name=""
                lastname=""
                gender=""
                fathername=""
                born_date=""
                born_city=""
                school_stat=""
                marage_stat=""
                job_stat=""
                job_comment_stat=""
                mobile=""
                phone=""
                other_numbers=""
            }

            val intent = Intent(this, ActivitySabteFard::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard2::class.java)
        startActivity(intent)
        finish()

    }
}
