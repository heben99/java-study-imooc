package immoc.beginner.season3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

	private int id;
	private String name;

	public Student(int _id, String _name) {
		id = _id;
		name = _name;
	}

	public void display() {

	}

	public static void display(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.println("id=" + student.id + ", name=" + student.name);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(500, "Andy"));
		students.add(new Student(100, "Ben"));
		students.add(new Student(300, "Jack"));
		students.add(new Student(101, "Jone"));

		System.out.println("[sorted by id]");
		Collections.sort(students);
		display(students);

		System.out.println("[sorted by name]");
		Collections.sort(students, new StudentComparatorByName());
		display(students);
	}

	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
