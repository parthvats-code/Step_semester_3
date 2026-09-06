public class FileExtensionValidator {
    String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');

        if (dot == -1)
            return "Rejected — invalid file type";

        String extension = filename.substring(dot + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip"))
            return "Accepted";

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        FileExtensionValidator obj = new FileExtensionValidator();
        System.out.println(obj.validateFileExtension("Assignment1.PDF"));
    }
}
