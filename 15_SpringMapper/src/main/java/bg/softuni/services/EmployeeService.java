package bg.softuni.services;

import bg.softuni.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findEmployeesBornBefore(int bornBefore);

    List<EmployeeDTO> findAllWithManager();
}
