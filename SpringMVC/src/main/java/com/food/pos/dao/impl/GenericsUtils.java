/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */
package com.food.pos.dao.impl;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class GenericsUtils {

	/**
	 * 通過反射,獲得定義Class時聲明的父類的泛型參數的類型. 如public BookManager extends
	 * GenricManager<Book>
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if
	 *         cannot be determined
	 */
	@SuppressWarnings("rawtypes")
	public static final Class getSuperClassGenricType(final Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通過反射,獲得定義Class時聲明的父類的泛型參數的類型. 如public BookManager extends
	 * GenricManager<Book>
	 * 
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 */
	@SuppressWarnings("rawtypes")
	public static final Class getSuperClassGenricType(final Class clazz, final int index) throws IndexOutOfBoundsException {
		final Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		final Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	// ====
	// == [Method] Block End
	// ================================================
}
