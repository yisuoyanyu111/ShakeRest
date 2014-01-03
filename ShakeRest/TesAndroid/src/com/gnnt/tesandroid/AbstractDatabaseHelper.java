package com.gnnt.tesandroid;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
/** *//**
 * TODO ���ݿ���ֻ��࣬һ�����ݿ��Ӧһ������ʵ�֡�
 *         �������ڲ�����������ֶ����͸���ҵ���߼������ȵȡ�
 *         �����ݿ����ɾ�Ĳ�������ʹ���������
 *         �����ݵĲ�ѯ����������ʹ��Cursorǰ������startManagingCursor()��������Cursor��
 * 
 */
public abstract class AbstractDatabaseHelper {
    
    /** *//**
     * SQLite���ݿ�ʵ�� 
     */
    protected SQLiteDatabase mDb = null;
    
    /** *//**
     * ���ݿⴴ������
     */
    protected CreateDBHelper mDbHelper = null;
    
    /** *//**
     * ��õ�ǰ���ݿ�������ʶ(һ���Ǹ�������)��������־�ȵļ�¼
     * @return
     */
    protected abstract String getTag();
    
    /** *//**
     * ������ݿ�����
     * @return
     */
    protected abstract String getDBName();
    
    /** *//**
     * ������ݿ�汾��ֵ����Ϊ1��
     * �����ݿ�ṹ�����ı��ʱ���뽫��ֵ��1��ϵͳ���ڳ�ʼ��ʱ�Զ�����
     * createDBTables��dropDBTables�����������ݿ�ṹ��
     * @return
     */
    protected abstract int getDatabaseVersion();
    
    /** *//**
     * �������ݿ���SQL��䣬һ��Ԫ��һ�����
     * @return
     */
    protected abstract String[] createDBTables();
    
    /** *//**
     * ɾ�����ݿ���SQL��䣬һ��Ԫ��һ�����
     * @return
     */
    protected abstract String[] dropTablesSql();
    
    /** *//**
     * 
     * TODO �ڲ����ݿⴴ��������
     * 
     */
    class CreateDBHelper extends SQLiteOpenHelper
    {
        public CreateDBHelper(Context ctx)
        {
            super(ctx, getDBName(), null, getDatabaseVersion());
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            executeBatch(createDBTables(), db);
        }

        @SuppressLint("NewApi")
		@Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            Log.w(getTag(), "Upgrading database '" + getDatabaseName() + "' from version " + oldVersion + " to " + newVersion);
            executeBatch(dropTablesSql(), db);
            onCreate(db);
        }
        
        /** *//**
         * ����ִ��Sql���
         * @param sqls
         * @param db
         */
        private void executeBatch(String[] sqls, SQLiteDatabase db)
        {
            if(sqls == null)
                return;
            
            db.beginTransaction();
            try
            {
                int len = sqls.length;
                for(int i = 0; i < len; i++)
                {
                    db.execSQL(sqls[i]);
                }
                db.setTransactionSuccessful();
            }catch(Exception e){
                Log.e(getTag(), e.getMessage(), e);
            }finally{
                db.endTransaction();
            }

        }
        
    }
    
    /** *//**
     * �򿪻��ߴ���һ��ָ�����Ƶ����ݿ�
     * @param dbName
     * @param ctx
     */
    public void open(Context ctx)
    {
        Log.i(getTag(), "Open database '" + getDBName() + "'");
        mDbHelper = new CreateDBHelper(ctx);
        mDb = mDbHelper.getWritableDatabase();
    }
    
    /** *//**
     * �ر����ݿ�
     */
    public void close()
    {
        if(mDbHelper != null)
        {
            Log.i(getTag(), "Close database '" + getDBName() + "'");
            mDbHelper.close();
        }    
    }
    
}

