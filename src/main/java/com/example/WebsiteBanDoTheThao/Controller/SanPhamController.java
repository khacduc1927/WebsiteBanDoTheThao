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
import org.springframework.web.bind.annotation.RestController;
import com.example.WebsiteBanDoTheThao.Exception.ResourceNotFoundException;
import com.example.WebsiteBanDoTheThao.Model.SanPham;
import com.example.WebsiteBanDoTheThao.Repository.SanPhamRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
class SanPhamController {
	
	@Autowired
	private SanPhamRepository SanPhamRepository;
	
	// Lấy tất cả sản phẩm
	@GetMapping("/SanPham")
	public List<SanPham> getAllSanPham(){
		return SanPhamRepository.findAll();
	}	
	
	// Tạo mới sản phẩm <rest api>
	@PostMapping("/SanPham")
	public SanPham createSanPham(@RequestBody SanPham SanPham){
		return SanPhamRepository.save(SanPham);
	}
	
	@GetMapping("/SanPham/{id}")
	public ResponseEntity<SanPham> getSanPhamById(@PathVariable Long id) {
		SanPham SanPham = SanPhamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SanPham not exist with id :" + id));
		return ResponseEntity.ok(SanPham);
	}
		
	@DeleteMapping("/SanPham/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSanPham(@PathVariable Long id){
		SanPham SanPham = SanPhamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SanPham not exist with id :" + id));
		
		SanPhamRepository.delete(SanPham);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
		
	// update SanPham rest api
	@PutMapping("/SanPham/{id}")
	public ResponseEntity<SanPham> updateSanPham(@PathVariable Long id, @RequestBody SanPham SanPhamDetails){
		SanPham SanPham = SanPhamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SanPham not exist with id :" + id));
		
		SanPham.setTenSanPham(SanPhamDetails.getTenSanPham());
		SanPham.setMoTaNgan(SanPhamDetails.getMoTaNgan());
		SanPham.setMoTaChiTiet(SanPhamDetails.getMoTaChiTiet());
		SanPham.setHinhAnh(SanPhamDetails.getHinhAnh());
		SanPham.setGiaBan(SanPhamDetails.getGiaBan());
		SanPham.setGiaBanKhuyenMai(SanPhamDetails.getGiaBanKhuyenMai());
		SanPham.setMaNhanHieu(SanPhamDetails.getMaNhanHieu());
		SanPham.setMaDanhMuc(SanPhamDetails.getMaDanhMuc());
		SanPham.setNguoiTao(SanPhamDetails.getNguoiTao());
		SanPham.setNgayTao(SanPhamDetails.getNgayTao());
		SanPham.setNguoiCapNhat(SanPhamDetails.getNguoiCapNhat());
		SanPham.setNgayCapNhat(SanPhamDetails.getNgayCapNhat());
		SanPham.setSoLuong(SanPhamDetails.getSoLuong());
		SanPham.setTinhTrang(SanPhamDetails.getTinhTrang());
		SanPham.setThungRac(SanPhamDetails.getThungRac());
		
		SanPham updateSanPham = SanPhamRepository.save(SanPham);
		return ResponseEntity.ok(updateSanPham);
	}
	
	// Lay san pham theo danh muc
	@GetMapping("/SanPham/DanhMuc/{maDanhMuc}")
	public ResponseEntity<List<SanPham>> getSanPhamByMaDanhMuc(@PathVariable Long maDanhMuc){
		return new ResponseEntity<>(SanPhamRepository.findSanPhamByMaDanhMuc(maDanhMuc), HttpStatus.OK);
	}
		
		// Lay san pham theo nhan hieu
	@GetMapping("/SanPham/NhanHieu/{maNhanHieu}")
	public ResponseEntity<List<SanPham>> getSanPhamByMaNhanHieu(@PathVariable Long maNhanHieu){
		return new ResponseEntity<>(SanPhamRepository.findSanPhamByMaNhanHieu(maNhanHieu), HttpStatus.OK);
	}
}
