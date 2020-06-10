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
import kotlinx.android.synthetic.main.sabt_makan.*


class ActivitySabteMakan : AppCompatActivity() {

    var ostan=""
    var city=""
    var ostan_index=0


    var list_of_ostan_spiner = arrayOf("استان","قم","تهران", "فارس", "اصفهان","البرز",
        "مرکزی","خراسان رضوی")


    var citis = arrayOf(
        arrayOf("شهر"),
        arrayOf("شهر","قم","قنوات","جعفریه","کهک","دستجرد","سلفجگان"),
        arrayOf("شهر","اسلامشهر","بومهن","پاكدشت","تهران","چهاردانگه","دماوند","رودهن",
            "ري","شريف آباد","شهر رباط كريم","شهر شهريار","فشم","فيروزكوه","قدس",
            "كهريزك","لواسان بزرگ","ملارد","ورامين"),
        arrayOf("شهر","آباده","آباده طشك","اردكان","ارسنجان","استهبان","اشكنان","اقليد",
            "اوز","ایج","ایزد خواست","باب انار","بالاده","بنارويه","بهمن","بوانات","بيرم","بیضا",
            "جنت شهر","جهرم","حاجي آباد-زرین دشت","خاوران","خرامه","خشت","خفر","خنج","خور","داراب",
            "رونيز عليا","زاهدشهر","زرقان","سده","سروستان","سعادت شهر","سورمق","ششده","شيراز","صغاد",
            "صفاشهر","علاء مرودشت","عنبر","فراشبند","فسا","فيروز آباد","قائميه","قادر آباد","قطب آباد",
            "قير","كازرون","كنار تخته","گراش","لار","لامرد","لپوئی","لطيفي","مبارك آباد ديز","مرودشت",
            "مشكان","مصير","مهر فارس(گله دار)","ميمند","نوبندگان","نودان","نورآباد","ني ريز","کوار"),
        arrayOf("شهر","آران و بيدگل","اردستان","اصفهان","باغ بهادران","تيران","خميني شهر",
            "خوانسار","دهاقان","دولت آباد-اصفهان","زرين شهر","زيباشهر (محمديه)","سميرم","شاهين شهر",
            "شهرضا","فريدن","فريدون شهر","فلاورجان","فولاد شهر","قهدریجان","كاشان","گلپايگان","گلدشت اصفهان",
            "گلدشت مركزی","مباركه اصفهان","مهاباد-اصفهان","نايين","نجف آباد","نطنز","هرند"),
        arrayOf("شهر","آسارا","اشتهارد","شهر جديد هشتگرد","طالقان","كرج","گلستان تهران","نظرآباد","هشتگرد"),
        arrayOf("شهر","آشتيان","اراك","تفرش","خمين","دليجان","ساوه","شازند","محلات","کمیجان"),
        arrayOf("شهر","بجستان","بردسكن","تايباد","تربت جام","تربت حيدريه","جغتای","جوین",
            "چناران","خلیل آباد","خواف","درگز","رشتخوار","سبزوار","سرخس","طبس","طرقبه","فريمان","قوچان",
            "كاشمر","كلات","گناباد","مشهد","نيشابور"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_makan)


        sabt_makan_ostan.setTitle("جستجو و انتخاب کنید")
        sabt_makan_ostan.setPositiveButton("تایید")
        val spostan = findViewById(R.id.sabt_makan_ostan) as Spinner
        val adapterostan: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, list_of_ostan_spiner)
        adapterostan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spostan.setAdapter(adapterostan)
        spostan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                ostan = list_of_ostan_spiner.get(position)
                ostan_index=position
                citySpiner()
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }




//        btn_sabtefard3.setOnTouchListener(View.OnTouchListener { v, event ->
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                btn_sabtefard3.setImageResource(R.drawable.pushed_btn_next)
//            }
//            if (event.action == MotionEvent.ACTION_UP) {
//                btn_sabtefard3.setImageResource(R.drawable.btn_next)
//            }
//            false
//        })
//        btn_sabtefard3.setOnClickListener {
//            val intent = Intent(this, ActivitySabteFard4::class.java)
//            startActivity(intent)
//            fullfinish()
//        }

    }

    override fun onBackPressed() {

//        val intent = Intent(this, ActivitySabteFard2::class.java)
//        startActivity(intent)
//        fullfinish()

    }

    private fun citySpiner(){
        sabt_makan_shahr.setTitle("جستجو و انتخاب کنید")
        sabt_makan_shahr.setPositiveButton("تایید")
        val spcity = findViewById(R.id.sabt_makan_shahr) as Spinner
        val adaptercity: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, citis[ostan_index])
        adaptercity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spcity.setAdapter(adaptercity)
        spcity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                city = citis[ostan_index].get(position)
                sabt_makan_name.setText(ostan+": "+city)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }

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
