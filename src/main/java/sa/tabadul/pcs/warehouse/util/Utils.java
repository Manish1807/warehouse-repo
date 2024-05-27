package sa.tabadul.pcs.warehouse.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import sa.tabadul.pcs.warehouse.api.v1.request.PaginationRequestModel;
import sa.tabadul.pcs.warehouse.domain.enums.CommonCodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils {

    private Utils() {

    }

    public long generateCRN() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonCodes.CRN_FORMAT.getMessage());
        String formattedDateTime = dateTime.format(formatter);
        return Long.parseLong(formattedDateTime);
    }

    public PageRequest createPageable(PaginationRequestModel pagination) {
        return PageRequest.of(pagination.getPage(), pagination.getLength(),
                Sort.by(Sort.Direction.valueOf(pagination.getSortDir()), pagination.getSort()));
    }
}
