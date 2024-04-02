package co.com.perez.microservice.orquestador.api;

import co.com.perez.microservice.orquestador.model.GetEnigmaStepResponse;
import co.com.perez.microservice.orquestador.model.JsonApiBodyRequest;
import co.com.perez.microservice.orquestador.model.JsonApiBodyResponseErrors;
import co.com.perez.microservice.orquestador.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-01T21:49:42.348-05:00[America/Bogota]")

@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<List<String>> getStep(@ApiParam(value = "request body get enigma step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
        RestTemplate restTemplate = new RestTemplate();
        String url1 = "http://localhost:8081/v1/getOneEnigma/getStep";
        String url2 = "http://localhost:8082/v1/getOneEnigma/getStep";
        String url3 = "http://localhost:8083/v1/getOneEnigma/getStep";
        
        // Realiza la solicitud al servicio destino y obtiene la respuesta
        ResponseEntity<List<JsonApiBodyResponseSuccess>> responseEntity1 = restTemplate.exchange(
                url1,
                HttpMethod.POST,
                new HttpEntity<>(body),
                new ParameterizedTypeReference<List<JsonApiBodyResponseSuccess>>() {});

     // Realiza la solicitud al segundo servicio destino y obtiene la respuesta
        ResponseEntity<List<JsonApiBodyResponseSuccess>> responseEntity2 = restTemplate.exchange(
                url2,
                HttpMethod.POST,
                new HttpEntity<>(body),
                new ParameterizedTypeReference<List<JsonApiBodyResponseSuccess>>() {});

        // Realiza la solicitud al tercer servicio destino y obtiene la respuesta
        ResponseEntity<List<JsonApiBodyResponseSuccess>> responseEntity3 = restTemplate.exchange(
                url3,
                HttpMethod.POST,
                new HttpEntity<>(body),
                new ParameterizedTypeReference<List<JsonApiBodyResponseSuccess>>() {});

        // Procesa las respuestas de los tres servicios
        List<String> answers = new ArrayList<>();
        processResponse(responseEntity1, answers);
        processResponse(responseEntity2, answers);
        processResponse(responseEntity3, answers);

        // Devuelve la lista de respuestas
        return ResponseEntity.ok(answers);
    }

    // Método para procesar la respuesta de cada servicio y extraer los valores de "answer"
    private void processResponse(ResponseEntity<List<JsonApiBodyResponseSuccess>> responseEntity, List<String> answers) {
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<JsonApiBodyResponseSuccess> responseBodyList = responseEntity.getBody();
            if (responseBodyList != null) {
                for (JsonApiBodyResponseSuccess responseBody : responseBodyList) {
                    for (GetEnigmaStepResponse enigma : responseBody.getData()) {
                        answers.add(enigma.getAnswer());
                    }
                }
            }
        }
    }


}