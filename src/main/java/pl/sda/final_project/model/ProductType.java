package pl.sda.final_project.model;

public enum ProductType {

    /**
     * empty brackets are to call default constructor
     */
    FOOD("jadalne"),
    NOT_FOOD("niejadalne");

    private final String plName;

    ProductType(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
