// package name
package Utils;


// import needed library 
import java.io.Serializable;


// ---------------------- main utility class ----------------------
// 1) 
public class Java_Utils { 

    private Utils(){
    };

    // a regular expression which matches commas but not commas within double quotations
    public static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
}


// 2)
public class Response implements Serializable {
    private String country;
    private Integer ageMidPoint;
    private String occupation;
    private Integer salaryMidPoint;

    public Response(String country, Integer ageMidPoint, String occupation, Integer salaryMidPoint) {
        this.country = country;
        this.ageMidPoint = ageMidPoint;
        this.occupation = occupation;
        this.salaryMidPoint = salaryMidPoint;
    }

    public Response() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAgeMidPoint() {
        return ageMidPoint;
    }

    public void setAgeMidPoint(Integer ageMidPoint) {
        this.ageMidPoint = ageMidPoint;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getSalaryMidPoint() {
        return salaryMidPoint;
    }

    public void setSalaryMidPoint(Integer salaryMidPoint) {
        this.salaryMidPoint = salaryMidPoint;
    }

    @Override
    public String toString() {
        return "Response{" +
                "country='" + country + '\'' +
                ", ageMidPoint=" + ageMidPoint +
                ", occupation='" + occupation + '\'' +
                ", salaryMidPoint=" + salaryMidPoint +
                '}';
    }
}

// 3) 
public class AvgCount implements Serializable {
    private int count;
    private double total;

    public AvgCount(int count, double total) {
        this.count = count;
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "AvgCount{" +
                "count=" + count +
                ", total=" + total +
                '}';
    }
}

