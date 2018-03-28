import java.util.*;
import java.io.*;

public class Payroll
{
    ArrayList <Employee> personnel;
    Scanner kb = new Scanner(System.in);
    
    File dataFile;
    
    public Payroll (File dataFile) throws IOException
    {
        this.personnel = new ArrayList <Employee> ();
        this.dataFile = dataFile;
        loadData();
    }
    
    // processing methods
    
    // adding an employee (Option A)
    public void addEmp()
    {
        Employee e;
        String nbr;
        
        System.out.println("Please enter the employee number you wish to add: ");
        nbr = kb.nextLine();
        
        e = validateNum(nbr);
        if (e != null)
        {
            System.out.println("That employee number is already in the payroll.  Cannot add employee");
        }
        else
        {
            e = readData(nbr);
            personnel.add(e); 
            System.out.println ("Employee " + nbr + " added to the Payroll");
        }
    }
    
    // printing individual employee info (Option I)
    public void printInfo()
    {
        Employee e;
        String nbr;
        
        System.out.println ("Please enter the employee number ");
        nbr = kb.nextLine();
        
        e = validateNum(nbr);
        if (e != null)
        {
            System.out.println (e.toString());
        }
        else
        {
            System.out.println("Employee does not exist in the payroll");
        }
    }
    
    // removing an employee (Option D)
    public void remove()
    {
        Employee e;
        String nbr;
        char ans;
        
        System.out.println ("Please enter the employee number to be removed ");
        nbr = kb.nextLine();
        
        e = validateNum(nbr);
        if (e != null)
        {
            System.out.println ("Do you really want to remove " + e.getEmpName() + " with number " + e.getEmpNum() + " Y or N?");
            ans = kb.nextLine().charAt(0);
            if (ans == 'Y')
            {
                personnel.remove(e);
                System.out.println ("Employee " + nbr + " removed from Payroll");
            }
            else
            {
                System.out.println ("You answered 'N'. " + e.getEmpName() + " will not be removed.");
            }
        }
        else
        {
            System.out.println("Employee does not exist in the payroll.  None removed");
        }
        
    }
    
    // prints the weekly salary of a particular employee (Option S)
    public void printWklySal()
    {
        Employee e;
        String nbr;
        
        System.out.println ("Please enter the employee number ");
        nbr = kb.nextLine();
        
        e = validateNum(nbr);
        if (e != null)
        {
            System.out.println ("The weekly salary of " + e.getEmpName() + " is " + e.calcWeeklySalary());
        }
        else
        {
            System.out.println("Employee does not exist in the payroll");
        }
    }
    

    public void printTopSellers(int topCount)
    {
        
    		List<CommissionedEmployee> topSellers = new ArrayList<>();
    		
    		
    		
    		for (Employee e : personnel) {
        		if (e instanceof CommissionedEmployee) {
        			topSellers.add((CommissionedEmployee) e);
        		}
        }
        
         
        for (int i = 0; i < topCount && i < topSellers.size(); i++) {
        		System.out.println(topSellers.get(i).getEmpName());
        		System.out.println();
        }
        
        
        
    }
    
    
    // prints the weekly salary report
    public void salaryRpt()
    {
        for (Employee e : personnel) {
            System.out.println (e.getEmpName() + "\t" + e.getEmpNum() + "\t" + e.getClass() + "\t" + e.calcWeeklySalary());
        }
    }
   
    // end of week (Option W) (for now now writing to file)
    public void endOfWeek() throws IOException
    {
        for (Employee e : personnel)
        {
            if (e instanceof HourlyEmployee) {
            		HourlyEmployee he = (HourlyEmployee) e;
                    he.resetHoursWorked();
                    he.addWeekWorked();
            }
            if (e instanceof CommissionedEmployee) {
            		CommissionedEmployee ce = (CommissionedEmployee) e;
            		ce.addWeekWorked();
            		ce.updateAndResetSales();
            }
        }
    }
    
