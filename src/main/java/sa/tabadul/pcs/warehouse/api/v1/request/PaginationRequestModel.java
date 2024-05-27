package sa.tabadul.pcs.warehouse.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaginationRequestModel {


    FilterRequest filter;
    private int draw;
    private int length;
    private String search;
    private int start;
    private int page;
    private String sort;
    private String sortDir;
    private Key keys;

}