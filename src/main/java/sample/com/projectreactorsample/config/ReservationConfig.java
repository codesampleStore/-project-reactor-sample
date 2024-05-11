package sample.com.projectreactorsample.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix="project.reactor.sample")
@Validated
@Data
public class ReservationConfig {

  @NotNull
  private String dbName;
  private String userName;
}
