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
            "cloud_name", "dedlan1fs",
            "api_key", "375414766152556",
            "api_secret", "On5Bw-gN1foa1F2ygBMT3TQvFbM");
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
