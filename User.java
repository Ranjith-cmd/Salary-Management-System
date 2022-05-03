package SMS.SalaryManagementSystem;
import java.util.Scanner;

public class User {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		 Admin adm=new Admin();
		    System.out.println("         WELCOME TO SALARY MANAGEMENT SYSTEM       ");  	
		    System.out.print("     Please Enter 1 for ADMIN or Enter 2 for EMPLOYEE   ");
		    int choice=sc.nextInt();
		    switch(choice) {
		    case 1:
		    	//System.out.println();
		    	System.out.println("  Welcome to Admin Login please Enter your USERNAME and PASSWORD  ");
		    	System.out.println();
		    	if(credentials_for_admin()) {
		    		 adm.login();
                    break;
		    	}
		    	else {
		    		System.out.println("INVALID USERNAME AND PASSWORD");	
		    		break;
		    	}
		    case 2:
		    	//System.out.println();
		    	System.out.println("  Welcome to Employee Login please Enter your USERNAME and PASSWORD   ");
		    	System.out.println();
//		    	String user=sc.nextLine();
//		    String pass=sc.nextLine();
		    	boolean ot=credentials_for_Employee();
		    	if(ot) {
		    		adm.emp_login();
		 	    	break;
		    	}
		    	else {
		    		System.out.println("INVALID USERNAME AND PASSWORD");
		    	}
		    }
	}
	public static boolean credentials_for_admin() {
		System.out.print("Enter user_name : ");
    	String user=sc.next().toLowerCase();
    	System.out.print("Enter password : ");
    	String pass=sc.next().toLowerCase();
    	if(user.equals("admin") && pass.equals("123")) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	public static boolean credentials_for_Employee() {
	System.out.print("Enter user_name : ");
    	String user=sc.next().toLowerCase();
    	System.out.print("Enter password : ");
    	String pass=sc.next().toLowerCase();
    	if(user.equals("emp") && pass.equals("1234")) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}
}
	    
	



