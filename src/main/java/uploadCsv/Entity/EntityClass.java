package uploadCsv.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyTable")
public class EntityClass {

  @Id
  @Column(name = "id")
  private int id;
  
  @Column(name = "Name")
  private String name;
  
  @Column(name = "Age")
  private int age;
  
  @Column(name = "Date of Birth")
  private String dob;

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
  public int getAge() {
	  return age;
  }
  public void setAge(int age) {
	  this.age = age;
  }
  public String getDob() {
	  return dob;
  }
  public void setDob(String dob) {
	  this.dob = dob;
  }
  public EntityClass() {
	  super();
  }
  
  public EntityClass(int id, String name, int age, String dob) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.dob = dob;
  }
  @Override
  public String toString() {
	  return "EntityClass [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + "]";
  }
}