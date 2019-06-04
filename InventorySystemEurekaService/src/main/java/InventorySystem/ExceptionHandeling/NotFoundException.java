package inventorysystem.exceptionhandeling;

public class NotFoundException extends Exception {
    private final String item;

    public static NotFoundException createWith(String item) {
        return new NotFoundException(item);
    }

    private NotFoundException(String item) {
        this.item = item;
    }

    @Override
    public String getMessage() {
        return "Item  '" + item + "' not found";
    }
}
