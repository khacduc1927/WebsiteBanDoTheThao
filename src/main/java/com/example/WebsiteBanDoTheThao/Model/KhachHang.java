package com.example.WebsiteBanDoTheThao.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TaiKhoan")
	private String taiKhoan;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@Column(name = "HoTen")
	private String hoTen;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "SoDienThoai")
	private String soDienThoai;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	public KhachHang() {
		super();
	}

	public KhachHang(long id, String taiKhoan, String matKhau, String hoTen,String email, String soDienThoai, String diaChi,
			long tinhTrang, long thungRac) {
		super();
		this.id = id;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
