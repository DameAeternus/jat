package jobapplication.model; // Make sure to update the package accordingly

import javax.persistence.*;
import java.util.Date;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isArchived;

    public JobApplication() {
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String companyName;

    private String jobPosition;

    private String adLink;

    // Enum representing different application statuses

    public enum ApplicationStatus {
        BOOKMARKED, APPLYING, APPLIED, INTERVIEWING, NEGOTIATING, FINAL_OFFER
    }
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private String cvUsed;

    private String motivationalLetter;

    private String notes;

    private Date applicationTime;

    private Date responseDateTime;

    private String applicationLocation;

    private String referralSource;

    // Wishlist for future considerations
    private String wishlist;

    // Company information
    private String companyInfo;

    private String mapLocation;

    private boolean isRemote;

    private Date nextInterviewDate;
    public JobApplication(boolean isArchived, User user, String companyName, String jobPosition, String adLink, ApplicationStatus status, String cvUsed, String motivationalLetter, String notes, Date applicationTime, Date responseDateTime, String applicationLocation, String referralSource, String wishlist, String companyInfo, String mapLocation, boolean isRemote, Date nextInterviewDate) {
        this.isArchived = isArchived;
        this.user = user;
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.adLink = adLink;
        this.status = status;
        this.cvUsed = cvUsed;
        this.motivationalLetter = motivationalLetter;
        this.notes = notes;
        this.applicationTime = applicationTime;
        this.responseDateTime = responseDateTime;
        this.applicationLocation = applicationLocation;
        this.referralSource = referralSource;
        this.wishlist = wishlist;
        this.companyInfo = companyInfo;
        this.mapLocation = mapLocation;
        this.isRemote = isRemote;
        this.nextInterviewDate = nextInterviewDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }


    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getCvUsed() {
        return cvUsed;
    }

    public void setCvUsed(String cvUsed) {
        this.cvUsed = cvUsed;
    }

    public String getMotivationalLetter() {
        return motivationalLetter;
    }

    public void setMotivationalLetter(String motivationalLetter) {
        this.motivationalLetter = motivationalLetter;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Date getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(Date responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getApplicationLocation() {
        return applicationLocation;
    }

    public void setApplicationLocation(String applicationLocation) {
        this.applicationLocation = applicationLocation;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public void setReferralSource(String referralSource) {
        this.referralSource = referralSource;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public Date getNextInterviewDate() {
        return nextInterviewDate;
    }

    public void setNextInterviewDate(Date nextInterviewDate) {
        this.nextInterviewDate = nextInterviewDate;
    }

    // Add getters and setters
}
