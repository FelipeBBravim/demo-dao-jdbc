package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TESTE 1: department insert ===");
		Department newDepartment = new Department(null, "Music");
		depDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TESTE 2: department update ===");
		Department department = depDao.findById(2);
		department.setName("Games");
		depDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 3: department delete ===");
		System.out.println("Enter id for delet test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TESTE 4: department findById ===");
		department = depDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TESTE 5: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		sc.close();		
	}
}
