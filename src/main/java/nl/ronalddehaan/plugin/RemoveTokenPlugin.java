package nl.ronalddehaan.plugin;

import nl.ronalddehaan.filter.FilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveTokenPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new LinkedHashMap<>();
        extra.put("remove-first-token", FilterFactory::new);
        return extra;
    }
}
