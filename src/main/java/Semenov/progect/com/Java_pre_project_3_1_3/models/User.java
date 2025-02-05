package Semenov.progect.com.Java_pre_project_3_1_3.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "users")
public class User implements  UserDetails {

    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq",initialValue = 1, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name="usersurname")
    private String userSurname;
    private Integer age;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set <Role> role = new HashSet<>();

    public User(){}


    public User(String userName, String userSurname, Integer age, String password){
        this.age = age;
        this.userSurname = userSurname;
        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String userSurname, Integer age, String password, Set <Role> role){
        this.age = age;
        this.userSurname = userSurname;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(User user) {}

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && userName.equals(user.userName) && Objects.equals(userSurname, user.userSurname)
                && password.equals(user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userSurname, age);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole().stream()
                .map(Role::getNameRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


