package uz.com.demorender.service;


import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.locationPaylod.*;

import java.util.List;

public interface ILocationService {
    ApiResult<ResponseLocationCountryDTO> addLocationCountry(AddLocationCountryDTO locationDTO);
    ApiResult<ResponseLocationRegionDTO> addLocationRegion(AddLocationRegionDTO locationDTO);

    ApiResult<ResponseLocationCityDTO> addLocationCity(AddLocationCityDTO locationDTO);
    ApiResult<ResponseLocationStreetDTO> addLocationStreet(AddLocationStreetDTO locationDTO);

    ApiResult<ResponseLocationHouseDTO> addLocationHouse(AddLocationHouseDTO locationDTO);

    ApiResult<ResponseLocationCountryDTO> editLocation(Integer id, AddLocationCountryDTO locationDTO);

    ApiResult<ResponseLocationRegionDTO> editLocationRegion(Integer id, AddLocationRegionDTO locationDTO);

    ApiResult<ResponseLocationCityDTO> editLocationCity(Integer id, AddLocationCityDTO locationDTO);

    ApiResult<ResponseLocationStreetDTO> editLocationStreet(Integer id, AddLocationStreetDTO locationDTO);

    ApiResult<ResponseLocationHouseDTO> editLocationHouse(Integer id, AddLocationHouseDTO locationDTO);

    ApiResult<List<?>> allLocationCountry();

    ApiResult<List<?>> allLocationRegion();

    ApiResult<List<?>> allLocationCity();

    ApiResult<List<?>> allLocationStreet();

    ApiResult<List<?>> allLocationHouse();
    
    ApiResult<Boolean> countryDelete(Integer id);

    ApiResult<Boolean> regionDelete(Integer id);

    ApiResult<Boolean> cityDelete(Integer id);

    ApiResult<Boolean> streetDelete(Integer id);

    ApiResult<Boolean> houseDelete(Integer id);

    ApiResult<ResponseLocationCountryDTO> locationCountryById(Integer id);

    ApiResult<ResponseLocationRegionDTO> locationRegionById(Integer id);

    ApiResult<ResponseLocationCityDTO> locationCityById(Integer id);

    ApiResult<ResponseLocationStreetDTO> locationStreetById(Integer id);

    ApiResult<ResponseLocationHouseDTO> locationHouseById(Integer id);
}
