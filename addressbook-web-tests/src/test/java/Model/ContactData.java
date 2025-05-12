package Model;

public record ContactData(String id, String firstName, String middleName, String lastName, String nickName,
                          String address, String photo, String phonesHome, String email, String email2, String email3,
                          String home, String mobile,
                          String work, String secondary) {

    public ContactData() {
        this("", "", "", "", "", "", "", "","", "", "", "", "", "", "");

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withFistName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, this.middleName, lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withNickName(String nickName) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withPhonesHome(String phonesHome) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, email, this.email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withEmailSecond(String email2) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, email2, this.email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withEmailThree(String email3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, email3, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, home, this.mobile, this.work, this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, mobile, this.work, this.secondary);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, work, this.secondary);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.address, this.photo, this.phonesHome, this.email, this.email2, this.email3, this.home, this.mobile, this.work, secondary);
    }
}