package fr.uvsq.M2.Datascale.GestionMedia.Model;

public class User {
	
	private String lastName ;
	private String firstName ;
	private String birthDate ;
	private String tel ;
	private String mail ;
	private String pwd ;
	
	
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName
				+ ", birthDate=" + birthDate + ", tel=" + tel + ", mail="
				+ mail + ", pwd=" + pwd + "]";
	}
	
	
	
	
	

}
