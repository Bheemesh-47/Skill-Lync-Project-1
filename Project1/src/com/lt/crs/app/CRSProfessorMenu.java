package com.lt.crs.app;

import java.util.Scanner;

import com.lt.crs.bean.Professor;

public class CRSProfessorMenu {
	 public void professor() {
		 Professor p= new Professor();
			while(true) {
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("	Welcome Professor to The CRS Application");
				System.out.println("			********");
				System.out.println("Please Key In the Selection");
				System.out.println("	1. View All Students");
				System.out.println("	2. Add Grades");
				System.out.println("	3. View Grades");
				System.out.println("	4. View Courses");
				System.out.println("	5. Exit");
				
				Scanner sc = new Scanner(System.in);
				int option2=sc.nextInt();
				if(option2==1) {
					System.out.println("Find The Attached Student Details");
					p.viewStudents();
				}else if(option2==2) {
					System.out.println("Grading Section");
					p.addGrades();
					System.out.println("************************************************************");
					System.out.println("Grades Updated successfully");
					System.out.println("************************************************************");
				}else if(option2==3){
					System.out.println("Grading Section");
					p.showGrades();
				}else if(option2==4){
					System.out.println("Course Section");
					// 1. view course 2.select course( we will update the pcourse in db)
					p.viewCourses();
					
				}else {
					break;
				} }}
}
