package com.ylmz.modelmap.mapper;

import com.ylmz.modelmap.enums.UserStatus;
import com.ylmz.modelmap.request.UserContactRequest;
import com.ylmz.modelmap.response.UserContactResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-16T00:45:38+0100",
    comments = "version: 1.6.1, compiler: javac, environment: Java 21.0.2 (Homebrew)"
)
public class UserContactInfoMapperImpl implements UserContactInfoMapper {

    @Override
    public UserContactResponse toResponse(UserContactRequest userContactRequest) {
        if ( userContactRequest == null ) {
            return null;
        }

        UserContactResponse userContactResponse = new UserContactResponse();

        userContactResponse.setUserName( userContactRequest.getName() );
        if ( userContactRequest.getStatus() != null ) {
            userContactResponse.setStatus( Enum.valueOf( UserStatus.class, userContactRequest.getStatus() ) );
        }
        else {
            userContactResponse.setStatus( UserStatus.ACTIVE );
        }
        userContactResponse.setAddress( getFullAddress( userContactRequest ) );
        userContactResponse.setPhoneNumber( userContactRequest.getPhoneNumber() );

        userContactResponse.setFullName( userContactRequest.getName() + " " + userContactRequest.getLName() );

        return userContactResponse;
    }
}
