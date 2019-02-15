package com.ls.logger.processors;

import com.ls.logger.LoggerMarker;
import org.apache.logging.log4j.core.LogEvent;

/**
 * 异常日志处理器，会将过滤信息存放在redis中。
 * @date: 2019年02月15日
 * @author: leslie.zhang
 */
public class ErrorLoggerRedisProcessor extends AbstractLoggerProcessor {

    public LoggerMarker processor(LogEvent event) {
        return super.parseLogger(event);
    }
}
