package seedu.quotely.command;

import seedu.quotely.ui.Ui;
import seedu.quotely.data.CompanyName;
import seedu.quotely.data.QuotelyState;
import seedu.quotely.data.QuoteList;
import seedu.quotely.data.Quote;
import seedu.quotely.exception.QuotelyException;
import seedu.quotely.util.LoggerConfig;
import seedu.quotely.writer.PDFWriter;

import java.util.logging.Logger;

public class ExportQuoteCommand extends Command {
    private static final Logger logger = LoggerConfig.getLogger(ExportQuoteCommand.class);
    private Quote quote;

    public ExportQuoteCommand(Quote quote) {
        super("export");
        this.quote = quote;
    }

    @Override
    public void execute(Ui ui,
                        QuoteList quoteList,
                        CompanyName companyName,
                        QuotelyState state) throws QuotelyException {

        logger.fine(String.format("Executing ExportQuoteCommand to quote %s", quote.getQuoteName()));
        ui.showMessage("Exporting quote: " + quote.getQuoteName());
        PDFWriter pdfWriter = PDFWriter.getInstance();
        pdfWriter.writeQuoteToPDF(quote, companyName);
        logger.fine(String.format("Successfully export quote: %s to pdf file.", quote.getQuoteName()));
    }
}
