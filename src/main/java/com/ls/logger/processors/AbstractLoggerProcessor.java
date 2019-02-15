package com.ls.logger.processors;


import com.ls.logger.LoggerMarker;
import org.apache.logging.log4j.core.LogEvent;

/**
 * 日志处理器抽象类，提供基本的日志解析功能。包含一个抽象的处理方法。
 * @date: 2019年02月15日
 * @author: leslie.zhang
 */
public abstract class AbstractLoggerProcessor implements LoggerProcessor {

    public AbstractLoggerProcessor() {
    }

    /**
     * 日志处理的抽象方法
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public abstract LoggerMarker processor(LogEvent event);

    /**
     * 解析log4j的日志
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public LoggerMarker parseLogger(LogEvent event) {
        return parseLogger(new LoggerMarker(event.getLoggerName(),event.getMessage().toString()),event.getThrown());
    }
    /**
     * 解析throwable
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public LoggerMarker parseLogger(Throwable e){
        LoggerMarker marker = parseLogger(new LoggerMarker(null, null), e);
        //设置类名
        marker.setClassName();
        return marker;
    }

    private LoggerMarker parseLogger(LoggerMarker marker,Throwable e){
        if(marker == null){
            return null;
        }
        if(e != null) {
            StackTraceElement[] errorMessage = e.getStackTrace();
            marker.setThrownName(e.toString());
            for (StackTraceElement element : errorMessage) {
                marker.addStack(element.getClassName(), element.getLineNumber());
            }
        }
        return marker;
    }
}
