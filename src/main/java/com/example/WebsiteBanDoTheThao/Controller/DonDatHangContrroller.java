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
import com.example.WebsiteBanDoTheThao.Model.DonDatHang;
import com.example.WebsiteBanDoTheThao.Model.KhachHang;
import com.example.WebsiteBanDoTheThao.Repository.DonDatHangRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class DonDatHangContrroller {
	@Autowired
	private DonDatHangRepository DonDatHangRepository;
	
	@GetMapping("/DonDatHang")
	public List<DonDatHang> getAllDonDatHang(){
		return DonDatHangRepository.findAll();
	}	
	
	// Tạo mới danh mục <rest api>
	@PostMapping("/DonDatHang")
	public DonDatHang createDonDatHang(@RequestBody DonDatHang DonDatHang) {
		return DonDatHangRepository.save(DonDatHang);
	}
	
	@GetMapping("/DonDatHang/{id}")
	public ResponseEntity<DonDatHang> getDonDatHangById(@PathVariable Long id) {
		DonDatHang DonDatHang = DonDatHangRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
		return ResponseEntity.ok(DonDatHang);
	}
	
	@DeleteMapping("/DonDatHang/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDonDatHang(@PathVariable Long id){
		DonDatHang DonDatHang = DonDatHangRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
		
		DonDatHangRepository.delete(DonDatHang);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/DonDatHang/{id}")
	public ResponseEntity<DonDatHang> updateDonDatHang(@PathVariable Long id, @RequestBody DonDatHang DonDatHangDetails){
		DonDatHang DonDatHang = DonDatHangRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
		DonDatHang.setTenDonHang(DonDatHangDetails.getTenDonHang());
		DonDatHang.setMaKhachHang(DonDatHangDetails.getMaKhachHang());
		DonDatHang.setNgayDatHang(DonDatHangDetails.getNgayDatHang());
		DonDatHang.setTongTien(DonDatHangDetails.getTongTien());
		DonDatHang.setThungRac(DonDatHangDetails.getThungRac());
		DonDatHang.setTinhTrang(DonDatHangDetails.getTinhTrang());
		DonDatHang updateDonDatHang = DonDatHangRepository.save(DonDatHang);
		return ResponseEntity.ok(updateDonDatHang);
	}
}
