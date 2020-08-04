package com.textcalculator.textcalculator;

import com.opensymphony.xwork2.util.ClassLoaderUtil;
import com.textcalculator.textcalculator.service.MathematicalOperationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TextCalculatorApplicationTests {

	@Autowired
	private MathematicalOperationService mos;

	@Test
	void addOperation() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("addOperation.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("8.00000");
	}

	@Test
	void subtractOperation() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("subtractOperation.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("-2.00000");
	}

	@Test
	void multiplyOperation() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("multiplyOperation.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("15.00000");
	}

	@Test
	void divideOperation() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("divideOperation.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("2.50000");
	}

	@Test
	void powerOperation() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("powerOperation.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("243.00000");
	}

	@Test
	void multipleOperations() throws URISyntaxException {
		URL url = ClassLoaderUtil.getResource("multipleOperations.txt", TextCalculatorApplicationTests.class);
		Path path = Paths.get(url.toURI());
		String result = mos.run(path.toString());
		assertThat(result).isEqualTo("27.00000");
	}

}
