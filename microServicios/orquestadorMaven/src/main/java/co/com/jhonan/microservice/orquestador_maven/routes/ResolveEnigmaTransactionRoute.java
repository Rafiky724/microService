package co.com.jhonan.microservice.orquestador_maven.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyRequest;
import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyResponseErrors;
import co.com.jhonan.microservice.orquestador_maven.model.JsonApiBodyResponseSuccess;
import co.com.jhonan.microservice.orquestador_maven.strategy.JoinReplyAggregationStrategy;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Component
public class ResolveEnigmaTransactionRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		JoinReplyAggregationStrategy myAggregationStrategy = new JoinReplyAggregationStrategy();
		
		from("direct:resolve-enigma")
		.routeId("resolveEnigma")
			.log("Request body ${body}")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception{
						JsonApiBodyRequest serviceRequestBody = (JsonApiBodyRequest) exchange.getIn().getBody();
						
						exchange.setProperty("ServiceId", serviceRequestBody.getData().get(0).getHeader().getId());
						exchange.setProperty("ServiceType", serviceRequestBody.getData().get(0).getHeader().getType());
						exchange.setProperty("ServiceEnigma", serviceRequestBody.getData().get(0).getEnigma() );
						exchange.setProperty("Error", "0000");
						exchange.setProperty("descError", "No errror");
				}					
			})
		
		
			.multicast(myAggregationStrategy)
		.parallelProcessing()
		.to("direct:get-step-one", "direct:get-step-two", "direct:get-step-three")
		.end()
		
		.choice()
    	.when(exchangeProperty("Error").isEqualTo("0000"))
    	 	.to("direct:generate-response-success")
        .otherwise()
         	.to("direct:generate-response-error")            	
         .end();
		
		
		from("direct:generate-response-success")
		.to("freemarker:templates/ResolveEnigmaTransactionResponse.ftl")
		.unmarshal().json(JsonLibrary.Jackson, JsonApiBodyResponseSuccess.class)
		.to("seda:save-log?waitForTaskToComplete=never");
		
		from("direct:generate-response-error")
		.to("freemarker:templates/ResolveEnigmaTransactionResponseError.ftl")
		.unmarshal().json(JsonLibrary.Jackson, JsonApiBodyResponseErrors.class);
	
	}
		

}