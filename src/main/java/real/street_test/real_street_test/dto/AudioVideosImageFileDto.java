package real.street_test.real_street_test.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AudioVideosImageFileDto {

    private MultipartFile audio;
    private MultipartFile video;
    private MultipartFile image;



}
