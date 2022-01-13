package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.ToKhaiYTe;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToKhaiController {
    @GetMapping("/")
    public String showHome(Model model){
        ToKhaiYTe toKhaiYTe = new ToKhaiYTe();
        model.addAttribute("toKhaiYTe",toKhaiYTe);

        List<String> namSinhList = new ArrayList<>();
        for (int i=1900; i<2022; i++){
            namSinhList.add(Integer.toString(i));
        }
        model.addAttribute("namSinhList",namSinhList);

        List<String> gioiTinhList = new ArrayList<>();
        gioiTinhList.add("Nam");
        gioiTinhList.add("Nữ");
        model.addAttribute("gioiTinhList",gioiTinhList);

        List<String> phuongTienList = new ArrayList<>();
        phuongTienList.add("Tàu bay");
        phuongTienList.add("Tàu thuyền");
        phuongTienList.add("Ô tô");
        phuongTienList.add("Khác");
        model.addAttribute("phuongTienList",phuongTienList);

        return "index";
    }
}
