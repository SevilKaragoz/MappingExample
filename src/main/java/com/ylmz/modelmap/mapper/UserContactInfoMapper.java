package com.ylmz.modelmap.mapper;

import com.ylmz.modelmap.request.UserContactRequest;
import com.ylmz.modelmap.response.UserContactResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserContactInfoMapper {

    UserContactInfoMapper INSTANCE = Mappers.getMapper(UserContactInfoMapper.class);

    @Mapping(source = "name", target = "userName") // farklı alan isimleri varsa
    @Mapping( target = "fullName" , expression = "java(userContactRequest.getName() + \" \" + userContactRequest.getLName())")
    @Mapping(target = "status", source = "status", defaultValue = "ACTIVE") // string to Enum, boş gelirse ACTIVE yapacak
    @Mapping(source = ".", target = "address", qualifiedByName = "fullAddress") // method ile concat edecek
    @Mapping(target = "idenNumber", ignore = true)
    UserContactResponse toResponse(UserContactRequest userContactRequest);

    @Named("fullAddress")
    default String getFullAddress(UserContactRequest request) {

        return """
                %s, %s , %s""".formatted(request.getStreet(),  request.getPostCode(), request.getCity());
    }

}
