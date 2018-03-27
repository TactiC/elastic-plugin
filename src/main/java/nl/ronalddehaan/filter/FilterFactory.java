package nl.ronalddehaan.filter;

import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class FilterFactory extends AbstractTokenFilterFactory {

    public FilterFactory(IndexSettings indexSettings,
                         Environment environment,
                         String name,
                         Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new RemoveFirstTokenFilter(tokenStream);
    }
}
