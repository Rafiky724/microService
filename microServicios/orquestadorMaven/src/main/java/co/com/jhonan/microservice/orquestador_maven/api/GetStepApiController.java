package co.com.jhonan.microservice.orquestador_maven.api;

import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyRequest;
import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @EndpointInject(uri = "direct:get-step-one")
    private FluentProducerTemplate producerTemplateResolveEnigma;

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<JsonApiBodyResponseSuccess>> getStep(@ApiParam(value = "request body get enigma step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");

        try {
            producerTemplateResolveEnigma.request();
            List<JsonApiBodyResponseSuccess> responseList = new ArrayList<>();
            responseList.add(objectMapper.readValue(
            		"{\n" +
                            "  \"data\": [\n" +
                            "    {\n" +
                            "      \"enigma\": \"string\",\n" +
                            "      \"header\": {\n" +
                            "        \"id\": \"string\",\n" +
                            "        \"type\": \"string\"\n" +
                            "      }\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}", JsonApiBodyResponseSuccess.class));
            return new ResponseEntity<>(responseList, HttpStatus.OK);

        } catch (IOException e) {
            log.error("Couldn't serialize response", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
