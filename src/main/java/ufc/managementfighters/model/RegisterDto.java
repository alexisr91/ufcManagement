package ufc.managementfighters.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Lob;

/*
 * DTO is an object that transfers your data between application layers.
 * It provides better security by decoupling the database entities and prevents sensitive data exposure.
 * It also allows for lighter HTTP requests.
 */
public class RegisterDto {

    @NotEmpty(message = "This field cannot be empty")
    private String firstName;

    @NotEmpty(message = "This field cannot be empty")
    private String lastName;

    @NotEmpty(message = "This field cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    private String phone;

    @NotNull(message = "Image cannot be null")
    @Lob
    private byte[] image;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 8, message = "Minimum password length is 8 characters")
    private String password;

    @NotEmpty(message = "Confirm Password is mandatory")
    @Size(min = 8, message = "Minimum password length is 8 characters")
    private String confirmPassword;

    // Getters and Setters

    /**
     * @return String returns the firstName
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
     * @return String returns the lastName
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
     * @return String returns the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String returns the phone
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
     * @return byte[] returns the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return String returns the password
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
     * @return String returns the confirmPassword
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
}
