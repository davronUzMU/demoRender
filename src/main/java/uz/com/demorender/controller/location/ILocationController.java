package uz.com.demorender.controller.location;

import org.springframework.web.bind.annotation.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.locationPaylod.*;
import uz.com.demorender.utils.ApplicationConstants;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = ILocationController.BATH_PATH)
public interface ILocationController {

    String BATH_PATH = ApplicationConstants.BASE_PATH + "/location";


    @PostMapping(value = "/add-location-country")
    ApiResult<ResponseLocationCountryDTO> addLocation(@Valid @RequestBody AddLocationCountryDTO locationDTO);

    @PostMapping(value = "/add-location-region")
    ApiResult<ResponseLocationRegionDTO> addLocationRegion(@Valid @RequestBody AddLocationRegionDTO locationDTO);

    @PostMapping(value = "/add-location-city")
    ApiResult<ResponseLocationCityDTO> addLocationCity(@Valid @RequestBody AddLocationCityDTO locationDTO);

    @PostMapping(value = "/add-location-street")
    ApiResult<ResponseLocationStreetDTO> addLocationStreet(@Valid @RequestBody AddLocationStreetDTO locationDTO);

    @PostMapping(value = "/add-location-house")
    ApiResult<ResponseLocationHouseDTO> addLocationHouse(@Valid @RequestBody AddLocationHouseDTO locationDTO);

    @PostMapping("/edit-location-country/{id}")
    ApiResult<ResponseLocationCountryDTO> editLocation(@Valid @PathVariable Integer id, @RequestBody AddLocationCountryDTO locationDTO);

    @PostMapping("/edit-location-region/{id}")
    ApiResult<ResponseLocationRegionDTO> editLocationRegion(@Valid @PathVariable Integer id, @RequestBody AddLocationRegionDTO locationDTO);

    @PostMapping("/edit-location-city/{id}")
    ApiResult<ResponseLocationCityDTO> editLocationCity(@Valid @PathVariable Integer id, @RequestBody AddLocationCityDTO locationDTO);

    @PostMapping("/edit-location-street/{id}")
    ApiResult<ResponseLocationStreetDTO> editLocationStreet(@Valid @PathVariable Integer id, @RequestBody AddLocationStreetDTO locationDTO);

    @PostMapping("/edit-location-house/{id}")
    ApiResult<ResponseLocationHouseDTO> editLocationHouse(@Valid @PathVariable Integer id, @RequestBody AddLocationHouseDTO locationDTO);


    @GetMapping("/all-Location-country")
    ApiResult<List<?>> allLocationCountry();

    @GetMapping("/all-Location-region")
    ApiResult<List<?>> allLocationRegion();

    @GetMapping("/all-Location-city")
    ApiResult<List<?>> allLocationCity();

    @GetMapping("/all-Location-street")
    ApiResult<List<?>> allLocationStreet();

    @GetMapping("/all-Location-house")
    ApiResult<List<?>> allLocationHouse();

    @GetMapping("/location-country/{id}")
    ApiResult<ResponseLocationCountryDTO> LocationCountryById(@PathVariable Integer id);

    @GetMapping("/location-region/{id}")
    ApiResult<ResponseLocationRegionDTO> LocationRegionById(@PathVariable Integer id);

    @GetMapping("/location-city/{id}")
    ApiResult<ResponseLocationCityDTO> LocationCityById(@PathVariable Integer id);

    @GetMapping("/location-street/{id}")
    ApiResult<ResponseLocationStreetDTO> LocationStreet(@PathVariable Integer id);

    @GetMapping("/location-house/{id}")
    ApiResult<ResponseLocationHouseDTO> LocationHouseById(@PathVariable Integer id);

    @DeleteMapping("/country-delete/{id}")
    ApiResult<Boolean> countryDelete(@PathVariable Integer id);

    @DeleteMapping("/region-delete/{id}")
    ApiResult<Boolean> regionDelete(@PathVariable Integer id);

    @DeleteMapping("/city-delete/{id}")
    ApiResult<Boolean> cityDelete(@PathVariable Integer id);

    @DeleteMapping("/street-delete/{id}")
    ApiResult<Boolean> streetDelete(@PathVariable Integer id);

    @DeleteMapping("/house-delete/{id}")
    ApiResult<Boolean> houseDelete(@PathVariable Integer id);

}
