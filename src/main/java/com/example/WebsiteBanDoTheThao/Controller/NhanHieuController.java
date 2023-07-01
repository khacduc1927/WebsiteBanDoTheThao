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

import com.example.WebsiteBanDoTheThao.Exception.ResourceNotFoundException;
import com.example.WebsiteBanDoTheThao.Model.NhanHieu;
import com.example.WebsiteBanDoTheThao.Repository.NhanHieuRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class NhanHieuController {
	@Autowired
	private NhanHieuRepository NhanHieuRepository;
	
	// Lấy tất cả nhãn hiệu 
	@GetMapping("/NhanHieu")
	public List<NhanHieu> getAllNhanHieu(){
		return NhanHieuRepository.findAll();
	}	
	
	// Tạo mới nhãn hiệu <rest api>
	@PostMapping("/NhanHieu")
	public NhanHieu createNhanHieu(@RequestBody NhanHieu NhanHieu) {
		return NhanHieuRepository.save(NhanHieu);
	}
	
	@GetMapping("/NhanHieu/{id}")
	public ResponseEntity<NhanHieu> getProductsById(@PathVariable Long id) {
		NhanHieu NhanHieu = NhanHieuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("NhanHieu not exist with id :" + id));
		return ResponseEntity.ok(NhanHieu);
	}
		
	@DeleteMapping("/NhanHieu/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNhanHieu(@PathVariable Long id){
		NhanHieu NhanHieu = NhanHieuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("NhanHieu not exist with id :" + id));
		
		NhanHieuRepository.delete(NhanHieu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
		
	// update NhanHieu rest api
	@PutMapping("/NhanHieu/{id}")
	public ResponseEntity<NhanHieu> updateNhanHieu(@PathVariable Long id, @RequestBody NhanHieu NhanHieuDetails){
		NhanHieu NhanHieu = NhanHieuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("NhanHieu not exist with id :" + id));
		
		NhanHieu.setTenNhanHieu(NhanHieuDetails.getTenNhanHieu());
		NhanHieu.setMoTa(NhanHieuDetails.getMoTa());
		NhanHieu.setTinhTrang(NhanHieuDetails.getTinhTrang());
		NhanHieu.setThungRac(NhanHieuDetails.getThungRac());
		
		NhanHieu updateNhanHieu = NhanHieuRepository.save(NhanHieu);
		return ResponseEntity.ok(updateNhanHieu);
	}
}
