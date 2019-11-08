package com.csrr.mppg.converter;


import com.csrr.mppg.dto.CompanyDTO;
import com.csrr.mppg.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyConverter {

     CompanyConverter INSTANCE = Mappers.getMapper(CompanyConverter.class);



     @Mappings({
             @Mapping(source = "companyId",target = "id"),
             @Mapping(source = "companyName",target = "name"),
             @Mapping(source = "companyAge",target = "age"),
             // @Mapping(target = "address",expression = "java(dto.getCompanyAddress().substring(0,5))")
             @Mapping(source = "companyAddress",target = "address")

     })
     Company DtoToEn(CompanyDTO dto);


     @Mappings({
             @Mapping(target = "companyId", source= "id"),
             @Mapping( target= "companyName",source = "name"),
             @Mapping( target= "companyAge",source = "age"),
             // @Mapping(target = "address",expression = "java(dto.getCompanyAddress().substring(0,5))")
             @Mapping( target= "companyAddress",source = "address")

     })
     CompanyDTO EnToDTO(Company en);
}
