/* CENGB BOIZ
QuickStudy
Ruel John Cootauco - N01114847
Adam Warrington - N01110575
Acefiel Eroma - N01101571
*/

package cengboiz.quickstudy;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "EntryTable";
    private static final String COL1 = "Entry";
    private static final String COL2 = "Name";
    private static final String COL3 = "Subject";
    private static final String COL4 = "Info";
    private static final String COL5 = "TimeStart";
    private static final String COL6 = "TimeEnd";



    public DatabaseHelper (Context context) {
        super (context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ENTRY INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public boolean addData(String Item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, Item);
        Log.d(TAG, "addData: Adding " + Item + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return true;
        else
            return false;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


















}
