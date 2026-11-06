package inventory.item;

import inventory.bomlines.BomLine;
import inventory.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Map<Long, Integer> calculateRequirements(Long itemId, int quantity){
        Map<Long, Integer> requirements = new HashMap<>();
        Item item = itemRepository.findById(itemId).orElseThrow(()-> new ItemNotFoundException("Item not found"));
        calculateAllRequirementsForItem(item, quantity, requirements);
        return requirements;
    }


    private void calculateAllRequirementsForItem(Item item, int quantity, Map<Long, Integer> requirements){
        if (item.getBom()==null){
            requirements.merge(item.getItemId(), quantity, Integer::sum);
            return;
        }
        for(BomLine bomLine: item.getBom().getBomlines()){
            int requiredQuantity = bomLine.getQuantity() * quantity;
            calculateAllRequirementsForItem(bomLine.getItem(), requiredQuantity, requirements);
        }
    }

}
