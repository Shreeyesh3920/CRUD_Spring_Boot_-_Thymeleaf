package com.CRUD.Product.Controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRUD.Product.Repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

import com.CRUD.Product.Entity.*;

@Controller
public class HomeController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/")
	public String home(Model model) {
		
		List<Products> list = productRepo.findAll();
		model.addAttribute("all_products", list);
		return "index";
	}

	@GetMapping("/load_form")
	public String loadForm(Model model) {
		
		model.addAttribute("product", new Products());
		return "add";
	}

	@GetMapping("/edit_form/{id}")
	public String editForm(@PathVariable(value = "id") long id, Model model) {
		Optional<Products> product = productRepo.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		return "edit";
	}

	@PostMapping("/save_products")
	public String saveProducts(@ModelAttribute("product") Products products) {
		
		productRepo.save(products);
		return "redirect:/";
	}

	@PostMapping("/update_products")
	public String updateProducts(@ModelAttribute("product") Products products) {
		
		productRepo.save(products);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteProducts(@PathVariable(value = "id") long id) {
		
		productRepo.deleteById(id);
		return "redirect:/";
	}

}
