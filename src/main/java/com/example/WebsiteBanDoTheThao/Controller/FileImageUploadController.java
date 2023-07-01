package com.example.WebsiteBanDoTheThao.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class FileImageUploadController {
	@PostMapping("/upload-file")
	public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
		String Path_Directory = "C:\\Users\\Nguyen Khac Duc\\Desktop\\TTTN\\NguyenKhacDuc_2119110142\\WebsiteBanDoTheThao\\images";
		//String Path_Directory = new ClassPathResource("static/images/").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		return "Successfully Image is uploaded";
	}

}
