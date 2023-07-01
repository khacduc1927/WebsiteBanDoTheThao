package com.example.WebsiteBanDoTheThao.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TenSanPham")
	private String tenSanPham;
	
	@Column(name = "MoTaNgan")
	private String moTaNgan;
	
	@Column(name = "MoTaChiTiet")
	private String moTaChiTiet;
	
	@Column(name = "HinhAnh")
	private String hinhAnh;
	
	@Column(name = "SoLuong")
	private double soLuong;
	
	@Column(name = "GiaBan")
	private double giaBan;
	
	@Column(name = "GiaBanKhuyenMai")
	private double giaBanKhuyenMai;
	
	@Column(name = "NgayTao")
	private Date ngayTao;
	
	@Column(name = "NguoiTao")
	private long nguoiTao;
	
	@Column(name = "NgayCapNhat")
	private Date ngayCapNhat;
	
	@Column(name = "NguoiCapNhat")
	private long nguoiCapNhat;
	
	@Column(name = "MaDanhMuc")
	private long maDanhMuc;
	
	@Column(name = "MaNhanHieu")
	private long maNhanHieu;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	public SanPham() {
		super();
	}

	public SanPham(long id, String tenSanPham, String moTaNgan, String moTaChiTiet, String hinhAnh, double soLuong,
			double giaBan, double giaBanKhuyenMai, Date ngayTao, long nguoiTao, Date ngayCapNhat, long nguoiCapNhat,
			long maDanhMuc, long maNhanHieu, long tinhTrang, long thungRac) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTaNgan = moTaNgan;
		this.moTaChiTiet = moTaChiTiet;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.giaBanKhuyenMai = giaBanKhuyenMai;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.maDanhMuc = maDanhMuc;
		this.maNhanHieu = maNhanHieu;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTaNgan() {
		return moTaNgan;
	}

	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}

	public String getMoTaChiTiet() {
		return moTaChiTiet;
	}

	public void setMoTaChiTiet(String moTaChiTiet) {
		this.moTaChiTiet = moTaChiTiet;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiaBanKhuyenMai() {
		return giaBanKhuyenMai;
	}

	public void setGiaBanKhuyenMai(double giaBanKhuyenMai) {
		this.giaBanKhuyenMai = giaBanKhuyenMai;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public long getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(long nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public long getNguoiCapNhat() {
		return nguoiCapNhat;
	}

	public void setNguoiCapNhat(long nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}

	public long getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(long maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public long getMaNhanHieu() {
		return maNhanHieu;
	}

	public void setMaNhanHieu(long maNhanHieu) {
		this.maNhanHieu = maNhanHieu;
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
