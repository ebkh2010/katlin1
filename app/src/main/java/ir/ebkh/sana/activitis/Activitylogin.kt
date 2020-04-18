package ir.ebkh.sana.activitis

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import kotlinx.android.synthetic.main.login.*


class Activitylogin : AppCompatActivity() {

    val user = "1234"
    val pass = "1111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        btn_login.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_login.setImageResource(R.drawable.pushed_btn_login)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_login.setImageResource(R.drawable.btn_login)
            }
            false
        })
        btn_login.setOnClickListener {
//            if (etxt_user.getText().toString() == user)
//                if (etxt_pass.getText().toString() == pass)
//                {
                    val intent = Intent(this, ActivityEstelam::class.java)
                    startActivity(intent)
                    finish()
//                }
        }

    }

    override fun onBackPressed() {
        finish()
    }
}
