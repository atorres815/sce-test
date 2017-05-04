package mx.com.gnp.sce.consultarpolizav1.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ConsultarPolizaResponse", description = "Sample model for the documentation")
public class ConsultarPolizaResponse {
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Resultados", required = true)
	private List<RegistroPoliza> registros = new ArrayList<>();

	public List<RegistroPoliza> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroPoliza> registros) {
		this.registros = registros;
	}

	public void addRegistroPoliza(RegistroPoliza registroPoliza) {
		registros.add(registroPoliza);
	}

}
