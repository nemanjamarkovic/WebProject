package projektniZadatak.entity.dto;

import projektniZadatak.entity.User;

public class ViewerDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private User.Role role;

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public ViewerDTO(Long id, String name, String lastname, String email, User.Role role, Long cinemaId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.cinemaId = cinemaId;
    }

    private Long cinemaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public ViewerDTO(Long id, String name, String lastname, String email, User.Role role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }
}
