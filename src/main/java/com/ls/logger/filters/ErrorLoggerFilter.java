package com.ls.logger.filters;

import com.ls.logger.adapter.LoggerProcessorAdapter;
import com.ls.logger.processors.LoggerProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.PerformanceSensitive;

@Plugin(
        name = "ErrorLoggerFilter",
        category = "Core",
        elementType = "filter",
        printObject = true
)
@PerformanceSensitive({"allocation"})
public class ErrorLoggerFilter extends AbstractFilter {
    private final Level level;
    private LoggerProcessorAdapter adapter;
    private ErrorLoggerFilter(Level level, Result onMatch, Result onMismatch, LoggerProcessor loggerProcessor) {
        super(onMatch, onMismatch);
        this.adapter = LoggerProcessorAdapter.getInstance();
        this.adapter.setProcessor(loggerProcessor);
        this.level = level;
    }

    public Result filter(Logger logger, Level testLevel, Marker marker, String msg, Object... params) {
        return this.filter(testLevel);
    }

    public Result filter(Logger logger, Level testLevel, Marker marker, Object msg, Throwable t) {
        return this.filter(testLevel);
    }

    public Result filter(Logger logger, Level testLevel, Marker marker, Message msg, Throwable t) {
        return this.filter(testLevel);
    }

    public Result filter(LogEvent event) {
        if(Level.ERROR == event.getLevel()){
            this.adapter.getProcessor().processor(event);
        }
        return this.filter(event.getLevel());
    }

    private Result filter(Level testLevel) {
        return testLevel.isMoreSpecificThan(this.level) ? this.onMatch : this.onMismatch;
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        return this.filter(level);
    }

    public Result filter(Logger logger, Level level, Marker marker, String msg, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        return this.filter(level);
    }

    public Level getLevel() {
        return this.level;
    }

    public String toString() {
        return this.level.toString();
    }
    @PluginFactory
    public static ErrorLoggerFilter createFilter(@PluginAttribute("level") Level level, @PluginAttribute("onMatch") Result match, @PluginAttribute("onMismatch") Result mismatch, @PluginAttribute("class") String sendClass) {
        Level actualLevel = level == null ? Level.ERROR : level;
        Result onMatch = match == null ? Result.NEUTRAL : match;
        Result onMismatch = mismatch == null ? Result.DENY : mismatch;
        LoggerProcessor loggerProcessor = null;
        try {
            loggerProcessor = (LoggerProcessor) Class.forName(sendClass).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return new ErrorLoggerFilter(actualLevel, onMatch, onMismatch,loggerProcessor);
    }

}
