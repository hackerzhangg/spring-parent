package com.emily.infrastructure.logback;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Emily
 * @description: 日志配置属性
 * @create: 2020/08/08
 */
@ConfigurationProperties(prefix = LogbackProperties.PREFIX)
public class LogbackProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "spring.emily.logback";
    /**
     * 是否开启日志组件，默认：false
     */
    private boolean enabled;
    /**
     * 是否报告内部状态信息，默认；false
     */
    private boolean reportState;
    /**
     * 日志文件存放路径，默认是:./logs
     */
    private String path = "./logs";
    /**
     * 是否开启基于文件大小和时间的SizeAndTimeBasedRollingPolicy归档策略
     * 默认是基于TimeBasedRollingPolicy的时间归档策略，默认false
     */
    private boolean sizeAndTimeRollingPolicy;
    /**
     * 设置要保留的最大存档文件数,默认 7
     */
    private int maxHistory = 7;
    /**
     * 最大日志文件大小 KB、MB、GB，默认500MB
     */
    private String maxFileSize = "500MB";
    /**
     * 文件总大小限制 KB、MB、GB，默认5GB
     */
    private String totalSizeCap = "5GB";
    /**
     * 基础根日志
     */
    private Root root = new Root();
    /**
     * 分组记录日志
     */
    private Group group = new Group();
    /**
     * 按模块记录日志
     */
    private Module module = new Module();
    /**
     * 异步日志配置
     */
    private Async async = new Async();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isReportState() {
        return reportState;
    }

    public void setReportState(boolean reportState) {
        this.reportState = reportState;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMaxHistory() {
        return maxHistory;
    }

    public void setMaxHistory(int maxHistory) {
        this.maxHistory = maxHistory;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(String maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getTotalSizeCap() {
        return totalSizeCap;
    }

    public void setTotalSizeCap(String totalSizeCap) {
        this.totalSizeCap = totalSizeCap;
    }

    public boolean isSizeAndTimeRollingPolicy() {
        return sizeAndTimeRollingPolicy;
    }

    public void setSizeAndTimeRollingPolicy(boolean sizeAndTimeRollingPolicy) {
        this.sizeAndTimeRollingPolicy = sizeAndTimeRollingPolicy;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Async getAsync() {
        return async;
    }

    public void setAsync(Async async) {
        this.async = async;
    }

    /**
     * OFF > ERROR > WARN > INFO > DEBUG > TRACE >ALL
     */
    public enum Level {
        OFF("OFF"), ERROR("ERROR"), WARN("WARN"), INFO("INFO"), DEBUG("DEBUG"), TRACE("TRACE"), ALL("ALL");

        public String levelStr;

        Level(String levelStr) {
            this.levelStr = levelStr;
        }
    }

    public static class Root {
        /**
         * 日志级别，OFF > ERROR > WARN > INFO > DEBUG >TRACE > ALL, 默认：DEBUG
         */
        private Level level = Level.INFO;
        /**
         * 可以打印当前类名格式，默认：[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] [%p (%file:%line\\)] : %msg%n
         * 通用日志输出格式：[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] [%-5level] [%-36.36logger{36}:%-4.4line] : %msg%n
         */
        private String pattern = "[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] [%-5level] [%-36.36logger{36}:%-4.4line] : %msg%n";

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class Group {
        /**
         * 模块输出的日志级别，ERROR > WARN > INFO > DEBUG >TRACE, 默认：DEBUG
         */
        private Level level = Level.INFO;
        /**
         * 模块日志输出格式，默认：%msg%n
         */
        private String pattern = "[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] [%-5level] [%-36.36logger{36}:%-4.4line] : %msg%n";
        /**
         * 是否将模块日志信息输出到控制台，默认false
         */
        private boolean console = false;

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public boolean isConsole() {
            return console;
        }

        public void setConsole(boolean console) {
            this.console = console;
        }
    }

    public static class Module {
        /**
         * 模块输出的日志级别，ERROR > WARN > INFO > DEBUG >TRACE, 默认：DEBUG
         */
        private Level level = Level.INFO;
        /**
         * 模块日志输出格式，默认：%msg%n
         */
        private String pattern = "[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] [%-5level] [%-36.36logger{36}:%-4.4line] : %msg%n";
        /**
         * 是否将模块日志信息输出到控制台，默认false
         */
        private boolean console = false;

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public boolean isConsole() {
            return console;
        }

        public void setConsole(boolean console) {
            this.console = console;
        }
    }

    public static class Async {
        /**
         * 是否启用日志异步记录Appender
         */
        private boolean enabled;
        /**
         * 队列的最大容量，默认为 256
         */
        private int queueSize = 256;
        /**
         * 默认，当队列还剩余 20% 的容量时，会丢弃级别为 TRACE, DEBUG 与 INFO 的日志，仅仅只保留 WARN 与 ERROR 级别的日志。想要保留所有的事件，可以设置为 0
         */
        private int discardingThreshold;
        /**
         * 根据所引用 appender 队列的深度以及延迟， AsyncAppender 可能会耗费长时间去刷新队列。
         * 当 LoggerContext 被停止时， AsyncAppender stop 方法会等待工作线程指定的时间来完成。
         * 使用 maxFlushTime 来指定最大的刷新时间，单位为毫秒。在指定时间内没有被处理完的事件将会被丢弃。这个属性的值的含义与 Thread.join(long)) 相同
         * 默认是 1000毫秒
         */
        private int maxFlushTime = 1000;
        /**
         * 在队列满的时候 appender 会阻塞而不是丢弃信息。设置为 true，appender 不会阻塞你的应用而会将消息丢弃，默认为 false
         */
        private boolean neverBlock;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public int getQueueSize() {
            return queueSize;
        }

        public void setQueueSize(int queueSize) {
            this.queueSize = queueSize;
        }

        public int getDiscardingThreshold() {
            return discardingThreshold;
        }

        public void setDiscardingThreshold(int discardingThreshold) {
            this.discardingThreshold = discardingThreshold;
        }

        public int getMaxFlushTime() {
            return maxFlushTime;
        }

        public void setMaxFlushTime(int maxFlushTime) {
            this.maxFlushTime = maxFlushTime;
        }

        public boolean isNeverBlock() {
            return neverBlock;
        }

        public void setNeverBlock(boolean neverBlock) {
            this.neverBlock = neverBlock;
        }
    }
}
