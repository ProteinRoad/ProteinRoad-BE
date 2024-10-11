package konkuk.proteinroad.domain.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Enumerated(EnumType.STRING)
    protected ActiveStatus status;

    protected Timestamp createdAt;

    protected Timestamp updatedAt;

    protected BaseEntity() {
        this.status = ActiveStatus.ACTIVE;
    }

    protected void delete() {
        this.status = ActiveStatus.INACTIVE;
    }
}
