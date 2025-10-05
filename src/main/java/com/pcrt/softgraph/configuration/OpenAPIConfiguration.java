package com.pcrt.softgraph.configuration;

import com.pcrt.softgraph.service.AuthenticationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "softgraph",
                version = "v1.0",
                summary = "Backend application to store software architecture metadata."
        ),
        security = {@SecurityRequirement(name = "API Key")}
)
@SecurityScheme(
        name = "API Key",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        paramName = AuthenticationService.API_KEY_HEADER_NAME)
public class OpenAPIConfiguration {
}
