package co.com.jhonan.microservice.orquestador_maven.api;

import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyRequest;
import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyResponseErrors;
import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyResponseSuccess;

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
        JsonApiBodyRequest body = new JsonApiBodyRequest();
        ResponseEntity<?> responseEntity = api.getStepsPost(body);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
