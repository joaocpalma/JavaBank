package org.academiadecodigo.javabank;


import javax.validation.constraints.*;

public class CustomerDto{
    private Integer id;
    @NotNull(message = "first name is mandatory")
    @NotBlank(message = "first name is mandatory")
    @Size(min = 3, max = 30)
    private String firstName;
    @NotNull(message = "last name is mandatory")
    @NotBlank(message = "last name is mandatory")
    @Size(min = 3, max = 30)
    private String lastName;
    @Size(min=9, max=16)
    private String phone;
    @Email
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
