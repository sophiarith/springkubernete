package com.kshrd.registration.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadFileService {
    public String saveFile(MultipartFile file) throws IOException;
    public List<String> saveMultiFiles(MultipartFile[] fileList) throws IOException;

}
