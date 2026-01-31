package com.sinodash.sb.logging_log4j2.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class LogController {

    @GetMapping("/log")
	public String log() {
        String appName = "Logger";
		// Logging various log level messages
        log.trace("Log level {}: TRACE", appName);
        log.info("Log level {}: INFO", appName);
        log.debug("Log level {}: DEBUG", appName);
        log.error("Log level {}: ERROR", appName);
        log.warn("Log level {}: WARN", appName);
  
        return "Hey! You can check the output in the logs";
	}
}
