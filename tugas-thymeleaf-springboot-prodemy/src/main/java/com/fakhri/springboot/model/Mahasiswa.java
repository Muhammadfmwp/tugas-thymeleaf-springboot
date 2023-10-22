package com.fakhri.springboot.model;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
	
	@Id
	@NotEmpty(message = "NIM tidak boleh kosong")
	@Size(min=1,max = 12)
	private String nim;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "tgl_lahir")
	private Date tglLahir;
	
	public Mahasiswa() {
		
	}
	
	public Mahasiswa(String nim, String nama, String alamat, Date tglLahir) {
		this.nim = nim;
		this.nama = nama;
		this.alamat = alamat;
		this.tglLahir = tglLahir;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

}
