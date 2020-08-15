package com.exam10.DTO;



import com.exam10.model.Role;
import com.exam10.model.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class UserDTO {
    private int id;
    private String email;
    private String fullName;
    private Role role;
    private String password;
    public static UserDTO from(User user){
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .build();
    }
}
