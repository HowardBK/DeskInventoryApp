package inventory.bomlines;

import inventory.bom.Bom;
import inventory.item.Item;
import jakarta.persistence.*;

@Entity
public class BomLine {
    @Id
    @GeneratedValue(generator = "bomline_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bomline_gen", initialValue = 1, allocationSize = 1, sequenceName = "bomline_seq")
    @Column(name = "bomline_id")
    private Long bomlineId;

    @ManyToOne
    @JoinColumn(name = "bom_id")
    private Bom bom;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    public Long getBomlineId() {
        return bomlineId;
    }

    public void setBomlineId(Long bomlineId) {
        this.bomlineId = bomlineId;
    }

    public Bom getBom() {
        return bom;
    }

    public void setBom(Bom bom) {
        this.bom = bom;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
