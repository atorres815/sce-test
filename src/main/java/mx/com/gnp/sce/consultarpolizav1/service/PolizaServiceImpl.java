package mx.com.gnp.sce.consultarpolizav1.service;

import org.springframework.stereotype.Service;

import gnp.ae.aplicacion.AqObjMensaje;
import gnp.ci.servidor.Kcilio01;
import gnp.ci.servidor.Kcilvo01;
import gnp.ci.servidor.PolizaStub;
import mx.com.gnp.sce.consultarpolizav1.mapper.CriterioBusquedaPolizaMapper;
import mx.com.gnp.sce.consultarpolizav1.pojo.CriterioBusquedaPoliza;

@Service
public class PolizaServiceImpl implements PolizaService {

	@Override
	public Kcilvo01 consultarPorCriterios(CriterioBusquedaPoliza criterioBusquedaPoliza) throws AqObjMensaje {
		PolizaStub servidorPoliza = new PolizaStub();

		// ***** Mensaje de Ida
		Kcilio01 mensajeIda = new Kcilio01();
		mensajeIda.setCriterio(CriterioBusquedaPolizaMapper.convertToKcirio01(criterioBusquedaPoliza));

		// ***** Mensaje de Vuelta
		return servidorPoliza.lista(mensajeIda);

	}
}
