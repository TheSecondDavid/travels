package com.zhouhao.service;

import com.zhouhao.entity.Province;
import java.util.List;

public interface ProvinceService {
    List<Province> list(Integer pageNum, Integer pageSize);

    Integer getTotal();

    void delete(Integer id);

    List<Province> listAll();
}
