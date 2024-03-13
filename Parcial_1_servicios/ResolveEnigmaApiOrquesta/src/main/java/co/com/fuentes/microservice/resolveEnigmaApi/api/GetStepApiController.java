package co.com.fuentes.microservice.resolveEnigmaApi.api;

import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.fuentes.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-12T21:52:54.679-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> getStep() {
        RestTemplate restTemplate = new RestTemplate();

        String message1 = restTemplate.getForObject("http://localhost:8081/v1/getOneEnigma/getStep", String.class);
        String message2 = restTemplate.getForObject("http://localhost:8082/v1/getOneEnigma/getStep", String.class);
        String message3 = restTemplate.getForObject("http://localhost:8083/v1/getOneEnigma/getStep", String.class);
        
        String combinedMessage = message1 + " " + message2 + " " + message3;
        System.out.println(combinedMessage);
        
        return new ResponseEntity<>(combinedMessage, HttpStatus.OK);
    }
}
