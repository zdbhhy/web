package org.student.entity;

public class Student {
    int number;

    String sname;

    Byte age;

    String gender;

    String sclass;

    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSclass() {
        return sclass;
    }

    @Override
	public String toString() {
		return "Student [number=" + number + ", sname=" + sname + ", age=" + age + ", gender=" + gender + ", sclass="
				+ sclass + "]";
	}

	public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}