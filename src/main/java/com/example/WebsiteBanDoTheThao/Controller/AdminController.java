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
import com.example.WebsiteBanDoTheThao.Model.Admin;
import com.example.WebsiteBanDoTheThao.Repository.AdminRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class AdminController {
	@Autowired
	private AdminRepository AdminRepository;
	
	// Lấy tất cả Admin
	@GetMapping("/Admin")
	public List<Admin> getAllAdmin(){
		return AdminRepository.findAll();
	}	
	
	// Tạo mới Admin <rest api>
	@PostMapping("/Admin")
	public Admin createAdmin(@RequestBody Admin Admin) {
		return AdminRepository.save(Admin);
	}
	
	@GetMapping("/Admin/tenAdmin")
	public ResponseEntity<Admin> getAdminbyTenAdmin(@RequestParam String tenAdmin) {
		return new ResponseEntity<Admin>(AdminRepository.findByTenAdmin(tenAdmin), HttpStatus.OK);
	}
	
	@DeleteMapping("/Admin/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAdmin(@PathVariable Long id){
		Admin Admin = AdminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		
		AdminRepository.delete(Admin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/Admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		Admin Admin = AdminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		return ResponseEntity.ok(Admin);
	}
	
	@PutMapping("/Admin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin AdminDetails){
		Admin Admin = AdminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
		Admin.setTenAdmin(AdminDetails.getTenAdmin());
		Admin.setMatKhau(AdminDetails.getMatKhau());
		Admin.setHoVaTen(AdminDetails.getHoVaTen());
		Admin.setDiaChi(AdminDetails.getDiaChi());
		Admin.setSoDienThoai(AdminDetails.getSoDienThoai());
		Admin.setTinhTrang(AdminDetails.getTinhTrang());
		Admin.setThungRac(AdminDetails.getThungRac());
		Admin updateAdmin = AdminRepository.save(Admin);
		return ResponseEntity.ok(updateAdmin);
	}
}
