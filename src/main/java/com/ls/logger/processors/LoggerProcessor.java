package com.ls.logger.processors;
import com.ls.logger.LoggerMarker;
import org.apache.logging.log4j.core.LogEvent;

public interface LoggerProcessor {
    LoggerMarker processor(LogEvent event);
    LoggerMarker parseLogger(LogEvent event);
    LoggerMarker parseLogger(Throwable e);
}
