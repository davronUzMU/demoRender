package uz.com.demorender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import uz.com.demorender.exceptions.AppException;
import uz.com.demorender.model.location.*;
import uz.com.demorender.payload.ApiResult;
import uz.com.demorender.payload.locationPaylod.*;
import uz.com.demorender.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class LocationService implements ILocationService{


    private final LocationCountryRepository locationCountryRepository;

    private final LocationRegionRepository locationRegionRepository;

    private final LocationCityRepository locationCityRepository;

    private  final LocationStreetRepository locationStreetRepository;

    private final LocationHouseRepository locationHouseRepository;

    private final MessageSource messageSource;


    @Override
    public ApiResult<ResponseLocationCountryDTO> addLocationCountry(AddLocationCountryDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationCountry.LocationCountryBuilder countryBuilder = LocationCountry.builder();
        countryBuilder.country(locationDTO.getCountry());
        countryBuilder.region(new HashSet<>(locationRegionRepository.findAllById(locationDTO.getRegions())));
        LocationCountry country = locationCountryRepository.save(countryBuilder.build());
        return ApiResult.successResponse(new ResponseLocationCountryDTO(country.getId(),country.getCountry(),responseRegionList(locationDTO.getRegions())));
    }


    @Override
    public ApiResult<ResponseLocationRegionDTO> addLocationRegion(AddLocationRegionDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationRegion.LocationRegionBuilder regionBuilder = LocationRegion.builder();
        regionBuilder.region(locationDTO.getRegion());
        regionBuilder.regionParentId(locationDTO.getRegionParentId());
        regionBuilder.locationCitySet(new HashSet<>(locationCityRepository.findAllById(locationDTO.getLocationCitySet())));
        LocationRegion region = locationRegionRepository.save(regionBuilder.build());
        return ApiResult.successResponse(new ResponseLocationRegionDTO(region.getId(), region.getRegion(), region.getRegionParentId(), responseCityList(locationDTO.getLocationCitySet())));
    }


    @Override
    public ApiResult<ResponseLocationCityDTO> addLocationCity(AddLocationCityDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationCity.LocationCityBuilder builder = LocationCity.builder();
        builder.city(locationDTO.getCity());
        builder.cityParentId(locationDTO.getCityParentId());
        builder.locationStreetSet(new HashSet<>(locationStreetRepository.findAllById(locationDTO.getLocationStreetSet())));
        LocationCity city = locationCityRepository.save(builder.build());
        return ApiResult.successResponse(new ResponseLocationCityDTO(city.getId(),city.getCity(),city.getCityParentId(),responseStreetList(locationDTO.getLocationStreetSet())));
    }

    @Override
    public ApiResult<ResponseLocationStreetDTO> addLocationStreet(AddLocationStreetDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationStreet.LocationStreetBuilder locationStreetBuilder = LocationStreet.builder();
        locationStreetBuilder.street(locationDTO.getStreet());
        locationStreetBuilder.streetParentId(locationDTO.getStreetParentId());
        locationStreetBuilder.locationHouseSet(new HashSet<>(locationHouseRepository.findAllById(locationDTO.getLocationHouseSet())));
        LocationStreet street = locationStreetRepository.save(locationStreetBuilder.build());
        return ApiResult.successResponse(new ResponseLocationStreetDTO(street.getId(),street.getStreet(),street.getStreetParentId(),responseHouseList(locationDTO.getLocationHouseSet())));
    }

    @Override
    public ApiResult<ResponseLocationHouseDTO> addLocationHouse(AddLocationHouseDTO locationDTO) {
        checkIsObject(locationDTO);
        checkIsObject(locationDTO);
        LocationHouse.LocationHouseBuilder locationHouseBuilder = LocationHouse.builder();
        locationHouseBuilder.houseAddress(locationDTO.getHouseAddress());
        locationHouseBuilder.parentId(locationDTO.getParentId());
        LocationHouse house = locationHouseRepository.save(locationHouseBuilder.build());
        return ApiResult.successResponse(new ResponseLocationHouseDTO(house.getId(),house.getHouseAddress(),house.getParentId()));
    }


    @Override
    public ApiResult<ResponseLocationCountryDTO> editLocation(Integer id, AddLocationCountryDTO locationDTO) {
        checkIsObject(locationDTO);
        checkThisIdCountryAvailability(id);
        LocationCountry country =checkThisIdCountryAvailability(id);
        country.setCountry(locationDTO.getCountry());
        country.setRegion(new HashSet<>(locationRegionRepository.findAllById(locationDTO.getRegions())));
        locationCountryRepository.save(country);
        return ApiResult.successResponse(new ResponseLocationCountryDTO(country.getId(),country.getCountry(),null));
    }


    @Override
    public ApiResult<ResponseLocationRegionDTO> editLocationRegion(Integer id, AddLocationRegionDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationRegion locationRegion = checkThisIdRegionAvailability(id);
        locationRegion.setRegion(locationRegion.getRegion());
        locationRegion.setRegionParentId(locationRegion.getRegionParentId());
        locationRegion.setLocationCitySet(new HashSet<>(locationCityRepository.findAllById(locationDTO.getLocationCitySet())));
        locationRegionRepository.save(locationRegion);
        return ApiResult.successResponse(new ResponseLocationRegionDTO(locationRegion.getId(),locationRegion.getRegion(),locationRegion.getRegionParentId(),null));
    }


    @Override
    public ApiResult<ResponseLocationCityDTO> editLocationCity(Integer id, AddLocationCityDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationCity city = checkThisIdCityAvailability(id);
        city.setCity(locationDTO.getCity());
        city.setCityParentId(locationDTO.getCityParentId());
        city.setLocationStreetSet(new HashSet<>(locationStreetRepository.findAllById(locationDTO.getLocationStreetSet())));
        locationCityRepository.save(city);
        return ApiResult.successResponse(new ResponseLocationCityDTO(city.getId(),city.getCity(),city.getCityParentId(),null));
    }


    @Override
    public ApiResult<ResponseLocationStreetDTO> editLocationStreet(Integer id, AddLocationStreetDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationStreet locationStreet = checkThisIdStreetAvailability(id);
        locationStreet.setStreet(locationDTO.getStreet());
        locationStreet.setStreetParentId(locationStreet.getStreetParentId());
        locationStreet.setLocationHouseSet(new HashSet<>(locationHouseRepository.findAllById(locationDTO.getLocationHouseSet())));
        locationStreetRepository.save(locationStreet);
        return ApiResult.successResponse(new ResponseLocationStreetDTO(locationStreet.getId(),locationStreet.getStreet(),locationStreet.getStreetParentId(),null));
    }


    @Override
    public ApiResult<ResponseLocationHouseDTO> editLocationHouse(Integer id, AddLocationHouseDTO locationDTO) {
        checkIsObject(locationDTO);
        LocationHouse locationHouse = checkThisIdHouseAvailability(id);
        locationHouse.setHouseAddress(locationDTO.getHouseAddress());
        locationHouse.setParentId(locationHouse.getParentId());
        locationHouseRepository.save(locationHouse);
        return ApiResult.successResponse(new ResponseLocationHouseDTO(locationHouse.getId(), locationHouse.getHouseAddress(), locationHouse.getParentId()));
    }



    @Override
    public ApiResult<List<?>> allLocationCountry() {
        return ApiResult.successResponse(locationCountryRepository.findAll());
    }

    @Override
    public ApiResult<List<?>> allLocationRegion() {
        return ApiResult.successResponse(locationRegionRepository.findAll());
    }

    @Override
    public ApiResult<List<?>> allLocationCity() {
        return ApiResult.successResponse(locationCityRepository.findAll());
    }

    @Override
    public ApiResult<List<?>> allLocationStreet() {
        return ApiResult.successResponse(locationStreetRepository.findAll());
    }

    @Override
    public ApiResult<List<?>> allLocationHouse() {
        return ApiResult.successResponse(locationHouseRepository.findAll());
    }



    @Override
    public ApiResult<Boolean> countryDelete(Integer id) {
        LocationCountry country = checkThisIdCountryAvailability(id);
        locationCountryRepository.deleteById(country.getId());
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> regionDelete(Integer id) {
        LocationRegion locationRegion = checkThisIdRegionAvailability(id);
        locationRegionRepository.deleteById(locationRegion.getId());
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> cityDelete(Integer id) {
        LocationCity city = checkThisIdCityAvailability(id);
        locationCityRepository.deleteById(city.getId());
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> streetDelete(Integer id) {
        LocationHouse locationHouse = checkThisIdHouseAvailability(id);
        checkThisIdHouseAvailability(locationHouse.getId());
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<Boolean> houseDelete(Integer id) {
        return null;
    }

    @Override
    public ApiResult<ResponseLocationCountryDTO> locationCountryById(Integer id) {
        LocationCountry country = checkThisIdCountryAvailability(id);
        return ApiResult.successResponse(new ResponseLocationCountryDTO(country.getId(),country.getCountry(),responseCountryChildrenById(id)));
    }



    @Override
    public ApiResult<ResponseLocationRegionDTO> locationRegionById(Integer id) {
        LocationRegion locationRegion = checkThisIdRegionAvailability(id);
        return ApiResult.successResponse(new ResponseLocationRegionDTO(locationRegion.getId(),locationRegion.getRegion(), locationRegion.getRegionParentId(),responseRegionChildrenById(id)));
    }


    @Override
    public ApiResult<ResponseLocationCityDTO> locationCityById(Integer id) {
        LocationCity city = checkThisIdCityAvailability(id);
        return ApiResult.successResponse(new ResponseLocationCityDTO(city.getId(),city.getCity(),city.getCityParentId(),responseCityChildrenById(id)));
    }


    @Override
    public ApiResult<ResponseLocationStreetDTO> locationStreetById(Integer id) {
        LocationStreet locationStreet = checkThisIdStreetAvailability(id);
        return ApiResult.successResponse(new ResponseLocationStreetDTO(locationStreet.getId(),locationStreet.getStreet(),locationStreet.getStreetParentId(),responseStreetChildrenById(id)));
    }


    @Override
    public ApiResult<ResponseLocationHouseDTO> locationHouseById(Integer id) {
        LocationHouse locationHouse = checkThisIdHouseAvailability(id);
        return ApiResult.successResponse(new ResponseLocationHouseDTO(locationHouse.getId(),locationHouse.getHouseAddress(),locationHouse.getParentId()));
    }

    private void checkIsObject(Object locationDTO) {
        if(Objects.isNull(locationDTO))
            throw AppException.appThrow(messageSource.getMessage(
                    "WRONG_WEIGHT",
                    null,
                    LocaleContextHolder.getLocale()
            ));
    }
    private LocationCountry checkThisIdCountryAvailability(Integer id) {
       return locationCountryRepository.findById(id).orElseThrow(
                () -> AppException.appThrow(messageSource.getMessage("WRONG_WEIGHT",
                null,
                LocaleContextHolder.getLocale())));
    }
    private LocationRegion checkThisIdRegionAvailability(Integer id) {
        return locationRegionRepository.findById(id).orElseThrow(()->
                AppException.appThrow(messageSource.getMessage("WRONG_WEIGHT",
                        null,
                        LocaleContextHolder.getLocale()))
        );
    }
    private LocationCity checkThisIdCityAvailability(Integer id) {
        return locationCityRepository.findById(id).orElseThrow(()->
                AppException.appThrow(messageSource.getMessage("WRONG_WEIGHT",
                        null,
                        LocaleContextHolder.getLocale())));
    }
    private LocationStreet checkThisIdStreetAvailability(Integer id) {
        return locationStreetRepository.findById(id).orElseThrow(()->
                AppException.appThrow(messageSource.getMessage("WRONG_WEIGHT",
                        null,
                        LocaleContextHolder.getLocale())));
    }
    private LocationHouse checkThisIdHouseAvailability(Integer id) {
        return locationHouseRepository.findById(id).orElseThrow(()->
                AppException.appThrow(messageSource.getMessage("WRONG_WEIGHT",
                        null,
                        LocaleContextHolder.getLocale())));
    }
    private Set<LocationRegion> responseRegionList(Set<Integer> regions) {
        List<LocationRegion> allById = locationRegionRepository.findAllById(regions);
        return new HashSet<>(allById);
    }
    private Set<LocationCity> responseCityList(Set<Integer> citys) {
        List<LocationCity> allById = locationCityRepository.findAllById(citys);
        return new HashSet<>(allById);
    }
    private Set<LocationStreet> responseStreetList(Set<Integer> streets) {
        List<LocationStreet> allById = locationStreetRepository.findAllById(streets);
        return new HashSet<>(allById);
    }
    private Set<LocationHouse> responseHouseList(Set<Integer> houses) {
        List<LocationHouse> allById = locationHouseRepository.findAllById(houses);
        return new HashSet<>(allById);
    }
    private Set<LocationRegion> responseCountryChildrenById(Integer id) {
        List<LocationRegion> all = locationRegionRepository.findAll();
        Set<LocationRegion> locationRegions=new HashSet<>();
        for (LocationRegion locationRegion : all) {
            if(Objects.equals(locationRegion.getRegionParentId(), id)){
                locationRegions.add(locationRegion);
            }
        }
        return locationRegions;
    }
    private Set<LocationCity> responseRegionChildrenById(Integer id) {
        List<LocationCity> all = locationCityRepository.findAll();
        Set<LocationCity> locationCity=new HashSet<>();
        for (LocationCity city : all) {
            if(Objects.equals(city.getCityParentId(),id)){
                locationCity.add(city);
            }
        }
        return locationCity;
    }
    private Set<LocationStreet> responseCityChildrenById(Integer id) {
        List<LocationStreet> all = locationStreetRepository.findAll();
        Set<LocationStreet> locationStreetSet=new HashSet<>();
        for (LocationStreet locationStreet : all) {
            if(Objects.equals(locationStreet.getStreetParentId(),id)){
                locationStreetSet.add(locationStreet);
            }
        }
        return locationStreetSet;
    }
    private Set<LocationHouse> responseStreetChildrenById(Integer id) {
        List<LocationHouse> all = locationHouseRepository.findAll();
        Set<LocationHouse> locationHouseSet=new HashSet<>();
        for (LocationHouse locationHouse : all) {
            if(Objects.equals(locationHouse.getParentId(),id)){
                locationHouseSet.add(locationHouse);
            }
        }

        return locationHouseSet;
    }
}
