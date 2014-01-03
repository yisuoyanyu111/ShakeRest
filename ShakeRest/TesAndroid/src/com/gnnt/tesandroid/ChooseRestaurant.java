package com.gnnt.tesandroid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ChooseRestaurant {
	private static Map<Integer, String> RESTMAP  = new HashMap<Integer, String>();
	private static Map<Integer, Integer> RESTMAPKEY  = new HashMap<Integer, Integer>();
	
	public static void ChooseRes(){
		//初始化RESTMAP
		RESTMAP.put(1, "望川家");
		RESTMAP.put(2,"三乐餐厅");
		RESTMAP.put(3, "晋B2008C");
		RESTMAP.put(4, "小笼包");
		RESTMAP.put(5, "桂林米粉");
		RESTMAP.put(6, "驴肉火烧");
		
		//初始化RESTMAPKEY
		Set<Integer> set = RESTMAP.keySet();
		for(Integer i:set){
			RESTMAPKEY.put(i, i);
		}
	}
	public Integer getMapKey(){
		Integer in = 0;
		
		Double ran = 0d;
		Integer random = 0;
		String str = null;
		while(true){
			ran = Math.random()*10;
			random = ran.intValue(); 
			if(random>0&&random<=6){
				in = random;
				str = RESTMAP.get(in);
				System.out.println(str);
				return in;
			}
		}
	}
	
	//计时秒
	public static boolean counTime(long seconds){
		boolean boo = true;
		
		long olddate = new Date().getTime();
		long newdate = 0L;
		while(true){
			newdate = new Date().getTime();
			if(newdate-olddate>seconds*1000){
				boo = true;
				return boo;
			}
		}
	}
	
	public String getRan(){
		ChooseRes();
		//随即选取
		Double ran = 0d;
		Integer random = 1;
		Integer rand = 0;
		String str = "没摇到!请继续^<>^!"; 
		
		ran = Math.random()*10;
		rand = ran.intValue();
		if(rand>0&&rand<=RESTMAP.size()){
			random = rand; 
			str = RESTMAP.get(random);
		}else if(rand>0&&rand<=RESTMAP.size()){//增加平均的机会
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//增加平均的机会
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//增加平均的机会
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//增加平均的机会
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//增加平均的机会
			random = rand; 
			str = RESTMAP.get(random);
		}
		
		return str;
	}
	

}
