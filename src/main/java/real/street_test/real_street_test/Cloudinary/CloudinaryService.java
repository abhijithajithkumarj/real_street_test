package real.street_test.real_street_test.Cloudinary;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
public interface CloudinaryService {
    Map upload(MultipartFile file, String folder);

    Map<String, Object> uploadVideo(MultipartFile file, String folder);


    Map<String, Object> uploadAudio(MultipartFile file, String folder);

}
