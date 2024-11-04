package bg.softuni.services;

import bg.softuni.entities.Employee;
import bg.softuni.entities.dtos.EmployeeDTO;
import bg.softuni.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public ManagerServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> findAllManagers() {
        List<Employee> result = employeeRepository.findManagers();

        return result
                .stream()
                .map(e -> modelMapper.map(e, EmployeeDTO.class))
                .toList();
    }
}
