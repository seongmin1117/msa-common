package common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@ToString
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    protected UUID id = UUID.randomUUID();

    public void setId(final UUID id) {
        this.id = (id != null) ? id : UUID.randomUUID();
    }
}
