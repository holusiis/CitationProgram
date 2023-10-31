public class StringCreation {
    public static String create(String surname, String name, String year, String nameOfBook, String publisher, String cityOfPublishing) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfBook +
        ". " + publisher + ", " + cityOfPublishing + ".";
        return finalString;
    }
}
