package nl.ronalddehaan.filter;

import org.apache.lucene.analysis.*;
import java.io.IOException;

public class RemoveFirstTokenFilter extends FilteringTokenFilter {

    private int count = 0;

    public RemoveFirstTokenFilter(TokenStream in) {
        super(in);
    }

    /**
     * This method decides if the current token will be returned to the client.
     */
    @Override
    protected boolean accept() throws IOException {
        // This is a real dumb implementation
        // It will return all but the first token.
        return 0 != this.count++;
    }
}
