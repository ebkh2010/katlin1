package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import ir.ebkh.sana.R
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.sabt_fard.*

class ActivitySabteFard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard)


        btn_sabtefard.setOnClickListener {

            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name) " +
                    "VALUES ('"+sabt_fard_kodmelli.text+"','"+sabt_fard_name.text+"','"+sabt_fard_famil.text+"')";
            try {
                G.database.execSQL(sqlq)
            }catch (e: NumberFormatException) {
                println("kodmelli") }


            val intent = Intent(this, ActivitySabteFard2::class.java)
            startActivity(intent)
        }
    }
}

//کد ملی یونیک است یعنی اگر طرف کد ملی تکراری زد نباید کلید بعدی عمل کند و به گونه ای نشان دهد که کد ملی تکراری است