package com.zhouhao.controller;

import com.zhouhao.entity.Province;
import com.zhouhao.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @RequestMapping("list")
    public List<Province> listProvince(Integer pageNum, Integer pageSize){
        return provinceService.list(pageNum, pageSize);
    }

    @RequestMapping("getTotal")
    public Integer getTotal(){
        return provinceService.getTotal();
    }

    @RequestMapping(value = "del", method = RequestMethod.GET)
    public void delete(Integer id){
        provinceService.delete(id);
    }

    @RequestMapping("getAll")
    public List<Province> getAll(){
        return provinceService.listAll();
    }
}
