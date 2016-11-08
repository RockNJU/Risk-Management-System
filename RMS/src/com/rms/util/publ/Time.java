package com.rms.util.publ;

import java.util.Calendar;

public class Time {
	 int year=0;
	 int month=0;
	 int day=0;
	public Time(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH)+1;
		day = c.get(Calendar.DATE);
		//System.out.println("打印时间："+"  year:"+year+"  month:"+month+"  date:"+date);
	}
	

	public  int getYear() {
		return year;
	}

	public  int getMonth() {
		return month;
	}

	public  int getDate() {
		return day;
	}
	
	private boolean isLeap(){
		/*判断是否是闰年*/
		if(year%4==0||(year%100==0&&year%4!=0)){
			return true;
		}
		return false;
	}
	
	public String getYMD(){
		String y=String.format("%2d",year).replace(" ", "0");
		String m=String.format("%2d",month).replace(" ", "0");
		String d=String.format("%2d",day).replace(" ", "0");
		return (y+"-"+m+"-"+d);
	}
	
	public String getbeforeNYMD(int n){
		/*获取当前日期的前n天的日期*/
		int mm=month;
		int dd=day;
		int yy=year;
		if(day>n){
			dd=day-n;
		}else{
			switch(month){
			case 5:
			case 7:
			case 12:
			case 10:
				{
					mm=month-1;
					dd=30+day-n;
					break;
				}
			case 8:
			case 2:
				{
					mm=month-1;
					dd=30+day-n;
					break;
				}
			case 3:
				{
					if(isLeap()){
						mm=month-1;
						dd=29+day-n;
						break;
					}else{
						mm=month-1;
						dd=28+day-n;
						break;
					}
				}
			case 4:
			case 6:
			case 9:
			case 11:
				{
					mm=month-1;
					dd=31+day-n;
					break;
				}
			default:
				{
					dd=31+day-n;
					yy=yy-1;
					month=12;
					
				}
			}
		}
		
		
		
		String y=String.format("%2d",yy).replace(" ", "0");
		String m=String.format("%2d",mm).replace(" ", "0");
		String d=String.format("%2d",dd).replace(" ", "0");
		
		return (y+"-"+m+"-"+d);
	}
	
}
