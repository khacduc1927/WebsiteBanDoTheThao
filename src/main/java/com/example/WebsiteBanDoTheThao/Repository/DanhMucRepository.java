package com.example.WebsiteBanDoTheThao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.DanhMuc;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Long>{

}
