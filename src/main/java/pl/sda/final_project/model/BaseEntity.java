package pl.sda.final_project.model;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {

    /**
     * <code>@GenerationValue<code/> define primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Long version;

    /**
     * down casting to <code>BaseEntity<code/>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BaseEntity sent = (BaseEntity) o;
        return Objects.equals(id, sent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }
}
