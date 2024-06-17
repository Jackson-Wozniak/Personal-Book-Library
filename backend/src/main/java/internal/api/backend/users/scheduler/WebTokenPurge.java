package internal.api.backend.users.scheduler;

import internal.api.backend.users.properties.SchedulingProperties;
import internal.api.backend.users.service.WebTokenService;
import internal.api.backend.users.utils.DateFormatting;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class WebTokenPurge{

    private final WebTokenService webTokenService;
    private final Logger logger = LoggerFactory.getLogger(WebTokenPurge.class);

    @Scheduled(cron = SchedulingProperties.runAtMidnight)
    public void execute(){
        long deleted = webTokenService.deleteExpiredTokens();
        logger.info("Tokens purged on {}: {}", findDate(), deleted);
    }

    public static String findDate(){
        return DateFormatting.toWords(LocalDateTime.now());
    }
}
