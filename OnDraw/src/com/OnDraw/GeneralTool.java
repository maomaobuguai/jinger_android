package com.OnDraw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import org.apache.http.util.EncodingUtils;

import android.os.Environment;

public class GeneralTool{
	
	public static void saveToSDcard(float x){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),"OnDrawData1.txt");
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"";
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");  	
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, String filename){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),filename);
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"";
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, float d){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),"OnDrawData2.txt");
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"  "+d;
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");  	
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, float d,String filename){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),filename);
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"  "+d;
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");  	
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, float d, float g){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),"OnDrawData3.txt");
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"  "+d+"  "+g;
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, float d, float g, String FileName){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),FileName);
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"  "+d+"  "+g;
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");  
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveToSDcard(float x, float d, float g, float h){
		try {			
			//以追加的方式来保存加速度的值
			File file = new File(Environment.getExternalStorageDirectory(),"OnDrawData4.txt");
		    //第二个参数意义是说是否以append方式添加内容  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = x+"  "+d+"  "+g+"  "+h;
		    bw.write(info);
		    bw.write("\r\n"); 
		    bw.flush();  
		    System.out.println("写入成功");  	
		    bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//扩容函数——float数组
	static float[] enlarge_float(float [] array, int index)
	{
		float [] temp;
		if(index*4/3 > array.length)
		{
			temp = array;
			array = new float[2*array.length];
			for(int i = 0; i < temp.length; i++)
				array[i] = temp[i];
		}
		return array;
	}
	//扩容函数——int数组
	static int[] enlarge_int(int [] array, int index)
	{
		int [] temp;
		if(index*4/3 > array.length)
		{
			temp = array;
			array = new int[2*array.length];
			for(int i = 0; i < temp.length; i++)
				array[i] = temp[i];
		}
		return array;
	}
	
	//"config_ondraw.txt"
	public static void read2vFromSDcard_value(String filename, float value[],int count){
		int length;
		String str;
		String str_arr[];
		try {			
			File file = new File(Environment.getExternalStorageDirectory(),filename);
			FileInputStream read = new FileInputStream(file);   
			length = read.available();
			byte [] buffer = new byte[length];
			read.read(buffer); 
			str = EncodingUtils.getString(buffer, "UTF-8");   
			str_arr = str.split("\r\n");
			for(int i=0; i < count; i++)
				if(str_arr[i] != null)
			    	value[i] = Float.parseFloat(str_arr[i]);
			
		    System.out.println("read成功");  	
		    read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Boolean removefile(String filename)
	{
		File file = new File(Environment.getExternalStorageDirectory(),filename);
        if (file.isFile() && file.exists()) {
        return file.delete();
        }
        return false;
	}
	//截取小数的小数点后n位
	public static float cut_decimal(float data, int n)
	{ 
		if(n < 0)
			return -1;
		for(int i = 0; i < n; i++)
			data = data * 10;
		data = (int)(data);
		for(int i = 0; i < n; i++)
			data = data / 10;
		return data;
	}
}