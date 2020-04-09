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
                "car_pelak_id INTEGER NOT NULL," +
                "name TEXT NOT NULL," +
                "system TEXT," +
                "tip TEXT," +
                "color TEXT NOT NULL," +
                "shasi_number INTEGER," +
                "motor_number INTEGER)");
        db.execSQL("CREATE TABLE car_plak(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "first_number INTEGER NOT NULL," +
                "harf TEXT NOT NULL," +
                "second_number INTEGER NOT NULL," +
                "iran_number INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE motor" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "motor_pelak_id INTEGER," +
                "motor_name TEXT NOT NULL," +
                "motor_system TEXT," +
                "motor_color TEXT NOT NULL," +
                "shasi_number TEXT," +
                "motor_number TEXT)");
        db.execSQL("CREATE TABLE motorpelak" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "up_number INTEGER NOT NULL," +
                "down_number INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE persons" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "kode_meli INTEGER NOT NULL UNIQUE," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "gender TEXT NOT NULL," +
                "father_name TEXT," +
                "tavalod_date INTEGER," +
                "tavalod_city TEXT," +
                "tahsilat TEXT," +
                "taahol TEXT," +
                "job TEXT," +
                "job_adress TEXT)");
        db.execSQL( "CREATE TABLE place" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "name TEXT," +
                "shahr TEXT NOT NULL," +
                "mantaghe TEXT NOT NULL," +
                "khiban_asli TEXT NOT NULL," +
                "mahale TEXT," +
                "khiaban_fari TEXT," +
                "adress TEXT NOT NULL," +
                "kuche TEXT," +
                "pelak INTEGER," +
                "name_vahed TEXT," +
                "senf_vahed TEXT," +
                "tozohat TEXT)");
        db.execSQL( "CREATE TABLE takhalof" +
                "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "sana_id TEXT NOT NULL UNIQUE," +
                "date INTEGER NOT NULL," +
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
