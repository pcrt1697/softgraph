package com.pcrt.softgraph.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "softgraph",
                version = "v1.0",
                summary = "Backend application to store software architecture metadata."
        )
)
public class OpenAPIConfiguration {
}
