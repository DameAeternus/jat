package jobapplication.service;

import jobapplication.model.JobApplication;
import jobapplication.model.User;

import java.util.Date;
import java.util.List;

public interface JobApplicationService {

    List<JobApplication> getAllJobApplications();

    JobApplication getJobApplicationById(Long id);

    JobApplication createJobApplication(User user, String companyName, String jobPosition, String adLink,
                                        JobApplication.ApplicationStatus status,
                                        String cvUsed, String motivationalLetter, String notes,
                                        Date applicationTime, Date responseDateTime, String applicationLocation,
                                        String referralSource, String wishlist, String companyInfo,
                                        String mapLocation, boolean isRemote, Date nextInterviewDate);

    JobApplication updateJobApplication(Long id, String companyName, String jobPosition, String adLink,
                                        JobApplication.ApplicationStatus status,
                                        String cvUsed, String motivationalLetter, String notes,
                                        Date applicationTime, Date responseDateTime, String applicationLocation,
                                        String referralSource, String wishlist, String companyInfo,
                                        String mapLocation, boolean isRemote, Date nextInterviewDate);

    JobApplication deleteJobApplication(Long id);
    List<JobApplication> getAllArchivedJobApplications();
    List<JobApplication> getJobApplicationsByUser(User user);

    List<JobApplication> getJobApplicationsByStatus(JobApplication.ApplicationStatus status);

    // Add additional methods as needed
}
