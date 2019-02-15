package com.ls.logger.adapter;

import com.ls.logger.LoggerMarker;
import com.ls.logger.processors.LoggerProcessor;

/**
 * 日志处理适配器
 * @date: 2019年02月15日
 * @author: leslie.zhang
 */
public class LoggerProcessorAdapter {
    private LoggerProcessor processor;

    private LoggerProcessorAdapter(){

    }

    /**
     * 添加一个异常，通过适配器中指定的处理器处理
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public LoggerMarker add(Throwable e){
        if(processor != null){
            return processor.parseLogger(e);
        }
        return null;
    }

    /**
     * 使用指定的处理器处理异常。
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public LoggerMarker send(LoggerProcessor processor,Throwable e){
        if(processor != null){
            return processor.parseLogger(e);
        }
        return null;
    }


    private static class SingletonInstance {
        private static final LoggerProcessorAdapter INSTANCE = new LoggerProcessorAdapter();
    }

    public static LoggerProcessorAdapter getInstance(){
        return  SingletonInstance.INSTANCE;
    }

    public LoggerProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(LoggerProcessor processor) {
        this.processor = processor;
    }
}
