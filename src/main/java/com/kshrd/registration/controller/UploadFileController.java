package com.kshrd.registration.controller;

import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.UploadFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
//@SecurityRequirement(name = "uploadFileController") //for swagger openapi
public class UploadFileController {

    private final UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

//    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> upLoadImage(@RequestParam("image") MultipartFile file) throws Exception {
        String url = "";
        try{
            url = uploadFileService.saveFile(file);
            System.out.println("url:" + url);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
        HashMap obj = new HashMap();
        obj.put("photoUrl", url);
        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign in with token successfully",
                "/auth",true, obj,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

    @PostMapping(value = "/multi-upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> multiUpload(@RequestParam("file") MultipartFile[] files) throws Exception {
        List urlList = new ArrayList();
        try {
            urlList = uploadFileService.saveMultiFiles(files);
            System.out.println("urlList:" + urlList);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
//        for(Object item: urlList){
//            System.out.println("Object item: " + item );
//        }
        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Sign in with token successfully",
                "/auth",true, urlList,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }
}
