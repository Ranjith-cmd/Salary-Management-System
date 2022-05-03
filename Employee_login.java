package SMS.SalaryManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Employee_login{
	 private static Connection con=null;
	 private static Scanner sc = new Scanner(System.in);
   public void emp_login() {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sms";
			String user="root";
			String password="ishuISHU1@";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("To get payslip Enter 1 ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				payslip();
				break;
			}
		  }
			  catch(Exception e) {
				 System.out.println("Invalid Exception");
				  e.printStackTrace();
			  }
		  }
   public static void payslip()throws Exception {
	   System.out.println("Enter Employee_id : ");
	   int emp_id=sc.nextInt();
	   String s3="select employee_data.employee_id,employee_data.Employee_name,employee_data.Designation,Basic_pay,HRA,Gross_pay,Deductions,Net_pay from employee_salary_details join employee_data where employee_data.Employee_id="+emp_id+" and employee_salary_details.employee_Id= "+emp_id;
		  Statement st = con.createStatement();
		  ResultSet rt=st.executeQuery(s3);
		  while(rt.next()) {
			  int Employee_id=rt.getInt("Employee_id");
			  String Employee_name=rt.getString("Employee_name");
			  String Designation=rt.getString("Designation");
			  int Basic_pay=rt.getInt("Basic_pay");
			  int Gross_pay=rt.getInt("Gross_pay");
			  int Deductions=rt.getInt("Deductions");
			  int HRA=rt.getInt("HRA");
			  int Net_pay=rt.getInt("Net_pay");
			  System.out.println("------------------------------------------------------------------------------");
			  System.out.println("Employee_id   ="+Employee_id);
			  System.out.println("Employee_name ="+Employee_name);
			  System.out.println("Designation   ="+Designation);
			  System.out.println("Basic_pay     ="+Basic_pay);
			  System.out.println("Gross_pay     ="+Gross_pay);
			  System.out.println("Deductions    ="+Deductions);
			  System.out.println("HRA           ="+HRA);
			  System.out.println("Net_pay       ="+Net_pay);
			  System.out.println("------------------------------------------------------------------------------");
			  
		  }
   }
}










