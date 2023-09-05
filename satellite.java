//========================================================================================
//
// Class to represent Satellite Objects
//
//========================================================================================
import java.util.*;
public class Satellite
{
   private String sat_name = null; // data members
   private String TLE_Line_1 = null;
   private String TLE_Line_2 = null;
   //-------------------------------------------------------
   // Constructor
   //
   public Satellite(String name, String line1, String line2)
   {
      sat_name = name;
      TLE_Line_1 = line1;
      TLE_Line_2 = line2;
   }
   
   //-------------------------------------------------------
   // Return catalog number as a string
   //
   public String catalog_number()
   {
      return TLE_Line_1.substring(2,7);
   }
   
   //-------------------------------------------------------
   // Return name as a string
   //
   public String name()
   {
      return sat_name;
   }
   
   //-------------------------------------------------------
   // Return 2 digit launch year as an int
   //
   public int launch_year_yy()
   {
      return Integer.valueOf(TLE_Line_1.substring(9,11));
   }
   
   //-------------------------------------------------------
   // Convert a 2 digit launch year to 4 digit
   //
   public static int year_yyyy(int yy) // method members
   {
      if(yy<58)
         return(2000+yy);
      else
         return(1900+yy);
   }
   
   //-------------------------------------------------------
   // Return 4 digit launch year (use previous 2 methods)
   //
   public int launch_year_yyyy()
   {
      return year_yyyy(launch_year_yy());
   }
   
   //----------------------------------------------------------
   // convert to string, return catalog number and name
   //
   public String toString()
   {
      return String.format("%8.2f\t%1.1f\t%1.6f\t%1s\t%1s\t%1s", inclination(), mean_motion(), eccentricity(), launch_year_yyyy(), catalog_number(), name());
   }
   
   public double mean_motion()
   {
      return Double.valueOf(TLE_Line_2.substring(52,63)); 
   }
   
   public double inclination()
   {
      return Double.valueOf(TLE_Line_2.substring(8,16));
   }
   
   public double eccentricity() // use the assumed decimal point
   {
      return Double.valueOf("."+TLE_Line_2.substring(26,33));
   }
}
