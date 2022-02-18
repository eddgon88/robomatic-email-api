package cl.robomatic.email.v1.utils;


import cl.robomatic.email.v1.dtos.utils.ExceptionTrace;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static ExceptionTrace getExceptionTrace(Exception e) {
        return ExceptionTrace.builder()
            .message(e.getMessage())
            .stackTrace(getStackTrace(e))
            .build();
    }

    private static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
