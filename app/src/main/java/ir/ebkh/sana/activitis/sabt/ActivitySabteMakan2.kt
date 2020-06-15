package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import ir.ebkh.sana.main.G.*
import kotlinx.android.synthetic.main.sabt_khodro.*
import kotlinx.android.synthetic.main.sabt_khodro2.*
import kotlinx.android.synthetic.main.sabt_makan2.*
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import java.util.*

class ActivitySabteMakan2 : AppCompatActivity() {

//    private var isRegistred=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_makan2)

        btn_sabte_makan2.setOnClickListener {

            var sqlq="INSERT INTO place(" +
                    "ostan," +
                    "shahr," +
                    "adress," +
                    "name_vahed," +
                    "senf_vahed," +
                    "malek," +
                    "tozohat) " +
                    "VALUES ('"+
                    listOfData[0]+"','"+
                    listOfData[1]+"','"+
                    sabt_makan_adress.text.toString()+ "','"+
                    listOfData[4]+"','"+
                    listOfData[3]+"','"+
                    listOfData[2]+ "','"+
                    sabte_makan_comment.text.toString()+"')"

            try {
                database.execSQL(sqlq)
            }catch (e: NumberFormatException) {
                println("kodmelli")

            }

            val intent = Intent(this, ActivitySabteTakhalof5::class.java)
            startActivity(intent)
            fullfinish()

        }

    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivitySabteMakan::class.java)
        startActivity(intent)
        fullfinish()
    }

    private fun fullfinish(){
        b84.setImageDrawable(null)
        b85.setImageDrawable(null)
        b86.setImageDrawable(null)
        b87.setImageDrawable(null)
        btn_sabte_makan2.setImageDrawable(null)

        sabt_makan2_main_layout.removeAllViews()
        listOfData=null
        finish()

    }
}
