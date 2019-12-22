package com.concept.employee.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.concept.employee.bean.*;

 
@Repository
public class EmployeeDaoImpl {
 
    
    public static int addEmployee(Employee employee)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			//INSERT INTO `employee_mvc`.`USER_TAB` (`ID`, `NAME`, `USERID`, `password`, `phone`) VALUES ('501', 'ahana', 'ahana sarva', '190', '897979')
			
			con=DBHelper.getConnection();
			query = "INSERT INTO tbl_employee1(firstName,lastName,emailId)VALUES(?,?,?)";
			
			ps=con.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmailId());
			//ps.setBoolean(4, false);
			
			 result = ps.executeUpdate();
			    ps.close();
		        con.close();
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**Error** CustomerDL:addCustomer "+e.getMessage());
		}
		
	return result;
	}
    
    
	public static ArrayList<Employee> getEmployees()
	{
		ArrayList<Employee> employees=null;
		Connection con=null;
		  Statement statement =null;
		  ResultSet resultSet=null;
		  Employee employee=null;
		try
		{
			employees = new ArrayList<Employee>();
		        String sql = "SELECT * FROM  tbl_employee1 ORDER BY id DESC";
		        con=DBHelper.getConnection();
		        statement = con.createStatement();
		        resultSet = statement.executeQuery(sql);
		        while (resultSet.next()) {
		        	employee = new Employee();
		        	employee.setId(resultSet.getInt("id"));
		        	employee.setFirstName(resultSet.getString("firstName"));
		        	employee.setLastName(resultSet.getString("lastName"));
		        	employee.setEmailId(resultSet.getString("emailId"));
		      
		          
		        	employees.add(employee);
		        }
		         
		        resultSet.close();
		        statement.close();
		        con.close();
		       
			
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:getEmployees "+e.getMessage());
		}
		
	return employees;
	}
	public static Employee getEmployee(int employee_id)
	{
		Connection con=null;
		Statement statement =null;
		ResultSet resultSet=null;
		Employee employee=null;
		
		try
		{
			
			
			String sql = "SELECT * FROM tbl_employee1 WHERE id="+employee_id+"";
	        con=DBHelper.getConnection();
	        statement = con.createStatement();
	        resultSet = statement.executeQuery(sql);
	         if(resultSet.next()) {
	        	 employee = new Employee();
		        	employee.setId(resultSet.getInt("id"));
		        	employee.setFirstName(resultSet.getString("firstName"));
		        	employee.setLastName(resultSet.getString("lastName"));
		        	employee.setEmailId(resultSet.getString("emailId"));
		      
	         }
	         
	         return employee;
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:getEmployee "+e.getMessage());
		}
		
	return employee;
	}
	
	
	public static int updateEmployee(Employee employee)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "UPDATE tbl_employee1 SET firstName=?,lastName=?,emailId=? WHERE id=?";
			ps=con.prepareStatement(query);
		
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmailId());
			ps.setLong(4, employee.getId());
			
			
			 result = ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:updateEmployee "+e.getMessage());
		}
		
	return result;
	}
	
	public static int deleteEmployee(int employee_id)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "delete from tbl_employee1 where id=?";
			ps=con.prepareStatement(query);
			ps.setLong(1, employee_id);
			 result = ps.executeUpdate();
			    ps.close();
		        con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:deleteEmployee "+e.getMessage());
		}
		
	return result;
	}
	
    
}