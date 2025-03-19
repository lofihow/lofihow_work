package test;

import org.junit.jupiter.api.Test;

public class GroupDeleteTest extends TestBase {

    @Test
    public void CanDeleteGroup() {
        if (!app.group().isGroupPresent()) {
            app.group().creategroup();
        }
        app.group().RemoveGroup();
    }

}


