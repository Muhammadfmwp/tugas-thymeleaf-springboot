package com.fakhri.springboot.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fakhri.springboot.model.Mahasiswa;
import com.fakhri.springboot.service.MahasiswaService;

import jakarta.validation.Valid;

@Controller
public class MahasiswaController {

	@Autowired
	private MahasiswaService mahasiswaService;
	
	@GetMapping("/")
	public String index(Model model) {
		Mahasiswa mahasiswa = new Mahasiswa();
		model.addAttribute("mahasiswa", mahasiswa);
		return "index";
	}
	
	@GetMapping("/list")
	public String viewAllMahasiwa(Model model) {
		model.addAttribute("listMahasiswa", mahasiswaService.getAllMahasiswa());
		return "listmahasiswa";
	}
	
	@PostMapping("/addMahasiswa")
	public String addMahasiswa(@Valid @ModelAttribute("mahasiswa") Mahasiswa mahasiswa, BindingResult bindingResult, Model model) {
		boolean errors = bindingResult.hasErrors();
		if(errors) {
			model.addAttribute(mahasiswa);
			return "index";
		}
		mahasiswaService.addMahasiswa(mahasiswa);
		return "redirect:/list";
	}
	
	@GetMapping("/editMahasiswa/{nim}")
	public String showEditMahasiswa(@PathVariable (value = "nim") String nim, Model model) {
		Mahasiswa mahasiswa = mahasiswaService.getById(nim);
		
		model.addAttribute("mahasiswa", mahasiswa);
		return "editmahasiswa";
	}
	
	@GetMapping("/deleteMahasiswa/{nim}")
	public String deleteMahasiswa(@PathVariable (value = "nim") String nim, Model model) {
		this.mahasiswaService.deleteMahasiswa(nim);
		return "redirect:/list";
	}
	
	
}
