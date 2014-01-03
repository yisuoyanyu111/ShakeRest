package com.gnnt.tesandroid;

import android.content.ContentValues;

public class DBHelper extends AbstractDatabaseHelper{

	public static String DBNAME = "Restaurant";
	public static int DBVERSION = 1;
	public static String TABLE = "REST";
	@Override
	protected String getTag() {
		// TODO Auto-generated method stub
		return "DBHelper";
	}

	@Override
	protected String getDBName() {
		// TODO Auto-generated method stub
		return DBNAME;
	}

	@Override
	protected int getDatabaseVersion() {
		// TODO Auto-generated method stub
		return DBVERSION;
	}

	@Override
	protected String[] createDBTables() {
		// TODO Auto-generated method stub
		String[] args = {"CREATE TABLE "+TABLE+" (id INTEGER PRIMARY KEY,name TEXT, address TEXT);"};
		return args;
	}

	@Override
	protected String[] dropTablesSql() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Long addRestaurant(Restaurant res ){
		Long num = 0l;
		ContentValues val = new ContentValues();
		val.put("name", res.getName());
		val.put("address", res.getAddress());
		num = mDb.insert(TABLE, "", val);
		return num;
	}
	
	public int updateRestaurant(Restaurant res){
		int num = 0;
		ContentValues val = new ContentValues();
		val.put("name", res.getName());
		val.put("address", res.getAddress());
		String[] args = {String.valueOf(res.getId())};
		num = mDb.update(TABLE, val, "id=?", args);
		return num;
	}
	
	public int deleteRestaurant(Restaurant res){
		int num = 0;
		String[] args = {String.valueOf(res.getId())};
		num = mDb.delete(TABLE, "id=?", args);
		return num;		
	}

	public int deleteRestaurantById(Long id){
		int num = 0;
		String[] args = {String.valueOf(id)};
		num = mDb.delete(TABLE, "id=?", args);
		return num;		
	}
	
	public Restaurant findResByName(String name){
		Restaurant res = null;
		
		return res;
	}
}
