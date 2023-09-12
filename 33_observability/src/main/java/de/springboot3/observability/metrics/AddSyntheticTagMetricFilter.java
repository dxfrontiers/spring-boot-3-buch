package de.springboot3.observability.metrics;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Component
public class AddSyntheticTagMetricFilter implements MeterFilter {

    private final Environment environment;

    public AddSyntheticTagMetricFilter(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Meter.Id map(Meter.Id id) {
        Boolean synthetic = Boolean.FALSE;
        if (id.getName().equals("currentUsers") &&
                isSyntheticUser(id.getTag("userName"))) {
            synthetic = Boolean.TRUE;
        }
        return id.withTag(Tag.of("synthetic", synthetic.toString()))
                .replaceTags(removeTag(id, "userName"));
    }

    private boolean isSyntheticUser(String userName) {
        return userName != null && userName.startsWith("synthetic-");
    }

    private List<Tag> removeTag(Meter.Id id, String tagToRemove) {
        return stream(id.getTagsAsIterable().spliterator(), false).filter(t -> !t.getKey().equals(tagToRemove)).collect(toList());
    }
}
