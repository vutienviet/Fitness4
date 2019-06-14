package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zeroc.fitness.model.Ex;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SLITe";
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "EX_Manager";
    private static final String TABLE_EX = "Ex";
    private static final String COLUMN_EX_ID = "Ex_Id";
    private static final String COLUMN_EX_TITLE = "Ex_Title";
    private static final String COLUMN_EX_CONTENT = "Ex_Content";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i( TAG , "Oncreat" );

        String script = "CREATE TABLE " + TABLE_EX + "(" + COLUMN_EX_ID+"INTEGER PRIMARY KEY," + COLUMN_EX_TITLE + "TEXT,"
                        +COLUMN_EX_CONTENT + "TEXT" + ")";
        db.execSQL( script );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG , "OnUpgrade..");
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_EX );
        onCreate( db );
    }

    public void CreateDefaultExIfNeed() {
        int count = this.getExCount();
        if (count == 0){
            Ex ex1 = new Ex( "Tottoro1" , "Totoro is dancing" );
            Ex ex2 = new Ex( "Tottoro2" , "Totoro is dancing" );

            this.addEx(ex1);
            this.addEx(ex2);
        }
    }

    private void addEx(Ex ex) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues(  );
        values.put( COLUMN_EX_TITLE , ex.getExTitle() );
        values.put( COLUMN_EX_CONTENT , ex.getExContent() );

//        chen du lieu vao bang
        db.insert( TABLE_EX , null , values );

        db.close();
    }

    public int getExCount(){
        String countScript = "SELECT * FROM " + TABLE_EX;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( countScript , null );

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public Ex getEx(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query( TABLE_EX , new String[]{
                COLUMN_EX_ID , COLUMN_EX_TITLE , COLUMN_EX_CONTENT
        } , COLUMN_EX_ID + " =? " , new String[]{
                String.valueOf( id )
        } , null ,null , null , null );
        if (cursor != null )
            cursor.moveToFirst();

            Ex ex = new Ex( Integer.parseInt( cursor.getString( 0 ) ) ,
                    cursor.getString( 1 ) , cursor.getString( 2 ));

            return ex;

    }
}
