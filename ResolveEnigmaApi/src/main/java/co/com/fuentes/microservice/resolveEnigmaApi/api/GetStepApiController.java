package co.com.fuentes.microservice.resolveEnigmaApi.api;

import co.com.fuentes.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-03T01:35:33.457-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    /* inicio */
    
    private JsonApiBodyResponseSuccess response = new JsonApiBodyResponseSuccess();
    private List<GetEnigmaStepResponse> enigmas = new ArrayList<>();
    private GetEnigmaStepResponse enigma = new GetEnigmaStepResponse();
    
    /* final */

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<JsonApiBodyResponseSuccess>> getStep(@ApiParam(value = "request body get enigma step" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        
        /* inicio */
        
        enigma.setAnswer("Abrir el refrigerador");
        enigmas.add(enigma);
        response.setData(enigmas);
     
        List<JsonApiBodyResponseSuccess> responseList = new ArrayList<>();
        responseList.add(response);
        
        /* final */
                
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}
