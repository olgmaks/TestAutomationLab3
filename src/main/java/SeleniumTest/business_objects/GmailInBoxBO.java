package SeleniumTest.business_objects;

import SeleniumTest.pages.GmailInboxPage;
import SeleniumTest.pages.GmailLetterTable;

import java.util.ArrayList;
import java.util.List;

public class GmailInBoxBO {

    GmailInboxPage inboxPage;
    GmailLetterTable safedImportantTable;
    public GmailInBoxBO(){

        inboxPage = new GmailInboxPage();
    }
    public void safeCurrentImportantLetters(){
        safedImportantTable = inboxPage.getImportantLetters();
    }

    private void goToImportant(){
        inboxPage.chooseImportantFolder();
    }
    private void chooseLetterFromImportand(int index){
        inboxPage.markImportantLetterAsChoosen(index);
    }
    private void deleteChoosen (){
        inboxPage.deleteChousenButton();
    }

    public void deleteLettersFromImportant(List<Integer> indexes){
        goToImportant();
        for (int index:indexes
             ) {
            System.out.print(index+" ");
            chooseLetterFromImportand(index);

        }
        deleteChoosen();
    }

    public int markNextAsImportant(int from)
    {int index=from;
    int allLettersLenght = inboxPage.allLetterQuantity();
        boolean isMarked = false;
        while ((index<allLettersLenght-1)&&(!isMarked)){
            if (inboxPage.isLetterMarkAsImportant(index))
            index++;
            else
            {inboxPage.markImportant(index);
                isMarked=true;
            }
        }
        if (!isMarked)
            index=-1;
        return index;
    }

    public List<Integer> findChanges()
    { List<Integer> indexes = new ArrayList<Integer>();
    int newIndex;
    int oldIndex=0;
    int tempIndex;
        inboxPage.updateImportantLattersTable();
        GmailLetterTable newImportant = inboxPage.getImportantLetters();
        for (newIndex =0; (newIndex<newImportant.findLettersQuantity()&&oldIndex<safedImportantTable.findLettersQuantity()); newIndex++) {
            if (newImportant.equalsByLetter(safedImportantTable, newIndex, oldIndex)){
                oldIndex++;
            }
            else
            {tempIndex=newImportant.findSameLetterIndex(newIndex, safedImportantTable.findLetter(oldIndex));
                if (tempIndex>=oldIndex)
                {
                    for (; oldIndex<tempIndex; oldIndex++){
                        System.out.println(oldIndex);
                        indexes.add(oldIndex);
                    }
                }
                else {
                    indexes.add((newIndex+1)*(-1));
                }

            }
        }

        return indexes;

    }

}
