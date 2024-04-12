package co.com.jhonan.microservice.orquestador_maven.model.client;

import java.util.Objects;
import co.com.jhonan.microservice.orquestador_maven.model.GetEnigmaStepResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonApiBodyResponseSuccess
 */
@Validated
public class ClientJsonApiBodyResponseSuccess   {
	@JsonProperty("data")
	  @Valid
	  private List<ClientGetEnigmaStepResponse> data = new ArrayList<ClientGetEnigmaStepResponse>();

	  public ClientJsonApiBodyResponseSuccess data(List<ClientGetEnigmaStepResponse> data) {
	    this.data = data;
	    return this;
	  }

	  public ClientJsonApiBodyResponseSuccess addDataItem(ClientGetEnigmaStepResponse dataItem) {
	    this.data.add(dataItem);
	    return this;
	  }

	  /**
	   * Get data
	   * @return data
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull
	  @Valid
	  public List<ClientGetEnigmaStepResponse> getData() {
	    return data;
	  }

	  public void setData(List<ClientGetEnigmaStepResponse> data) {
	    this.data = data;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ClientJsonApiBodyResponseSuccess jsonApiBodyResponseSuccess = (ClientJsonApiBodyResponseSuccess) o;
	    return Objects.equals(this.data, jsonApiBodyResponseSuccess.data);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(data);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class JsonApiBodyResponseSuccess {\n");
	    
	    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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