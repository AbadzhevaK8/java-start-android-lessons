package android.example.p0381sqlitetransaction;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

  final String LOG_TAG = "myLogs";

  DBHelper dbh;
  SQLiteDatabase db;

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(LOG_TAG, "--- onCreate Activity ---");
    dbh = new DBHelper(this);
    myActions();
  }

//  void myActions() {
//    db = dbh.getWritableDatabase();
//    delete(db, "mytable");
//    insert(db, "mytable", "val1");
//    read(db, "mytable");
//    dbh.close();
//  }

//  void myActions() {
//    db = dbh.getWritableDatabase();
//    delete(db, "mytable");
//    db.beginTransaction();
//    insert(db, "mytable", "val1");
//    db.endTransaction();
//    insert(db, "mytable", "val2");
//    read(db, "mytable");
//    dbh.close();
//  }

//  void myActions() {
//    db = dbh.getWritableDatabase();
//    delete(db, "mytable");
//    db.beginTransaction();
//    insert(db, "mytable", "val1");
//    db.setTransactionSuccessful();
//    insert(db, "mytable", "val2");
//    db.endTransaction();
//    insert(db, "mytable", "val3");
//    read(db, "mytable");
//    dbh.close();
//  }

//  void myActions() {
//    try {
//      db = dbh.getWritableDatabase();
//      delete(db, "mytable");
//
//      db.beginTransaction();
//      insert(db, "mytable", "val1");
//
//      Log.d(LOG_TAG, "create DBHelper");
//      DBHelper dbh2 = new DBHelper(this);
//      Log.d(LOG_TAG, "get db");
//      SQLiteDatabase db2 = dbh2.getWritableDatabase();
//      read(db2, "mytable");
//      dbh2.close();
//
//      db.setTransactionSuccessful();
//      db.endTransaction();
//
//      read(db, "mytable");
//      dbh.close();
//
//    } catch (Exception ex) {
//      Log.d(LOG_TAG, ex.getClass() + " error: " + ex.getMessage());
//    }
//  }

  void myActions() {
    db = dbh.getWritableDatabase();
    SQLiteDatabase db2 = dbh.getWritableDatabase();
    Log.d(LOG_TAG, "db = db2 - " + db.equals(db2));
    Log.d(LOG_TAG, "db open - " + db.isOpen() + ", db2 open - " + db2.isOpen());
    db2.close();
    Log.d(LOG_TAG, "db open - " + db.isOpen() + ", db2 open - " + db2.isOpen());
  }

  void insert(SQLiteDatabase db, String table, String value) {
    Log.d(LOG_TAG, "Insert in table " + table + " value = " + value);
    ContentValues cv = new ContentValues();
    cv.put("val", value);
    db.insert(table, null, cv);
  }

  void read(SQLiteDatabase db, String table) {
    Log.d(LOG_TAG, "Read table " + table);
    Cursor c = db.query(table, null, null, null, null, null, null);
    if (c != null) {
      Log.d(LOG_TAG, "Records count = " + c.getCount());
      if (c.moveToFirst()) {
        do {
          Log.d(LOG_TAG, c.getString(c.getColumnIndexOrThrow("val")));
        } while (c.moveToNext());
      }
      c.close();
    }
  }

  void delete(SQLiteDatabase db, String table) {
    Log.d(LOG_TAG, "Delete all from table " + table);
    db.delete(table, null, null);
  }

  // ?????????? ?????? ???????????? ?? ????
  class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
      super(context, "myDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
      Log.d(LOG_TAG, "--- onCreate database ---");

      db.execSQL("create table mytable ("
          + "id integer primary key autoincrement,"
          + "val text"
          + ");");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
  }

}