package com.openhackathon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogGenerator { 

	private static final Logger LOG = LoggerFactory.getLogger(LogGenerator.class);

	@Scheduled(fixedRate = 100)
	public void create() {
		double type = Math.random();
		if (type % 2 == 0) {
			LOG.info("Service completed successfully!");
		} else if (type % 3 == 0) {
			LOG.warn("Service completed with warning {}", "Check request");
		} else {
			try {
				throw new NullPointerException();
			} catch (Exception ex) {
				LOG.error("Service completed with error {}", ex.getMessage());
			}
		}
	}

}
