package mx.com.gnp.sce.consultarpolizav1;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gnp.ae.presentacion.ventanaMarco.AqSesion;
import gnp.ae.presentacion.ventanaMarco.AqSistema;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	@Value("${cd.usuario}")
	private String cdUsuario;
	@Value("${ds.password}")
	private String dsPassword;
	@Value("${cd.entorno}")
	private String cdEntorno;

	@PostConstruct
	public void init() {
		
		AqSesion sesion = new AqSesion();
		sesion.setCdUsuario(cdUsuario);
		sesion.setDsPassword(dsPassword);
		AqSistema.setCdEntorno(cdEntorno);
		AqSistema.setSesionActiva(sesion);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Polizas").apiInfo(apiInfo()).select().paths(regex("/api/poliza.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring REST Api para Polizas").description("Contiene las operaciones para polizas")
				.termsOfServiceUrl("https://www.gnp.com.mx/wps/portal/portalesgnp/anexos/aviso-privacidad").license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("2.0").build();
	}
}
