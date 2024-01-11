package jobapplication.web;

import jobapplication.model.JobApplication;
import jobapplication.model.User;
import jobapplication.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";  // Assuming your login page is named login.html
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register.html";  // Assuming your register page is named register.html
    }
    @GetMapping
    public String getAllJobApplications(Model model) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();
        model.addAttribute("jobApplications", jobApplications);
        return "jobApplicationsList"; // Thymeleaf template name
    }

    @GetMapping("/archived")
    public String getAllArchivedJobApplications(Model model) {
        List<JobApplication> archivedApplications = jobApplicationService.getAllArchivedJobApplications();
        model.addAttribute("archivedApplications", archivedApplications);
        return "archivedApplicationsList"; // Thymeleaf template name
    }

    @GetMapping("/{id}")
    public String getJobApplicationById(@PathVariable Long id, Model model) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationById(id);
        model.addAttribute("jobApplication", jobApplication);
        return "jobApplicationDetails"; // Thymeleaf template name
    }

    @PostMapping
    public String createJobApplication(@ModelAttribute JobApplication jobApplication,
                                       @RequestParam String companyName,
                                       @RequestParam String jobPosition,
                                       @RequestParam String adLink,
                                       @RequestParam JobApplication.ApplicationStatus status,
                                       @RequestParam String cvUsed,
                                       @RequestParam String motivationalLetter,
                                       @RequestParam String notes,
                                       @RequestParam Date applicationTime,
                                       @RequestParam Date responseDateTime,
                                       @RequestParam String applicationLocation,
                                       @RequestParam String referralSource,
                                       @RequestParam String wishlist,
                                       @RequestParam String companyInfo,
                                       @RequestParam String mapLocation,
                                       @RequestParam boolean isRemote,
                                       @RequestParam Date nextInterviewDate) {

        // Extracted parameters from JobApplication object
        User user = jobApplication.getUser();

        // Call the service method with all the required parameters
        jobApplicationService.createJobApplication(user, companyName, jobPosition, adLink, status,
                cvUsed, motivationalLetter, notes, applicationTime, responseDateTime,
                applicationLocation, referralSource, wishlist, companyInfo, mapLocation, isRemote, nextInterviewDate);

        return "redirect:/api/job-applications";
    }

    @DeleteMapping("/{id}")
    public String deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
        return "redirect:/api/job-applications";
    }

    // Add additional methods or custom endpoints as needed
}
