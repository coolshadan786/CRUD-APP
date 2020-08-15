package productCRUDApp.controller;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productCRUDApp.dao.ProductDAO;
import productCRUDApp.pojo.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/")
	public String home(Model m) {
		
		List<Product> products = productDAO.getProducts();
		m.addAttribute("products",products);
		return "index";
	}
		
	//Show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m){
		
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	//Handle add product form
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		
		System.out.println(product);
		this.productDAO.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//Delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		
		this.productDAO.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	
	//Update handler
	@RequestMapping("update/{productId}")
	public String updateForm(@PathVariable("productId") int pid,Model model) {
		
		Product product =this.productDAO.getProduct(pid);
		model.addAttribute("product", product);
		return "update-form";
	}
	
	
	
}
