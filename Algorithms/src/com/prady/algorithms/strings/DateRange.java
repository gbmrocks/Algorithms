package com.prady.algorithms.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DateRange {
    
    private static SimpleDateFormat sdf;
    private static List<String> inputList;
    private static TreeMap<Date, TreeMap> logs;
    private static StringBuffer buffer;
    private static Scanner scanner;
    private static String[] dateRange;
    private static Date startDate;
    private static Date endDate;
        
    public static void main(String args[] ) throws Exception {
        
        sdf         = new SimpleDateFormat("yyyy-MM");
        inputList   = new ArrayList<String>();
        logs        = new TreeMap<Date, TreeMap>(Collections.reverseOrder());
        buffer      = new StringBuffer();
        scanner     = new Scanner(System.in);
        dateRange   = scanner.nextLine().split(",");
        
        scanner.nextLine();         // Skipping the second line

        while(scanner.hasNextLine()){
            inputList.add(scanner.nextLine().trim());
        }        
        scanner.close();
        
        if(dateRange.length!=2)
            return;
        
        try{
            startDate  = sdf.parse(dateRange[0]);
            endDate    = sdf.parse(dateRange[1]);
            
            for(String input: inputList){
                buffer.delete(0, buffer.length());
                String[] dataArray  = input.split(",");
                Date date           = sdf.parse(dataArray[0]);
                if(!date.before(startDate) && date.before(endDate)){
                    TreeMap<String, Integer> engagementMap;
                    String engagement   = dataArray[1];
                    int occurance       = Integer.valueOf(dataArray[2].trim());
                    if(logs.containsKey(date)){
                        engagementMap   = logs.get(date);
                        if(engagementMap.containsKey(engagement)){
                           occurance    += engagementMap.get(dataArray[1]);
                        }
                    }else{
                        engagementMap   = new TreeMap<String, Integer>(); 
                    }
                    engagementMap.put(engagement, occurance);
                    logs.put(date, engagementMap);
                }
            }
        }catch(ParseException ex){
            System.out.println("Exception occured while parsing. Error Message: " + ex.getMessage());
        }
        
        for(Date date:logs.keySet()){
            System.out.print(sdf.format(date));
            TreeMap<String, Integer> engsMap = logs.get(date);
            for(String engagement: engsMap.keySet()){
                System.out.print("," + engagement + ", " + engsMap.get(engagement));
            }
            System.out.println("");
        }
    }
}


