import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	private String firstName;
	private String lastName;
	private int EmployeeId;
	private double Salary;
   
	/* Task 3C: Add three constructors */
   public Employee()
   {
		EmployeeId = 0;
        firstName = null;
		lastName = null;
        Salary = 0;
   }
   public Employee(String lastName, String firstName )
   {
	this.firstName = firstName;
	this.lastName = lastName;
   }

	public Employee(String lastName, String firstName, int EmployeeId, double salary)
	{
		this.EmployeeId = EmployeeId;
		this.firstName = lastName;
		this.lastName = lastName;
        this.Salary = salary;
	} 
   
	/* Task 3D: Add set (mutator) and get (accessor) methods*/
	public void setfirstName(String newfirstName)
	{
		firstName = newfirstName;
	}
	public String getfirstName()
	{
		return firstName;
	}

	public void setlastName(String newlastName)
	{
		lastName = newlastName;
	}
	public String getlasName()
	{
		return lastName;
	}

	public void setEmployeeId(int newEmployeeId)
	{
		EmployeeId = newEmployeeId;
	}
	public int getemployeeID()
	{
		return EmployeeId;
	}

	public void setSalary(double newSalary)
	{
		Salary = newSalary;
	}
	public double getSalary()
	{
		return Salary;
	}

	/* Task 3F: Add toString method */
   public String toString()
   {
	String message;
	message = String.format("%s, %s \n   ID number: %d \n   Salary : %f", lastName, firstName, EmployeeId, Salary);
	return message;
   }
   
	/* Task 3G: Add equals method */
	public boolean equals(Employee object)
	{
		if (lastName == object.getlasName())
		{
			return true;
		}
		return false;
	}
   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.print("Enter Last Name      :" );
						inputString = keyboard.next();
						employees[empCount].setfirstName(inputString);
						System.out.print("Enter First Name     :" );
						inputString = keyboard.next();
						employees[empCount].setlastName(inputString);
						System.out.print("Enter Employee ID    :" );
						inputInt = keyboard.nextInt();
						employees[empCount].setEmployeeId(inputInt);
						System.out.print("Enter Employee Salary:" );
						inputDouble = keyboard.nextDouble();
						employees[empCount].setSalary(inputDouble);
   
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
