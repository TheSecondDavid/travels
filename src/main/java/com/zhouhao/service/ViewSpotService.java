package com.zhouhao.service;

import com.zhouhao.entity.ViewSpot;
import com.zhouhao.utils.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ViewSpotService {
    List<ViewSpot> list(Integer pageNum, Integer pageSize);

    ViewSpot getOne(Integer id);

    R update(MultipartFile file, ViewSpot viewSpot) throws IOException, InterruptedException;
}
