package Model;

public final class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String address;
    private final String phonesHome;
    private final String email;

    public ContactData(String firstName, String middleName, String lastName, String nickName, String address, String phonesHome, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.address = address;
        this.phonesHome = phonesHome;
        this.email = email;
    }

    public String firstName() {
        return firstName;
    }
    public String middleName(){
        return middleName;
    }
    public String lastName(){
        return lastName;
    }
    public String nickName(){
        return nickName;
    }
    public String address(){
        return address;
    }
    public String phonesHome(){
        return phonesHome;
    }
    public String email(){
        return email;
    }
}