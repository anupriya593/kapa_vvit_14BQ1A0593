import java.util.*;
import java.util.Date;
import java.util.Scanner;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	Scanner sc=new Scanner(System.in);
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents(){
		return students;
			
			
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException{
		int lenght=students.length;
			for(int i=0;i<length;i++)
			{	
				int id;
				String fullname;
				String dob;
				float avg;
				id=sc.nextInt();
				fullname=sc.nextLine();
				dob=sc.nextLine();
				avg=sc.nextFloat();
				students[i]=new Student(id,fullname,new date(dob),avg);
			}
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException{
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException{
			int n=students.length;
			int length=students.length+1;
			this.StudentGroup(length);
			for(int i=0;i<length;i++)
				students[i+1]=students[i];
			students[0]=student;
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException{
		int n=students.length;
		int length=students.length+1;
		this.StudentGroup(length);
		students[length]=student;
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		int n=students.length;
		int length=students.length+1;
		for(int i=index;i<n;i++)
			students[i+1]=students[i];
		students[index]=student;
		
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		int n=students.length;
		for(int i=index;i<n;i++)
			students[i]=students[i+1];
		n=n-1;
		this.StudentGroup(n);
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException{
			int n=students.length;
			int index;
			for(int i=0;i<n;i++)
			{
				if(students[i].id=student.id)
				{
					index=i;
					break;
				}
			}
			this.remove(index);
		
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException {
		int n=students.length-index+1;
		this.StudenGroup(n);
	}

	@Override
	public void removeFromElement(Student student) throws IllegakArgumentException {
		int n=students.length;
		int index;
			for(int i=0;i<n;i++)
			{
				if(students[i].id=student.id)
				{
					index=i;
					break;
				}
			}
			this.removeFromIndex(index);
	}

	@Override
	public void removeToIndex(int index) {
		int n=students.length;
		int k=n-index+1;
		for(int i=0;i<index;i++)
			this.remove(students[i]);
		this.StudentGroup(k);
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException {
		int n=students.length;
		int index;
		for(int i=0;i<n;i++)
		{
			if(students[i].id==student.id)
			{
				index=i;
				break;
			}
		}
		this.removeToIndex(index);
		
	}

	@Override
	public void bubbleSort() {
		int i,j;
		int n=students.length;
		Student temp;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(students[i].id>students[j].id)
				{
					temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException {
			int n=students.length;
			Student date[];
			date= new Student[students.length];
			int j=0;
			for(int i=0;i<n;i++)
			{
				if(students[i].getBirthDate()==date)
				{	
					date[j]=students[i];
					j++;
				}
			}
			return date;			
		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		date=new Student[students.length];
		int n=students.length;
		int j=0;
		for(int i=0;i<n;i++)
			{
				if(students[i].getBirthDate()>=firstdate&&students[i].date<=lastdate)
				{	
					date[j]=students[i];
					j++;
				}
			}
			return date;	
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) throws ILLegalArgumentException {
		int n=students.length;
		Student p;
		p=new Student[students.length];
		int j=0;
		for(i=0;i<n;i++)
		{
			if(students[i].birthDate.getDay()>=date.getDay()&&students[i].birthDate.getDay()<=days)
			{
				p[j]=students[i];
			}
		}
		
		return p;
				
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) throws IllegalArgumentException{
		int i=students.length;
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localdate=LocalDate.now();
		Date d=new Date(dtf.format(localdate));
		int age=students[indexOfStudent].birthDate-d;
		return age;	
		
	}

	@Override
	public Student[] getStudentsByAge(int age) throws IllegalArgumentException{
		Student[] temp;
		temp=new Student[students.length];
		int j=0;
		int n=students.length;
		for(int i=0;i<n;i++)
		{
			if(this.getCurrentAgeByDate(i)==age)
			{
				temp[j]=students[i];
				j++;
			}
		}
		return temp;	
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() throws IllegalArgumentException {
		int n=students.length;
		float max=0;
		Student[] date;
		date=new Student[students.length];
		int j=0;
		for(int i=0;i<n;i++)
		{
			if(students[i].avgMark>max)
				max=students[i].avgMark;
		}
		for(int i=0;i<n;i++)
		{
			if(students[i].avgMark==max)
			{
				date[j]=students[i];
				j++;
			}
		}
		return date;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		int n=students.length;
		Student temp;
		for(int i=0;i<n;i++)
		{
			if(students[i].id==student.id)
				temp=student[i+1];
		}
		return temp;
	}
}
