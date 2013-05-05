package util;
//测试中文比较

import java.util.Vector;

public class compareCh {
	public static void main(String[] args){
		Vector<String> a=new Vector<String>();
		a.add("刘洋");
		a.add("冯瑞陶");
		a.add("刘小洋");
		a.add("冯让他");
		a.add("冯岁套");
		a.add("冯啊他");
		
		for(int i=0;i<a.size();i++){
			for(int j=0;j<a.size()-1;j++){
				if(a.elementAt(j).compareTo(a.elementAt(j+1))>0){
					String temp=a.set(j+1, a.elementAt(j));
					a.set(j, temp);
				}
			}
		}
		for(int b=0;b<a.size();b++){
			System.out.println(a.elementAt(b)+" ");
		}
	}
}
