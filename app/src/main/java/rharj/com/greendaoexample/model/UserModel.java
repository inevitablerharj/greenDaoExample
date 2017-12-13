package rharj.com.greendaoexample.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by rharj on 12/13/2017.
 */
@Entity(nameInDb = "user_details")
public class UserModel {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "Fname")
    private String Fname;

    @Property(nameInDb = "Lname")
    private String Lname;

    @Property(nameInDb = "address")
    private String address;

    @Property(nameInDb = "occupation")
    private String occupation;

    @Generated(hash = 916967517)
    public UserModel(Long id, String Fname, String Lname, String address,
            String occupation) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.address = address;
        this.occupation = occupation;
    }

    @Generated(hash = 782181818)
    public UserModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return this.Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return this.Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


}
