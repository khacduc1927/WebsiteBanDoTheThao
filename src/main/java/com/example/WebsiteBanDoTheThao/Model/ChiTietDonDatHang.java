package com.example.WebsiteBanDoTheThao.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietDonDatHang")
public class ChiTietDonDatHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TenDonHang")
	private String tenDonHang;
	
	@Column(name = "TenSanPham")
	private String tenSanPham;
	
	@Column(name = "SoLuong")
	private long soLuong;
	
	@Column(name = "GiaBan")
	private double giaBan;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	public ChiTietDonDatHang() {
		super();
	}

	public ChiTietDonDatHang(long id, String tenDonHang, String tenSanPham, long soLuong, double giaBan, long tinhTrang,
			long thungRac) {
		super();
		this.id = id;
		this.tenDonHang = tenDonHang;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenDonHang() {
		return tenDonHang;
	}

	public void setTenDonHang(String tenDonHang) {
		this.tenDonHang = tenDonHang;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
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
