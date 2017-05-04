package mx.com.gnp.sce.consultarpolizav1.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gnp.ae.aplicacion.AqObjMensaje;
import gnp.ci.servidor.Kcilvo01;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.gnp.sce.consultarpolizav1.exception.InternalException;
import mx.com.gnp.sce.consultarpolizav1.exception.PolizaNotFoundException;
import mx.com.gnp.sce.consultarpolizav1.mapper.Kcirvo01Mapper;
import mx.com.gnp.sce.consultarpolizav1.pojo.ConsultarPolizaResponse;
import mx.com.gnp.sce.consultarpolizav1.pojo.CriterioBusquedaPoliza;
import mx.com.gnp.sce.consultarpolizav1.service.PolizaService;

/**
 * Clase que contiene los endpoints a desplegar.
 */
@RestController
public class PolizaController {
	private static final Logger log = LoggerFactory.getLogger(PolizaController.class);

	/**
	 * Clase que contiene el servicio a utilizar por los endpoints.
	 */
	private final PolizaService consultarPolizaService;

	/**
	 * If a bean has one constructor, you can omit the @Autowired and allows the
	 * field to be marked as final, indicating that it cannot be subsequently
	 * changed
	 */
	public PolizaController(PolizaService consultarPolizaService) {
		this.consultarPolizaService = consultarPolizaService;
	}

	/**
	 * Expone el metodo del servicio de negocio consultarPolizaVersion
	 * 
	 * @param CriterioBusquedaPoliza
	 * @return ConsultarPolizaResponse
	 */

	@ApiOperation(value = "Consultar poliza por numero", notes="En esta operacion se pude consultar la poliza por numero y version con opcion de incluir el tipo")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Parametros incorrectos."),
			@ApiResponse(code = 401, message = "Acceso no autorizado."),
			@ApiResponse(code = 403, message = "Acceso prohibido."),
			@ApiResponse(code = 404, message = "Poliza no encontrada."),
			@ApiResponse(code = 500, message = "Error interno.")})
	@RequestMapping(method = RequestMethod.GET, path = "api/poliza/consultar", produces = "application/json")
	public ConsultarPolizaResponse consultar(CriterioBusquedaPoliza criterioBusquedaPoliza) {
		Optional<Kcilvo01> optKcilvo01 = null;
		try {
			optKcilvo01 = Optional.ofNullable(consultarPolizaService.consultarPorCriterios(criterioBusquedaPoliza));
		} catch (AqObjMensaje e) {
			log.info(e.getMessage(), e);
			throw new InternalException();
		}
		return Kcirvo01Mapper.convertToConsultarPolizaResponse(optKcilvo01.orElseThrow(PolizaNotFoundException::new));
	}
}
