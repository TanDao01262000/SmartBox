package smartbox;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class AddCommand extends Command {
    public AddCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Container container = (Container) model;
        String component_name = Utilities.ask("What component?");
        try{
            container.addComponent(component_name);
        }catch(Exception e) {
            Utilities.error("This component doesn't exist!");
        }
    }
}
