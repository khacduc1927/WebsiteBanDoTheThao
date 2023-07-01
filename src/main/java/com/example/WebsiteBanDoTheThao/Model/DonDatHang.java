package com.example.WebsiteBanDoTheThao.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DonDatHang")
public class DonDatHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TenDonHang")
	private String tenDonHang;
	
	@Column(name = "TongTien")
	private String tongTien;
	
	@Column(name = "NgayDatHang")
	private String ngayDatHang;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	@Column(name = "MaKhachHang")
	private long maKhachHang;
	
	public DonDatHang() {
		super();
	}

	public DonDatHang(long id, String tenDonHang, String tongTien, String ngayDatHang, long tinhTrang,
			long thungRac, long maKhachHang) {
		super();
		this.id = id;
		this.tenDonHang = tenDonHang;
		this.tongTien = tongTien;
		this.ngayDatHang = ngayDatHang;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
		this.maKhachHang = maKhachHang;
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

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public String getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
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

	public long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

}
