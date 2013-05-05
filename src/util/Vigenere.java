package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

public class Vigenere {
	private static String keyword="whyqiue";
	
	public static void main(String[] args) throws Exception{
		VigenereCode("明文.txt",keyword,"console");
	}
	
	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public static boolean VigenereCode(String readFileName,String keyword,String writeFileName) throws IOException{
		FileReader fr=null;
		//String resultLine=null;
		
		try {
			fr=new FileReader(readFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not exist!");
			return false;
		}
		
		BufferedReader bufr=new BufferedReader(fr);
		
		String line=null;
		int k=0;//keyword
		while((line=bufr.readLine())!=null){
			line.split("\\W");
			char[] chLine=line.toCharArray();
			char[] keywords=keyword.toCharArray();
			char[] resultLine=new char[chLine.length];
			for(int i=0;i<line.length();i++){
				resultLine[i]=(char) (((int)(chLine[i]-'a')+(int)(keywords[k%keywords.length]-'a'))%26+'a');
				k++;
			}
			if(!showCodeResult(writeFileName,resultLine))
				return false;
		}
		
		
		return true;
	}
	
	public static boolean showCodeResult(String output,char[] resultLine){
		if(output.contains("console")){
			System.out.println(resultLine);
		}
		else{
			try {
				FileWriter fw=new FileWriter(output);
				BufferedWriter bufw=new BufferedWriter(fw);
				bufw.append(new String(resultLine));
				bufw.newLine();
				bufw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		
		return true;
	}
	
	public static void exper1() throws IOException
	{
		//创建一个读取流对象和文件相关联。
		FileReader fr = new FileReader("bufr.txt");
		//为了提高效率。加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数。
		BufferedReader bufr = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("bufw.txt");
		//为了提高字符写入流效率。加入了缓冲技术。
		//只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
		BufferedWriter bufw = new BufferedWriter(fw);

		String line1=null;
		String line2=null;
		String newLine=null;
		
		int lineC=0;
		while((line1=bufr.readLine())!=null)
		{
			line2=bufr.readLine();
			if(line1.length()!=line2.length()){
				System.out.println("明文密钥组不配对。。。");
			}
			char[] chLine1=line1.toCharArray();
			char[] chLine2=line2.toCharArray();
			char[] chLine3=new char[line1.length()];
			
			for(int i=0;i<line1.length();i++){
				chLine3[i]=(char) ((int)((chLine1[i]-'a')+(int)(chLine2[i]-'a'))%26+'a');
				System.out.println((int)(chLine1[i]-'a'));
				System.out.println((int)(chLine2[i]-'a'));
				System.out.println(((int)(chLine1[i]-'a')+(int)(chLine2[i]-'a'))%26+'a');
				
			}
			bufw.write(chLine3);
			bufw.newLine();
			bufw.flush();
			System.out.println("lineC"+lineC);
			lineC++;
		}


		bufr.close();
		bufw.close();
	}
	
	public static void CodeAnalysis(Vector<String> results,Vector<Vector<int[]>> coordinates,int length){
		
	}
	
	public static void decode(String codeFile,String keyword){
		
	}
}
