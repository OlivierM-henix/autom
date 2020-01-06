package org.autom5;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestFormaterDate3 {

  public static void main(String[] args) {
    DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
    DateFormatSymbols dfsEN = new DateFormatSymbols(Locale.ENGLISH);

    String[] joursSemaineFR = dfsFR.getWeekdays();
    String[] joursSemaineEN = dfsEN.getWeekdays();

    StringBuffer texteFR = new StringBuffer("Jours FR ");
    StringBuffer texteEN = new StringBuffer("Jours EN ");

    for (int i = 1; i < joursSemaineFR.length; i++) {
      texteFR.append(" : ");
      texteFR.append(joursSemaineFR[i]);
      texteEN.append(" : ");
      texteEN.append(joursSemaineEN[i]);
    }
    System.out.println(texteFR);
    System.out.println(texteEN);

    texteFR = new StringBuffer("Mois courts FR ");
    texteEN = new StringBuffer("Mois courts EN ");
    String[] moisCourtsFR = dfsFR.getShortMonths();
    String[] moisCourtsEN = dfsEN.getShortMonths();

    for (int i = 0; i < moisCourtsFR.length - 1; i++) {
      texteFR.append(" : ");
      texteFR.append(moisCourtsFR[i]);
      texteEN.append(" : ");
      texteEN.append(moisCourtsEN[i]);
    }

    System.out.println(texteFR);
    System.out.println(texteEN);

    texteFR = new StringBuffer("Mois FR ");
    texteEN = new StringBuffer("Mois EN ");
    String[] moisFR = dfsFR.getMonths();
    String[] moisEN = dfsEN.getMonths();

    for (int i = 0; i < moisFR.length - 1; i++) {
      texteFR.append(" : ");
      texteFR.append(moisFR[i]);
      texteEN.append(" : ");
      texteEN.append(moisEN[i]);
    }

    System.out.println(texteFR);
    System.out.println(texteEN);

    
    public static void main1(String[] args) {
        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
        String[] moisCourtsFR = dfsFR.getShortMonths();
        String value1 = new SimpleDateFormat("dd M YYYY").format(date);
    System.out.println(value1);
  }

}
