package mx.com.gnp.sce.consultarpolizav1.mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Kcirvo01MapperTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwIllegalAccessException()
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		thrown.expect(IllegalAccessException.class);
		Constructor<Kcirvo01Mapper> constructor = Kcirvo01Mapper.class.getDeclaredConstructor();
		constructor.newInstance();
	}

}
