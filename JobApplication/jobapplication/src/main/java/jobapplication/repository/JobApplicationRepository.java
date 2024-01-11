package jobapplication.repository;

import jobapplication.model.JobApplication;
import jobapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
    List<JobApplication> findByStatus(JobApplication.ApplicationStatus status);
    List<JobApplication> findByUser(User user);
}
