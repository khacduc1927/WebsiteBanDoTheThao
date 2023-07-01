package com.example.WebsiteBanDoTheThao.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TenAdmin")
	private String tenAdmin;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@Column(name = "HoVaTen")
	private String hoVaTen;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "SoDienThoai")
	private String soDienThoai;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	public Admin(long id, String tenAdmin, String matKhau, String hoVaTen, String diaChi, String soDienThoai,
			long tinhTrang, long thungRac) {
		super();
		this.id = id;
		this.tenAdmin = tenAdmin;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
	}

	public Admin() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenAdmin() {
		return tenAdmin;
	}

	public void setTenAdmin(String tenAdmin) {
		this.tenAdmin = tenAdmin;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public long getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(long tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public long getThungRac() {
		return thungRac;
	}

	public void setThungRac(long thungRac) {
		this.thungRac = thungRac;
	}
	
}
