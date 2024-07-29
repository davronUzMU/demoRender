package uz.com.demorender.service;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import uz.com.demorender.model.ImgUrl;
import uz.com.demorender.payload.ApiResult;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IImgService {
    ApiResult<?> uploadImage(MultipartFile multipartFile) throws IOException;
    

    ApiResult<?> uploadImageToFileSystem(MultipartFile file);

    ApiResult<?> downloadImageFromFileSystem(String filename);

   // Optional<ImgUrl> imgUrl(String fileName);

    Optional<ImgUrl> imgUrl(Integer id);

  //  void downloadImage(String filename, HttpServletResponse response);

    ApiResult<List<ImgUrl>> allImage();

    void downloadImage(Integer id, HttpServletResponse response);

    List<ImgUrl> imgResponse(List<Integer> arr);
}
