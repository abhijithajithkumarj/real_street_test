package real.street_test.real_street_test.service;

import org.springframework.web.multipart.MultipartFile;
import real.street_test.real_street_test.dto.AssetDTO;
import real.street_test.real_street_test.dto.AudioVideosImageFileDto;
import real.street_test.real_street_test.entity.AudioVideosImageFile;
import real.street_test.real_street_test.repo.AudioVideosImageFileRepo;

import java.util.List;
import java.util.Map;

public interface UploadFile {
    void uploadFile(MultipartFile imageFile,MultipartFile audioFil,MultipartFile videoFile);

    String uploadImage(MultipartFile imageFile);

    public String uploadAudio(MultipartFile audioFile);

    public String uploadVideo(MultipartFile videoFile);

    AssetDTO getAllAssets() ;
}
