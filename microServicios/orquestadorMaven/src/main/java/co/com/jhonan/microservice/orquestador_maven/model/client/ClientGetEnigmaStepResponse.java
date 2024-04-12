package co.com.jhonan.microservice.orquestador_maven.model.client;

import java.util.Objects;
import co.com.jhonan.microservice.orquestador_maven.model.Header;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetEnigmaStepResponse
 */
@Validated
public class ClientGetEnigmaStepResponse {
	@JsonProperty("header")
	private ClientHeader header = null;

	@JsonProperty("step")
	private String step = null;

	@JsonProperty("stepDescription")
	private String stepDescription = null;

	public ClientGetEnigmaStepResponse header(ClientHeader header) {
		this.header = header;
		return this;
	}

	/**
	 * Get header
	 * 
	 * @return header
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public ClientHeader getHeader() {
		return header;
	}

	public void setHeader(ClientHeader header) {
		this.header = header;
	}

	public ClientGetEnigmaStepResponse step(String step) {
		this.step = step;
		return this;
	}

	/**
	 * Get step
	 * 
	 * @return step
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public ClientGetEnigmaStepResponse stepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
		return this;
	}

	/**
	 * Get stepDescription
	 * 
	 * @return stepDescription
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public String getStepDescription() {
		return stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ClientGetEnigmaStepResponse getEnigmaStepResponse = (ClientGetEnigmaStepResponse) o;

		return Objects.equals(this.header, getEnigmaStepResponse.header)
				&& Objects.equals(this.step, getEnigmaStepResponse.step)
				&& Objects.equals(this.stepDescription, getEnigmaStepResponse.stepDescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(header, step, stepDescription);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("class GetEnigmaStepResponse {\n");
		sb.append("    header:          ").append(toIndentedString(header)).append("\n");
		sb.append("    step:            ").append(toIndentedString(stepDescription)).append("\n");
		sb.append("    stepDescription: ").append(toIndentedString(stepDescription)).append("\n");
		sb.append("}");

		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}