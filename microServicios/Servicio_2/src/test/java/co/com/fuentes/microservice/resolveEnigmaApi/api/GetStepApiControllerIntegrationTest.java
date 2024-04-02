package co.com.fuentes.microservice.resolveEnigmaApi.api;

import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetStepApiControllerIntegrationTest {

    @Autowired
    private GetStepApi api;

    @Test
    public void getStepTest() throws Exception {
        ResponseEntity<String> responseEntity = api.getStep();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Poner la jirafa adentro", responseEntity.getBody());
    }

}
