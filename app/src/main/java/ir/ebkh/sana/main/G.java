package ir.ebkh.sana.main;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class G extends Application {

    public static SQLiteDatabase database;
    public static final String              DIR_SDCARD 				= Environment.getExternalStorageDirectory()
                                                                        .getAbsolutePath(),
                                            APP_SD_DIR              = DIR_SDCARD + "/sana",
                                            DB_SD_DIR               = APP_SD_DIR + "/DB";
    public static  String
                                            takhalofSanaCod="",
                                            takhalofTarikh="",
                                            takhalofSaat="",
                                            takhalofModel="",
                                            takhalofModelComment="",
    carPelak="",
    carName="",
    carSystem="",
    carTip="",
                                            kode_meli="",
                                            name="",
                                            lastname="",
                                            fathername="",
                                            gender="",
                                            born_date="",
                                            born_city="",
                                            marage_stat="",
                                            school_stat="",
                                            job_stat="",
                                            job_comment_stat="",
                                            mobile="",
                                            phone="",
                                            other_numbers=""
                                                    ;
    public static ArrayList<String>         listOfSelectedMeliCods = new ArrayList<String>(),
                                            listOfSelectedCArPelaks = new ArrayList<>(),
                                            listOfPesons = new ArrayList<String>();
    public static ArrayList<Person>         listOfSelectedPersons = new ArrayList<Person>();


    public static Context context;
    public static LayoutInflater inflater;

    public Person p=new Person();

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }





}

