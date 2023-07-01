package com.example.WebsiteBanDoTheThao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebsiteBanDoTheThao.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findByTenAdmin(String tenAdmin);
}
