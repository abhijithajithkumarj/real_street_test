package real.street_test.real_street_test.entity;

import jakarta.persistence.Entity;
import lombok.*;
import real.street_test.real_street_test.BaseEntity.BaseEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Video  extends BaseEntity {

    private String video;
    private String videoPublicId;
    private String createdAt;
    private String fileType;
    private String lastModification;
    private Integer size;
}
