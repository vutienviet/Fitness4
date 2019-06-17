package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zeroc.fitness.model.DbResponse;
import com.example.zeroc.fitness.model.Item;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "EX_Manager.db";
    private static final String TABLE_NAME = "EX";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static int VERSION = 1;

    private Context context;
    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }

    public void addEx(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, item.getName());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addStudent Successfuly");
    }

    public List<Item> getAllEx() {
        List<Item> listEx = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(cursor.getInt(0));
                item.setName(cursor.getString(1)+"");

                listEx.add(item);

            } while (cursor.moveToNext());
        }
        db.close();
        return listEx;
    }

    public DbResponse getData(){
        DbResponse obj = new DbResponse();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            obj.name = cursor.getString(cursor.getColumnIndex(NAME));
        }
        cursor.close();
        return obj;
    }
    public int updateEx(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,item.getName());
        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(item.getId())});
    }
    public int deleteEx(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }

    public Cursor searchEx(String text){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select " +NAME+" from " + TABLE_NAME+" WHERE "+NAME+" Like '%"+text+"%'";
        Cursor cursor = db.rawQuery( query , null );
        return cursor;
    }
}
