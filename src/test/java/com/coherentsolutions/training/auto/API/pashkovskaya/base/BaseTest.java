package com.coherentsolutions.training.auto.API.pashkovskaya.base;

import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import com.coherentsolutions.training.auto.API.pashkovskaya.specs.Specs;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public ObjectMapper objectMapper = new ObjectMapper();
    @BeforeMethod
    public void setUp() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Specs.instalSpec(Specs.requestSpec(PropertiesFileReader.getBaseURI()), Specs.responseSpecOK200());
    }
}
