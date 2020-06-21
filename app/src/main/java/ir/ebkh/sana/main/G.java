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
//                                            kode_meli="",0
//                                            name="",1
//                                            lastname="",2
//                                            fathername="",3
//                                            gender="",4
//                                            born_date="",5
//                                            born_city="",6
//                                            marage_stat="",7
//                                            school_stat="",8
//                                            job_stat="",9
//                                            job_comment_stat="",10
//                                            mobile="",
//                                            phone="",
//                                            other_numbers="",
                                            refrense_activity=""
                                                    ;
    public static ArrayList<String>         listOfSelectedMeliCods = new ArrayList<String>(),
                                            listOfMeliCods = new ArrayList<String>(),
                                            listOfSelectedCArPelaks = new ArrayList<>(),
                                            listOfSelectedMotorPelaks = new ArrayList<>(),
                                            listOfPelaks = new ArrayList<>(),
                                            listOfData= new ArrayList<>(),
                                            listOfDataMakan= new ArrayList<>(),
                                            listOfPesons = new ArrayList<String>(),
                                            listOfCars = new ArrayList<String>(),
                                            listOfMotors = new ArrayList<String>();

    public static ArrayList<Integer>        listOfMakanPositions = new ArrayList<>();
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

