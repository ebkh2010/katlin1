package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
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


class ActivitySabteFard3 : AppCompatActivity() {



    var list_of_job_spiner = arrayOf("بیکار", "دانشجو", "کارمند","شغل آزاد","فرهنگی","مهندس","پزشک","نظامی")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard3)

        val sp1 = findViewById(R.id.searchablespinner_add_job) as Spinner
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list_of_job_spiner)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp1.setAdapter(adapter1)
        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                job_stat = list_of_job_spiner.get(position)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }






        btn_sabtefard3.setOnClickListener {
            job_comment_stat = job_comment.text.toString()

            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name,gender," +
                    "father_name,tavalod_date,tavalod_city,tahsilat,taahol,job,job_comment) " +
                    "VALUES ('"+kode_meli+"','"+name+"','"+lastname+"','"+gender+"','"+ fathername+"','"+
                    born_date+"','"+ born_city+"','"+ school_stat+"','"+ marage_stat+"','"+ job_stat+"','"+ job_comment_stat+"')";


            try {
                database.execSQL(sqlq)
            }catch (e: NumberFormatException) {
                println("kodmelli") }

            val intent = Intent(this, ActivitySabteTakhalof3::class.java)
            startActivity(intent)
        }


    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard2::class.java)
        startActivity(intent)
        finish()

    }
}
