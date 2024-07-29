package uz.com.demorender.controller.location;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.locationPaylod.*;
import uz.com.demorender.service.ILocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController implements ILocationController{

    private final ILocationService locationService;


    @Override
    public ApiResult<ResponseLocationCountryDTO> addLocation(AddLocationCountryDTO locationDTO) {
        return locationService.addLocationCountry(locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationRegionDTO> addLocationRegion(AddLocationRegionDTO locationDTO) {
        return locationService.addLocationRegion(locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationCityDTO> addLocationCity(AddLocationCityDTO locationDTO) {
        return locationService.addLocationCity(locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationStreetDTO> addLocationStreet(AddLocationStreetDTO locationDTO) {
        return locationService.addLocationStreet(locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationHouseDTO> addLocationHouse(AddLocationHouseDTO locationDTO) {
        return locationService.addLocationHouse(locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationCountryDTO> editLocation(Integer id, AddLocationCountryDTO locationDTO) {
        return locationService.editLocation(id,locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationRegionDTO> editLocationRegion(Integer id, AddLocationRegionDTO locationDTO) {
        return locationService.editLocationRegion(id,locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationCityDTO> editLocationCity(Integer id, AddLocationCityDTO locationDTO) {
        return locationService.editLocationCity(id,locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationStreetDTO> editLocationStreet(Integer id, AddLocationStreetDTO locationDTO) {
        return locationService.editLocationStreet(id,locationDTO);
    }

    @Override
    public ApiResult<ResponseLocationHouseDTO> editLocationHouse(Integer id, AddLocationHouseDTO locationDTO) {
        return locationService.editLocationHouse(id,locationDTO);
    }

    @Override
    public ApiResult<List<?>> allLocationCountry() {
        return locationService.allLocationCountry();
    }

    @Override
    public ApiResult<List<?>> allLocationRegion() {
        return locationService.allLocationRegion();
    }

    @Override
    public ApiResult<List<?>> allLocationCity() {
        return locationService.allLocationCity();
    }

    @Override
    public ApiResult<List<?>> allLocationStreet() {
        return locationService.allLocationStreet();
    }

    @Override
    public ApiResult<List<?>> allLocationHouse() {
        return locationService.allLocationHouse();
    }

    @Override
    public ApiResult<ResponseLocationCountryDTO> LocationCountryById(Integer id) {
        return locationService.locationCountryById(id);
    }

    @Override
    public ApiResult<ResponseLocationRegionDTO> LocationRegionById(Integer id) {
        return locationService.locationRegionById(id);
    }

    @Override
    public ApiResult<ResponseLocationCityDTO> LocationCityById(Integer id) {
        return locationService.locationCityById(id);
    }

    @Override
    public ApiResult<ResponseLocationStreetDTO> LocationStreet(Integer id) {
        return locationService.locationStreetById(id);
    }

    @Override
    public ApiResult<ResponseLocationHouseDTO> LocationHouseById(Integer id) {
        return locationService.locationHouseById(id);
    }


    @Override
    public ApiResult<Boolean> countryDelete(Integer id) {
        return locationService.countryDelete(id);
    }

    @Override
    public ApiResult<Boolean> regionDelete(Integer id) {
        return locationService.regionDelete(id);
    }

    @Override
    public ApiResult<Boolean> cityDelete(Integer id) {
        return locationService.cityDelete(id);
    }

    @Override
    public ApiResult<Boolean> streetDelete(Integer id) {
        return locationService.streetDelete(id);
    }

    @Override
    public ApiResult<Boolean> houseDelete(Integer id) {
        return locationService.houseDelete(id);
    }
}
