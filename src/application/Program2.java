package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById =====");
		
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("\n==== Test 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== Test 3: department insert =====");
		Department newDepartment = new Department(null, "Sales");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== Test 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n==== Test 5: seller delete =====");
		departmentDao.deleteById(9);
		System.out.println("Delete completed!");
	}

}
