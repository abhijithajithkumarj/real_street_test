package real.street_test.real_street_test.Cloudinary;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Service
public class CloudinaryServiceImp implements CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map upload(MultipartFile file, String folder) {
        try {
            Map options = ObjectUtils.asMap("folder", folder);
            Map data = cloudinary.uploader().upload(file.getBytes(), options);
            String imageUrl = (String) data.get("secure_url");
            System.out.println("Image Url" + imageUrl);
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed !");
        }

    }

    @Override
    public Map uploadVideo(MultipartFile file, String folder) {
        try {
            Map options = ObjectUtils.asMap(
                    "folder", folder,
                    "resource_type", "video"
            );
            Map data = cloudinary.uploader().upload(file.getBytes(), options);


            String videoUrl = (String) data.get("secure_url");
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Video uploading failed !");
        }
    }

    @Override
    public Map uploadAudio(MultipartFile file, String folder) {

        try {
            Map params = ObjectUtils.asMap(
                    "folder", folder,
                    "resource_type", "auto"
            );
            return cloudinary.uploader().upload(file.getBytes(), params);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file", e);
        }
    }

}