package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.service.CustomerService;
import com.example.casestudy.service.CustomerTypeService;
import com.example.casestudy.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private GenderService genderService;
    @GetMapping("")
    public String listCustomer(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("customerTypeList", customerTypeService.selectAllCustomerType());
        model.addAttribute("customerList", customerService.selectAllCustomer(PageRequest.of(page, 2)));
        return "customer/list";
    }
    @GetMapping("create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList",genderService.selectAllGender());
        model.addAttribute("customerTypeList", customerTypeService.selectAllCustomerType());
        return "customer/create";
    }
    @PostMapping("save")
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("detail/{customerId}")
    public String detailCustomer(@PathVariable int customerId,Model model){
        model.addAttribute("customer", customerService.findCustomerById(customerId));
     return "customer/detail";
    }

    @GetMapping("edit/{customerId}")
    public String editCustomer(@PathVariable int customerId, Model model, HttpServletRequest request){

        model.addAttribute("url",request.getHeader("referer"));

        model.addAttribute("customer", customerService.findCustomerById(customerId));
        model.addAttribute("genderList",genderService.selectAllGender());
        model.addAttribute("customerTypeList", customerTypeService.selectAllCustomerType());
        return "customer/edit";
    }
    @PostMapping("update")
    public String updateCustomer(Customer customer,@RequestParam String url){
        customerService.saveCustomer(customer);
//        return "redirect:/customer";
        return "redirect:" + url;
    }
    @GetMapping("delete/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customer";
    }

    @GetMapping("search")
    public String searchCustomer(@RequestParam(value = "page",defaultValue ="0") int page, String namecustomer, String phonecustomer, Optional<Integer> idcustomertype,Model model){

        model.addAttribute("namecustomer",namecustomer);
        model.addAttribute("phonecustomer",phonecustomer);
        model.addAttribute("idcustomertype",idcustomertype.orElse(null));
        model.addAttribute("customerTypeList", customerTypeService.selectAllCustomerType());
        if (idcustomertype.isPresent()){
            model.addAttribute("customerListSearch", customerService.findByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(PageRequest.of(page,2),namecustomer,phonecustomer,idcustomertype));
        } else {
            model.addAttribute("customerListSearch", customerService.findByCustomerNameContainingAndCustomerPhoneContaining(PageRequest.of(page,2),namecustomer,phonecustomer));
        }

        return "customer/list";
    }



}
