package tests;

import org.testng.annotations.Test;


public class InputHome {
    @Test
    public void search(){
        typeOnInputBox("#gh-ac","ring");
    }

    private void typeOnInputBox(String s, String ring) {
    }
}
