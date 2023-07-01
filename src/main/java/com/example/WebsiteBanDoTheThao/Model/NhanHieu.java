package com.example.WebsiteBanDoTheThao.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhanHieu")
public class NhanHieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TenNhanHieu")
	private String tenNhanHieu;
	
	@Column(name = "MoTa")
	private String moTa;
	
	@Column(name = "TinhTrang")
	private long tinhTrang;
	
	@Column(name = "ThungRac")
	private long thungRac;

	public NhanHieu(long id, String tenNhanHieu, String moTa, long tinhTrang, long thungRac) {
		super();
		this.id = id;
		this.tenNhanHieu = tenNhanHieu;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.thungRac = thungRac;
	}

	public NhanHieu() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenNhanHieu() {
		return tenNhanHieu;
	}

	public void setTenNhanHieu(String tenNhanHieu) {
		this.tenNhanHieu = tenNhanHieu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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
