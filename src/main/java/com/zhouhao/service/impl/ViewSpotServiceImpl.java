package com.zhouhao.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhouhao.dao.ViewSpotMapper;
import com.zhouhao.entity.ViewSpot;
import com.zhouhao.service.ViewSpotService;
import com.zhouhao.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ViewSpotServiceImpl implements ViewSpotService {
    @Autowired
    ViewSpotMapper viewSpotMapper;


    @Override
    public List<ViewSpot> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return viewSpotMapper.selectList(null);
    }

    @Override
    public ViewSpot getOne(Integer id) {
        return viewSpotMapper.selectById(id);
    }

    @Override
    public R update(MultipartFile file, ViewSpot viewSpot) throws IOException {
        String uuid = String.valueOf(UUID.randomUUID());
        file.transferTo(new File("C:\\Users\\91192\\IdeaProjects\\travels\\target\\classes\\static\\img\\" + uuid + ".jpg"));
        viewSpot.setPicpath("../img/" + uuid + ".jpg");
        viewSpotMapper.updateById(viewSpot);
        return R.ok();
    }
}
