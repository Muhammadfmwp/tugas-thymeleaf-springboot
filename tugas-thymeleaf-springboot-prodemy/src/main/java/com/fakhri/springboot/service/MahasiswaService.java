package com.fakhri.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fakhri.springboot.model.Mahasiswa;

@Service
public interface MahasiswaService {
	List<Mahasiswa> getAllMahasiswa();
	void addMahasiswa(Mahasiswa mahasiswa);
	Mahasiswa getById(String nim);
	void deleteMahasiswa(String nim);
	Page<Mahasiswa> paginatedPage(int pageNo, int pageSize, String sortField, String sortDirection);
}
