package com.zhouhao.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhouhao.dao.ProvinceMapper;
import com.zhouhao.entity.Province;
import com.zhouhao.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return provinceMapper.selectList(null);
    }

    @Override
    public Integer getTotal() {
        return provinceMapper.selectList(null).size();
    }

    @Override
    public void delete(Integer id) {
        provinceMapper.deleteById(id);
    }

    @Override
    public List<Province> listAll() {
        return provinceMapper.selectList(null);
    }
}
