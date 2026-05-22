import java.io.File;
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
            case 1 :
                System.out.println("ALL AVAILALE PROMPTS");
                System.out.println("======================");

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile() && files[i].getName().endsWith(".txt")) {
                    System.out.println((i + 1) + ". " + files[i].getName());
            }
        }
                break;
            default:
                throw new AssertionError();
        }

    }
}