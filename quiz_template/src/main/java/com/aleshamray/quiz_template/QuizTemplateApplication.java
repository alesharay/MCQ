package com.aleshamray.quiz_template;

//import com.aleshamray.quiz_template.services.ExamServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

import static com.aleshamray.quiz_template.constants.Colors.*;

@SpringBootApplication(scanBasePackages = "com.aleshamray.quiz_template")
@EnableMongoRepositories
@AutoConfiguration
public class QuizTemplateApplication {

  private static final Logger log = LoggerFactory.getLogger(QuizTemplateApplication.class);
  @Autowired
  private Environment env;


  @Bean
  RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  /**  Main method, used to run the application. */
  @SuppressWarnings("unused")
  public static void main(String[] args) throws IOException {
    ConfigurableApplicationContext ctx = SpringApplication.run(QuizTemplateApplication.class, args);

//    run(args);

//    ctx.close();
  }


//  private static ExamServiceUtil examServiceUtil;
//
//  @Autowired
//  public void setExamServiceUtil(ExamServiceUtil e) {
//    examServiceUtil = e;
//  }
//
//  public static void run(String[] args) throws IOException {
//    examServiceUtil.run(args);
//  }


  @EventListener(ApplicationReadyEvent.class)
  public void postStartup() {
    String protocol = env.getProperty("server.ssl.key-store") != null ? "https" : "http";
    String serverPort = env.getRequiredProperty("server.port");
    String contextPath = env.getRequiredProperty("server.servlet.context-path");
    String hostAddress = env.getRequiredProperty("server.host-address");

    if( !StringUtils.hasLength(contextPath)) { contextPath = "/"; }

    try {
      hostAddress = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException uhe) {
      log.warn("The host name could not be determined, using 'localhost' as fallback");
    }

    StringBuffer consoleMsg = new StringBuffer();
    consoleMsg.append(ANSI_PURPLE + "\n\t________________________________________________________________" + ANSI_RESET);
    consoleMsg.append(ANSI_BLUE + "\n\t Application is running! Access URLs:");
    consoleMsg.append("\n\t".concat(String.format(" Local: \t%s://localhost:%s%s", protocol, serverPort, contextPath)));
    consoleMsg.append("\n\t".concat(String.format(" External: \t%s://%s:%s%s", protocol, hostAddress, serverPort, contextPath)));
    consoleMsg.append("\n\t".concat(String.format(" Profile(s): \t%s", Arrays.toString(env.getActiveProfiles()) + ANSI_RESET)));
    consoleMsg.append(ANSI_PURPLE + "\n\t________________________________________________________________" + ANSI_RESET);

    log.info(consoleMsg.toString());
  }
}
