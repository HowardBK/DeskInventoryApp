package inventory.bom;

import inventory.bomlines.BomLineDto;

import java.util.List;

public record BomDto(
        Long id,
        List<BomLineDto> bomlines
) {
}
