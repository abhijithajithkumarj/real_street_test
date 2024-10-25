package real.street_test.real_street_test.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import real.street_test.real_street_test.BaseEntity.BaseEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Audio extends BaseEntity {

    private String audio;
    private String audioPublicId;
    private String createdAt;
    private String fileType;
    private String lastModification;
    private Integer size;


}
