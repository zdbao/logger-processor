package com.ls.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志标记。
 * @date: 2019年02月15日
 * @author: leslie.zhang
 */
public class LoggerMarker {
    //日志出现的类名
    private String className;
    //异常名
    private String thrownName;
    //错误信息
    private String message;
    //异常堆
    private List<Stack> stack = new ArrayList<Stack>();
    public LoggerMarker(String className,String message){
        this.className = className;
        this.message = message;
    }

    public String getClassName() {
        return className;
    }

    /**
     * 将异常堆最顶部的异常类名设置为日志标记的类名。
     * @date: 2019年02月15日
     * @author: leslie.zhang
     */
    public void setClassName() {
        if(this.stack.size() > 0){
            this.className = this.stack.get(0).name;
        }
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Stack> getStack() {
        return stack;
    }

    public String getThrownName() {
        return thrownName;
    }

    public void setThrownName(String thrownName) {
        this.thrownName = thrownName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addStack(String name, int lineNum) {
        this.stack.add(new Stack(name,lineNum));
    }

    class Stack{
        private String name;
        private int lineNum;

        public Stack(String name, int lineNum) {
            this.name = name;
            this.lineNum = lineNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLineNum() {
            return lineNum;
        }

        public void setLineNum(int lineNum) {
            this.lineNum = lineNum;
        }
    }

}
