package com.yawthinking.webapp.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

@Controller
public class InformationController implements EnvironmentAware {

    private static final LocalDateTime StartedAt = LocalDateTime.now();
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy MMM dd h:mm a, EEE", Locale.TAIWAN);

    private final WebApplicationContext webAppContext;
    private Environment environment;

    @Autowired
    public InformationController(WebApplicationContext applicationContext) {
        super();
        this.webAppContext = applicationContext;
    }

    @Override
    public void setEnvironment(@NotNull Environment environment) {
        this.environment = environment;
    }

    @RequestMapping(path = "/information/server", produces = "text/html")
    @ResponseBody
    public String server() {
        return new StringJoiner("<br>")
                .add("-------------------------------------------------------------")
                .add("Server: " + Objects.requireNonNull(webAppContext.getServletContext()).getServerInfo())
                .add("Started at: " + StartedAt.format(DATE_TIME_FORMATTER))
                .add("Version: " + environment.getProperty("webapp.version", "0.0.1"))
                .add("-------------------------------------------------------------")
                .toString();
    }

}
