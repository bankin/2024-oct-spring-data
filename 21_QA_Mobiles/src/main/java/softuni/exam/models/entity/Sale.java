package softuni.exam.models.entity;

import javax.persistence.ManyToOne;

public class Sale {

    @ManyToOne
    private Seller seller;
}
