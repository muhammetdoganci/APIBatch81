package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DuumyRestApiResponseBodyPojo {

    private String status;
    private DuumyRestApiDataPojo data;
    private String message;

    public DuumyRestApiResponseBodyPojo(String status, DuumyRestApiDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DuumyRestApiResponseBodyPojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DuumyRestApiDataPojo getData() {
        return data;
    }

    public void setData(DuumyRestApiDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DuumyRestApiResponseBodyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
