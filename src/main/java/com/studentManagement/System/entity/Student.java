/**
 * 
 */
package com.studentManagement.System.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Premala
 *
 */
@Entity
@Table(name="student_master")
public class Student {
	@Id
	@GeneratedValue(generator = "student",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="stud" ,initialValue = 1)
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "first_name")
	@NotNull(message = "student name must be required !!!")
	@Size(min = 2, message = "Name of the student must have 2 or more character !!!")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message="last name is required..")
	private String lastName;
	
	@NotBlank(message = "Contact number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String contactNo;
	
	@NotBlank
	@Email
	private String emailId;
	
	@NotBlank(message = "stream is required!!")
	private String stream;
	
	private Address studentAddress;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long studentId,
			@NotNull(message = "student name must be required !!!") @Size(min = 2, message = "Name of the student must have 2 or more character !!!") String firstName,
			@NotBlank(message = "last name is required..") String lastName,
			@NotBlank(message = "Contact number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String contactNo,
			@NotBlank @Email String emailId, @NotBlank(message = "stream is required!!") String stream,
			Address studentAddress) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.stream = stream;
		this.studentAddress = studentAddress;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNo=" + contactNo + ", emailId=" + emailId + ", stream=" + stream + ", studentAddress="
				+ studentAddress + "]";
	}

	
	
	
}
