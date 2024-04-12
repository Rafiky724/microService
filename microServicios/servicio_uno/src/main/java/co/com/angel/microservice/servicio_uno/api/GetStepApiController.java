package co.com.angel.microservice.servicio_uno.api;

import co.com.angel.microservice.servicio_uno.model.ErrorDetail;
import co.com.angel.microservice.servicio_uno.model.GetEnigmaRequest;
import co.com.angel.microservice.servicio_uno.model.GetEnigmaStepResponse;
import co.com.angel.microservice.servicio_uno.model.JsonApiBodyRequest;
import co.com.angel.microservice.servicio_uno.model.JsonApiBodyResponseErrors;
import co.com.angel.microservice.servicio_uno.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-01T21:03:19.339-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {
    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController() {
    }

    public ResponseEntity<?> getStep(@ApiParam(value = "request body get enigma step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
        boolean isStepOne = (body.getData().get(0).getStep().equalsIgnoreCase("1"));
    	
    	if (!isStepOne) {        	
        	return new ResponseEntity<>(createResponseErrors(body), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(createResponseSuccess(body), HttpStatus.OK);
    }
    
    @GetMapping("/getStepOne")
    public ResponseEntity<String> getStepOne() {
    	return new ResponseEntity<>("Step 1: Abrir el refrigerador", HttpStatus.OK);
    }
    
    private List<JsonApiBodyResponseErrors> createResponseErrors(JsonApiBodyRequest body) {
    	ErrorDetail errorDetail = new ErrorDetail();
    	errorDetail.setCode("001");
    	errorDetail.setDetail("Step: ".concat(body.getData().get(0).getStep()).concat(" not supported - Expected: 1"));
    	errorDetail.setId(body.getData().get(0).getHeader().getId());
    	errorDetail.setSource("/getStep");
    	errorDetail.setStatus("400");
    	errorDetail.setTitle("Step not supported");
    	
    	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
    	responseError.addErrorsItem(errorDetail);
    	
    	List<JsonApiBodyResponseErrors> responseErrorsList = new ArrayList<JsonApiBodyResponseErrors>(); 
    	responseErrorsList.add(responseError);
    	
    	return responseErrorsList;
    }
    
    private List<JsonApiBodyResponseSuccess> createResponseSuccess(JsonApiBodyRequest body) {
        GetEnigmaStepResponse responseEnigma = new GetEnigmaStepResponse();    
        responseEnigma.setHeader(body.getData().get(0).getHeader());
        responseEnigma.setStep(body.getData().get(0).getStep());
        responseEnigma.setStepDescription("Step 1: Abrir el refrigerador");
        
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        responseSuccess.addDataItem(responseEnigma);
        
        List<JsonApiBodyResponseSuccess> responseSuccessList = new ArrayList<JsonApiBodyResponseSuccess>();  
        responseSuccessList.add(responseSuccess);
        
        return responseSuccessList;
    }
}