package rharj.com.greendaoexample.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import rharj.com.greendaoexample.R;
import rharj.com.greendaoexample.database.DbHelper;
import rharj.com.greendaoexample.model.DaoMaster;
import rharj.com.greendaoexample.model.DaoSession;
import rharj.com.greendaoexample.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private EditText fname,lname,address,occupation;
    private Button submit;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeControls();
    }

    private void initializeControls() {

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        address = (EditText) findViewById(R.id.address);
        occupation = (EditText) findViewById(R.id.occupation);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateControls(fname.getText().toString(),lname.getText().toString(),address.getText().toString(),
                        occupation.getText().toString())){

                    //insert record to db using greendao library
                    saveUserDetails(getBaseContext(),fname.getText().toString(),lname.getText().toString(),address.getText().toString(),
                            occupation.getText().toString());

                }
            }
        });
    }

    private boolean validateControls(String FName,String LName,String address, String occupation) {
        if(TextUtils.isEmpty(FName)){
            fname.setError("Please provide your first name");
            return false;
        }
        if(TextUtils.isEmpty(LName)){
            fname.setError("Please provide your last name");
            return false;
        }
        if(TextUtils.isEmpty(address)){
            fname.setError("Please provide your address");
            return false;
        }
        if(TextUtils.isEmpty(occupation)){
            fname.setError("Please provide your occupation");
            return false;
        }

        return true;

    }

    private void saveUserDetails(Context context,String fname,String lname,String address,String occupation){

        daoSession = new DaoMaster(new DbHelper(context,"demo.db").getWritableDb()).newSession();
        Long result = daoSession.getUserModelDao().insert(new UserModel(null,fname,lname,address,occupation));
        if(result>0){
            Snackbar.make(submit,"Details saved",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
