package pl.sda.final_project.dto;

import pl.sda.final_project.model.UserEntity;

import java.util.Objects;

public class UserDto {

    private String userName;
    private String userCity;


    public static UserDto apply(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.userCity = userEntity.getAddress().getCity();
        userDto.userName = userEntity.getFirstName();
        return userDto;
    }

    public UserDto(String userName, String userCity) {
        this.userName = userName;
        this.userCity = userCity;
    }

    public UserDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(userName, userDto.userName) && Objects.equals(userCity, userDto.userCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userCity);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
