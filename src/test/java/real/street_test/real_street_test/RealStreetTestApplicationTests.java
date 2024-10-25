package real.street_test.real_street_test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import real.street_test.real_street_test.controller.UploadFileController;
import real.street_test.real_street_test.service.UploadFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RealStreetTestApplicationTests {

	@InjectMocks
	private UploadFileController uploadFileController;

	@Mock
	private UploadFile uploadFile;
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testUploadFilesImage_Success() {

		MultipartFile mockImageFile = mock(MultipartFile.class);

		when(uploadFile.uploadImage(mockImageFile)).thenReturn("Image uploaded successfully");


		ResponseEntity<String> response = uploadFileController.uploadFilesImage(mockImageFile);
		assertEquals("Image uploaded successfully", response.getBody());
		assertEquals(200, response.getStatusCodeValue());

		verify(uploadFile, times(1)).uploadImage(mockImageFile);
	}

	@Test
	public void testUploadFilesAudio_Success() {

		MultipartFile mockAudioFile = mock(MultipartFile.class);


		when(uploadFile.uploadAudio(mockAudioFile)).thenReturn("Audio uploaded successfully");


		ResponseEntity<String> response = uploadFileController.uploadFilesAudio(mockAudioFile);
		assertEquals("Audio uploaded successfully", response.getBody());
		assertEquals(200, response.getStatusCodeValue());

		verify(uploadFile, times(1)).uploadAudio(mockAudioFile);
	}



}
