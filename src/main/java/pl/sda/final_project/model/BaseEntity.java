package pl.sda.final_project.model;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {

    /**
     * <code>@GenerationValue<code/> define primary key
     * the worst solution is to use <code>@Table<code/>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        /**
         * down casting to <code>BaseEntity<code/>
         */
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
