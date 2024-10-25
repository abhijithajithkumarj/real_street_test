package real.street_test.real_street_test.entity;


import org.springframework.web.multipart.MultipartFile;
import real.street_test.real_street_test.BaseEntity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AudioVideosImageFile extends BaseEntity {


    private String audio;
    private String audioPublicId;

    private String video;
    private String videoPublicId;

    private String image;
    private String imagePublicId;


    private String createdAudio;
    private String createdVideo;
    private String createdImage;



}
