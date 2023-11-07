package dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utils.FilmHref;
import utils.StoreHref;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"id", "store", "film"})
@Getter
@Setter
public class InventoryDTO {

    private Integer id;
    private StoreHref store;
    private FilmHref film;

}
