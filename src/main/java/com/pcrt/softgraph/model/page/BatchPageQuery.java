package com.pcrt.softgraph.model.page;

import com.pcrt.softgraph.model.entity.ProgrammingLanguage;
import com.pcrt.softgraph.model.node.batch.BatchNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Getter
@Setter
public class BatchPageQuery extends PageQuery<BatchNode> {

    private static final ExampleMatcher MATCHER = ExampleMatcher.matching()
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withMatcher("programmingLanguage", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("repositoryUrl", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withMatcher("chronExpression", ExampleMatcher.GenericPropertyMatchers.startsWith())
            .withIgnoreNullValues();

    private String name;
    private String description;
    private ProgrammingLanguage programmingLanguage;
    private String repositoryUrl;
    private String chronExpression;

    @Override
    public Example<BatchNode> toExample() {
        BatchNode node = new BatchNode();
        node.setName(this.name);
        node.setDescription(this.description);
        node.setProgrammingLanguage(this.programmingLanguage);
        node.setRepositoryUrl(this.repositoryUrl);
        node.setChronExpression(this.chronExpression);
        return Example.of(node, MATCHER);
    }

}
