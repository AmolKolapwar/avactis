package avactis.pages.user;

import java.util.List;

import org.openqa.selenium.WebElement;

public class RegistratingMethod {
	
	private String Email;
	private String Password;
    private String Re_TypePassword;
	private String FirstName;
	private String LastName;
	 public String getEmail() {
			return Email;
		}



		public void setEmail(String email) {
			Email = email;
		}



		public String getPassword() {
			return Password;
		}



		public void setPassword(String password) {
			Password = password;
		}



		public String getRe_TypePassword() {
			return Re_TypePassword;
		}



		public void setRe_TypePassword(String re_TypePassword) {
			Re_TypePassword = re_TypePassword;
		}



		public String getFirstName() {
			return FirstName;
		}



		public void setFirstName(String firstName) {
			FirstName = firstName;
		}



		public String getLastName() {
			return LastName;
		}



		public void setLastName(String lastName) {
			LastName = lastName;
		}



		public List<WebElement> getCountry() {
			return Country;
		}



		public void setCountry(List<WebElement> country) {
			Country = country;
		}



		public List<WebElement> getState() {
			return State;
		}



		public void setState(List<WebElement> state) {
			State = state;
		}



		public WebElement getZipCode() {
			return ZipCode;
		}



		public void setZipCode(WebElement zipCode) {
			ZipCode = zipCode;
		}



		public WebElement getCity() {
			return City;
		}



		public void setCity(WebElement city) {
			City = city;
		}



		public WebElement getAddress1() {
			return Address1;
		}



		public void setAddress1(WebElement address1) {
			Address1 = address1;
		}



		public WebElement getAddress2() {
			return Address2;
		}



		public void setAddress2(WebElement address2) {
			Address2 = address2;
		}



		public WebElement getPhone() {
			return Phone;
		}



		public void setPhone(WebElement phone) {
			Phone = phone;
		}



		public WebElement getRegister_Button() {
			return Register_Button;
		}



		public void setRegister_Button(WebElement register_Button) {
			Register_Button = register_Button;
		}



		public WebElement getSign_Register_Button() {
			return Sign_Register_Button;
		}



		public void setSign_Register_Button(WebElement sign_Register_Button) {
			Sign_Register_Button = sign_Register_Button;
		}



		public WebElement getNewCustomers_Title() {
			return NewCustomers_Title;
		}



		public void setNewCustomers_Title(WebElement newCustomers_Title) {
			NewCustomers_Title = newCustomers_Title;
		}



		public WebElement getSign_In() {
			return Sign_In;
		}



		public void setSign_In(WebElement sign_In) {
			Sign_In = sign_In;
		}



		public List<WebElement> getMessage() {
			return Message;
		}



		public void setMessage(List<WebElement> message) {
			Message = message;
		}

}
