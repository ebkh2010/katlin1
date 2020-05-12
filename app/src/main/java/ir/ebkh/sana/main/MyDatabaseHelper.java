package ir.ebkh.sana.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "sana.sqlite";
    public static final int DB_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, G.DB_SD_DIR +"/"+ DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE car(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "car_pelak_id INTEGER ," +
                "name TEXT ," +
                "system TEXT," +
                "tip TEXT," +
                "color TEXT ," +
                "shasi_number INTEGER," +
                "motor_number INTEGER)");
        db.execSQL("CREATE TABLE car_plak(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "first_number INTEGER ," +
                "harf TEXT ," +
                "second_number INTEGER ," +
                "iran_number INTEGER )");

        db.execSQL("CREATE TABLE motor" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "motor_pelak_id INTEGER," +
                "motor_name TEXT ," +
                "motor_system TEXT," +
                "motor_color TEXT ," +
                "shasi_number TEXT," +
                "motor_number TEXT)");
        db.execSQL("CREATE TABLE motorpelak" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "up_number INTEGER ," +
                "down_number INTEGER )");

        db.execSQL("CREATE TABLE persons" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "kode_meli TEXT  UNIQUE," +
                "first_name TEXT ," +
                "last_name TEXT ," +
                "gender TEXT ," +
                "father_name TEXT," +
                "tavalod_date TEXT," +
                "tavalod_city TEXT," +
                "tahsilat TEXT," +
                "taahol TEXT," +
                "job TEXT," +
                "job_comment TEXT)");
        db.execSQL( "CREATE TABLE place" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "name TEXT," +
                "shahr TEXT ," +
                "mantaghe TEXT ," +
                "khiban_asli TEXT ," +
                "mahale TEXT," +
                "khiaban_fari TEXT," +
                "adress TEXT ," +
                "kuche TEXT," +
                "pelak INTEGER," +
                "name_vahed TEXT," +
                "senf_vahed TEXT," +
                "tozohat TEXT)");
        db.execSQL( "CREATE TABLE takhalof" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "sana_id TEXT  UNIQUE," +
                "date INTEGER ," +
                "model TEXT," +
                "person_ids TEXT," +
                "car_and_motor_ids TEXT," +
                "place_ids TEXT)");
//        db.execSQL("CREATE YOUR TABLES b ( QUERY )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("YOUR UPGRAGE QUERY 1");
//        db.execSQL("YOUR UPGRAGE QUERY 2");

    }
}
