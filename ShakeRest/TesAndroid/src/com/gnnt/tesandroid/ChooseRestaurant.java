package com.gnnt.tesandroid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ChooseRestaurant {
	private static Map<Integer, String> RESTMAP  = new HashMap<Integer, String>();
	private static Map<Integer, Integer> RESTMAPKEY  = new HashMap<Integer, Integer>();
	
	public static void ChooseRes(){
		//��ʼ��RESTMAP
		RESTMAP.put(1, "������");
		RESTMAP.put(2,"���ֲ���");
		RESTMAP.put(3, "��B2008C");
		RESTMAP.put(4, "С����");
		RESTMAP.put(5, "�����׷�");
		RESTMAP.put(6, "¿�����");
		
		//��ʼ��RESTMAPKEY
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
	
	//��ʱ��
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
		//�漴ѡȡ
		Double ran = 0d;
		Integer random = 1;
		Integer rand = 0;
		String str = "ûҡ��!�����^<>^!"; 
		
		ran = Math.random()*10;
		rand = ran.intValue();
		if(rand>0&&rand<=RESTMAP.size()){
			random = rand; 
			str = RESTMAP.get(random);
		}else if(rand>0&&rand<=RESTMAP.size()){//����ƽ���Ļ���
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//����ƽ���Ļ���
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//����ƽ���Ļ���
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//����ƽ���Ļ���
			random = rand; 
			str = RESTMAP.get(random);
		}
		else if(rand>0&&rand<=RESTMAP.size()){//����ƽ���Ļ���
			random = rand; 
			str = RESTMAP.get(random);
		}
		
		return str;
	}
	

}
