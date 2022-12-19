package com.zhouhao.controller;

import com.zhouhao.entity.ViewSpot;
import com.zhouhao.service.ViewSpotService;
import com.zhouhao.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RequestMapping("viewSpot")
@RestController
public class ViewSpotController {
    @Autowired
    ViewSpotService viewSpotService;

    @RequestMapping("list")
    public List<ViewSpot> list(Integer pageNum, Integer pageSize){
        return viewSpotService.list(pageNum, pageSize);
    }

    @RequestMapping("getOne")
    public ViewSpot getOne(Integer id){
        return viewSpotService.getOne(id);
    }

    @RequestMapping("update")
    public R update(MultipartFile file, ViewSpot viewSpot) throws IOException, InterruptedException {
        return viewSpotService.update(file, viewSpot);
    }
}