    // helper methods
    // validate employee number
    public Employee validateNum(String num)
    {
        Employee emp = null;
        boolean found = false; 
        int i = 0;
        
        while (i < personnel.size() && !found)
        {
            if (personnel.get(i).getEmpNum().equals(num))
            {
                emp = personnel.get(i);
                found = true;
            }
            i++;
        }
        return emp;
    }
    
    
    // reading data of employee from keyboard
    public Employee readData(String n1)
    {
        Employee e1 = null;
        String name;
        String dept;
        char type;    
                
        System.out.println ("Please enter the employee type: S, H, or C");
        type = kb.nextLine().charAt(0); 
        
        if (type == 'S' || type == 'H' || type == 'C') 
        {
            System.out.println ("Please enter the name of the employee");
            name = kb.nextLine();
            System.out.println ("Please enter the department of " + name);
            dept = kb.nextLine();
            
            switch (type)
            {
                case 'S':
                    System.out.println ("Please enter the yearly salary of " + name);
                    double sal = kb.nextDouble();
                    e1 = new SalariedEmployee (name, n1, dept, sal);
                    break;
                case 'H':
                    System.out.println("Please enter the hourly rate of " + name);
                    double rate = kb.nextDouble();
                    System.out.println("Please enter the number of hours worked by " + name + " this week");
                    double hrs = kb.nextDouble();
                    System.out.println("Please enter the number of weeks worked by " + name + ".");
                    int weeks = kb.nextInt();
                    e1 = new HourlyEmployee(name, n1, dept, rate, hrs, weeks);
                    break;
                case 'C':
                    System.out.println ("Please enter the number of weeks " + name + " has been working");
                    int wks = kb.nextInt();
                    System.out.println ("Please enter the base salary of " + name);
                    double base = kb.nextDouble();
                    System.out.println ("Please enter this week's sales for " + name);
                    double w_sales = kb.nextDouble();
                    System.out.println ("Please enter the year to date sales for " + name);
                    double y_sales = kb.nextDouble();
                    System.out.println("Please enter the commission rate of " + name);
                    double comm = kb.nextDouble();
                    e1 = new CommissionedEmployee(name, n1, dept, wks, base, w_sales, y_sales, comm);
                    break;                
            }
            kb.nextLine();
        }
        return e1;
    }
    
    // prints info about all employees
    public void printAll()
    {
        for (Employee e: personnel)
        {
            
            
            System.out.println (e);
            System.out.println();
            
        }
    }
    
    //prints all employee numbers
    public void printAllNum()
    {
        int i = 0;
        while (i < personnel.size())
        {
            Employee e;
            e = personnel.get(i);
            System.out.println (e.getEmpNum());
            i++;
        }
    }
    
    // loads data from file
    public void loadData() throws IOException
    {
        
        Scanner in = new Scanner (dataFile);
        
        
        
        System.out.println("Reading data from: " + dataFile.getName());
        while(in.hasNextLine())
        {
        		Employee e;
        		String line = in.nextLine();
        		String[] data = line.split(",");
        		
        		
            String name = data[0].trim();
            String number = data[1].trim();
            String department = data[2].trim();
            String type = data[3].trim();
            
            switch(type)
            {
                case "H":
                    double rate = Double.parseDouble(data[4].trim());
                    double hours = Double.parseDouble(data[5].trim()); 
                    int weeks = Integer.parseInt(data[6].trim());
                    e = new HourlyEmployee(name, number, department, rate, hours, weeks);
                    System.out.println("Adding Employee " + e.getEmpName()); 
                    personnel.add(e);
                    break;
                case "S":
                    double salary = Double.parseDouble(data[4].trim());
                    e = new SalariedEmployee(name, number, department, salary);
                    System.out.println("Adding Employee " + e.getEmpName());
                    personnel.add(e);
                    break;
                case "C":
                    double basePay = Double.parseDouble(data[4].trim());
                    double weeklySales = Double.parseDouble(data[5].trim());
                    double yearlySales = Double.parseDouble(data[6].trim());
                    double commissionRate = Double.parseDouble(data[7].trim());
                    weeks = Integer.parseInt(data[8].trim());
                    e = new CommissionedEmployee(name, number, department, weeks, basePay, weeklySales, yearlySales, commissionRate);
                    System.out.println("Adding Employee " + e.getEmpName());
                    personnel.add(e);
                    break;
                default:
                    System.out.println(type + " is not a valid type");
            }
            
        }
        in.close();
        System.out.println("Data Read");
        

    }
   
    
    // writing data to file
    public void writeToFile() throws IOException
    {
        PrintWriter output;
        
        
        output = new PrintWriter(dataFile);

        for (Employee e: personnel)
        {
            output.println(e.getSaveString());
        }
        output.close();
    }

	public void update() {
		
        
        
        System.out.println ("Please enter the name of the employee");
        String id = kb.nextLine();
        
        Employee e = validateNum(id);
    
        if (e instanceof HourlyEmployee) {
        		HourlyEmployee he = (HourlyEmployee) e;
        		System.out.println("Please enter the number of hours worked by " + e.getEmpName() + " this week");
            double hrs = kb.nextDouble();
            he.setHoursWorked(hrs);
        } if (e instanceof CommissionedEmployee) {
        		CommissionedEmployee ce = (CommissionedEmployee) e;
        		System.out.println ("Please enter this week's sales for " + e.getEmpName());
            double w_sales = kb.nextDouble();
            ce.setWklySales(w_sales);
        }
         
        kb.nextLine();
  
		
	}
    
}
