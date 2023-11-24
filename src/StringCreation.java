import java.time.LocalDate;
import java.time.ZoneId;

public class StringCreation {
    public static String currentDate() {
        StringBuilder currentDate = new StringBuilder();
        ZoneId z = ZoneId.of("Europe/Prague");
        //YYYY-MM-DD
        LocalDate today = LocalDate.now (z);
        String stringToday = today.toString();
        int[] array = {8, 9, 5, 6, 0, 3};
        int j = 0, k = 1;
        for(int i = 0; i < 3; i++) {
            String temporaryString;
            temporaryString = stringToday.substring(array[j], array[k] + 1);
            if(temporaryString.startsWith("0")) {
                currentDate.append(temporaryString.substring(1));
            }
            else {
                currentDate.append(temporaryString);
            }
            if(i < 2) {
                currentDate.append(". ");
            }
            j += 2;
            k += 2;
        }
        return currentDate.toString();
    }
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
    public static String createWeb(boolean authorOrOrganization, boolean chcbNameOrganization, String surname, String name,
                                   String shortcutOrganisation, String nameOrganization, String year, String articleName,
                                   String link) {
        String finalString = "";
        if(authorOrOrganization) {
            finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ".";
        }
        else {
            finalString += shortcutOrganisation.toUpperCase();
        }
        finalString += " (" + year + "): " + articleName + ", ";
        if(chcbNameOrganization) {
            finalString += nameOrganization + ", ";
        }
        else {
            finalString += shortcutOrganisation + ", ";
        }
        finalString += link + " (" + currentDate() + ")";
        return finalString;
    }
}
