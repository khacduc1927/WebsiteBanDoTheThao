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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebsiteBanDoTheThao.Exception.ResourceNotFoundException;
import com.example.WebsiteBanDoTheThao.Model.ChiTietDonDatHang;
import com.example.WebsiteBanDoTheThao.Model.DanhMuc;
import com.example.WebsiteBanDoTheThao.Model.DonDatHang;
import com.example.WebsiteBanDoTheThao.Model.KhachHang;
import com.example.WebsiteBanDoTheThao.Model.SanPham;
import com.example.WebsiteBanDoTheThao.Repository.ChiTietDonDatHangRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class ChiTietDonDatHangController {
	@Autowired
	private ChiTietDonDatHangRepository ChiTietDonDatHangRepository;
	
	// Lấy tất cả chi tiết đơn đặt hàng
	@GetMapping("/ChiTietDonDatHang")
	public List<ChiTietDonDatHang> getAllChiTietDonDatHang(){
		return ChiTietDonDatHangRepository.findAll();
	}	
	
	// Tạo mới chi tiết đơn đặt hàng <rest api>
	@PostMapping("/ChiTietDonDatHang")
	public ChiTietDonDatHang createChiTietDonDatHang(@RequestBody ChiTietDonDatHang ChiTietDonDatHang) {
		return ChiTietDonDatHangRepository.save(ChiTietDonDatHang);
	}
	
	// Lay chi tiết đơn đặt hàng theo ten don hang
	@GetMapping("/ChiTietDonDatHang/tenDonHang")
	public ResponseEntity<List<ChiTietDonDatHang>> getChiTietDonDatHangbyTenDonHang(@RequestParam String tenDonHang) {
		return new ResponseEntity<List<ChiTietDonDatHang>>(ChiTietDonDatHangRepository.findByTenDonHang(tenDonHang), HttpStatus.OK);
	}
	
	@DeleteMapping("/ChiTietDonDatHang/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteChiTietDonDatHang(@PathVariable Long id){
		ChiTietDonDatHang ChiTietDonDatHang = ChiTietDonDatHangRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("KhachHang not exist with id :" + id));
		
		ChiTietDonDatHangRepository.delete(ChiTietDonDatHang);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
