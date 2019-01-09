package unknow.daoproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    public List<String> list = new ArrayList<>();
    private Integer id;

    private String user;

    private String pass;

    public User() {
        for (int i=0; i<100000; i++) {
            list.add(new String("asdasdasqewqwezcrewrw") + Math.random() + Math.random());
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }
}