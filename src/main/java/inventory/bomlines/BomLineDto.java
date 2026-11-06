package inventory.bomlines;

import inventory.item.ItemSummaryDto;

public record BomLineDto(

        Long id,
        int quantity,
        ItemSummaryDto item
) {

}
