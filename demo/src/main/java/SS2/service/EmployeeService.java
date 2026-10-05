package SS2.service;

import SS2.model.entity.Employee;
import SS2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    @Autowired //  Tiêm Repository vào Service
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getFullName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(int id, Employee employee) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.update(id, employee);
            return employee; // Trả về đối tượng đã update (giả lập)
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employeeRepository.delete(id);
    }
}
