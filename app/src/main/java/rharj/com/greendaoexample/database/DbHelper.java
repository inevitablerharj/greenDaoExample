package rharj.com.greendaoexample.database;

import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import rharj.com.greendaoexample.model.DaoMaster;

/**
 * Created by rharj on 12/13/2017.
 */

public class DbHelper extends DaoMaster.OpenHelper {

    public DbHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }
}
