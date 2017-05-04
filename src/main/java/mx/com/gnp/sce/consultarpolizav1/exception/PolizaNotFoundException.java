package mx.com.gnp.sce.consultarpolizav1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolizaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PolizaNotFoundException() {
		super("Poliza no encontrada.");
	}
}