package ufc.managementfighters.model;

import jakarta.validation.constraints.*;

/*
 * DTO is an object that transfers your datas between application layers. It gives a better security between the db entities and do not return sensitive datas
 * You can also have lighters HTTP request
 */
public class RegisterDto {


    @NotEmpty(message = "This field cannot be empty")
    private String firstName;

    @NotEmpty(message = "This field cannot be empty")
    private String lastName;

    @NotEmpty(message = "This field cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    private String phone;

    @NotEmpty(message = "This field cannot be empty")
    private String image;


    @Size(min = 8,message = "Minimum password length is 6 characters")
    private String password;

    @ValidPassword
    @PasswordValueMatch
    @Size(min = 8,message = "Minimum password length is 6 characters")
    @NotBlank(message = "Confirm Password is mandatory")
    private String confirmPassword;



    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the emai
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the emai to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

   


    /**
     * @return String return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

}
