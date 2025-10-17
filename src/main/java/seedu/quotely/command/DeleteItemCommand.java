package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuoteList;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.Quote;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;

import java.util.logging.Logger;

public class DeleteItemCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(DeleteItemCommand.class);
    private String itemName;
    private Quote quote;

    public DeleteItemCommand(String itemName, Quote quote) {
        super("deleteItem");
        this.itemName = itemName;
        this.quote = quote;
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        logger.fine(String.format("Executing DeleteItemCommand to delete item %s from quote %s",
                itemName, quote.getQuoteName()));

        quote.removeItem(itemName);

        ui.showMessage(String.format("Deleting item %s from quote %s", itemName, quote.getQuoteName()));
        logger.fine(String.format("Successfully deleted item: %s", itemName));
    }
}
