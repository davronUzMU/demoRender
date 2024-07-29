package uz.com.demorender.service;


import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.Product;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.product.ProductRequestDTO;
import uz.com.demorender.payload.product.ProductResponseDTO;
import uz.com.demorender.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final MessageSource messageSource;

    private final ProductRepository productRepository;

    private final ImgUrlRepository imgUrlRepository;

    private final ColorRepository colorRepository;

    private final ManufactureRepository manufactureRepository;


    @Override
    public ApiResult<ProductResponseDTO> add(ProductRequestDTO productRequestDTO) {
        checkingDataForExistenceAndNonEmpty(2, productRequestDTO);
        checkAddProduct(productRequestDTO);
        Product.ProductBuilder productBuilder = Product.builder();
        productBuilder.name(productRequestDTO.getProductName());
        if (!Objects.isNull(productRequestDTO.getImgId())) {
            productBuilder.imgUrlSet(new HashSet<>(imgUrlRepository.findAllById(productRequestDTO.getImgId())));
        } else {
            productBuilder.imgUrlSet(null);
        }
        productBuilder.prise(productRequestDTO.getPrise());
        productBuilder.availability(productRequestDTO.getAvailability());
        productBuilder.numberOfProducts(productRequestDTO.getNumberOfProducts());
        productBuilder.aboutProduct(productRequestDTO.getAboutProduct());
        productBuilder.color(colorRepository.findById(productRequestDTO.
                        getColor()).
                orElseThrow(() -> AppException.
                        appThrow(messageSource.
                                getMessage("",
                                        null,
                                        LocaleContextHolder.getLocale()))));
        productBuilder.manufacture(manufactureRepository.findById(productRequestDTO.getManufacture())
                .orElseThrow(() -> AppException.appThrow(
                        messageSource.getMessage("",
                                null,
                                LocaleContextHolder.getLocale())
                )));

        Product product = productBuilder.build();
        productRepository.save(product);
        ProductResponseDTO productResponseDTO = convertProductToProductResponse(product);

        return ApiResult.successResponse(productResponseDTO);
    }


    @Override
    public ApiResult<ProductResponseDTO> edit(ProductRequestDTO productRequestDTO, Integer id) {
        checkingDataForExistenceAndNonEmpty(id, productRequestDTO);

        Product product = productRepository.findById(id).
                orElseThrow(() -> AppException.
                        appThrow("this id,There isn't in product data"));

        return ApiResult.successResponse(swapOldProductNewProduct(product, productRequestDTO));
    }


    @Override
    public ApiResult<Boolean> delete(Integer id) {
        checkingDataForExistenceAndNonEmpty(id, productRepository.findById(id));

        boolean b = productRepository.existsById(id);
        productRepository.deleteById(id);
        return ApiResult.successResponse(b);
    }

    @Override
    public ApiResult<ProductResponseDTO> one(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> AppException.appThrow(messageSource.getMessage("",
                null,
                LocaleContextHolder.getLocale())));
        return ApiResult.successResponse(convertProductToProductResponse(product));
    }

    @Override
    public ApiResult<List<ProductResponseDTO>> list() {
        List<ProductResponseDTO> responseDTOS = productRepository.
                findAll().
                stream().
                map(ProductResponseDTO::new).toList();
        return ApiResult.successResponse(responseDTOS);
    }

    @Override
    public Boolean editNumberOfProduct(Integer id, Integer numberOfProduct) {
        Product product = productRepository.findById(id).orElseThrow(()->AppException.appThrow("Wrong"));
        Integer numberOfProducts = product.getNumberOfProducts();
        Integer productNumber = numberOfProducts - numberOfProduct;
        Product.ProductBuilder productBuilder = Product.builder();
        productBuilder.name(product.getName());
        productBuilder.imgUrlSet(product.getImgUrlSet());
        productBuilder.prise(product.getPrise());
        productBuilder.availability(true);
        productBuilder.numberOfProducts(productNumber);
        productBuilder.aboutProduct(product.getAboutProduct());
        productBuilder.color(product.getColor());
        productBuilder.manufacture(product.getManufacture());

        Product product1 = productBuilder.build();
        productRepository.save(product1);
        return true;
    }


    private void checkingDataForExistenceAndNonEmpty(Integer id, Object object) {
        if (Objects.isNull(id)) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (Objects.isNull(object)) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
    }

    private void checkAddProduct(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO.getProductName().isEmpty() && productRequestDTO.getProductName().isBlank()) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (productRequestDTO.getPrise() == 0) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
        if (productRequestDTO.getNumberOfProducts() == 0) {
            throw AppException.appThrow(messageSource.getMessage("",
                    null,
                    LocaleContextHolder.getLocale()));
        }
    }

    protected ProductResponseDTO convertProductToProductResponse(Product product) {

        return
                new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        new HashSet<>(product.getImgUrlSet()),
                        product.getPrise(),
                        product.isAvailability(),
                        product.getNumberOfProducts(),
                        product.getAboutProduct(),
                        product.getColor()
                );

    }

    private ProductResponseDTO swapOldProductNewProduct(Product product, ProductRequestDTO productRequestDTO) {
        product.setName(productRequestDTO.getProductName());
        product.setImgUrlSet(new HashSet<>(imgUrlRepository.findAllById(productRequestDTO.getImgId())));
        product.setPrise(productRequestDTO.getPrise());
        product.setAvailability(product.isAvailability());
        product.setNumberOfProducts(product.getNumberOfProducts());
        product.setAboutProduct(productRequestDTO.getAboutProduct());
        product.setColor(colorRepository.findById(
                        productRequestDTO.getColor()).
                orElseThrow(() -> AppException.appThrow("This id.It isn't availability")));
        productRepository.save(product);
        return convertProductToProductResponse(product);
    }
}
