package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.Quote;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.QuoteList;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.List;
import java.util.logging.Logger;

public class ShowQuotesCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(ShowQuotesCommand.class);
    private static final double GST_RATE = 0.09;

    public ShowQuotesCommand() {
        super("show");
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        logger.fine("Executing ShowQuoteCommand");
        List<Quote> quotes = quoteList.getQuotes();

        if (quotes == null || quotes.isEmpty()) {
            ui.showMessage("No quotes to show.");
            logger.finer("ShowQuoteCommand executed with no quotes");
            return;
        }

        ui.showMessage("Displaying all quotes:\n");
        logger.finer("ShowQuoteCommand executed with quotes");
        for (Quote q : quotes) {
            ui.showQuote(companyName, q, GST_RATE);
        }
    }
}
