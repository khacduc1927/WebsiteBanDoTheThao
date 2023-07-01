package com.example.WebsiteBanDoTheThao.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebsiteBanDoTheThao.Model.DanhMuc;
import com.example.WebsiteBanDoTheThao.Repository.DanhMucRepository;
import com.example.WebsiteBanDoTheThao.Exception.ResourceNotFoundException;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class DanhMucController {
	@Autowired
	private DanhMucRepository DanhMucRepository;
	
	// Lấy tất cả danh mục
	@GetMapping("/DanhMuc")
	public List<DanhMuc> getAllDanhMuc(){
		return DanhMucRepository.findAll();
	}	
	
	// Tạo mới danh mục <rest api>
	@PostMapping("/DanhMuc")
	public DanhMuc createDanhMuc(@RequestBody DanhMuc DanhMuc) {
		return DanhMucRepository.save(DanhMuc);
	}
	
	// Lấy danh mục theo id
	@GetMapping("/DanhMuc/{id}")
	public ResponseEntity<DanhMuc> getProductsById(@PathVariable Long id) {
		DanhMuc danhmuc = DanhMucRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DanhMuc not exist with id :" + id));
		return ResponseEntity.ok(danhmuc);
	}
	
	@DeleteMapping("/DanhMuc/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDanhMuc(@PathVariable Long id){
		DanhMuc danhmuc = DanhMucRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DanhMuc not exist with id :" + id));
		
		DanhMucRepository.delete(danhmuc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// update DanhMuc rest api
	@PutMapping("/DanhMuc/{id}")
	public ResponseEntity<DanhMuc> updateDanhMuc(@PathVariable Long id, @RequestBody DanhMuc DanhMucDetails){
		DanhMuc danhmuc = DanhMucRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DanhMuc not exist with id :" + id));
		
		danhmuc.setTenDanhMuc(DanhMucDetails.getTenDanhMuc());
		danhmuc.setMoTa(DanhMucDetails.getMoTa());
		danhmuc.setTinhTrang(DanhMucDetails.getTinhTrang());
		danhmuc.setThungRac(DanhMucDetails.getThungRac());
		
		DanhMuc updateDanhMuc = DanhMucRepository.save(danhmuc);
		return ResponseEntity.ok(updateDanhMuc);
	}
}


