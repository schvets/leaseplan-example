package starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DetailedError {
    private Boolean error;
    private String message;
    @JsonProperty("requested_item")
    private String requestedItem;
    @JsonProperty("served_by")
    private String servedBy;
}
