package com.example.WebsiteBanDoTheThao.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebsiteBanDoTheThao.Exception.ResourceNotFoundException;
import com.example.WebsiteBanDoTheThao.Model.KhachHang;
import com.example.WebsiteBanDoTheThao.Repository.KhachHangRepository;



@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class KhachHangController {
	@Autowired
	private KhachHangRepository KhachHangRepository;
	
		@GetMapping("/KhachHang")
		public List<KhachHang> getAllKhachHang(){
			return KhachHangRepository.findAll();
		}	
		
		@PostMapping("/KhachHang")
		public KhachHang createKhachHang(@RequestBody KhachHang KhachHang) {
			return KhachHangRepository.save(KhachHang);
		}
		
		@GetMapping("/KhachHang/{id}")
		public ResponseEntity<KhachHang> getProductsById(@PathVariable Long id) {
			KhachHang KhachHang = KhachHangRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
			return ResponseEntity.ok(KhachHang);
		}
			
		@DeleteMapping("/KhachHang/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteKhachHang(@PathVariable Long id){
			KhachHang KhachHang = KhachHangRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
			
			KhachHangRepository.delete(KhachHang);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
			
		@PutMapping("/KhachHang/{id}")
		public ResponseEntity<KhachHang> updateKhachHang(@PathVariable Long id, @RequestBody KhachHang KhachHangDetails){
			KhachHang KhachHang = KhachHangRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
			KhachHang.setTaiKhoan(KhachHangDetails.getTaiKhoan());
			KhachHang.setMatKhau(KhachHangDetails.getMatKhau());
			KhachHang.setHoTen(KhachHangDetails.getHoTen());
			KhachHang.setEmail(KhachHangDetails.getEmail());
			KhachHang.setDiaChi(KhachHangDetails.getDiaChi());
			KhachHang.setSoDienThoai(KhachHangDetails.getSoDienThoai());
			KhachHang.setTinhTrang(KhachHangDetails.getTinhTrang());
			KhachHang.setThungRac(KhachHangDetails.getThungRac());
			
			KhachHang updateKhachHang = KhachHangRepository.save(KhachHang);
			return ResponseEntity.ok(updateKhachHang);
		}
		
		@GetMapping("/KhachHang/taiKhoan")
		public ResponseEntity<KhachHang> getKhachHangbyTaiKhoan(@RequestParam String taiKhoan) {
			return new ResponseEntity<KhachHang>(KhachHangRepository.findByTaiKhoan(taiKhoan), HttpStatus.OK);
		}
}
