package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.QuoteList;
import seedu.quotely.data.Quote;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.logging.Logger;

public class DeleteQuoteCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(DeleteQuoteCommand.class);
    private Quote quote;

    public DeleteQuoteCommand(Quote quote) {
        super("delete");
        this.quote = quote;
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        logger.fine(String.format("Executing DeleteQuoteCommand to remove quote %s", quote.getQuoteName()));

        quoteList.removeQuote(quote);

        ui.showMessage("Deleting quote: " + quote.getQuoteName());
        // go back to main menu if the deleted quote is the current quote
        if (state.isInsideQuote() && state.getQuoteReference().equals(quote)) {
            logger.info("State set to outside quote");
            state.setOutsideQuote();
            assert state.getQuoteReference() == null : "state failed";
        }

        logger.fine(String.format("Successfully removed quote: %s", quote.getQuoteName()));
    }
}
