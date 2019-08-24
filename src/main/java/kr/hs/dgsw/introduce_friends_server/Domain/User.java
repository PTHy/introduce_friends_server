package kr.hs.dgsw.introduce_friends_server.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.security.MessageDigest;

@Entity
@Data
public class User {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String account;

    @Column(nullable = false)
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String phoneNumber;

    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(), 0, password.getBytes().length);
            this.password = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(ex.getMessage());
        }
    }
}
