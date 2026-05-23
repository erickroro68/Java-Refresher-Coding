import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class AppSelector {
    public static void main(String[] args) {

        String promptsFolderPath =  "X:\\CODE\\Visual STUDIO\\Customer-MasterPrompt_Launch_Picker\\UsefulPrompts\\private_prompts";
        File Folder = new File(promptsFolderPath);
        File[] files = Folder.listFiles();

        Scanner userInput = new Scanner(System.in);

        System.out.println("===========================" );
        System.out.println("    PROMPT SELECT MENU     " );
        System.out.println("===========================" );
        System.out.println(" 1) View Prompts" );
        System.out.println(" 2) Quit CLI" );
        
        //adding and or changing so Scanner has to be a Integer input / 'userInput'
        int usersChoice = userInput.nextInt();
        switch (usersChoice) {
            case 1:
                System.out.println("ALL AVAILALE PROMPTS");
                System.out.println("======================");

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile() && files[i].getName().endsWith(".txt")) {
                    System.out.println((i + 1) + ". " + files[i].getName());
                    }
                }
                System.out.println("======================");
                System.out.println("=== PICK A PROMPT ===");
                System.out.println("======================");

                int usersPromptPicker = userInput.nextInt();
                //add a copied to clipboard action and maybe another switch statement 

                try {
                File chosenFile = files[usersPromptPicker - 1];
                Path selectedPath = chosenFile.toPath();
                //diosplay the text in the file we chose
                String dissplayFileString = Files.readString(selectedPath);
                System.out.println("======================");
                System.out.println("==== PROMPTs TEXT ====");
                System.out.println("======================");
                System.out.println(dissplayFileString);
                    
                } catch (Exception e) {
                System.err.println("UNKOWN PROMPT FILE");
                }
                

                break;
            case 2:
                System.out.println("EXITING APPLICATION");
                break;
            default:
                System.out.println("ERROR: NOT A VALID OPTION CHOOSE A DIFFERENT OPTION");
                break;
        
            }

    }
}