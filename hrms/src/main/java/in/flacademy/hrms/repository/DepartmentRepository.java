package in.flacademy.hrms.repository;
import in.flacademy.hrms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
