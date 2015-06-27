package cal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculateCostMobile {

	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Cost of Promotion One (P1)");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		readFileAndPrint("d:\\promotion1.log");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Cost of Promotion Two (P2)");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		readFileAndPrint("d:\\promotion2.log");
	}
	
	public static void readFileAndPrint(String fileName) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String line;
			if(fileName.equals("d:\\promotion1.log")){
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("   Date   | S Time | E Time |  Number  | Promotion");
					System.out.println(line);
					calculateCostOfPromotionOne(line+"\n");
				}
			}else{
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("  Date  | S Time | E Time |  Number  | Promotion");
					System.out.println(line);		
					calculateCostOfPromotionTwo(line+"\n");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	public static void calculateCostOfPromotionOne(String data) {
		int count=0,s=0,e=0,HH=0,MM=0,sum=0;
		double SS=0,cost=0;
		int[] S_time = new int[3];
		int[] E_time = new int[3];
		String[] start_time = new String[3];
		String[] end_time = new String[3];
		String[] str = new String[5];
		String[] splitData = data.split("\\|");
		for (String string : splitData) {
			str[count] = string;	
			count++;
			if(count == 5){
				start_time = str[1].split("\\:");
				for(String st : start_time){
					S_time[s] = Integer.parseInt(st);
					//System.out.println("start time "+s+" is "+B_time[s]);
					s++;		
				}
				end_time = str[2].split("\\:");
				for(String et : end_time){
					E_time[e] = Integer.parseInt(et);
					//System.out.println("end time "+e+" is "+E_time[e]);
					e++;		
				}
				HH = (E_time[0] - S_time[0])*60;
				MM = (E_time[1] - S_time[1]);
				HH = Math.abs(HH);
				MM = Math.abs(MM);
				sum = HH + MM;
				System.out.println("HH = "+HH+" Minute | MM = "+MM+" Minute | sum = "+sum+" Minute");
				SS = (double)(E_time[2] - S_time[2])/60;
				SS = Math.abs(SS);
				System.out.printf("SS = %.2f Baht\n", SS);
				cost = ((sum-1)+3)+SS;
				System.out.printf("Cost is %.2f Baht\n\n", cost);
				s = 0;
				e = 0;
				HH = 0;
				MM = 0;
				SS = 0;
				cost = 0;
				count = 0;
			}
		}
	}
	
	public static void calculateCostOfPromotionTwo(String data) {
		int count=0,s=0,e=0,HH=0,MM=0,sum=0;
		double SS=0,cost=0;
		int[] S_time = new int[3];
		int[] E_time = new int[3];
		String[] start_time = new String[3];
		String[] end_time = new String[3];
		String[] str = new String[5];
		String[] splitData = data.split("\\|");
		for (String string : splitData) {
			str[count] = string;	
			count++;
			if(count == 5){
				start_time = str[1].split("\\:");
				for(String st : start_time){
					S_time[s] = Integer.parseInt(st);
					//System.out.println("start time "+s+" is "+B_time[s]);
					s++;		
				}
				end_time = str[2].split("\\:");
				for(String et : end_time){
					E_time[e] = Integer.parseInt(et);
					//System.out.println("end time "+e+" is "+E_time[e]);
					e++;		
				}
				HH = (E_time[0] - S_time[0])*60;
				MM = (E_time[1] - S_time[1]);
				HH = Math.abs(HH);
				MM = Math.abs(MM);
				sum = HH + MM;
				System.out.println("HH = "+HH+" Minute | MM = "+MM+" Minute | sum = "+sum+" Minute");
				SS = (double)((E_time[2] - S_time[2])*2)/60;
				SS = Math.abs(SS);
				System.out.printf("SS = %.2f Baht\n", SS);
				cost = ((sum*2))+SS;
				System.out.printf("Cost is %.2f Baht\n\n", cost);
				s = 0;
				e = 0;
				HH = 0;
				MM = 0;
				SS = 0;
				cost = 0;
				count = 0;
			}
		}
	}

}
