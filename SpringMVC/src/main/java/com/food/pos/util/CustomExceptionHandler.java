package com.food.pos.util;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomExceptionHandler.class);
	private final ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator();

		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();

			Throwable t = context.getException();

			try {

				Throwable rootException = ExceptionUtils.getRootCause(t);

				FacesMessage facesMsg = new FacesMessage(
						FacesMessage.SEVERITY_INFO, rootException.getMessage(),
						null);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);

				logger.error("Severe Exception Occured");
				logger.error("rootException:{}", rootException);

			} finally {
				// remove it from queue
				i.remove();
			}
		}
		// parent hanle
		getWrapped().handle();
	}

	@Override
	public javax.faces.context.ExceptionHandler getWrapped() {
		// TODO Auto-generated method stub
		return this.wrapped;
	}

}
