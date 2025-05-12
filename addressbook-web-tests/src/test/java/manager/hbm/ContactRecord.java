package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;

    public String firstname;

    public String middlename;

    public String lastname;

    public String nickname;

    public String address;

    public String home;

    public String mobile;

    public String work;

    public String phone2;

    public String email;

    public String email2;

    public String email3;

    public ContactRecord (){
    }
    public ContactRecord (int id, String firstname, String middlename, String lastname, String nickname, String address){
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.address = address;
    }
}
