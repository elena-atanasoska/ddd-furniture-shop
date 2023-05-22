package mk.ukim.finki.mk.ordermanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {
    private OrderItemId() {
        super(OrderItemId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String uuid) {
        super(uuid);
    }
}
