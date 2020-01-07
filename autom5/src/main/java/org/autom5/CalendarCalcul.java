package org.autom5;

import java.util.Calendar;

public class CalendarCalcul {


		static int targetDay = 0;
		static int targetMonth = 0;
		static int targetYear = 0;
		static int currentDay = 0;
		static int currentMonth = 0;
		static int currentYear = 0;
		int nbjoursavantdebut;
		int nbjoursavantecheance;
		String currentdatemonthandyear;
	
		//public void main(String[] args) throws InterruptedException {


		public String getCurrentDateMonthAndYear() {
			System.out.println(currentDay+"   "+currentMonth+"   "+currentYear);
			System.out.println(targetDay+"   "+targetMonth+"   "+targetYear);				
			Calendar cal = Calendar.getInstance();
			currentDay = cal.get(Calendar.DAY_OF_MONTH);
			currentMonth = cal.get(Calendar.MONTH)+1;
			currentYear = cal.get(Calendar.YEAR);
			String currentdatemonthandyear= currentDay+"/"+currentMonth+"/"+currentYear;
			return (currentdatemonthandyear);
		}

		public static String getTargetDateMonthAndYear_debutprojet(int nbjoursavantdebut) {
			targetDay = currentDay + nbjoursavantdebut;
			targetMonth = currentMonth;
			targetYear = currentYear;
			//String targetdatedebut=targetDay+"/"+targetMonth+"/"+targetYear;
			String targetdatedebut=targetDay+"/"+targetMonth+"/"+targetYear;
			System.out.println(targetdatedebut);
			return (targetdatedebut);
		}

		public static String getTargetDateMonthAndYear_echeanceprojet(int nbjoursavantecheance){
			targetDay = currentDay + nbjoursavantecheance;
			targetMonth = currentMonth;
			targetYear = currentYear;
			String targetdateecheance=targetDay+"/"+targetMonth+"/"+targetYear;
			System.out.println(targetDay+"/"+targetMonth+"/"+targetYear);
			return (targetdateecheance);
		}
	
}
	

