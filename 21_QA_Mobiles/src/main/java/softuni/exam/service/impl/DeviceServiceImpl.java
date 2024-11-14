package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.DeviceService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return null;
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        return null;
    }

    @Override
    public String exportDevices() {
        return null;
    }
}
