public class StringCreation {
    public static String createBook(String surname, String name, String year, String nameOfBook, String publisher, String cityOfPublishing) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfBook +
                ". " + publisher + ", " + cityOfPublishing + ".";
        return finalString;
    }
    public static String createMagazine(String surname, String name, String year, String nameOfArticle, String nameOfMagazine, String volume, String issue, String pages) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfArticle +
                ". " + nameOfMagazine + ", " + volume + ", " + issue + ", " + pages + ".";
        return finalString;
    }
    public static String createChapter(String surname, String name, String year, String nameOfChapter, boolean editor, String surnameEditor,
                                       String nameEditor, String nameBook, String publisher, String city, String pages) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfChapter +
        ". In: " + surnameEditor + ", " + nameEditor.charAt(0) + ".";
        if(editor) {
            finalString += " (ed.)";
        }
        finalString += ": " + nameBook + ". " + publisher + ", " + city + ", " + pages + ".";
        return finalString;
    }
}
