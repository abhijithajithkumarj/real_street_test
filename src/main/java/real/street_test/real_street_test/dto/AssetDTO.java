package real.street_test.real_street_test.dto;

import lombok.*;
import real.street_test.real_street_test.entity.Audio;
import real.street_test.real_street_test.entity.Image;
import real.street_test.real_street_test.entity.Video;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetDTO {
    private List<Image> images;
    private List<Audio> audios;
    private List<Video> videos;
}
