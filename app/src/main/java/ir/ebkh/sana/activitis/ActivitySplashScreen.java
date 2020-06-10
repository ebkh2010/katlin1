
package ir.ebkh.sana.activitis;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.ebkh.sana.main.G;

import androidx.core.app.ActivityCompat;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import ir.ebkh.sana.R;
import ir.ebkh.sana.main.MyDatabaseHelper;

import static ir.ebkh.sana.main.G.database;


public class ActivitySplashScreen extends Activity
{

    private static long SPLASH_MILLIS = 4000;
    ImageView back,book;
    Animation fade,zoomout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.splash_screen, null, false);

        addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        fade = AnimationUtils.loadAnimation(this,R.anim.fade);
        zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);

        back =  findViewById(R.id.splash_logo);
        book =  findViewById(R.id.splash_sana);

        book.setAnimation(fade);
        back.setAnimation(zoomout);

        //TODO گرفتن دسترسی های مورد نیاز
        int PERMISSION_ALL = 1;
        final String[] PERMISSIONS = {
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET};

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }


        //TODO اگر همه دسترسی ها برای نرم افزار وجود داشت بعد از مدتی به صفحه اصلی منتقل میشه
        final Timer timer= new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (hasPermissions(ActivitySplashScreen.this, PERMISSIONS)) {

                    timer.cancel();
                    makeDirs();
                    creatOrOpenDB();
                    Intent intent = new Intent(ActivitySplashScreen.this,
                            Activitylogin.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    finish();
                }
            }
        },SPLASH_MILLIS,SPLASH_MILLIS);


    }

    // تابعی که چک میکند آیا همه دسترسی گرفته شده یا نه؟
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void makeDirs(){

        new File(G.DIR_SDCARD).mkdirs();
        new File(G.APP_SD_DIR).mkdirs();
        new File(G.DB_SD_DIR).mkdirs();
    }

    public void creatOrOpenDB(){

        if (database!=null) return;
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        database = dbHelper.getWritableDatabase();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

}
