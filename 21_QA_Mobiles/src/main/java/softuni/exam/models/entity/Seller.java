package softuni.exam.models.entity;

import javax.persistence.OneToMany;
import java.util.List;

public class Seller {

    @OneToMany(mappedBy = "seller")
    private List<Sale> sales;
}
