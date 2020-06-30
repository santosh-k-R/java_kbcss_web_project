package com.kbcss.util;



import com.kbcss.exception.WrongTimeException;



public class ConvertTime{
	
	int hour = 0;
	String newhour=null;
	
public String  ChangeTimeFormat(int hour){
//initialize variables



//initialize the scanner
//Scanner key = new Scanner(System.in);
//ask the person to enter the data
//System.out.print("Enter time in 24-hour format: ");
//enter the data
try{
//hour =hour;

//check to see if time is out of range, throw exception

if(hour<0 || hour>23 )
throw new WrongTimeException();

//check to see if hour is less than 12


if(hour==00){
System.out.println("That is the same as: "  +"12:00" +  "AM");
newhour="12:00AM";


}if (hour!=0&&hour<12)
{
System.out.println("That is the same as: " + hour + ":00" +  "AM");
newhour=hour+":00AM";
}
//check to see if hour is equal to 12
if (hour==12)
{
System.out.println("That is the same as: " + hour + ":00" + "PM");

newhour=hour+":00PM";
}

//check to see if it is more than 12
//subtract the number from 12 in this case
if (hour>12)
{
hour=hour-12;
System.out.println("That is the same as: " + hour + ":00" + "PM");
newhour=hour+":00PM";
}

}catch(WrongTimeException e){
System.out.println(e.getMessage());
}


return newhour;
}
}
