package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.QuoteList;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.logging.Logger;

public class FinishQuoteCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(FinishQuoteCommand.class);

    public FinishQuoteCommand() {
        super("finish");
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {
        ui.showMessage("Finishing quote process.");

        logger.fine("Executing FinishQuoteCommand");
        logger.info("State set to outside quote");
        state.setOutsideQuote();
    }

}
