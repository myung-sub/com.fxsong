package com.fxsong.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.fxsong.util.PropertiesService;

public class PropertiesServiceTest {

	@Test
	public void test() throws IOException {
		String name = PropertiesService.getProperty("fxsong.name");
		assertThat(name,is("AAA"));
	}
	

}
