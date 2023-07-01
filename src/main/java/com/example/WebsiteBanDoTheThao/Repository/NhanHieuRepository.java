package com.example.WebsiteBanDoTheThao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.NhanHieu;

@Repository
public interface NhanHieuRepository extends JpaRepository<NhanHieu, Long>{

}
