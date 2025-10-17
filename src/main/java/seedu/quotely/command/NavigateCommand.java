package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuoteList;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.Quote;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.logging.Logger;

public class NavigateCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(NavigateCommand.class);
    private Quote quote;

    public NavigateCommand(Quote quote) {
        super("nav");
        this.quote = quote;
    }

    public NavigateCommand() {
        super("nav");
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        if (quote == null) { //if trying to navigate to main menu
            if (state.getQuoteReference() == null) {
                ui.showMessage("You're already at the main menu.");
            } else {
                ui.showMessage("Navigating to the main menu.");
                logger.info("State set to outside quote");
                state.setOutsideQuote();
            }
            return;
        }

        if (state.getQuoteReference() == quote) { //if at main menu
            ui.showMessage("You're already at quote: " + quote.getQuoteName());

        } else { //if trying to navigate to the same quote
            ui.showMessage("Navigating to quote: " + quote.getQuoteName());
            logger.info(String.format("State set to inside quote with reference %s",
                    quote.getQuoteName()));
            state.setQuoteReference(quote);
            state.setInsideQuote(quote);
        }
    }
}
