package com.example.WebsiteBanDoTheThao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.WebsiteBanDoTheThao.Model.ChiTietDonDatHang;

@Repository
public interface ChiTietDonDatHangRepository extends JpaRepository<ChiTietDonDatHang, Long>{
	List<ChiTietDonDatHang> findByTenDonHang(String tenDonHang);
}
