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


class ActivitySabteFard3 : AppCompatActivity() {



    var list_of_job_spiner = arrayOf("شغل","بیکار", "دانشجو", "کارمند","شغل آزاد","فرهنگی","مهندس","پزشک","نظامی","خانه دار")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard3)


        searchablespinner_add_job.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_job.setPositiveButton("تایید")
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


        btn_sabtefard3.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtefard3.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtefard3.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtefard3.setOnClickListener {
            job_comment_stat = job_comment.text.toString()


            val intent = Intent(this, ActivitySabteFard4::class.java)
            startActivity(intent)
            fullfinish()
        }

    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard2::class.java)
        startActivity(intent)
        fullfinish()

    }

    private fun fullfinish(){
        b33.setImageDrawable(null)
        b34.setImageDrawable(null)
        b35.setImageDrawable(null)
        b36.setImageDrawable(null)
        btn_sabtefard3.setImageDrawable(null)
        sabt_fard3_mail_layout.removeAllViews()
        finish()
    }
}
