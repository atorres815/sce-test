package mx.com.gnp.sce.consultarpolizav1.service;

import gnp.ae.aplicacion.AqObjMensaje;
import gnp.ci.servidor.Kcilvo01;
import mx.com.gnp.sce.consultarpolizav1.pojo.CriterioBusquedaPoliza;

@FunctionalInterface
public interface PolizaService {
	Kcilvo01 consultarPorCriterios(CriterioBusquedaPoliza criterioBusquedaPoliza) throws AqObjMensaje;
}
