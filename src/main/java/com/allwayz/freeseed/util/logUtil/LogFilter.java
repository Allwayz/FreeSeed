package com.allwayz.freeseed.util.logUtil;

import ch.qos.logback.classic.spi.ILoggingEvent;

import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.allwayz.freeseed.model.entity.LoggerMessage;

import java.text.DateFormat;
import java.util.Date;


public class LogFilter extends Filter {
    @Override
    public FilterReply decide(Object o) {
        ILoggingEvent event = null;
        LoggerMessage loggerMessage = new LoggerMessage(
                event.getMessage()
                , DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())),
                event.getThreadName(),
                event.getLoggerName(),
                event.getLevel().levelStr
        );
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}
