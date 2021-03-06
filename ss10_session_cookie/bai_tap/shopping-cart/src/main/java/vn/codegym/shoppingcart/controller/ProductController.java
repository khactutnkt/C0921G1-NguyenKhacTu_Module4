package vn.codegym.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.shoppingcart.model.Cart;
import vn.codegym.shoppingcart.model.Product;
import vn.codegym.shoppingcart.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") Cart cart,
                            @RequestParam(value = "action", required = false, defaultValue = "") String action, Model model) {
        Optional<Product> product = this.productService.findById(id);

        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.addProduct(product.get());
        model.addAttribute("mess","Add product successfully!!");
        return "redirect:/cart";
    }

    @GetMapping("/view/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Product> product = this.productService.findById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "/view";
        }else {
            return "error.404";
        }
    }
}
