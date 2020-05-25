package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*

class ActivitySabteTakhalof2 : AppCompatActivity() {

    var list_of_takhalof_model = arrayOf("نوع تخلف", "رابطه نامشروع", "شرب خمر","اختلاط نامحرم","مزاحمت برای نوامیس")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof2)

        searchablespinner_add_takhalof.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_takhalof.setPositiveButton("تایید")
        val spast2 = findViewById(R.id.list_persons_sppiner) as Spinner
        val adapterast2: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line,
            list_of_takhalof_model
        )
        adapterast2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spast2.setAdapter(adapterast2)
        spast2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                if (position>0)
                    G.takhalofModel = list_of_takhalof_model.get(position-1)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }



        btn_sabtetakhalof2.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof2.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof2.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof2.setOnClickListener {
            G.takhalofModelComment = takhalof_comment.text.toString()
            val intent = Intent(this, ActivitySabteTakhalof3::class.java)
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
