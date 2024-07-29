package uz.com.demorender.controller.img;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.com.demorender.model.ImgUrl;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.utils.ApplicationConstants;
import java.io.IOException;
import java.util.List;

@RequestMapping(value = IImgUrlController.BATH_PATH)
public interface IImgUrlController {
     String BATH_PATH= ApplicationConstants.BASE_PATH+"/img";

     @PostMapping
     ApiResult<?> uploadImage(@RequestParam("image")MultipartFile multipartFile) throws IOException;

     @GetMapping("/{id}")
     @Transactional
     void downloadImage(@PathVariable(name = "id") Integer id, HttpServletResponse response) throws IOException;

     @PostMapping("/file")
     ApiResult<?>  uploadImageToFileSystem(@RequestParam("image")MultipartFile file);

     @GetMapping("/fileSystem/{filename}")
     ApiResult<?> downloadImageFromFileSystem(@PathVariable String filename);

     @GetMapping()
     ApiResult<List<ImgUrl>> allImage();
}
