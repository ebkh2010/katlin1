package ir.ebkh.sana.main;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.view.LayoutInflater;

public class G extends Application {


    public static SQLiteDatabase database;
    public static final String              DIR_SDCARD 				= Environment.getExternalStorageDirectory()
                                                                        .getAbsolutePath(),
                                            APP_SD_DIR              = DIR_SDCARD + "/sana",
                                            DB_SD_DIR               = APP_SD_DIR + "/DB";

    public static Context context;
    public static LayoutInflater inflater;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



}

