package mx.com.gnp.sce.consultarpolizav1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RegistroPoliza", description = "Sample model for the documentation")
public class RegistroPoliza {

	@JsonProperty(required = true)
	@ApiModelProperty(value = "Numero de poliza", required = true)
	private String numPoliza;
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Version de la poliza", required = true)
	private Integer versionPoliza;
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Clave de produto tecnico", required = true)
	private String cveProductoTecnico;
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Clave de producto comercial", required = true)
	private String cveProductoComercial;

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public Integer getVersionPoliza() {
		return versionPoliza;
	}

	public void setVersionPoliza(Integer versionPoliza) {
		this.versionPoliza = versionPoliza;
	}

	public String getCveProductoTecnico() {
		return cveProductoTecnico;
	}

	public void setCveProductoTecnico(String cveProductoTecnico) {
		this.cveProductoTecnico = cveProductoTecnico;
	}

	public String getCveProductoComercial() {
		return cveProductoComercial;
	}

	public void setCveProductoComercial(String cveProductoComercial) {
		this.cveProductoComercial = cveProductoComercial;
	}

}
