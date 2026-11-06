package inventory.bom;

import inventory.bomlines.BomLine;
import inventory.item.Item;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bom {
    @Id
    @GeneratedValue(generator = "bom_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bom_gen", initialValue = 1, allocationSize = 1, sequenceName = "bom_seq")
    @Column(name = "bom_id")
    private Long bomId;

    @OneToOne
    @JoinColumn(name = "item_id",nullable = false,unique = true)
    private Item item;

    @OneToMany(mappedBy = "bom")
    private List<BomLine> bomlines = new ArrayList<>();


    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<BomLine> getBomlines() {
        return bomlines;
    }

    public void setBomlines(List<BomLine> bomlines) {
        this.bomlines = bomlines;
    }
}
