package ir.ebkh.sana.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "sana .sqlite";
    public static final int DB_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, G.DB_SD_DIR +"/"+ DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE YOUR TABLES a ( QUERY )");
//        db.execSQL("CREATE YOUR TABLES b ( QUERY )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("YOUR UPGRAGE QUERY 1");
//        db.execSQL("YOUR UPGRAGE QUERY 2");

    }
}
