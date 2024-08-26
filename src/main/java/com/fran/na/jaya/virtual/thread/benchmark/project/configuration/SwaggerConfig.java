package com.fran.na.jaya.virtual.thread.benchmark.project.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "application.swagger.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {

  private final BuildProperties buildProperties;
  private final GitProperties gitProperties;
  private final ObjectMapper objectMapper;
  private final String applicationName;

  @Autowired
  public SwaggerConfig(
      Optional<BuildProperties> buildPropertiesOpt,
      Optional<GitProperties> gitPropertiesOpt,
      ObjectMapper objectMapper,
      @Value("${spring.application.name}")
      String springApplicationName
  ) {
    this.buildProperties = buildPropertiesOpt.orElseGet(() -> {
      Properties properties = new Properties();
      properties.setProperty("name", "service");
      properties.setProperty("version", "-");
      return new BuildProperties(properties);
    });

    this.gitProperties = gitPropertiesOpt.orElse(new GitProperties(new Properties()));

    this.objectMapper = objectMapper;

    this.applicationName = StringUtils.hasText(springApplicationName) ?
        springApplicationName :
        this.buildProperties.getName();
  }

  @Bean
  public OpenAPI globalConfig() {
    return new OpenAPI()
        .info(new Info()
            .title(applicationName)
            .version(buildProperties.getVersion())
        )
        .tags(Arrays.asList(
            new Tag().name("git.branch")
                .description(gitProperties.getBranch()),
            new Tag().name("git.commit.id")
                .description(gitProperties.getCommitId()),
            new Tag().name("git.commit.message.full")
                .description(gitProperties.get("commit.message.full")),
            new Tag().name("git.commit.time")
                .description(Objects.isNull(gitProperties.getCommitTime()) ?
                    "" :
                    String.valueOf(gitProperties.getCommitTime())
                )
        ));
  }

  /**
   * customize swagger to fix
   * <a href="https://github.com/springdoc/springdoc-openapi/issues/1281">this issue</a>
   *
   * @return OpenApiCustomizer
   */
  @Bean
  public GlobalOpenApiCustomizer sortByOperationTagCustomizer() {
    return openApi -> {
      Paths paths = openApi
          .getPaths()
          .entrySet()
          .stream()
          .sorted(Comparator.comparing(entry -> getOperationTag(entry.getValue())))
          .collect(Paths::new, (map, item) -> map.addPathItem(item.getKey(), item.getValue()),
              Paths::putAll);

      openApi.setPaths(paths);
    };
  }

  private String getOperationTag(PathItem pathItem) {
    return Stream.of(
            pathItem.getGet(),
            pathItem.getPost(),
            pathItem.getPut(),
            pathItem.getPatch(),
            pathItem.getDelete(),
            pathItem.getHead(),
            pathItem.getOptions(),
            pathItem.getTrace()
        )
        .filter(Objects::nonNull)
        .map(Operation::getTags)
        .flatMap(Collection::stream)
        .findFirst()
        .orElse("");
  }

  /**
   * Customize swagger so that every API has operationId with custom format, <br/>e.g.:
   * <i>coin-trading_orderBuyControllerV1_create</i>
   * <p>
   * Java Method Overloading in controller is now allowed because it will yield duplicate
   * operationId, which will violate operationId's unique <a
   * href="https://spec.openapis.org/oas/v3.0.2#fixed-fields-5">constraint</a>!
   *
   * @return OpenApiCustomizer
   */
  @Bean
  public OperationCustomizer operationIdCustomizer() {
    return (operation, handlerMethod) -> {
      String beanName = String.valueOf(handlerMethod.getBean());
      String methodName = handlerMethod.getMethod().getName();

      operation.setOperationId(String.format("%s_%s_%s",
          applicationName,
          beanName,
          methodName
      ));
      return operation;
    };
  }
}
