package com.pcrt.softgraph.model.page;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.model.node.microservice.MicroserviceNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Getter
@Setter
public class MicroservicePageQuery extends PageQuery<MicroserviceNode> {

    private static final ExampleMatcher MATCHER = ExampleMatcher.matching()
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withMatcher("programmingLanguage", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("repositoryUrl", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withMatcher("serviceUrl", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withIgnoreNullValues();

    private String name;
    private String description;
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String serviceUrl;

    @Override
    public Example<MicroserviceNode> toExample() {
        MicroserviceNode node = new MicroserviceNode();
        node.setName(this.name);
        node.setDescription(this.description);
        node.setProgrammingLanguage(this.programmingLanguage);
        node.setRepositoryUrl(this.repositoryUrl);
        node.setServiceUrl(this.serviceUrl);
        return Example.of(node, MATCHER);
    }

}