/*package com.prady.algorithms.strings;

import java.text.*;
import java.util.*;

public class DateRange {
	private static SimpleDateFormat sdf;
    private static List<String> inputList;
    private static TreeMap<Date, TreeMap> logs;
    private static StringBuffer buffer;
//    private static Scanner scanner;
    private static String[] dateRange;
    private static Date startDate;
    private static Date endDate;
    
    class EngagementData{
        String engagement;
        int occurance;
        
        public EngagementData(String engagement, int occurance){
            this.engagement = engagement;
            this.occurance  = occurance;
        }
        
        public void setOccurance(int occurance){
            this.occurance  = occurance;
        }
        
        public int getOccurance(){
            return occurance;
        }
        
        public String showData(){
            return engagement + ", " + occurance;
        }
    }
    
    public static void main(String args[] ) throws Exception {
    	dateRange = "2015-08, 2016-06".split(",");
		
		String[] inputArr = {"2015-08-15, clicks, 635", 
				"2016-03-24, app_installs, 683", 
				"2015-04-05, favorites, 763", 
				"2016-01-22, favorites, 788",
				"2015-12-26, clicks, 525",
				"2016-06-03, retweets, 101",
				"2015-12-02, app_installs, 982",
				"2016-09-17, app_installs, 770",
				"2015-11-07, impressions, 245",
				"2016-10-16, impressions, 567",
				"2016-06-03, retweets, 101",};
        sdf         = new SimpleDateFormat("yyyy-MM");
        inputList   = new ArrayList<String>();
        logs        = new TreeMap<Date, TreeMap>(Collections.reverseOrder());
        buffer      = new StringBuffer();
//        scanner     = new Scanner(System.in);
//        dateRange   = scanner.nextLine().split(",");
        
//        scanner.nextLine();         // Skipping the second line

        for(String str : inputArr){
            inputList.add(str);
        }        
//        scanner.close();
        
        if(dateRange.length!=2)
            return;
        
        try{
            startDate  = sdf.parse(dateRange[0]);
            endDate    = sdf.parse(dateRange[1]);
            
            for(String input: inputList){
                buffer.delete(0, buffer.length());
                String[] dataArray  = input.split(",");
                Date date           = sdf.parse(dataArray[0]);
                if(!date.before(startDate) && !date.after(endDate)){
                    TreeMap<String, Integer> engagementMap;
                    String engagement   = dataArray[1];
                    int occurance      = Integer.valueOf(dataArray[2].trim());
                    if(logs.containsKey(date)){
                        engagementMap   = logs.get(date);
                        if(engagementMap.containsKey(engagement)){
                           occurance    += engagementMap.get(dataArray[1]);
                        }
                    }else{
                        engagementMap   = new TreeMap<String, Integer>(); 
                    }
                    engagementMap.put(engagement, occurance);
                    logs.put(date, engagementMap);
                }
            }
        }catch(ParseException ex){
            System.out.println("Exception occured while parsing. Error Message: " + ex.getMessage());
        }
        
        for(Date date:logs.keySet()){
            System.out.print(sdf.format(date));
            TreeMap<String, Integer> engsMap = logs.get(date);
            for(String engagement: engsMap.keySet()){
                System.out.print(" " + engagement + ", " + engsMap.get(engagement));
            }
            System.out.println("");
        }
    }
    
    
	class EngagementData{
		String engagement;
		int occurance;
		
		public EngagementData(String engagement, int occurance){
			this.engagement = engagement;
			this.occurance	= occurance;
		}
		
		public void setOccurance(int occurance){
			this.occurance = occurance;
		}
		
		public int getOccurance(){
			return occurance;
		}
		
		public String showData(){
			return engagement +", " + occurance;
		}
	}
	
	public static void main(String[] args) {
		
		TreeMap<Date, String> logs = new TreeMap<Date, String>(Collections.reverseOrder());
		String[] range = "2015-08, 2016-04".split(",");
		
		String[] inputArr = {"2015-08-15, clicks, 635", 
				"2016-03-24, app_installs, 683", 
				"2015-04-05, favorites, 763", 
				"2016-01-22, favorites, 788",
				"2015-12-26, clicks, 525",
				"2016-06-03, retweets, 101",
				"2015-12-02, app_installs, 982",
				"2016-09-17, app_installs, 770",
				"2015-11-07, impressions, 245",
				"2016-10-16, impressions, 567"};

		SimpleDateFormat sdf 	= new SimpleDateFormat("yyyy-MM");
		try{
			Date startDate 			= sdf.parse(range[0]);
			Date endDate			= sdf.parse(range[1]);
			StringBuffer strbf 		= new StringBuffer();
			
			for(String input:inputArr){
				String[] arr = input.split(",");
				Date date = sdf.parse(arr[0]);
				if(!date.before(startDate) && !date.after(endDate)){
					if(!logs.containsKey(sdf.parse(arr[0])))
						logs.put(date, arr[1]);
					else{
						strbf.delete(0, strbf.length());
						strbf.append(logs.get(sdf.parse(arr[0])));
						strbf.append(","+arr[1]);
						logs.put(date, strbf.toString());
					}
				}
			}
			for(Date date: logs.keySet()){
				System.out.println(sdf.format(date)+"," + logs.get(date));
			}
		}catch(ParseException ex){
			ex.getMessage();
		}
		

	}
	
	
//	2015-08, 2016-04
//
//	2015-08-15, clicks, 635
//	2016-03-24, app_installs, 683
//	2015-04-05, favorites, 763
//	2016-01-22, favorites, 788
//	2015-12-26, clicks, 525
//	2016-06-03, retweets, 101
//	2015-12-02, app_installs, 982
//	2016-09-17, app_installs, 770
//	2015-11-07, impressions, 245
//	2016-10-16, impressions, 567
}
*/