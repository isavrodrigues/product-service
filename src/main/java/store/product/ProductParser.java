package store.product;

public final class ProductParser {

    public static Product toProduct(ProductModel m) {
        if (m == null) return null;
        return Product.builder()
            .id(m.getId())
            .name(m.getName())
            .price(m.getPrice())
            .unit(m.getUnit())
            .build();
    }

    public static ProductModel toModel(Product p) {
        if (p == null) return null;
        var m = new ProductModel();
        m.setId(p.id());
        m.setName(p.name());
        m.setPrice(p.price());
        m.setUnit(p.unit());
        return m;
    }
}
