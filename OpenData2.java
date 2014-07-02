import java.io.*;
import java.util.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;

import java.lang.*;
import java.net.URL;
import java.net.SocketTimeoutException;

//import org.json.*;

import java.util.regex.*;



public class OpenData2 {

	private  URL url = null;
	//String[] ALL_Courses_Names={"EE_Courses","SS_Courses","MS_Courses","EN_Courses","FS_Courses","LS_Courses","GE_Courses","OE_Courses"};
	String[] EE_Courses={"E2","F7","N2","P7","P9","Q1","Q3","Q5"};
	String[] SS_Courses={"D2","D4","D5","D8","U1","U2","U3","U5","U6","U7"};
	String[] MD_Courses={"I2","I3","I5","I6","I7","I8","T2","T3","T6","T7","S1","S2","S3","S4","S5","S6","S7","S8","S9"
						 ,"SA","T1","T4","T8","T9","TA","TB","TC"};
	String[] MS_Courses={"H1","H2","H3","H4","H5","R0","R1","R2","R3","R4","R5","R6","R7","R8","R9","RA","RB","RD","RZ"};
	String[] EN_Courses={"E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","F0","F1","F2","F3","F4","F5","F6","F7","F8","F9",
						 "N0","N1","N3","N4","N5","N6","N8","N9","P1","P4","P5","P6","P8","NA","NB","NC"};
	String[] FS_Courses={"C1","C2","C3","C4","F8","L1","L2","L3","L4","L7","LA","VF"};
	String[] LS_Courses={"B1","B2","B3","B5","K1","K2","K3","K4","K5"};
	String[] GE_Courses={"A1","A7","A8","A9","AG"};
	String[] OE_Courses={"A2","A3","A4","A5","A6","AA","AH","AN"};
	String[][] ALL_Courses={EE_Courses,SS_Courses,MS_Courses,EN_Courses,FS_Courses,LS_Courses,GE_Courses,OE_Courses,MD_Courses};
	
	
	
		
	OpenData2(){
		
			
			
		
	}
	public  int parse_easy(int mod_select,String str,String input)throws IOException,FileNotFoundException{

		 
			//System.out.println("輸入資料查詢中，請稍後......");
		String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		
		URL url = null;
		Document doc = null;
		Element jsElms = null;
		File fr = null;
		ListIterator <Element> iter = null;
		
		
		if(mod_select==1){
			String url_str = url_orig + str ;
			url = new URL(url_str);
			doc = Jsoup.parse(url, 3000); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();  
		}else{
			String url_file =  str +".html";
			fr = new File(url_file);
			if(!fr.exists()){
				System.out.println("本地端無此檔案，更新中");
				load_url_file(url_orig+str,str);
				
			}
			doc = Jsoup.parse(fr, null); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();
		}
		
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			
			mt = iter.next().text();
			//Iterator <Element> col = 
			if(input.equals(mt)){
				//System.out.println("找到了"+mt);
				for(int i=0;i<22;i++){
				//mt = iter.next().text();
				//if(mt.equals(str))break;
				if(iter.hasPrevious()==true){
					mt=iter.previous().text();
					if(mt.equals(str))break;}
				
				}
				
				mt = iter.next().text();
				for(int i=0;i<22;i++){
					System.out.print(mt+" ");
					if(iter.hasNext())mt = iter.next().text();
					else break;}
				
				System.out.println("");
				find = true;
				break;
			}
				
			
		}
		if(!find){
			//System.out.println("找不到與 "+mt+" 的相關資料");
			//System.out.println("-----------------");
			return 0;
		}else{
			//System.out.println("-----------------");
			return 1;
		}
			
		
	}
	public void parse_advanced(String str,String input)throws IOException,FileNotFoundException{
		
		String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		
		//URL url = null;
		Document doc = null;
		Element jsElms = null;
		File fr = null;
		ListIterator <Element> iter = null;
		
		
		
			String url_file =  str +".html";
			fr = new File(url_file);
			if(!fr.exists()){
				System.out.println("本地端無此檔案，更新中");
				load_url_file(url_orig+str,str);
				
			}
			doc = Jsoup.parse(fr, null); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();
			
			
		
		
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			
			mt = iter.next().text();
			Pattern pa1 = Pattern.compile(input);
			Matcher mt1 = pa1.matcher(mt);
			if(mt1.find()){
				//System.out.println("找到了"+mt);
				for(int i=0;i<22;i++){
				
				if(iter.hasPrevious()==true){
					mt=iter.previous().text();
					if(mt.equals(str))break;}
				
				}
				
				mt = iter.next().text();
				for(int i=0;i<22;i++){
					System.out.print(mt+" ");
					if(iter.hasNext())mt = iter.next().text();
					else break;}
				
				System.out.println("");
				find = true;
				break;
			}
				
			
		}
		if(!find){
			//System.out.println("找不到與 "+mt+" 的相關資料");
			//System.out.println("-----------------");
			//return 0;
		}else{
			//System.out.println("-----------------");
			//return 1;
		}
		
		
	}
	public void parse_multi(String str,String input)throws IOException,FileNotFoundException{
		
		String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		
		String[] input_token = input.split(":");
		int lg = input_token.length;
		//System.out.println("input_token[0]="+input_token[0]);
		//System.out.println("input_token[1]="+input_token[1]);
		
		Document doc = null;
		Element jsElms = null;
		File fr = null;
		ListIterator <Element> iter = null;
		
		
		
		
			String url_file =  str +".html";
			fr = new File(url_file);
			if(!fr.exists()){
				System.out.println("本地端無此檔案，更新中");
				load_url_file(url_orig+str,str);
				
			}
			doc = Jsoup.parse(fr, null); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();
			
			
		
		
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			
			mt = iter.next().text();
			Pattern pa1 = Pattern.compile(input_token[0]);
			Pattern pa2 = Pattern.compile(input_token[1]);
			Pattern pa3 = null;
			if(lg>=3)
				pa3 = Pattern.compile(input_token[2]);
			Matcher mt1 = pa1.matcher(mt);
			Matcher mt2 = null;
			Matcher mt3 = null;
			boolean if_mt2=false;
			boolean if_mt3=false;
			if(mt1.find()){
				
						for(int i=0;i<22;i++){
						
						if(iter.hasPrevious()==true){//回到頂端
							mt=iter.previous().text();
							if(mt.equals(str))break;}
						
						}
						
						
						for(int i=0;i<22;i++){
							
							
							if(iter.hasNext()){
								mt = iter.next().text();
								mt2 = pa2.matcher(mt);
								if(lg>=3)
								mt3 = pa3.matcher(mt);
								if(mt2.find())if_mt2 = true;
								if((lg>=3) && mt3.find())if_mt3 = true;
								
							}else break;
						}
						boolean if_find = false;
						if(lg>=3)if_find = if_mt2 && if_mt3;
						else if_find = if_mt2;
						
						if(if_find){
							for(int i=0;i<22;i++){
								if(iter.hasPrevious()==true){//回到頂端
									mt=iter.previous().text();
									if(mt.equals(str))break;}
								
							}
							for(int i=0;i<22;i++){
								
								if(iter.hasNext()){
									mt = iter.next().text();
									System.out.print(mt+" ");
									
								}else break;
							}
					
						
						}
						
						
						System.out.println("");
						
						break;
			}
				
			if_mt2=false;//重要
			if_mt3=false;//重要
		}//while iter next
		
		
		
	}
	public void easy_finder(int mod_select){

		print_mod_select(1);
		
		try{
				while(true)	{
					System.out.print("你的選擇是(例如:ALL或EE) :");
					Scanner sc = new Scanner(System.in);
					String opt = sc.next();
					
					String tea = null;
					
					if(opt.equals("EXIT"))break;
					else if(opt.equals("SS")){
						print_example_and_select("SS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:SS_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
					}else if(opt.equals("MD")){
						print_example_and_select("MD");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MD_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("MS")){
						print_example_and_select("MS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MS_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("EN")){
						print_example_and_select("EN");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EN_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("FS")){
						print_example_and_select("FS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:FS_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("LS")){
						print_example_and_select("LS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:LS_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("GE")){
						print_example_and_select("GE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:GE_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("OE")){
						print_example_and_select("OE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:OE_Courses){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("ALL")){
						print_example_and_select("ALL");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String[] CLG:ALL_Courses)
						for(String str:CLG){
						
						parse_easy(mod_select,str,tea);
						}
						System.out.println("搜索結束");
						
					}else{
						print_example_and_select("EE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EE_Courses){
						;
						parse_easy(mod_select,str,tea);
						//System.out.println(url_add+" "+tea);
						}	
						System.out.println("搜索結束");
						
					}
				}//while
		
		}catch(java.net.SocketTimeoutException e){System.out.println("連線逾時");}
		catch(FileNotFoundException e){System.out.println("系統找不到檔案讀取");}
		catch(IOException e){e.printStackTrace();}
		
	}

	public void advanced_finder(){
		
		
		print_mod_select(2);
		
		try{
				while(true)	{
					System.out.print("你的選擇是(例如:ALL或EE) :");
					Scanner sc = new Scanner(System.in);
					String opt = sc.next();
					
					String tea = null;
					
					if(opt.equals("EXIT"))break;
					else if(opt.equals("SS")){
						print_example_and_select_adv("SS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:SS_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
					}else if(opt.equals("MD")){
						print_example_and_select_adv("MD");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MD_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("MS")){
						print_example_and_select_adv("MS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MS_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("EN")){
						print_example_and_select_adv("EN");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EN_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("FS")){
						print_example_and_select_adv("FS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:FS_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("LS")){
						print_example_and_select_adv("LS");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:LS_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("GE")){
						print_example_and_select_adv("GE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:GE_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("OE")){
						print_example_and_select_adv("OE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:OE_Courses){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("ALL")){
						print_example_and_select_adv("ALL");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String[] CLG:ALL_Courses)
						for(String str:CLG){
						
						parse_advanced(str,tea);
						}
						System.out.println("搜索結束");
						
					}else{
						print_example_and_select_adv("EE");
						tea = sc.next();
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EE_Courses){
						;
						parse_advanced(str,tea);
						//System.out.println(url_add+" "+tea);
						}	
						System.out.println("搜索結束");
						
					}
				}//while
		
		}catch(java.net.SocketTimeoutException e){System.out.println("連線逾時");}
		catch(FileNotFoundException e){System.out.println("系統找不到檔案讀取");}
		catch(IOException e){e.printStackTrace();}
	}
	public void multi_finder(int amt){
		print_mod_select(2);
		
		try{
				while(true)	{
					System.out.print("你的選擇是(例如:ALL或EE) :");
					Scanner sc = new Scanner(System.in);
					String opt = sc.next();
					
					
					String sttr,sttr1,sttr2,sttr3;
					
					if(opt.equals("EXIT"))break;
					else if(opt.equals("SS")){
						print_example_and_select_multi("SS");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:SS_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
					}else if(opt.equals("MD")){
						print_example_and_select_multi("MD");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MD_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("MS")){
						print_example_and_select_multi("MS");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:MS_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("EN")){
						print_example_and_select_multi("EN");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EN_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("FS")){
						print_example_and_select_multi("FS");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:FS_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("LS")){
						print_example_and_select_multi("LS");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:LS_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("GE")){
						print_example_and_select_multi("GE");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:GE_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("OE")){
						print_example_and_select_multi("OE");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:OE_Courses){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else if(opt.equals("ALL")){
						print_example_and_select_multi("ALL");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String[] CLG:ALL_Courses)
						for(String str:CLG){
						
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}else{
						print_example_and_select_multi("EE");
						System.out.println("請輸入第一個關鍵字 :");
						sttr1 = sc.next();
						if(amt==2){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							sttr = sttr1+":"+sttr2;
						}else if(amt==3){
							System.out.println("請輸入第二個關鍵字 :");
							sttr2 = sc.next();
							System.out.println("請輸入第三個關鍵字 :");
							sttr3 = sc.next();
							sttr = sttr1+":"+sttr2+":"+sttr3;
						}else{
							sttr = sttr1;
						}
						System.out.println("輸入資料查詢中，請稍後......");
						for(String str:EE_Courses){
						//System.out.println("sttr "+sttr);
						parse_multi(str,sttr);
						}
						System.out.println("搜索結束");
						
					}
				}//while
		
		}catch(java.net.SocketTimeoutException e){System.out.println("連線逾時");}
		catch(FileNotFoundException e){System.out.println("系統找不到檔案讀取");}
		catch(IOException e){e.printStackTrace();}
		
	}
	public void all_url_load(){
		 String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		 for(String[] CLG:ALL_Courses)
			 for(String str:CLG){
				 String url_add = url_orig + str;
				 load_url_file(url_add,str);
			 }
		 System.out.println("Done all file已更新全部本地端資料");
	 }
	 public void load_url_file(String inp,String sv){
		 
		 
			 try{
			 //String inp ="http://140.116.165.74/qry/qry001.php?dept_no=F7";
			 //String sv = "F7.html";
				 sv = sv +".html";
			 URL src = new URL(inp);
			 BufferedInputStream br = new BufferedInputStream(src.openStream());
			 byte[] b = new byte[1024];
			 FileOutputStream fs = new FileOutputStream(sv);
			 int len;
			 while((len=br.read(b,0,b.length))!=-1){
				 fs.write(b);
			 }
			 br.close();
			 fs.close();
			 }catch(IOException e){e.printStackTrace();}
			 System.out.println(sv+" Done");
	 }
	 public void print_mod_select(int opt){
		
			if(opt==2)
			System.out.println("**************************************");
		 	System.out.println("請輸入你要找的學院(預設是EE)");
			System.out.println("EE 表示 電機資訊學院  |  SS 表示 社會科學學院");
			System.out.println("MD 表示 醫學院        |  MS 表示 管理學院    ");
			System.out.println("EN 表示 工學院        |  FS 表示 理學院      ");
			System.out.println("LS 表示 文學院        |  GE 表示 通識課程    ");
			System.out.println("OE 表示 其他課程      |  ALL 表示 全部搜尋   ");
			System.out.println("EXIT --------------------->>>>>>>>>>離開     ");
			if(opt==2)
				System.out.println("**************************************");
	 }
	 public void print_example_and_select(String str){
			System.out.println(str+	"模式");
			System.out.println("請輸入你要查詢的課程資訊(如:教授、課程代碼、屬性碼):");
			System.out.println("範例:羅光耀or E215810 or CSIE1001 ");
	 }
	 public void print_example_and_select_adv(String str){
		    System.out.println("--------------進階搜尋(關鍵字)-------------------------");
		 	System.out.println(str+	"模式");
			System.out.println("請輸入課程資訊的關鍵字:");
			System.out.println("範例:羅光 or 張燕 or E21 or CSIE1001 or 理化大樓二樓 or 普物");
	 }
	 public void print_example_and_select_multi(String str){
		    System.out.println("--------------多欄位搜尋(關鍵字)-------------------------");
		 	System.out.println(str+	"模式");
			System.out.println("請輸入課程資訊的多個關鍵字:");
			System.out.println("範例:胡敏君:必修  or 蘇銓清/工程數學  or 生物統計學/李中一 /醫學院 ");
	 }
	 public static void main(String args[])throws IOException {
			
			OpenData2 op = new OpenData2();
			//String str1 = "http://140.116.165.74/qry/qry001.php?dept_no=F7";
			//System.out.println("請輸入你要查詢的課程老師名稱:");
			//op.all_url_load();
			Scanner sc = new Scanner (System.in);
			int select_mod = 2;
			
				System.out.println("選1-直接在網路上parse 選2-使用本地端資料  ");
				select_mod = sc.nextInt();
				if(select_mod==1)op.easy_finder(1);
				else if(select_mod==2){
					System.out.println("是否要更新本地端資料  ");
					System.out.println("選1-是  選2-否  ");
					int s = sc.nextInt();
					if(s==1)op.all_url_load();
					System.out.println("選擇簡單查詢 或 進階查詢");
					System.out.println("選1-簡單 選2-進階 ");
					int r = sc.nextInt();
					if(r==1)op.easy_finder(2);
					else if(r==2){ 
						System.out.println("請選擇單一欄位關鍵字 或 多欄位關鍵字");
						System.out.println("選1 單欄位 選2 雙欄位 選3 三欄位(預設單欄位)");
						int z = sc.nextInt();
						if(z==2)op.multi_finder(2);
						else if(z==3)op.multi_finder(3);
						else op.advanced_finder();}
					
				}
			
			
		}

	 
}

