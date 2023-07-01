package com.example.WebsiteBanDoTheThao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>{
	List<SanPham> findSanPhamByMaDanhMuc(long maDanhMuc);
	List<SanPham> findSanPhamByMaNhanHieu(long maNhanHieu);
}
