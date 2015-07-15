package com.food.pos;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractTestJob {
	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"mvc-dispatcher-servlet.xml");

	final public Object getComent(Class<?> compentClass) {
		return this.ac.getBean(compentClass);
	}
}
