package com.example.plantsstore.Modals;

public class Modal1 {
    private int p_image;
    private String p_name;
    private String p_price;

    public Modal1() {
    }

    public int getP_image() {
        return p_image;
    }

    public void setP_image(int p_image) {
        this.p_image = p_image;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    @Override
    public String toString() {
        return "Modal1{" +
                "p_image=" + p_image +
                ", p_name='" + p_name + '\'' +
                ", p_price='" + p_price + '\'' +
                '}';
    }
}
