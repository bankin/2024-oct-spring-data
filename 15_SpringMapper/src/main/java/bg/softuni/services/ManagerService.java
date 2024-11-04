package bg.softuni.services;

import bg.softuni.entities.dtos.EmployeeDTO;

import java.util.List;

public interface ManagerService {
    List<EmployeeDTO> findAllManagers();
}
