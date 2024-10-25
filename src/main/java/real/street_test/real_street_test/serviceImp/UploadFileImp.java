package real.street_test.real_street_test.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import real.street_test.real_street_test.Cloudinary.CloudinaryServiceImp;
import real.street_test.real_street_test.dto.AssetDTO;
import real.street_test.real_street_test.entity.Audio;
import real.street_test.real_street_test.entity.AudioVideosImageFile;
import real.street_test.real_street_test.entity.Image;
import real.street_test.real_street_test.entity.Video;
import real.street_test.real_street_test.repo.AudioRepo;
import real.street_test.real_street_test.repo.AudioVideosImageFileRepo;
import real.street_test.real_street_test.repo.ImageRepo;
import real.street_test.real_street_test.repo.VideoRepo;
import real.street_test.real_street_test.service.UploadFile;

import java.util.List;
import java.util.Map;

@Service
public class UploadFileImp implements UploadFile {
    @Autowired
    private CloudinaryServiceImp cloudinaryServiceImp;

    @Autowired
    private AudioVideosImageFileRepo audioVideosImageFileRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private ImageRepo imageRepo;



    @Autowired
    private AudioRepo audioRepo;

    @Override
    public void uploadFile(MultipartFile imageFile, MultipartFile audioFil, MultipartFile videoFile) {
        AudioVideosImageFile file = new AudioVideosImageFile();
        uploadImage(imageFile);
        uploadAudio(audioFil);
        uploadVideo(videoFile);

    }



    @Override
    public String uploadImage(MultipartFile imageFile) {
        try {
             Map imageData=cloudinaryServiceImp.upload(imageFile,"image_realsreet");


            if (imageData != null) {
                Image file = new Image();
                file.setImagePublicId((String) imageData.get("public_id"));
                file.setImage((String) imageData.get("secure_url"));
                file.setFileType((String) imageData.get("resource_type"));
                file.setSize((Integer) imageData.get("bytes"));
                file.setCreatedAt((String) imageData.get("created_at"));
                file.setLastModification((String) imageData.get("created_at"));
                imageRepo.save(file);
                return "Image uploaded successfully";
            }
            return "Image upload failed: No data received.";
        } catch (Exception e) {
            return "Image upload failed: " + e.getMessage();
        }
    }




    @Override
    public String uploadAudio(MultipartFile audioFile) {



        try {
            Map audioData = cloudinaryServiceImp.uploadAudio(audioFile,"audio_realsreet");


            if (audioData != null) {
                Audio file = new Audio();
                file.setAudioPublicId((String) audioData.get("public_id"));
                file.setAudio((String) audioData.get("secure_url"));
                file.setFileType((String) audioData.get("resource_type"));
                file.setSize((Integer) audioData.get("bytes"));
                file.setCreatedAt((String) audioData.get("created_at"));
                file.setLastModification((String) audioData.get("created_at"));
                audioRepo.save(file);
                return "Audio uploaded successfully";
            }
            return "Audio upload failed: No data received.";
        } catch (Exception e) {
            return "Audio upload failed: " + e.getMessage();
        }
    }





    @Override
    public String uploadVideo(MultipartFile videoFile) {
        try {
            Map videoData = cloudinaryServiceImp.uploadVideo(videoFile,"video_realsreet");


            if (videoData != null) {
                Video file = new Video();
                file.setVideoPublicId((String) videoData.get("public_id"));
                file.setVideo((String) videoData.get("secure_url"));
                file.setFileType((String) videoData.get("resource_type"));
                file.setSize((Integer) videoData.get("bytes"));
                file.setCreatedAt((String) videoData.get("created_at"));
                file.setLastModification((String) videoData.get("created_at"));
                videoRepo.save(file);
                return "Video uploaded successfully";
            }
            return "Video upload failed: No data received.";
        } catch (Exception e) {
            return "Video upload failed: " + e.getMessage();
        }
    }

    @Override
    public AssetDTO getAllAssets()  {
        AssetDTO assetDTO = new AssetDTO();

        List<Image> images = imageRepo.findAll();
        List<Audio> audios = audioRepo.findAll();
        List<Video> videos = videoRepo.findAll();

        assetDTO.setImages(images);
        assetDTO.setAudios(audios);
        assetDTO.setVideos(videos);

        return assetDTO;
    }


}
