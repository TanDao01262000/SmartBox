package smartbox;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;


public class ContainerFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Container();
    }

    @Override
    public View makeView(Model m) {
        return new ContainerView(m);
    }

    @Override
    public String getTitle() {
        return "SmartBox";
    }

    @Override
    public String[] getHelp() {
        String[] cmmds = new String[3];
        cmmds[0] = "Add: Add a new component";
        cmmds[1] = "Remove: Remove existing component";
        cmmds[2] = "Run: Launch added component";
        return cmmds;
    }

    @Override
    public String about() {
        return "SmartBox 2023  by TanDao";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] { "Add", "Remove", "Run"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {

        switch(type) {
            case "Add":
                return new AddCommand(model);
            case "Rem":
                return new RemoveCommand(model);
            case "Run":
                return new RunCommand(model);
            default:
                return null;
        }

    }
}
