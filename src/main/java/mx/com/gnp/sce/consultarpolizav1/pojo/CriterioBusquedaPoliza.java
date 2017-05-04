package mx.com.gnp.sce.consultarpolizav1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CriterioBusquedaPoliza {

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Numero de poliza", required = true)
	private String numPoliza;
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Numero de version", required = true)
	private Integer numVersion;
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Indicador de tipo poliza")
	private String indPolCompleta = "C";

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public Integer getNumVersion() {
		return numVersion;
	}

	public void setNumVersion(Integer numVersion) {
		this.numVersion = numVersion;
	}

	public String getIndPolCompleta() {
		return indPolCompleta;
	}

	public void setIndPolCompleta(String indPolCompleta) {
		this.indPolCompleta = indPolCompleta;
	}
}
