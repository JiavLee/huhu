package top.banbianjia.cloud.member.domain;

public class User {
    private Long id;

    private String name;

    private String password;

    private String personal_statement;

    private String avatar;

    private Boolean sex;

    private String place_of_residence;

    private String industry;

    private String company;

    private String profession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonal_statement() {
        return personal_statement;
    }

    public void setPersonal_statement(String personal_statement) {
        this.personal_statement = personal_statement;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPlace_of_residence() {
        return place_of_residence;
    }

    public void setPlace_of_residence(String place_of_residence) {
        this.place_of_residence = place_of_residence;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}