package com.pcrt.softgraph.model.page;

import com.pcrt.softgraph.model.entity.database.DatabaseTechnology;
import com.pcrt.softgraph.model.node.database.DatabaseNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Getter
@Setter
public class DatabasePageQuery extends PageQuery<DatabaseNode> {

    private static final ExampleMatcher MATCHER = ExampleMatcher.matching()
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withMatcher("technology", ExampleMatcher.GenericPropertyMatchers.exact())
            .withMatcher("hostname", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains())
            .withIgnoreNullValues();

    private String name;
    private String description;
    private DatabaseTechnology technology;
    private String hostname;
    private String chronExpression;

    @Override
    public Example<DatabaseNode> toExample() {
        DatabaseNode node = new DatabaseNode();
        node.setName(this.name);
        node.setDescription(this.description);
        node.setTechnology(this.technology);
        node.setHostname(this.hostname);
        return Example.of(node, MATCHER);
    }

}
