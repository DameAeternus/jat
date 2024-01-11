package jobapplication.service.Impl;

import jobapplication.model.JobApplication;
import jobapplication.model.User;
import jobapplication.repository.JobApplicationRepository;
import jobapplication.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public JobApplication createJobApplication(User user, String companyName, String jobPosition, String adLink,
                                               JobApplication.ApplicationStatus status,
                                               String cvUsed, String motivationalLetter, String notes,
                                               Date applicationTime, Date responseDateTime, String applicationLocation,
                                               String referralSource, String wishlist, String companyInfo,
                                               String mapLocation, boolean isRemote, Date nextInterviewDate) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setUser(user);
        jobApplication.setCompanyName(companyName);
        jobApplication.setJobPosition(jobPosition);
        jobApplication.setAdLink(adLink);
        jobApplication.setStatus(status);
        jobApplication.setCvUsed(cvUsed);
        jobApplication.setMotivationalLetter(motivationalLetter);
        jobApplication.setNotes(notes);
        jobApplication.setApplicationTime(applicationTime);
        jobApplication.setResponseDateTime(responseDateTime);
        jobApplication.setApplicationLocation(applicationLocation);
        jobApplication.setReferralSource(referralSource);
        jobApplication.setWishlist(wishlist);
        jobApplication.setCompanyInfo(companyInfo);
        jobApplication.setMapLocation(mapLocation);
        jobApplication.setRemote(isRemote);
        jobApplication.setNextInterviewDate(nextInterviewDate);

        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public JobApplication updateJobApplication(Long id, String companyName, String jobPosition, String adLink,
                                               JobApplication.ApplicationStatus status,
                                               String cvUsed, String motivationalLetter, String notes,
                                               Date applicationTime, Date responseDateTime, String applicationLocation,
                                               String referralSource, String wishlist, String companyInfo,
                                               String mapLocation, boolean isRemote, Date nextInterviewDate) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(id);

        if (optionalJobApplication.isPresent()) {
            JobApplication jobApplication = optionalJobApplication.get();
            jobApplication.setCompanyName(companyName);
            jobApplication.setJobPosition(jobPosition);
            jobApplication.setAdLink(adLink);
            jobApplication.setStatus(status);
            jobApplication.setCvUsed(cvUsed);
            jobApplication.setMotivationalLetter(motivationalLetter);
            jobApplication.setNotes(notes);
            jobApplication.setApplicationTime(applicationTime);
            jobApplication.setResponseDateTime(responseDateTime);
            jobApplication.setApplicationLocation(applicationLocation);
            jobApplication.setReferralSource(referralSource);
            jobApplication.setWishlist(wishlist);
            jobApplication.setCompanyInfo(companyInfo);
            jobApplication.setMapLocation(mapLocation);
            jobApplication.setRemote(isRemote);
            jobApplication.setNextInterviewDate(nextInterviewDate);

            return jobApplicationRepository.save(jobApplication);
        }

        return null; // or throw an exception if needed
    }

    @Override
    public JobApplication deleteJobApplication(Long id) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(id);

        if (optionalJobApplication.isPresent()) {
            JobApplication jobApplication = optionalJobApplication.get();
            jobApplicationRepository.delete(jobApplication);
            return jobApplication;
        }

        return null; // or throw an exception if needed
    }

    @Override
    public List<JobApplication> getAllArchivedJobApplications() {
        return jobApplicationRepository.findAll().stream()
                .filter(JobApplication::isArchived)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobApplication> getJobApplicationsByUser(User user) {
        return jobApplicationRepository.findByUser(user);
    }

    @Override
    public List<JobApplication> getJobApplicationsByStatus(JobApplication.ApplicationStatus status) {
        return jobApplicationRepository.findByStatus(status);
    }

    // Add additional methods or override methods from the interface as needed
}
