package uz.com.demorender.controller.img;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.com.demorender.model.ImgUrl;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.service.IImgService;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImgUrlController implements IImgUrlController{

    private  final IImgService iImgService;

    @Override
    public ApiResult<?> uploadImage(MultipartFile multipartFile) throws IOException {
        return iImgService.uploadImage(multipartFile);
    }

    @Override
    public void downloadImage(Integer id, HttpServletResponse response) throws IOException {
        iImgService.downloadImage(id,response);
    }


//    @Override
//    public void downloadImage(String filename, HttpServletResponse response){
//        iImgService.downloadImage(filename,response);
//    }

    @Override
    public ApiResult<?> uploadImageToFileSystem(MultipartFile file) {
        return iImgService.uploadImageToFileSystem(file);
    }

    @Override
    public ApiResult<?> downloadImageFromFileSystem(String filename) {
        return iImgService.downloadImageFromFileSystem(filename);
    }

    @Override
    public ApiResult<List<ImgUrl>> allImage() {
        return iImgService.allImage();
    }
}
