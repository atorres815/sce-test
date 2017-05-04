package mx.com.gnp.sce.consultarpolizav1.mapper;

import gnp.ci.ModeloDatos.Kcirvo01;
import gnp.ci.servidor.Kcilvo01;
import mx.com.gnp.sce.consultarpolizav1.exception.PolizaNotFoundException;
import mx.com.gnp.sce.consultarpolizav1.pojo.ConsultarPolizaResponse;
import mx.com.gnp.sce.consultarpolizav1.pojo.RegistroPoliza;

public class Kcirvo01Mapper {

	private Kcirvo01Mapper() {
	}

	public static ConsultarPolizaResponse convertToConsultarPolizaResponse(Kcilvo01 kcilvo01){
		ConsultarPolizaResponse consultarPolizaResponse = new ConsultarPolizaResponse();

		if (0 == kcilvo01.getNuocurre()) {
			throw new PolizaNotFoundException();
		}
		RegistroPoliza registroPoliza;
		for (int i = 0; i < kcilvo01.nuocurre; i++) {
			Kcirvo01 kcirvo01 = kcilvo01.cdlisreg[i];
			registroPoliza = new RegistroPoliza();
			registroPoliza.setCveProductoComercial(kcirvo01.cdprodco);
			registroPoliza.setCveProductoTecnico(kcirvo01.cdprodte);
			registroPoliza.setNumPoliza(kcirvo01.cdnumpol);
			registroPoliza.setVersionPoliza(kcirvo01.ctvrspol);
			consultarPolizaResponse.addRegistroPoliza(registroPoliza);
		}
		return consultarPolizaResponse;
	}
}
