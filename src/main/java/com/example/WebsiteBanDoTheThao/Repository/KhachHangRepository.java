package com.example.WebsiteBanDoTheThao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long>{
	KhachHang findByTaiKhoan(String taiKhoan);
}

