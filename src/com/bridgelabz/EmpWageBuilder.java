package com.bridgelabz;

public class EmpWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	public EmpWageBuilder(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth)
	{
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	public void computeWage() {
		int empHrs = 0, totalEmpHrs=0, totalWorkingDays=0;
		while (totalEmpHrs<=maxHoursPerMonth && totalWorkingDays < numOfWorkingDays)
		{
			 totalWorkingDays++;
			 int empCheck=(int) Math.floor(Math.random() * 10) %3;
			 switch (empCheck)
			 {
			 case IS_PART_TIME:
				 empHrs = 4;
				 break;
			 case IS_FULL_TIME:
				 empHrs =8;
				 break;
			default:
				empHrs =0;
				
		}
			 totalEmpHrs += empHrs;
			 System.out.println("Day: " + totalWorkingDays + " Emp Hr: " + empHrs);
    
		}
	  totalEmpWage = totalEmpHrs * empRatePerHour;
	}
	public String tosString()
	{
		return "Total emp wage for company " + company + " is :" + totalEmpWage;
	}
	public static void main(String[] args) {
	EmpWageBuilder google=new EmpWageBuilder("Google",20,4,10);

	EmpWageBuilder Tesla=new EmpWageBuilder("Tesla",10,8,30);
	google.computeWage();
	System.out.println(google);
	Tesla.computeWage();
	System.out.println(Tesla);
	}
}
