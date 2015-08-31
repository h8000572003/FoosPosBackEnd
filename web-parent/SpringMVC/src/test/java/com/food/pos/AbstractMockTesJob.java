package com.food.pos;

import java.lang.reflect.Field;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractMockTesJob {
	public final void mockitoAll(Object mockIbj) {
		final Field[] fs = mockIbj.getClass().getDeclaredFields();
		for (Field f : fs) {
			if (f.isAnnotationPresent(Autowired.class)
					|| f.isAnnotationPresent(Inject.class)) {

				Object mockObje = Mockito.mock(f.getType());
				f.setAccessible(true);

				try {
					f.set(mockIbj, mockObje);
				} catch (Exception e) {
					e.printStackTrace();
				}
				f.setAccessible(false);
			}
		}
	}

	@Before
	public abstract void inti();

}
