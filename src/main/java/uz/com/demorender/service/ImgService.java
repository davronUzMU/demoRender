package uz.com.demorender.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.ImgUrl;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.repository.ImgUrlRepository;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Service
@RequiredArgsConstructor
public class ImgService implements IImgService{

    private final ImgUrlRepository repository;
    private final String uploadDirectory = "uploads";

    private final MessageSource messageSource;

    @Override
    @SneakyThrows
    public ApiResult<?> uploadImage(MultipartFile multipartFile){

        checkMultipartFile(multipartFile);

            String originalFileName = multipartFile.getOriginalFilename();
            ImgUrl imgUrl = new ImgUrl();
            imgUrl.setFileOriginalName(originalFileName);
            imgUrl.setSize(multipartFile.getSize());
            imgUrl.setType(multipartFile.getContentType());
            assert originalFileName != null;
            String[] split = originalFileName.split("\\.");
            String name = UUID.randomUUID() + "." + split[split.length-1];
            imgUrl.setName(name);

            repository.save(imgUrl);

            Path path = Paths.get(uploadDirectory + "/" + name);
            Files.copy(multipartFile.getInputStream(), path);
            return ApiResult.successResponse("File success");
    }


    @Override
    @SneakyThrows
    public void downloadImage(Integer id, HttpServletResponse response) {
        Optional<ImgUrl> optional = imgUrl(id);
        if (optional.isPresent()) {
            ImgUrl imgUrl = optional.get();
            response.setHeader("Content_Disposition", "attachment; filename=\"" + imgUrl.getName());
            response.setContentType(imgUrl.getType());
            FileInputStream fileInputStream = new FileInputStream(uploadDirectory + "/" + imgUrl.getName());
            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
        }
    }

    @Override
    public List<ImgUrl> imgResponse(List<Integer> arr) {
       return  null;
    }


    @Override
    public ApiResult<?> uploadImageToFileSystem(MultipartFile file) {
        return null;
    }

    @Override
    public ApiResult<?> downloadImageFromFileSystem(String filename) {
        return null;
    }

    @Override
    public Optional<ImgUrl> imgUrl(Integer id) {
        return repository.findById(id);
    }

    private void checkMultipartFile(MultipartFile multipartFile) {
        if(Objects.isNull(multipartFile))
            throw AppException.appThrow(messageSource.getMessage("NAME_OF_MANUFACTURE_IS_BLANK",
                    null,
                    LocaleContextHolder.getLocale()));
    }
    @Override
    public ApiResult<List<ImgUrl>> allImage() {
        return ApiResult.successResponse(repository.findAll());
    }
}
