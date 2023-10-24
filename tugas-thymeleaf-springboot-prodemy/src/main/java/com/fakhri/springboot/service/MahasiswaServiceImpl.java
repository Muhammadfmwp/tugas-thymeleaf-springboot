package com.fakhri.springboot.service;


import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fakhri.springboot.model.Mahasiswa;
import com.fakhri.springboot.repository.MahasiswaRepository;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

	@Autowired
	private MahasiswaRepository mahasiswaRepository;
	
	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		// TODO Auto-generated method stub
		return mahasiswaRepository.findAll();
	}

	@Override
	public void addMahasiswa(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		this.mahasiswaRepository.save(mahasiswa);
	}

	@Override
	public Mahasiswa getById(String nim) {
		// TODO Auto-generated method stub
		Optional<Mahasiswa> optional = mahasiswaRepository.findById(nim);
		Mahasiswa mahasiswa = null;
		if(optional.isPresent()) {
			mahasiswa = optional.get();
		}
		else {
			throw new RuntimeException("Mahasiswa tidak ditemukan");
		}
		return mahasiswa;
	}

	@Override
	public void deleteMahasiswa(String nim) {
		// TODO Auto-generated method stub
		mahasiswaRepository.deleteById(nim);
		
	}

	@Override
	public Page<Mahasiswa> paginatedPage(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.mahasiswaRepository.findAll(pageable);
	}
	
	

}
