package inventory.item;

import inventory.bom.Bom;
import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator = "item_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "item_gen", initialValue = 1, allocationSize = 1, sequenceName = "item_seq")

    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_description")
    private String itemDescription;

    @OneToOne(mappedBy = "item")
    private Bom bom;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Bom getBom() {
        return bom;
    }

    public void setBom(Bom bom) {
        this.bom = bom;
    }
}
