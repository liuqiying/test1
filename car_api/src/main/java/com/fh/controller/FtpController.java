package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.util.FTPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("ftp")
@CrossOrigin
public class FtpController {

    @RequestMapping("uploadFTP")
    @ResponseBody
    public ServerResponse uploadFTP(MultipartFile file) throws Exception {
        String s = FTPUtils.uploadFile("/upload", file.getOriginalFilename(), file.getInputStream());
        Map map = new HashMap();
        map.put("filePath", s);
        map.put("fileName", file.getOriginalFilename());
        return ServerResponse.success(map);
    }
}
