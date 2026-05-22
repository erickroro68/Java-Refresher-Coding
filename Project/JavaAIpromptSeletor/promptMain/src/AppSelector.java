import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class AppSelector {
    public static void main(String[] args) {

        String promptFolderPath =  "X:\\CODE\\Visual STUDIO\\Customer-MasterPrompt_Launch_Picker\\UsefulPrompts\\private_prompts";
        File Folder = new File(promptFolderPath);
        File[] files = Folder.listFiles();

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("===========================" );
        System.out.println("    PROMPT SELECT MENU     " );
        System.out.println("===========================" );
        System.out.println(" 1) View Prompts" );
        System.out.println(" 2) Quit CLI" );
    
        switch (userInput) {
            case 1 :
                System.out.println("ALL AVAILALE PROMPTS");

                break;
            default:
                throw new AssertionError();
        }

    }
}