package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.QuoteList;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.logging.Logger;

public class RegisterCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(RegisterCommand.class);
    private final String newName;

    public RegisterCommand(String name) {
        super("register");
        this.newName = name;
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        ui.showMessage("Registering company: " + newName);
        logger.fine("Executing RegisterCommand");
        companyName.setCompanyName(newName);
    }
}
