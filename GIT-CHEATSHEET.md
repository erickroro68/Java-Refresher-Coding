📌 1. Before starting a new challenge
Always pull the latest changes from GitHub:

git pull origin main --allow-unrelated-histories

(If your repo uses master, replace main with master.)
📌 2. Add your new challenge folder
Create your folder normally in VS  or File Explorer.
Example:
ScoreSorter/
TopScoreSorter/
MeanMode/

📌 3. Stage all new files

git add .

OR STAGE A SPECEFIC FOLDER OR FILE

git add <FolderName>

📌 4. Commit your changes

git commit -m "Added new challenge: ScoreSorter"

📌 5. Push to GitHub

git push origin main

📌 6. If Git asks for a merge message (Vim)
Press:

ESC
:wq
ENTER

📌 7. If push is rejected
Run:

git pull origin main --allow-unrelated-histories

Then push again.

📌 8. Check your status anytime

git status

📌 9. Undo a staged file

git restore --staged <filename>

📌 10. See your remotes

git remote -v



git remote -v

