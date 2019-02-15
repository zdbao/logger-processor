package com.ls.logger.processors;

import com.ls.logger.LoggerMarker;
import org.apache.logging.log4j.core.LogEvent;

/**
 * 异常日志处理器。 过滤信息保存在本地。集群方式会出现同一个错误输出多次的问题。
 * @date: 2019年02月15日
 * @author: leslie.zhang
 */
public class ErrorLoggerLocalProcessor extends AbstractLoggerProcessor {

    public LoggerMarker processor(LogEvent event) {
        return super.parseLogger(event);
    }

}
