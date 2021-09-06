package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private String email;
    private String password;
    private String confirmPassword;
    private String pid;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
