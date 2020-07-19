package projektniZadatak.entity.dto;

import projektniZadatak.entity.User;

public class UserDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO(Long id, String name, String lastname, String email, String password, User.Role role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private String name;
    private String lastname;
    private String email;
    private String password;
    private User.Role role;

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public UserDTO(String name, String lastname, String email, String password, User.Role role) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDTO(String name, String lastname, String email, String password) {

        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
