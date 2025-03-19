package test;

import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void СanCreateGroup() {
        app.group().creategroup();
    }

}
