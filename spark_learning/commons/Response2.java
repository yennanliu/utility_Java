package commons;

import java.io.Serializable;

public class Response2 implements Serializable {
    private String location;
    private Float price;
    private Float size;
    private String status;

    public Response2(String location, Float price, Float size, String status) {
        this.location = location;
        this.price = price;
        this.size = size;
        this.status = status;
    }

    public Response2() {}

    public String getLocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public Float getprice() {
        return price;
    }

    public void setprice(Float price) {
        this.price = price;
    }

    public Float getsize() {
        return size;
    }

    public void setpsize(Float price) {
        this.price = price;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response2{" +
                "location='" + location + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", status=" + status +
                '}';
    }
}
