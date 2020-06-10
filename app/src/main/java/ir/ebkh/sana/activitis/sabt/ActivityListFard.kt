package ir.ebkh.sana.activitis.sabt


import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.sabt.Adapters.CustomAdapter
import ir.ebkh.sana.main.G.*
import ir.ebkh.sana.main.Person
import kotlinx.android.synthetic.main.list_fard.*
import java.util.*


class ActivityListFard : AppCompatActivity() {


    var listt = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_fard)

        listOfSelectedPersons.clear()
        cursorToString(getData(database,"persons","kode_meli", listOfSelectedMeliCods),
            listt)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val adapter = CustomAdapter(listt)

        recyclerView.adapter = adapter
    }


    // این تابع از دیتا بیس db جدول tebl همه مشخصات آیتمهایی که در ستون col دارای مقادیر item هستند را به صورت کرسر باز میگرداند
    fun getData(db: SQLiteDatabase, tabl: String, col: String, items: ArrayList<String>): Cursor {

        var selectALLQuery = "SELECT * FROM " + tabl +" WHERE "
        var conditions: ArrayList<String> = arrayListOf()

        for (i in 0..items.size - 1) {
            conditions.add(col + " = '" + items[i] + "'")
        }

        selectALLQuery += conditions.joinToString(" OR ")
        val cursor = db.rawQuery(selectALLQuery, null)

        return  cursor

    }

    fun cursorToString(c: Cursor, prsn:MutableList<String>) {
        var pp = Person()
        var ss=""

        c.moveToFirst()
        while (!c.isAfterLast)
        {
            pp.firsname          = c.getString(c.getColumnIndex("first_name"))
            pp.lastname          = c.getString(c.getColumnIndex("last_name"))
            pp.fathername        = c.getString(c.getColumnIndex("father_name"))
            pp.gender            = c.getString(c.getColumnIndex("gender"))
            pp.melikod           = c.getString(c.getColumnIndex("kode_meli"))
            pp.job               = c.getString(c.getColumnIndex("job"))
            pp.mobile            = c.getString(c.getColumnIndex("modile_number"))
            pp.taahol            = c.getString(c.getColumnIndex("taahol"))
            pp.tahsilat          = c.getString(c.getColumnIndex("tahsilat"))
            pp.tavalodcity       = c.getString(c.getColumnIndex("tavalod_city"))
            pp.tavaloddate       = c.getString(c.getColumnIndex("tavalod_date"))


            if (pp.gender=="مرد")
                ss="آقای "+pp.firsname+" "+pp.lastname+"\n"+
                        "کد ملی:"+pp.melikod
            else if (pp.gender=="زن")
                ss="خانم "+pp.firsname+" "+pp.lastname+"\n"+
                        "کد ملی:"+pp.melikod
            else
                ss=pp.firsname+" "+pp.lastname+"\n"+
                        "کد ملی:"+pp.melikod

            prsn.add(ss)
            c.moveToNext()
        }
        c.close()
    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivitySabteTakhalof3::class.java)
        startActivity(intent)
        listfard_layout.removeAllViews()
        finish()
    }


}