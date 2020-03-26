package ir.ebkh.sana.activitis.sabt;


import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.IStatusListener;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener;
import ir.ebkh.sana.R;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySabteTakhalof3 extends AppCompatActivity {


    private SearchableSpinner mSearchableSpinner;
    private SearchableSpinner mSearchableSpinner1;
    private SearchableSpinner mSearchableSpinner2;
    private SearchableSpinner mSearchableSpinner3;
    private SimpleListAdapter mSimpleListAdapter;
    private SimpleArrayListAdapter mSimpleArrayListAdapter;
    private final ArrayList<String> mStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sabt_takhalof3);

        initListValues();
        mSimpleListAdapter = new SimpleListAdapter(this, mStrings);
        mSimpleArrayListAdapter = new SimpleArrayListAdapter(this, mStrings);

        mSearchableSpinner = (SearchableSpinner) findViewById(R.id.SearchableSpinner);
        mSearchableSpinner.setAdapter(mSimpleArrayListAdapter);
        mSearchableSpinner.setOnItemSelectedListener(mOnItemSelectedListener);
        mSearchableSpinner.setStatusListener(new IStatusListener() {
            @Override
            public void spinnerIsOpening() {
//                mSearchableSpinner1.hideEdit();
//                mSearchableSpinner2.hideEdit();
            }

            @Override
            public void spinnerIsClosing() {

            }
        });
//
//        mSearchableSpinner1 = (SearchableSpinner) findViewById(R.id.SearchableSpinner);
//        mSearchableSpinner1.setAdapter(mSimpleListAdapter);
//        mSearchableSpinner1.setOnItemSelectedListener(mOnItemSelectedListener);
//        mSearchableSpinner1.setStatusListener(new IStatusListener() {
//            @Override
//            public void spinnerIsOpening() {
//                mSearchableSpinner.hideEdit();
//                mSearchableSpinner2.hideEdit();
//            }
//
//            @Override
//            public void spinnerIsClosing() {
//
//            }
//        });
//
//        mSearchableSpinner2 = (SearchableSpinner) findViewById(R.id.SearchableSpinner2);
//        mSearchableSpinner2.setAdapter(mSimpleListAdapter);
//        mSearchableSpinner2.setOnItemSelectedListener(mOnItemSelectedListener);
//        mSearchableSpinner2.setStatusListener(new IStatusListener() {
//            @Override
//            public void spinnerIsOpening() {
//                mSearchableSpinner.hideEdit();
//                mSearchableSpinner1.hideEdit();
//            }
//
//            @Override
//            public void spinnerIsClosing() {
//
//            }
//        });
//
//        mSearchableSpinner3 = (SearchableSpinner) findViewById(R.id.SearchableSpinner3);
//        mSearchableSpinner3.setAdapter(mSimpleListAdapter);
//        mSearchableSpinner3.setOnItemSelectedListener(mOnItemSelectedListener);
//        mSearchableSpinner3.setStatusListener(new IStatusListener() {
//            @Override
//            public void spinnerIsOpening() {
//                mSearchableSpinner.hideEdit();
//                mSearchableSpinner3.hideEdit();
//            }
//
//            @Override
//            public void spinnerIsClosing() {
//
//            }
//        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mSearchableSpinner.isInsideSearchEditText(event)) {
            mSearchableSpinner.hideEdit();
        }
        if (!mSearchableSpinner1.isInsideSearchEditText(event)) {
            mSearchableSpinner1.hideEdit();
        }
        if (!mSearchableSpinner2.isInsideSearchEditText(event)) {
            mSearchableSpinner2.hideEdit();
        }
        return super.onTouchEvent(event);
    }

    private OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(View view, int position, long id) {
            Toast.makeText(ActivitySabteTakhalof3.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected() {
            Toast.makeText(ActivitySabteTakhalof3.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
    };

    private void initListValues() {
        mStrings.add("فروردین");
        mStrings.add("اردیبهشت");
        mStrings.add("خرداد");
        mStrings.add("تیر");
        mStrings.add("مرداد");
        mStrings.add("شهریور");
        mStrings.add("مهر");
        mStrings.add("آبان");
        mStrings.add("آذر");
        mStrings.add("دی");
        mStrings.add("بهمن");
        mStrings.add("اسفند");

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_reset) {
//            mSearchableSpinner.setSelectedItem(0);
//            mSearchableSpinner1.setSelectedItem(0);
//            mSearchableSpinner2.setSelectedItem(0);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
