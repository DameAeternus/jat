package jobapplication.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    public enum UserType {
        REGULAR,
        ADMIN
    }
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @OneToMany(mappedBy = "user")
    private List<JobApplication> jobApplications;

    public User(List<JobApplication> jobApplications, String username, UserType userType, String password) {
        this.jobApplications = jobApplications;
        this.username = username;
        this.userType = userType;
        this.password = password;
    }

    private String username;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(){
    }

    private String password; // Consider using secure authentication methods

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Add other user-related fields as needed

    // Add getters and setters
}
