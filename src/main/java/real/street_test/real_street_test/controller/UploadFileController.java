package real.street_test.real_street_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import real.street_test.real_street_test.dto.AssetDTO;
import real.street_test.real_street_test.entity.AudioVideosImageFile;
import real.street_test.real_street_test.service.UploadFile;

import java.util.List;

@RestController
@RequestMapping("/v1/assets")
public class UploadFileController {

    @Autowired
    private UploadFile uploadFile;

    @GetMapping
    public ResponseEntity<AssetDTO> getAllAssets() {
        AssetDTO assets = uploadFile.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    @PostMapping("/uploadimage")
    public ResponseEntity<String> uploadFilesImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            String response = uploadFile.uploadImage(imageFile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Image upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/uploadaudio")
    public ResponseEntity<String> uploadFilesAudio(@RequestParam("audio") MultipartFile audioFile) {
        try {
            String response = uploadFile.uploadAudio(audioFile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Audio upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/uploadvideo")
    public ResponseEntity<String> uploadFilesVideo(@RequestParam("video") MultipartFile videoFile) {
        try {
            String response = uploadFile.uploadVideo(videoFile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Video upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam(value = "audio", required = false) MultipartFile audioFile,
            @RequestParam(value = "video", required = false) MultipartFile videoFile) {


        uploadFile.uploadFile(imageFile, audioFile, videoFile);
        return ResponseEntity.ok("Files uploaded successfully.");
    }
}
