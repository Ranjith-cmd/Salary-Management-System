package SMS.SalaryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin extends Employee_login{
	 private static Connection con=null;
	 private static Scanner sc = new Scanner(System.in);
			public void login() {
				// TODO Auto-generated method stub
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/sms";
						String user="root";
						String password="ishuISHU1@";
						con=DriverManager.getConnection(url,user,password);
						System.out.println("   Enter 1)INSERT  2)SHOW 3)UPDATE 4) DELETE   ");
						int choice=sc.nextInt();
						switch(choice) {
						case 1:
							insert();
							break;
						case 2:
							show();
							break;
						case 3:
							update();
							break;
						case 4:
							delete();
							break;
						}
					  }
						  catch(Exception e) {
							 System.out.println("Invalid Exception");
							  e.printStackTrace();
						  }
					  }
				
		           	static void insert() throws SQLException {
		           		System.out.println("Enter 1)Insert in Employee_data Table 2)Insert in Employee_Salary_details Table");
		           		int ch=sc.nextInt();
		           		switch(ch) {
		           		case 1:
		           			System.out.println();
		           		 String s="insert into Employee_data values(?,?,?,?,?)";
		                 PreparedStatement pr=con.prepareStatement(s);
		                 System.out.println("Employee_id");
		                 int Employee_id=sc.nextInt();
		                 pr.setInt(1,Employee_id);
		                 System.out.println();
		                 sc.nextLine();;
		                
		                 System.out.println("Employee_Name");
		                 String Employee_Name= sc.nextLine();
		                 pr.setString(2,Employee_Name);
		                 System.out.println();
		                 
		                 System.out.println("Designation");
		                 String Designation= sc.nextLine();
		                 pr.setString(3,Designation);
		                 System.out.println();
		                 
		                 System.out.println("Gender");
		                 String Gender= sc.nextLine();
		                 pr.setString(4,Gender);
		                 System.out.println();
		                 
		                 System.out.println("City");
		                 String City= sc.nextLine();
		                 pr.setString(5,City);
		                 System.out.println();
		                 int rows=pr.executeUpdate();
		                 if(rows>0) {
		            	 System.out.println();
		            	 System.out.println("    Employee_data table is Update successfully   ");
		                 }
		                 break;
		           		case 2:
		           		 String s1="insert into Employee_Salary_details values(?,?,?,?,?,?,?,?,?,?)";
		                 PreparedStatement pr1=con.prepareStatement(s1);
		                 System.out.println();
		                 System.out.println("Employee_id");
		                 int Employee_Id=sc.nextInt();
		                 pr1.setInt(1,Employee_Id);
		                 System.out.println();
		                 sc.nextLine();
		                
		                 System.out.println("Employee_Name");
		                 String Employee_name= sc.nextLine();
		                 pr1.setString(2,Employee_name);
		                 System.out.println();
		                 
		                 System.out.println("Total_no_of_workingdays");
		                 int Total_no_of_workingdays= sc.nextInt();
		                 pr1.setInt(3,Total_no_of_workingdays);
		                 System.out.println();
		                 sc.nextLine();
		                 
		                 System.out.println("No_of_days_present");
		                 int No_of_days_present=sc.nextInt();
		                 pr1.setInt(4,No_of_days_present);
		                 System.out.println();
		                 sc.nextLine();
		                 
		                 System.out.println("Month_of_payslip");
		                 int Month_of_payslip=sc.nextInt();
		                 pr1.setInt(5,Month_of_payslip);
		                 System.out.println();
		                 sc.nextLine();
		  
		                 System.out.println("Basic_pay");
		                 int Basic_pay=sc.nextInt();
		                 pr1.setInt(6,Basic_pay);
		                 System.out.println();
		                 sc.nextLine();
		 
		                 System.out.println("HRA");
		                 int HRA=sc.nextInt();
		                 pr1.setInt(7,HRA);
		                 System.out.println();
		                 sc.nextLine();
		 
		                 System.out.println("Gross_pay");
		                 int Gross_pay=sc.nextInt();
		                 pr1.setInt(8,Gross_pay);
		                 System.out.println();
		                 sc.nextLine();
		 
		                 System.out.println("Deductions");
		                 int Deductions=sc.nextInt();
		                 pr1.setInt(9,Deductions);
		                 System.out.println();
		                 sc.nextLine();
		 
		                 System.out.println("Net_pay");
		                 int Net_pay=sc.nextInt();
		                 pr1.setInt(10,Net_pay);
		                 System.out.println();
		                 sc.nextLine();
		 
		                 int rows1=pr1.executeUpdate();
		                 if(rows1>0) {
		                	 System.out.println();
		              	   System.out.println("    Employee_Salary_details table is update successfully   ");
		                 }
		                 break;
		           		}
		           	}
		           	static void show() throws SQLException {
		           		System.out.println();
		           		System.out.println("Enter 1)Read in Employee_data Table 2)Read in Employee_Salary_details Table");
		           		int ch=sc.nextInt();	
		           		switch(ch) {
		           		case 1:
		           		 String s="select * from Employee_data";
		           	     Statement st = con.createStatement();
		           	     ResultSet rt=st.executeQuery(s);
		           	     while(rt.next()) {
		           	    	 int employee_id=rt.getInt("employee_id");
		           		     String employee_name=rt.getString("employee_name");
		           		  String Designation=rt.getString("Designation");
		           		String Gender=rt.getString("Gender");
		           		String city=rt.getString("city");
		     			  System.out.println("------------------------------------------------------------------------------");
		             		System.out.println(employee_id+"   "+employee_name+"   "+Designation+"   "+Gender+"   "+city);
		     			  System.out.println("------------------------------------------------------------------------------");

		           	     }
		           	     break;
		           		case 2:
		           		 String s1="select * from employee_salary_details";
		       		  Statement st1 = con.createStatement();
		       		  ResultSet rt1=st1.executeQuery(s1);
		       		  while(rt1.next()) {
		       			  int Employee_Id=rt1.getInt("Employee_Id");
		       			  String Employee_name=rt1.getString("Employee_name");
		       			 int Total_no_of_workingdays=rt1.getInt("Total_no_of_workingdays");
		       			 int No_of_days_present=rt1.getInt("No_of_days_present");
		       			 int Month_of_payslip=rt1.getInt("Month_of_payslip");
		       			  int Basic_pay=rt1.getInt("Basic_pay");
		       			  int HRA=rt1.getInt("HRA");
		       			  int Gross_pay=rt1.getInt("Gross_pay");
		     			  int Deductions=rt1.getInt("Deductions");
		       			  int Net_pay=rt1.getInt("Net_pay");
		       			  System.out.println("------------------------------------------------------------------------------");
		       			  System.out.println("Employee_Id ="+Employee_Id);
		       			  System.out.println("Employee_name ="+Employee_name);
		       			  System.out.println("Total_no_of_workingdays ="+Total_no_of_workingdays);
		       			  System.out.println("No_of_days_present ="+No_of_days_present);
		       		      System.out.println("Month_of_payslip ="+Month_of_payslip);
		       			  System.out.println("Basic_pay ="+Basic_pay);
		       			  System.out.println("HRA ="+HRA);
		       			System.out.println("Gross_pay ="+Gross_pay);
		       			System.out.println("Deductions ="+Deductions);
		       			  System.out.println("Net_pay ="+Net_pay);
		       			  System.out.println("------------------------------------------------------------------------------");
		       		  }
		                break;
		           		}
		           	}

		           	static void update() throws Exception {
		           		System.out.print("Enter 1)Update in Employee_data Table 2)Update in Employee_Salary_details Table");
		           		int n=sc.nextInt();
		           		switch(n) {
		           		case 1:
		           			System.out.print("Enter Employee_id you want to edit ");
		           			int emid=sc.nextInt();
		           			System.out.print("Enter column name You want to edit ");
		           			String colname=sc.next();
		           			System.out.print("Enter value You want to edit ");
		           			String colval=sc.next();
		           		String s = "UPDATE Employee_data " + "SET "+ colname+"="+"'"+colval+"'"+" WHERE Employee_id="+emid;
		           		PreparedStatement pr=con.prepareStatement(s);
		                int rows=pr.executeUpdate();
		                if(rows>0) {
		           	    System.out.println();
		           	      System.out.println("Successfully Updated");
		                }
		                break;
		           		case 2:  
		           			System.out.print("Enter Employee_id you want to edit ");
		           			int emid1=sc.nextInt();
		           			System.out.print("Enter column name You want to edit ");
		           			String colname1=sc.next();
		           			System.out.print("Enter value You want to  ");
		           			String colval1=sc.next();
		           		String s1 = "UPDATE Employee_salary_details " + "SET "+ colname1+"="+"'"+colval1+"'"+" WHERE Employee_Id="+emid1;
		           		PreparedStatement pr1=con.prepareStatement(s1);
		                int rows1=pr1.executeUpdate();
		                if(rows1>0) {
		           	    System.out.println();
		           	      System.out.println("Successfully Updated");
		                }
		                break;
		           	   }
		           	}
		           	static void delete() throws Exception {
		         		System.out.println("Delete data's in Employee_data Enter 1 or Delete data's in Employee_salary_details Enter 2");
		         		int choice=sc.nextInt();
		         		switch(choice) {
		         		case 1:
		         			System.out.println("Enter Employee_id which you want to delete");
		         			int emp=sc.nextInt();
		         			String s="Delete from Employee_data where Employee_id="+emp;
		         			  PreparedStatement pr=con.prepareStatement(s);
		         			  int col=pr.executeUpdate();
		         			  if(col>0) {
		         				  System.out.println("Deletion is completed");
		         			  }
		         			  break;
		         		case 2:
		         			System.out.println("Enter Employee_id which you want to delete");
		         			int emp1=sc.nextInt();
		         			String s1="Delete from Employee_salary_details where employee_Id="+emp1;
		         			  PreparedStatement pr1=con.prepareStatement(s1);
		         			  int col1=pr1.executeUpdate();
		         			  if(col1>0) {
		         				  System.out.println("Deletion is completed");
		         			  }
		         			  break;
		         		}
			
			}

		


}

