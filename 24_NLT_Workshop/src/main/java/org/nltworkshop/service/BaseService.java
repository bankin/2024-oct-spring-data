package org.nltworkshop.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface BaseService {

    boolean isImported();

    void seedData() throws JAXBException, IOException;

    String readFile() throws IOException;
}
