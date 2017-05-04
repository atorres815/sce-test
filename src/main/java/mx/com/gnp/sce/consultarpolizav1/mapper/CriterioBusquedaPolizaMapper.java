package mx.com.gnp.sce.consultarpolizav1.mapper;

import gnp.ci.ModeloDatos.Kcirio01;
import mx.com.gnp.sce.consultarpolizav1.pojo.CriterioBusquedaPoliza;

public class CriterioBusquedaPolizaMapper {

	private CriterioBusquedaPolizaMapper() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	public static Kcirio01 convertToKcirio01(CriterioBusquedaPoliza criterioBusquedaPoliza) {
		Kcirio01 kicirio01 = new Kcirio01();
		kicirio01.setCdnumpol(criterioBusquedaPoliza.getNumPoliza());
		kicirio01.setIntippol(criterioBusquedaPoliza.getIndPolCompleta());
		kicirio01.setCtvrspol(criterioBusquedaPoliza.getNumVersion());
		return kicirio01;
	}
}
