package com.bridgelabz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class EmpWageBuilder implements InterfaceEmpWage {
public int numOfCompanies = 0;
	
	private HashMap<Integer, Double> compEmpWageHashMap;
	private ArrayList<CompanyEmpWage> compEmpWageArrayList;
	
	public EmpWageBuilder()
 	{
		compEmpWageHashMap = new HashMap<>();
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
				double dailyWage = 0;
			while (totalempHrs < EmpWage.MAX_HRS_IN_MONTH && totalWorkingDays < EmpWage.NO_OF_WORKING_DAYS)
			{
				totalWorkingDays++;
				int day = totalWorkingDays;
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
				dailyWage = empHrs * EmpWage.EMP_RATE_PER_HOUR;
				totalempHrs += empHrs;
				System.out.println("Day " + day + "\tEMP HRS: " + empHrs);
				compEmpWageHashMap.put(day, dailyWage);	
			}
			for (int j = 1; j <= compEmpWageHashMap.size(); j++) {

				System.out.println("Day " + j + ", DailyWage " + compEmpWageHashMap.get(j));
			}
			int totalempWage =  totalempHrs * EmpWage.EMP_RATE_PER_HOUR;
			System.out.println("Total Employee Wage for Company " + EmpWage.Company + " is : " + totalempWage);
	}
public static void main(String[] args)
{
	int opt;
	int a=1;
	System.out.println("Welcome to Employee Wage Computation Program");
	Scanner sc = new Scanner(System.in);
	
	InterfaceEmpWage cmp = new EmpWageBuilder();
	while (a == 1)
			{
				System.out.println("Enter the choice 1-Google, 2-Microsoft, 3-Tesla, 4-exit");
				opt = sc.nextInt();
				if (opt == 1)
				{
					cmp.addComEmpWage("Google",20,20,160);
				}
				else if (opt == 2)
				{
					cmp.addComEmpWage("Microsoft",25,23,120);
				}
				else if (opt == 3)
				{
					cmp.addComEmpWage("Tesla",30,24,110);
				}
				else
				{
					System.exit(0);
				}
				cmp.computeEmpWage();
			}
}
}
