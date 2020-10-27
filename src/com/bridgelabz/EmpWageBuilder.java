package com.bridgelabz;
import java.util.ArrayList;
public class EmpWageBuilder implements InterfaceEmpWage {
public int numOfCompanies = 0;
	
	private ArrayList<CompanyEmpWage> compEmpWageArrayList;
	
	public EmpWageBuilder() {	
		compEmpWageArrayList = new ArrayList<>();
	}
	@Override
	public void addComEmpWage(String company, int EMP_RATE_PER_HOUR, int NO_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH)
	{
		CompanyEmpWage CEmpWage = new CompanyEmpWage(company, EMP_RATE_PER_HOUR, NO_OF_WORKING_DAYS, MAX_HRS_IN_MONTH);
		compEmpWageArrayList.add(CEmpWage);
	}
	@Override
	public void computeEmpWage() {
		for (int i = 0; i < compEmpWageArrayList.size(); i++)
		{
			CompanyEmpWage CEmpWage = compEmpWageArrayList.get(i);
			EmployeeW(CEmpWage);
			
		}
	}
	
	private void EmployeeW(CompanyEmpWage EmpWage)
	{
				int empHrs = 0;
				int totalempHrs = 0;
				int totalWorkingDays = 0;
			while (totalempHrs < EmpWage.MAX_HRS_IN_MONTH && totalWorkingDays < EmpWage.NO_OF_WORKING_DAYS)
			{
				totalWorkingDays++;
				int empCheck = (int) (Math.floor(Math.random() * 10) % 3);
		
				switch (empCheck)
				{
				case 1:
					empHrs = 8;
					break;
				case 2:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
				}
				totalempHrs += empHrs;
				System.out.println("Day " + totalWorkingDays + "\tEMP HRS: " + empHrs);
			}	
			int totalempWage =  totalempHrs * EmpWage.EMP_RATE_PER_HOUR;
			System.out.println("Total Employee Wage for Company " + EmpWage.Company + " is : " + totalempWage);
	}
public static void main(String[] args)
{


	InterfaceEmpWage cmp = new EmpWageBuilder();
	cmp.addComEmpWage("Google",20,20,160);

	cmp.addComEmpWage("Microsoft",25,23,120);
	
	cmp.addComEmpWage("Tesla",30,24,110);
	
	cmp.computeEmpWage();
}
}
