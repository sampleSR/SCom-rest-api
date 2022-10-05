package com.aihc.scomrestapi.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryService {
  Cloudinary cloudinary;
  Map<String, String> credentials = new HashMap<>();

  public CloudinaryService() {
    credentials =
        ObjectUtils.asMap(
            "cloud_name", "dcm0rx3pb",
            "api_key", "714564169565678",
            "api_secret", "iZ4d09AWSgBr13ihLhLM9xafjJQ");
    cloudinary = new Cloudinary(credentials);
  }

  public Map upload(MultipartFile multipartFile) throws IOException {
    File file = convert(multipartFile);
    Map response = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    file.delete();
    return response;
  }

  public Map delete(String id) throws IOException {
    Map response = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    return response;
  }

  public File convert(MultipartFile multipartFile) throws IOException {
    File file = new File(multipartFile.getOriginalFilename());
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(multipartFile.getBytes());
    fo.close();
    return file;
  }
}
