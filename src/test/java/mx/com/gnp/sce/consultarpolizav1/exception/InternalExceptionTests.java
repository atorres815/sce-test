package mx.com.gnp.sce.consultarpolizav1.exception;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InternalExceptionTests {

	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwInternalException() {
        thrown.expect(InternalException.class);
        thrown.expectMessage(equalTo("A sucedido un error interno, por favor intente mas tarde."));
        throw new InternalException();
    }


}
