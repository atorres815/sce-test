package mx.com.gnp.sce.consultarpolizav1.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConsultarPolizaControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void consultarPolizaVersionTest() throws Exception {
		this.mockMvc.perform(get("/api/poliza/consultar").param("numPoliza",  "00000886495050").param("numVersion", "0"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("__DOLLAR__.registros", hasSize(1)))
				.andExpect(jsonPath("__DOLLAR__.registros[0].numPoliza", equalTo("00000886495050")))
				.andExpect(jsonPath("__DOLLAR__.registros[0].versionPoliza", equalTo(0)))
				.andExpect(jsonPath("__DOLLAR__.registros[0].cveProductoTecnico", equalTo("A2400LNEVO")))
				.andExpect(jsonPath("__DOLLAR__.registros[0].cveProductoComercial", equalTo("00001")));
	}

	@Test
	public void consultarPolizaVersionTipoTest() throws Exception {
		this.mockMvc.perform(get("/api/poliza/consultar").param("numPoliza",  "00000886495050").param("numVersion", "0").param("indPolCompleta", "C"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("__DOLLAR__.registros", hasSize(1)))
				.andExpect(jsonPath("__DOLLAR__.registros[0].numPoliza", equalTo("00000886495050")))
				.andExpect(jsonPath("__DOLLAR__.registros[0].versionPoliza", equalTo(0)))
				.andExpect(jsonPath("__DOLLAR__.registros[0].cveProductoTecnico", equalTo("A2400LNEVO")))
				.andExpect(jsonPath("__DOLLAR__.registros[0].cveProductoComercial", equalTo("00001")));
	}
	
	@Test
	public void consultarPolizaVersionTipoNotFoundTest() throws Exception {
		this.mockMvc.perform(get("/api/poliza/consultar").param("numPoliza",  "00000886495050").param("numVersion", "1").param("indPolCompleta", "D")).andExpect(status().isNotFound());
	}
	
	@Test
	public void consultarPolizaNotFoundTest() throws Exception {
		this.mockMvc.perform(get("/api/poliza/consultar").param("numPoliza",  "00000131171324").param("numVersion", "1")).andExpect(status().isNotFound());
	}
}
