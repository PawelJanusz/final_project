package pl.sda.final_project.model;

public enum ProductType {

    FOOD("jadalne"),  // puste nawiasy to wywoływanie konstruktora domyślnego
    NOT_FOOD("niejadalne");

    private String plName;

    ProductType(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
