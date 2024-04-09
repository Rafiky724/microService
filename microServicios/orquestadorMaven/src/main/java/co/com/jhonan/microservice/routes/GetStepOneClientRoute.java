package co.com.jhonan.microservice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetStepOneClientRoute extends RouteBuilder{

	//String url1 = "http://localhost:8081/v1/getOneEnigma/getStep";
    //String url2 = "http://localhost:8082/v1/getOneEnigma/getStep";
    //String url3 = "http://localhost:8083/v1/getOneEnigma/getStep";
    
	@Override
	public void configure() throws Exception {
		
		from("direct:get-step-one")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to("freemarkertemplates/GetStepOneClientTemplate.ftl")
		.log("Request microservice step one ${body}")
		.to("http4://localhost:8081/v1/getOneEnigma/getStep")
		.log("Response microservice step one ${body}");
		
	}
}
