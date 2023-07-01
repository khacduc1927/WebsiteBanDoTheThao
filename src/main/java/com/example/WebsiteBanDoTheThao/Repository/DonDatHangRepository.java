package com.example.WebsiteBanDoTheThao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.DonDatHang;

@Repository
public interface DonDatHangRepository extends JpaRepository<DonDatHang, Long>{

}
