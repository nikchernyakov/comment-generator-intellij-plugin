import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;

public class CommentGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        GeneratorDialog generateDialog = new GeneratorDialog(e.getProject());
        generateDialog.show();

        if (generateDialog.isOK()){
            writeComment(e, "// Lol");
        }
    }

    private void writeComment(AnActionEvent e, String comment){

        // Get the offset in the current editor
        DataContext dataContext = e.getDataContext();
        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        final Document document = editor.getDocument();
        final int offset = editor.getCaretModel().getOffset();

        // Insert the block comment at the cursor position
        new WriteCommandAction(e.getProject()){
            @Override
            protected void run(Result result) throws Throwable {
                document.insertString(offset, comment);
                editor.getCaretModel().moveToOffset(offset + comment.length());
            }
        }.execute();
    }

}