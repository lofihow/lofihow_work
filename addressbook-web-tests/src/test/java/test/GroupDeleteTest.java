package test;

import Model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupDeleteTest extends TestBase {

    @Test
    public void CanDeleteGroup() {
        if (app.group().getCount() == 0) {
            app.group().creategroup(new GroupData("group_name", "group_header", "getGroup_footer"));
        }
        int groupCount = app.group().getCount();
        app.group().RemoveGroups();
        int newGroupCount = app.group().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    void  canDeleteALLGroupAtOnce(){
        if (app.group().getCount() == 0) {
            app.group().creategroup(new GroupData("group_name", "group_header", "getGroup_footer"));
        }
        app.group().removeALLGroup();
        Assertions.assertEquals(0, app.group().getCount());
    }
}


