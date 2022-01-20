package ru.netology.domain;

public class SmartPhone extends Product {
    private String company;

    public SmartPhone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public SmartPhone() {
    }

    public SmartPhone(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getCompany().contains(search);
    }
}
